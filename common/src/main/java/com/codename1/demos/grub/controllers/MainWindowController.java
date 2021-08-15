/**
 * Licensed to Codename One LTD under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  Codename One licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.codename1.demos.grub.controllers;

import com.codename1.demos.grub.interfaces.CompletedOrder;
import com.codename1.demos.grub.interfaces.MainWindow;
import com.codename1.demos.grub.models.AccountModel;
import com.codename1.demos.grub.models.RestaurantModel;
import com.codename1.demos.grub.views.*;
import com.codename1.rad.controllers.Controller;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.EntityList;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.nodes.ViewNode;
import com.codename1.rad.ui.UI;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

public class MainWindowController extends FormController {

    MainWindowView mainWindowView;

    public static final ActionNode editProfile = UI.action();
    public static final ActionNode editAddresses = UI.action();
    public static final ActionNode editCreditCards = UI.action();
    public static final ActionNode logOut = UI.action();
    public static final ActionNode updateProfileView = UI.action();

    public static final ActionNode enterRest = UI.action();
    public static final ActionNode recommendedExplore = UI.action();
    public static final ActionNode popularExplore = UI.action();

    public static final ActionNode enterFilter = UI.action();
    public static final ActionNode enterSearch = UI.action();

    public static final ActionNode addFavorite = UI.action();
    public static final ActionNode removeFavorite = UI.action();

    public static final ActionNode addCompletedOrder = UI.action();
    public static final ActionNode orderAgain = UI.action();


    public MainWindowController(Controller parent, Entity appEntity, Node appNode) {
        super(parent);
        Form mainWindowForm = new Form(new BorderLayout());
        mainWindowForm.getToolbar().hideToolbar();
        Node profileNode = createProfileNode();
        Node homeNode = createHomeNode();

        mainWindowView = new MainWindowView(appEntity, profileNode, homeNode, appNode);
        mainWindowForm.add(BorderLayout.CENTER, mainWindowView);

        setView(mainWindowForm);

        addActionListener(editProfile, evt -> {
            evt.consume();
            Entity accountEntity = evt.getEntity();
            new EditProfileController(this, accountEntity, profileNode).getView().show();
        });

        addActionListener(editAddresses, evt -> {
            evt.consume();
            AccountModel accountEntity = (AccountModel)evt.getEntity();
            new EditAddressesController(this, accountEntity).getView().show();
        });

        addActionListener(editCreditCards, evt -> {
            evt.consume();
            AccountModel account = (AccountModel)evt.getEntity();
            new EditCreditCardsController(this, account).getView().show();

        });

        addActionListener(enterRest, evt -> {
            evt.consume();
            Entity restEntity = evt.getEntity();
            new RestaurantController(this, restEntity, appEntity.getEntity(MainWindow.profile), homeNode).getView().show();
        });

        addActionListener(enterFilter, evt -> {
            evt.consume();
            new FilterController(this, appEntity.getEntity(MainWindow.filter), homeNode).getView().show();
        });

        addActionListener(enterSearch, evt -> {
            evt.consume();
            new SearchController(this, appEntity, homeNode).getView().show();
        });

        addActionListener(addFavorite, evt -> {
            evt.consume();
            if(appEntity.get(MainWindow.profile) instanceof AccountModel){
                ((AccountModel) appEntity.get(MainWindow.profile)).addFavorite(evt.getEntity());
            }
            mainWindowView.addFavorite(evt.getEntity());
        });

        addActionListener(removeFavorite, evt -> {
            evt.consume();
            if(appEntity.get(MainWindow.profile) instanceof AccountModel){
                ((AccountModel) appEntity.get(MainWindow.profile)).removeFavorite(evt.getEntity());
            }
            mainWindowView.removeFavorite(evt.getEntity());
        });

        addActionListener(addCompletedOrder, evt -> {
            evt.consume();
            Entity completedOrder = evt.getEntity();
            Entity rest = completedOrder.getEntity(CompletedOrder.restaurant);
            if (rest instanceof RestaurantModel){
                ((RestaurantModel) rest).clearOrder();
            }
            mainWindowView.addCompletedOrder(completedOrder);
            mainWindowView.moveToOrders();
            this.getView().showBack();
        });

        addActionListener(orderAgain, evt -> {
            evt.consume();
            Entity completedOrder = evt.getEntity();
            RestaurantModel rest = (RestaurantModel) completedOrder.getEntity(CompletedOrder.restaurant);
            if (completedOrder.get(CompletedOrder.order) instanceof EntityList){
                EntityList<Entity> dishesList = (EntityList<Entity>) completedOrder.get(CompletedOrder.order);
                for (Entity dish : dishesList){
                    rest.addToOrder(dish);
                }
            }
            new RestaurantController(this, rest, appEntity.getEntity(MainWindow.profile), homeNode).getView().show();

        });


    }

    private Node createProfileNode(){
        return new ViewNode(
                UI.actions(ProfileView.EDIT_PROFILE, editProfile),
                UI.actions(ProfileView.EDIT_ADDRESSES, editAddresses),
                UI.actions(ProfileView.EDIT_CREDIT_CARDS, editCreditCards),
                UI.actions(ProfileView.UPDATE_VIEW, logOut),
                UI.actions(ProfileView.LOG_OUT, updateProfileView)
        );
    }

    private Node createHomeNode(){
        return new ViewNode(
                UI.actions(HomeView.ENTER_REST, enterRest),
                UI.actions(HomeView.RECOMMENDED_EXPLORE, recommendedExplore),
                UI.actions(HomeView.POPULAR_EXPLORE, popularExplore),
                UI.actions(HomeView.ENTER_FILTER, enterFilter),
                UI.actions(HomeView.ENTER_SEARCH, enterSearch),
                UI.actions(RestaurantView.ADD_TO_FAVORITE, addFavorite),
                UI.actions(RestaurantView.REMOVE_FAVORITE, removeFavorite),
                UI.actions(OrderView.COMPLETE_ORDER, addCompletedOrder),
                UI.actions(CompletedOrderView.ORDER_AGAIN, orderAgain)

        );
    }

    public void updateDefaultAddressView(){
        mainWindowView.updateDefaultAddressView();
    }

}
