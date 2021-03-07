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

import com.codename1.components.ScaleImageLabel;
import com.codename1.demos.grub.Grub;
import com.codename1.demos.grub.interfaces.CompletedOrder;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.*;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;

import static com.codename1.ui.CN.convertToPixels;
import static com.codename1.ui.util.Resources.getGlobalResources;

public class MainWindowOrdersView extends AbstractEntityView {

    RecentOrdersView recentOrdersView;
    Container inProgressCnt;
    public MainWindowOrdersView(Entity account, Node viewNode) {
        super(account);
        setLayout(new BorderLayout());
        setUIID("MainWindowOrdersView");

        Label headerLabel = new Label("My orders", "MyOrdersHeaderLabel");
        Container headerCnt = BorderLayout.centerAbsolute(headerLabel);
        headerCnt.setUIID("MyOrdersHeaderCnt");
        add(BorderLayout.NORTH, headerCnt);

        Tabs ordersView = new Tabs();
        ordersView.getTabsContainer().setUIID("OrdersTabsContainer");
        ordersView.setTabUIID("OrdersTab");
        ordersView.setTabPlacement(Component.TOP);
        recentOrdersView = new RecentOrdersView(account, viewNode);
        inProgressCnt = new Container(new BorderLayout());
        ordersView.addTab("In Progress", inProgressCnt);
        ordersView.addTab("Recent", recentOrdersView);

        add(BorderLayout.CENTER, ordersView);
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

    public void addCompletedOrder(Entity completedOrder){
        recentOrdersView.addRecentOrder(completedOrder);
        String backgroundImageName = Grub.isDarkMode() ? "set-first-location-background-dark.png" : "set-first-location-background.png";
        inProgressCnt.getAllStyles().setBgImage(getGlobalResources().getImage(backgroundImageName));
        inProgressCnt.getAllStyles().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED);
        Container deliveryInfoCnt = new Container(new BorderLayout());
        Label trackingOrderLabel = new Label ("Tracking Order", "TrackingOrderLabel");
        Label orderId = new Label ("Order #" + completedOrder.getInt(CompletedOrder.orderId), "OrderIdLabel");
        deliveryInfoCnt.add(BorderLayout.NORTH, BoxLayout.encloseY(trackingOrderLabel, orderId));

        Label preparingFoodLabel = new Label ("Preparing Food", "PreparingFoodLabel");
        Label drivesAtTheRestaurantLabel = new Label ("Drives At The Restaurant", "DrivesAtTheRestaurantLabel");
        String progressImageName = Grub.isDarkMode() ? "delivery-progress-dark.png" : "delivery-progress.png";
        Image deliveryProgressImage = getGlobalResources().getImage(progressImageName);
        ScaleImageLabel deliveryProgress = new ScaleImageLabel(deliveryProgressImage){
            @Override
            public Dimension getPreferredSize() {
                Dimension dim = super.getPreferredSize();
                dim.setHeight(convertToPixels(8));
                return dim;
            }
        };
        deliveryProgress.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FIT);
        deliveryInfoCnt.add(BorderLayout.CENTER, BoxLayout.encloseY(deliveryProgress, preparingFoodLabel, drivesAtTheRestaurantLabel));

        Container driverInfoCnt = new Container(new BorderLayout());
        Image iconMessage = getGlobalResources().getImage("icon-message-circle.png").scaled(convertToPixels(4), convertToPixels(4));
        Image iconPhone = getGlobalResources().getImage("icon-phone.png").scaled(convertToPixels(4), convertToPixels(4));
        Image iconRating = getGlobalResources().getImage("rating-icon.png").scaled(convertToPixels(4), convertToPixels(4));
        Image iconDriver = getGlobalResources().getImage("account-place-holder.png");

        Label driverName = new Label("James Smith", "DriverNameLabel");
        Label driverRating = new Label(" 4.9/5", iconRating, "DriverRatingLabel");
        ScaleImageLabel driverImageLabel = new ScaleImageLabel(iconDriver){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(convertToPixels(10), convertToPixels(10));
            }
        };
        driverInfoCnt.add(BorderLayout.WEST, driverImageLabel);
        driverInfoCnt.add(BorderLayout.CENTER, BoxLayout.encloseY(driverName, driverRating));
        driverInfoCnt.add(BorderLayout.EAST, BorderLayout.centerAbsolute(BoxLayout.encloseX(new Button(iconMessage, "MessageDriverButton"), new Button(iconPhone, "CallDriverButton"))));
        driverInfoCnt.setUIID("DriverInfoCnt");
        deliveryInfoCnt.add(BorderLayout.SOUTH, driverInfoCnt);

        deliveryInfoCnt.setUIID("DeliveryInfoCnt");
        inProgressCnt.add(BorderLayout.SOUTH, deliveryInfoCnt);
    }
}
