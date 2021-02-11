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

import com.codename1.demos.ubereatsclone.Util;
import com.codename1.demos.ubereatsclone.interfaces.Restaurant;
import com.codename1.demos.ubereatsclone.models.RestaurantModel;
import com.codename1.l10n.L10NManager;
import com.codename1.rad.controllers.ActionSupport;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.EntityList;
import com.codename1.rad.models.Property;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

import java.util.ArrayList;
import java.util.List;

public class OrderView extends AbstractEntityView {

    Node viewNode;
    Property orderProp;
    List dishes = new ArrayList();
    Label totalPriceLabel, itemTotalCostLabel;
    Container totalPriceCnt, itemTotalCostCnt;


    public OrderView(Entity restEntity, Entity profileEntity, Node viewNode) {
        super(restEntity);
        setLayout(BoxLayout.y());
        setUIID("OrderCnt");
        setScrollableY(true);

        this.viewNode = viewNode;
        orderProp = restEntity.findProperty(Restaurant.order);

        Button backButton = new Button(FontImage.MATERIAL_KEYBOARD_ARROW_LEFT);
        backButton.setUIID("AddDishBackButton");
        backButton.addActionListener(evt -> {
            evt.consume();
            ActionSupport.dispatchEvent(new FormController.FormBackEvent(backButton));
        });
        Label headerLabel = new Label("MY ORDERS", "AddDishHeaderLabel");
        Container headerCnt = BorderLayout.center(headerLabel).add(BorderLayout.WEST, backButton);
        headerCnt.setUIID("AddDishHeaderCnt");
        add(headerCnt);

        if (restEntity.get(orderProp) instanceof EntityList) {
            EntityList<Entity> dishList = (EntityList) (restEntity.get(Restaurant.order));
            for(Entity dishOrderEntity : dishList){
                DishOrderPreview dish = new DishOrderPreview(dishOrderEntity, viewNode);
                dishes.add(dish);
                add(dish);
            }
        }

        Label deliveryFeeHeaderLabel = new Label("Delivery Fee", "OrderDeliveryFeeHeader");
        Label deliveryFeeLabel = new Label(restEntity.getDouble(Restaurant.deliveryFee) + " " + L10NManager.getInstance().getCurrencySymbol(), "OrderDeliveryFee");
        Container deliveryFeeCnt = BorderLayout.centerCenterEastWest(null, deliveryFeeLabel, deliveryFeeHeaderLabel);
        deliveryFeeCnt.setUIID("DeliveryFeeCnt");

        Label itemTotalHeaderLabel = new Label("Item Total", "ItemTotalHeader");
        itemTotalCostLabel = new Label("", "ItemTotalCost");
        itemTotalCostCnt = BorderLayout.centerCenterEastWest(null, itemTotalCostLabel, itemTotalHeaderLabel);
        itemTotalCostCnt.setUIID("v");

        Label totalHeaderLabel = new Label("Total:", "TotalCostHeader");
        totalPriceLabel = new Label("", "TotalCost");
        totalPriceCnt = BorderLayout.centerCenterEastWest(null, totalPriceLabel, totalHeaderLabel);
        totalPriceCnt.setUIID("TotalCostCnt");

        Button confirmOrder = new Button("Confirm Order", "OrderConfirmButton");

        Container summaryCnt = new Container(new BorderLayout(), "OrderSummaryCnt");
        summaryCnt.add(BorderLayout.NORTH, BoxLayout.encloseY(deliveryFeeCnt, itemTotalCostCnt));
        summaryCnt.add(BorderLayout.CENTER, totalPriceCnt);

        add(summaryCnt);
        add(confirmOrder);
        update();
    }

    @Override
    public void update() {
        itemTotalCostLabel.setText(Util.getPriceAsString(((RestaurantModel)getEntity()).getTotalItemPrice()));
        totalPriceLabel.setText(Util.getPriceAsString(((RestaurantModel)getEntity()).getTotalPrice()));
        totalPriceCnt.revalidateWithAnimationSafety();
        itemTotalCostCnt.revalidateWithAnimationSafety();
    }

    @Override
    public void commit() {

    }

    @Override
    public Node getViewNode() {
        return viewNode;
    }
}
