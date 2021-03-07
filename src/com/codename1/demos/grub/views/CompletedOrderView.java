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
import com.codename1.demos.grub.interfaces.Address;
import com.codename1.demos.grub.interfaces.CompletedOrder;
import com.codename1.demos.grub.interfaces.Restaurant;
import com.codename1.demos.grub.models.RestaurantModel;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.PropertySelector;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.rad.ui.image.RoundRectImageRenderer;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.UIManager;

import static com.codename1.ui.util.Resources.getGlobalResources;

public class CompletedOrderView extends AbstractEntityView {

    private static EncodedImage placeHolder = EncodedImage.createFromImage(getGlobalResources().getImage("placeholder.png"), false).
            scaledEncoded(100, 100);

    public static final ActionNode.Category ORDER_AGAIN = new ActionNode.Category();

    public CompletedOrderView(Entity order, Node viewNode) {
        super(order);
        setUIID("CompletedOrderView");
        setLayout(new BorderLayout());
        String restName = order.getEntity(CompletedOrder.restaurant).getText(Restaurant.name);

        Label restNameLabel = new Label(restName, "CompletedOrderRestName");
        Label orderNumber = new Label("Order #" + order.getInt(CompletedOrder.orderId), "CompletedOrderIdLabel");
        int deliverTo = order.getInt(CompletedOrder.deliveredTo);
        String deliverToText = "Home";
        if (deliverTo == Address.WORK){
            deliverToText = "Work";
        }else if(deliverTo == Address.OTHER){
            deliverToText = "Other";
        }
        RestaurantModel rest = (RestaurantModel) order.getEntity(CompletedOrder.restaurant);

        PropertySelector imagePropertySelector = new PropertySelector(rest, Restaurant.icon);
        RoundRectImageRenderer renderer = new RoundRectImageRenderer(100, 100, 1);

        Image restImage = renderer.createImage(imagePropertySelector);
        ScaleImageLabel restIconLabel = new ScaleImageLabel(restImage);

        Label deliverToHeaderLabel = new Label("DELIVERED TO:", "CompletedOrderDeliveredToHeaderLabel");
        Label deliverToLabel = new Label(deliverToText, "CompletedOrderDeliveredToLabel");

        Label dateHeaderLabel = new Label("DATE:", "CompletedOrderDateHeaderLabel");
        Label dateLabel = new Label(order.getText(CompletedOrder.date), "CompletedOrderDateLabel");

        Button orderAgain = new Button("Order again", "CompletedOrderOrderAgainButton");
        Button rate = new Button("rate", "CompletedOrderRateButton");

        orderAgain.addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(ORDER_AGAIN);
            if (action != null) {
                action.fireEvent(order, CompletedOrderView.this);
            }
        });

        Label completedIcon = new Label(FontImage.createMaterial(FontImage.MATERIAL_CHECK_CIRCLE, UIManager.getInstance().getComponentStyle("CompletedOrderIcon")));
        Container orderTopView = new Container(new BorderLayout());
        orderTopView.add(BorderLayout.NORTH, BorderLayout.centerEastWest(BoxLayout.encloseY(restNameLabel, orderNumber), completedIcon, restIconLabel));
        orderTopView.add(BorderLayout.WEST, BoxLayout.encloseY(dateHeaderLabel, dateLabel));
        orderTopView.add(BorderLayout.EAST, BoxLayout.encloseY(deliverToHeaderLabel, deliverToLabel));
        add(BorderLayout.NORTH, orderTopView);
        add(BorderLayout.CENTER, GridLayout.encloseIn(2, orderAgain, rate));
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
}
