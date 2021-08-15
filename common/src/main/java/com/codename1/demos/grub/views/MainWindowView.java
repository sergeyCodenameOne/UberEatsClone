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


package com.codename1.demos.grub.views;

import com.codename1.demos.grub.interfaces.MainWindow;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.Component;
import com.codename1.ui.Tabs;
import com.codename1.ui.layouts.BorderLayout;

import static com.codename1.ui.CN.convertToPixels;
import static com.codename1.ui.util.Resources.getGlobalResources;

public class MainWindowView extends AbstractEntityView {

    FavoriteRestaurantsView favoriteView;
    MainWindowOrdersView ordersView;
    HomeView homeView;
    Tabs mainWindowContainer;
    private static final int TABS_ICON_SIZE = convertToPixels(4);
    private static final int TABS_ICON_SELECTED_SIZE = convertToPixels(6);

    public MainWindowView(Entity mainWindowEntity, Node profileNode, Node homeViewNode, Node appNode) {
        super(mainWindowEntity);
        setLayout(new BorderLayout());
        setUIID("MainWindow");
        mainWindowContainer = new Tabs();
        mainWindowContainer.setTabPlacement(Component.BOTTOM);
        mainWindowContainer.getTabsContainer().setUIID("MainWindowTabsContainer");
        mainWindowContainer.setUIID("MainWindowTabsCnt");
        mainWindowContainer.setTabUIID("MainWindowTab");
        mainWindowContainer.getTabsContainer().setSafeArea(false);

        homeView = new HomeView(mainWindowEntity, homeViewNode);
        mainWindowContainer.addTab("HOME",
                                    getGlobalResources().getImage("main-window-favorite.png").scaled(TABS_ICON_SIZE, TABS_ICON_SIZE),
                                    getGlobalResources().getImage("main-window-favorite-selected.png").scaled(TABS_ICON_SELECTED_SIZE, TABS_ICON_SELECTED_SIZE),
                                    homeView);

        favoriteView = new FavoriteRestaurantsView((Entity)mainWindowEntity.get(MainWindow.profile), homeViewNode);
        mainWindowContainer.addTab("FAVORITE",
                                    getGlobalResources().getImage("main-window-home.png").scaled(TABS_ICON_SIZE, TABS_ICON_SIZE),
                                    getGlobalResources().getImage("main-window-home-selected.png").scaled(TABS_ICON_SELECTED_SIZE, TABS_ICON_SELECTED_SIZE),
                                    favoriteView);

        ordersView = new MainWindowOrdersView(mainWindowEntity.getEntity(MainWindow.profile), homeViewNode);
        mainWindowContainer.addTab("ORDERS",
                                    getGlobalResources().getImage("main-window-orders.png").scaled(TABS_ICON_SIZE, TABS_ICON_SIZE),
                                    getGlobalResources().getImage("main-window-orders-selected.png").scaled(TABS_ICON_SELECTED_SIZE, TABS_ICON_SELECTED_SIZE),
                                    ordersView);

        mainWindowContainer.addTab("PROFILE",
                                    getGlobalResources().getImage("main-window-profile.png").scaled(TABS_ICON_SIZE, TABS_ICON_SIZE),
                                    getGlobalResources().getImage("main-window-profile-selected.png").scaled(TABS_ICON_SELECTED_SIZE, TABS_ICON_SELECTED_SIZE),
                                    new ProfileView(mainWindowEntity.getEntity(MainWindow.profile), profileNode, appNode));

        add(BorderLayout.CENTER, mainWindowContainer);
    }

    @Override
    public void update() {

    }

    @Override
    public void commit() {

    }

    @Override
    public Node getViewNode() {
        return null;
    }

    public void addFavorite(Entity rest){
        favoriteView.addFavorite(rest);
    }

    public void removeFavorite(Entity rest){
        favoriteView.removeFavorite(rest);
    }

    public void addCompletedOrder(Entity completedOrder){
        ordersView.addCompletedOrder(completedOrder);
    }

    public void updateDefaultAddressView(){
        homeView.update();
    }

    public void moveToOrders(){
        mainWindowContainer.setSelectedIndex(2);
    }
}
