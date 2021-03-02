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

package com.codename1.demos.ubereatsclone.views;

import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.*;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Style;

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
        inProgressCnt.getAllStyles().setBgImage(getGlobalResources().getImage("set-first-location-background.png"));
        inProgressCnt.getAllStyles().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED);
        Container deliveryInfoCnt = new Container(){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(Display.getInstance().getDisplayWidth(), (int) (Display.getInstance().getDisplayHeight() / 2.5));
            }
        };
        deliveryInfoCnt.setUIID("DeliveryInfoCnt");
        inProgressCnt.add(BorderLayout.SOUTH, deliveryInfoCnt);
    }
}
