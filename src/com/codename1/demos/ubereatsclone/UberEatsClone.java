/*
 * Copyright (c) 2012, Codename One and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Codename One designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Codename One through http://www.codenameone.com/ if you
 * need additional information or have any questions.
 */

package com.codename1.demos.ubereatsclone;

import com.codename1.demos.ubereatsclone.controllers.*;
import com.codename1.demos.ubereatsclone.interfaces.Account;
import com.codename1.demos.ubereatsclone.models.*;
import com.codename1.demos.ubereatsclone.views.*;
import com.codename1.rad.controllers.ApplicationController;
import com.codename1.rad.controllers.ControllerEvent;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.ViewNode;
import com.codename1.rad.ui.UI;

import java.util.ArrayList;
import java.util.List;


public class UberEatsClone extends ApplicationController {

    Entity account;

    public static final ActionNode enterMainWindow = UI.action();
    public static final ActionNode enterFirstIntroduction = UI.action();
    public static final ActionNode enterSecondIntroduction = UI.action();
    public static final ActionNode enterThirdIntroduction = UI.action();
    public static final ActionNode enterSetLocation = UI.action();
    public static final ActionNode logout = UI.action();

    public static final ActionNode.Category SKIP_TO_MAIN_WINDOW = new ActionNode.Category();

    public static final int DEBUG_MODE_WITHOUT_SIGNING = 0;
    public static final int DEBUG_MODE_WITH_SIGNING = 1;

    public static final int mode = DEBUG_MODE_WITH_SIGNING;

    @Override
    public void actionPerformed(ControllerEvent evt) {
        if (evt instanceof StartEvent) {
            evt.consume();

            ViewNode viewNode = new ViewNode(
                    UI.actions(SignInView.COMPLETE_SIGNING_IN, enterFirstIntroduction),
                    UI.actions(FirstIntroductionView.FINISHED_FIRST_INTRO, enterSecondIntroduction),
                    UI.actions(SecondIntroductionView.FINISHED_SECOND_INTRO, enterThirdIntroduction),
                    UI.actions(ThirdIntroductionView.FINISHED_THIRD_INTRO, enterSetLocation),
                    UI.actions(SetFirstLocationView.COMPLETE_SETTING_ADDRESS, enterMainWindow),
                    UI.actions(ProfileView.LOG_OUT, logout),
                    UI.actions(SKIP_TO_MAIN_WINDOW, enterMainWindow)
            );

            if (mode == DEBUG_MODE_WITH_SIGNING){

                account = new AccountModel();
                new AccountController(this, account, viewNode).getView().show();

                addActionListener(logout, event-> {
                    account = new AccountModel();
                    new AccountController(this, account, viewNode).getView().showBack();
                });

                addActionListener(enterFirstIntroduction, event->{
                    event.consume();
                    new FirstIntroductionController(this, account, viewNode).getView().show();
                });

                addActionListener(enterSecondIntroduction, event->{
                    event.consume();
                    new SecondIntroductionController(this, account, viewNode).getView().show();
                });

                addActionListener(enterThirdIntroduction, event->{
                    event.consume();
                    new ThirdIntroductionController(this, account, viewNode).getView().show();
                });

                addActionListener(enterSetLocation, event -> {
                    event.consume();
                    new SetFirstLocationController(this, account, viewNode).getView().show();
                });

                addActionListener(enterMainWindow, event->{
                    event.consume();
                    new MainWindowController(this, createDemoMainWindowEntity(account), viewNode).getView().show();
                });


            }else if (mode == DEBUG_MODE_WITHOUT_SIGNING){
                new MainWindowController(this, createDemoMainWindowEntity(null), viewNode).getView().show();
            }
        }
    }

    private Entity createDemoMainWindowEntity(Entity accountEntity){
        Entity account;
        if (accountEntity == null){
             account = new AccountModel();
            account.set(Account.firstName, "Codename");
            account.set(Account.lastName, "One");
            account.set(Account.emailAddress, "sergey@gmail.com");
            account.set(Account.password, "sd12eqwf134qsd");
            account.set(Account.mobileNumber, "0544123415");
        }else{
            account = accountEntity;
        }
        List restaurantsList = new ArrayList();
        for (int i = 0; i < 10; i++){
            restaurantsList.add(createRestaurantDemoModel());
        }
        return new MainWindowModel(account, restaurantsList);
    }

    private Entity createRestaurantDemoModel(){
        RestaurantModel restaurant = new RestaurantModel("Super Burgers", "https://sergeycodenameone.github.io/rest.jpg", "sea food", 4.7, 5, "https://sergeycodenameone.github.io/rest-icon.png",30, createDemoMenu());
        return restaurant;
    }

    private List<Entity> createDemoMenu(){
        List<Entity> menu = new ArrayList<>();

        menu.add(new FoodCategoryModel("Salads", createSaladsMenu()));
        menu.add(new FoodCategoryModel("Burgers", createBurgersMenu()));
        menu.add(new FoodCategoryModel("Desserts", createDessertsMenu()));
        menu.add(new FoodCategoryModel("Drinks", createDrinksMenu()));
        return menu;
    }

    private List<Entity> createBurgersMenu(){
        List<Entity> dishes = new ArrayList<>();
        dishes.add(new DishModel("Red Burger", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 4, createDemoAddOns()));
        dishes.add(new DishModel("Green Burger", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 5, createDemoAddOns()));
        dishes.add(new DishModel("Blue Burger", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 2, createDemoAddOns()));
        dishes.add(new DishModel("Big Burger", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 3, createDemoAddOns()));
        dishes.add(new DishModel("Small Burger", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 4.5, createDemoAddOns()));
        dishes.add(new DishModel("Vegetarian Burger", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 6.4, createDemoAddOns()));

        return dishes;
    }

    private List<Entity> createDrinksMenu(){
        List<Entity> dishes = new ArrayList<>();
        dishes.add(new DishModel("Cola", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Soda", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Orange Juice", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Apple juice", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Vanilla Milkshake", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Chocolate Milkshake", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 4.60, createDemoAddOns()));

        return dishes;
    }

    private List<Entity> createDessertsMenu(){
        List<Entity> dishes = new ArrayList<>();
        dishes.add(new DishModel("Apple Pie", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Chocolate Cake", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Blue Burger", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Big Burger", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Vanilla Ice Cream", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Chocolate Ice Cream", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 4.60, createDemoAddOns()));

        return dishes;
    }

    private List<Entity> createSaladsMenu(){
        List<Entity> dishes = new ArrayList<>();
        dishes.add(new DishModel("Big Salad", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Small Salad", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Green Salad", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Red Salad", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Blue Salad", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Vegetarian Salad", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 4.60, createDemoAddOns()));

        return dishes;
    }


    private List<Entity> createDemoAddOns(){
        List addOns = new ArrayList();

        addOns.add(new DishAddOnModel("lettuce", "https://sergeycodenameone.github.io/dish.jpg", 4.0));
        addOns.add(new DishAddOnModel("tomato", "https://sergeycodenameone.github.io/dish.jpg", 2.0));
        addOns.add(new DishAddOnModel("cheese", "https://sergeycodenameone.github.io/dish.jpg", 3.0));
        addOns.add(new DishAddOnModel("onion", "https://sergeycodenameone.github.io/dish.jpg", 1.0));


        return addOns;
    }
}

