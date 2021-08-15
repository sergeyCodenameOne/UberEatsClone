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


package com.codename1.demos.grub;

import com.codename1.demos.grub.controllers.AccountController;
import com.codename1.demos.grub.controllers.IntroductionController;
import com.codename1.demos.grub.controllers.MainWindowController;
import com.codename1.demos.grub.controllers.SetFirstLocationController;
import com.codename1.demos.grub.interfaces.Account;
import com.codename1.demos.grub.models.*;
import com.codename1.demos.grub.views.*;
import com.codename1.io.Log;
import com.codename1.rad.controllers.ApplicationController;
import com.codename1.rad.controllers.ControllerEvent;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.ViewNode;
import com.codename1.rad.ui.UI;
import com.codename1.ui.*;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.codename1.ui.CN.*;


public class Grub extends ApplicationController {
    Entity account;
    private static boolean darkMode = false;
    private Resources theme;

    public static final ActionNode enterMainWindow = UI.action();
    public static final ActionNode enterIntroduction = UI.action();
    public static final ActionNode enterSetLocation = UI.action();
    public static final ActionNode logout = UI.action();
    public static final ActionNode darkModeActionNode = UI.action();

    public static final ActionNode.Category SKIP_TO_MAIN_WINDOW = new ActionNode.Category();

    public static final int DEBUG_MODE_WITH_SIGNING = 0;
    public static final int DEBUG_MODE_WITHOUT_SIGNING = 1;
    public static final int DEBUG_MODE_WITH_SIGNING_DARK_MODE = 2;
    public static final int DEBUG_MODE_WITHOUT_SIGNING_DARK_MODE = 3;

    public static final int mode = DEBUG_MODE_WITH_SIGNING;

    @Override
    public void actionPerformed(ControllerEvent evt) {
        if (evt instanceof StartEvent) {
            evt.consume();

            ViewNode viewNode = new ViewNode(
                    UI.actions(SignInView.COMPLETE_SIGNING_IN, enterIntroduction),
                    UI.actions(ThirdIntroductionView.FINISHED_THIRD_INTRO, enterSetLocation),
                    UI.actions(SetFirstLocationView.COMPLETE_SETTING_ADDRESS, enterMainWindow),
                    UI.actions(ProfileView.LOG_OUT, logout),
                    UI.actions(AccountView.DARK_MODE, darkModeActionNode),
                    UI.actions(SKIP_TO_MAIN_WINDOW, enterMainWindow)
            );

            if (mode == DEBUG_MODE_WITH_SIGNING || mode == DEBUG_MODE_WITH_SIGNING_DARK_MODE){

                if (mode == DEBUG_MODE_WITH_SIGNING_DARK_MODE){
                    darkMode = true;
                    initTheme();
                }

                account = new AccountModel();
                new AccountController(this, account, viewNode).getView().show();

                addActionListener(logout, event-> {
                    account = new AccountModel();
                    new AccountController(this, account, viewNode).getView().showBack();
                });

                addActionListener(enterIntroduction, event->{
                    event.consume();
                    new IntroductionController(this, account, viewNode).getView().show();
                });


                addActionListener(enterSetLocation, event -> {
                    event.consume();
                    new SetFirstLocationController(this, account, viewNode).getView().show();
                });

                addActionListener(enterMainWindow, event->{
                    event.consume();
                    new MainWindowController(this, createDemoMainWindowEntity(account), viewNode).getView().show();
                });

                addActionListener(darkModeActionNode, event->{
                    event.consume();
                    darkMode = !darkMode;
                    initTheme();
                });
            }else if (mode == DEBUG_MODE_WITHOUT_SIGNING){
                new MainWindowController(this, createDemoMainWindowEntity(null), viewNode).getView().show();

            }else if(mode == DEBUG_MODE_WITHOUT_SIGNING_DARK_MODE){
                darkMode = true;
                initTheme();
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
        RestaurantModel restaurant = new RestaurantModel("Sergio's Pizza", "https://sergeycodenameone.github.io/restaurant.png", "Italian", 4.7, 5, "https://sergeycodenameone.github.io/restaurant-icon.png",30, createDemoMenu());
        return restaurant;
    }

    private List<Entity> createDemoMenu(){
        List<Entity> menu = new ArrayList<>();

        menu.add(new FoodCategoryModel("Pizzas", createPizzaMenu()));
        menu.add(new FoodCategoryModel("Pastas", createPastaMenu()));
        menu.add(new FoodCategoryModel("Desserts", createDessertsMenu()));
        menu.add(new FoodCategoryModel("Drinks", createDrinksMenu()));
        return menu;
    }

    private List<Entity> createPastaMenu(){
        List<Entity> dishes = new ArrayList<>();
        dishes.add(new DishModel("Ravioli", "Ravioli pasta", "https://sergeycodenameone.github.io/pasta-image.jpg", 4, createDemoAddOns()));
        dishes.add(new DishModel("Fettuccine", "Fettuccine pasta", "https://sergeycodenameone.github.io/pasta-image.jpg", 5, createDemoAddOns()));
        dishes.add(new DishModel("Linguini", "Linguini pasta", "https://sergeycodenameone.github.io/pasta-image.jpg", 2, createDemoAddOns()));
        dishes.add(new DishModel("Rotelle", "Rotelle pasta", "https://sergeycodenameone.github.io/pasta-image.jpg", 3, createDemoAddOns()));
        dishes.add(new DishModel("Ditalini", "Ditalini pasta", "https://sergeycodenameone.github.io/pasta-image.jpg", 4.5, createDemoAddOns()));
        dishes.add(new DishModel("Tortellini", "Tortellini pasta", "https://sergeycodenameone.github.io/pasta-image.jpg", 6.4, createDemoAddOns()));

        return dishes;
    }

    private List<Entity> createDrinksMenu(){
        List<Entity> dishes = new ArrayList<>();
        dishes.add(new DishModel("Cola", "Cola with ice", "https://sergeycodenameone.github.io/orange-juice.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Soda", "Soda with ice", "https://sergeycodenameone.github.io/orange-juice.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Orange Juice", "Orange Juice with ice", "https://sergeycodenameone.github.io/orange-juice.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Apple juice", "Apple juice with ice", "https://sergeycodenameone.github.io/orange-juice.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Vanilla Milkshake", "Vanilla Milkshake with cream", "https://sergeycodenameone.github.io/orange-juice.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Chocolate Milkshake", "Chocolate Milkshake with cream", "https://sergeycodenameone.github.io/orange-juice.jpg", 4.60, createDemoAddOns()));

        return dishes;
    }

    private List<Entity> createDessertsMenu(){
        List<Entity> dishes = new ArrayList<>();
        dishes.add(new DishModel("Apple Pie", "Apple Pie with ice-cream", "https://sergeycodenameone.github.io/pancakes-image.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Chocolate Cake", "Chocolate Cake with ice-cream", "https://sergeycodenameone.github.io/pancakes-image.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Pancakes", "Pancakes with ice-cream", "https://sergeycodenameone.github.io/pancakes-image.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Cupcakes", "Cupcakes with ice-cream", "https://sergeycodenameone.github.io/pancakes-image.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Vanilla Ice Cream", "Vanilla Ice Cream", "https://sergeycodenameone.github.io/pancakes-image.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Chocolate Ice Cream", "Chocolate Ice Cream", "https://sergeycodenameone.github.io/pancakes-image.jpg", 4.60, createDemoAddOns()));

        return dishes;
    }

    private List<Entity> createPizzaMenu(){
        List<Entity> dishes = new ArrayList<>();
        dishes.add(new DishModel("Neapolitan Pizza", "Large pizza", "https://sergeycodenameone.github.io/pizza-image.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Chicago Pizza", "Medium pizza", "https://sergeycodenameone.github.io/pizza-image.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("New York-Style Pizza", "Small pizza", "https://sergeycodenameone.github.io/pizza-image.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Sicilian Pizza", "Medium pizza", "https://sergeycodenameone.github.io/pizza-image.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Greek Pizza", "Small pizza", "https://sergeycodenameone.github.io/pizza-image.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("California Pizza", "Medium pizza", "https://sergeycodenameone.github.io/pizza-image.jpg", 4.60, createDemoAddOns()));

        return dishes;
    }


    private List<Entity> createDemoAddOns(){
        List addOns = new ArrayList();

        addOns.add(new DishAddOnModel("mushrooms", "https://sergeycodenameone.github.io/mushrooms-image.jpg", 4.0));
        addOns.add(new DishAddOnModel("tomato", "https://sergeycodenameone.github.io/tomato-image.jpg", 2.0));
        addOns.add(new DishAddOnModel("cheese", "https://sergeycodenameone.github.io/cheese-image.jpg", 3.0));
        addOns.add(new DishAddOnModel("onion", "https://sergeycodenameone.github.io/onion-image.jpg", 1.0));

        return addOns;
    }

    private void initTheme() {
        String themeFileName = darkMode ? "/dark-theme" : "/theme";
        try {
            Resources theme = Resources.openLayered(themeFileName);
            UIManager.getInstance().addThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
        }catch(IOException e){
            Log.e(e);
        }
        Form currForm = Display.getInstance().getCurrent();
        if (currForm != null) {
            currForm.refreshTheme();
        }
    }

    @Override
    public void init(Object context) {
        CN.setProperty("Component.revalidateOnStyleChange", "false");
        updateNetworkThreadCount(2);

        try {
            theme = Resources.openLayered("/theme");
            UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
            Resources.setGlobalResources(theme);
        }catch(IOException e){
            Log.e(e);
        }

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if(err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });
        dispatchEvent(new InitEvent(context));
    }

    public static boolean isDarkMode(){
        return darkMode;
    }

    @Override
    public void stop() {
        current = getCurrentForm();
        dispatchEvent(new StopEvent());
        System.out.println(current);
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }

    @Override
    public void start() {
        showCurrentForm();
        if (current == null){
            dispatchEvent(new StartEvent());
        }
    }

    @Override
    protected void showCurrentForm() {
        if (current != null) {
            current.show();
        }
    }
    
}

