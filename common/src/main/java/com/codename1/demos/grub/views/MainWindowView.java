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
