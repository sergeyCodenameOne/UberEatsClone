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

package com.codename1.demos.grub.controllers;

import com.codename1.demos.grub.interfaces.Restaurant;
import com.codename1.demos.grub.models.AccountModel;
import com.codename1.demos.grub.models.OrderDishModel;
import com.codename1.demos.grub.views.*;
import com.codename1.rad.controllers.Controller;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.nodes.ViewNode;
import com.codename1.rad.ui.UI;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

public class OrderController extends FormController {

    public static final ActionNode increaseQuantity = UI.action();
    public static final ActionNode decreaseQuantity = UI.action();
    public static final ActionNode manegePayment = UI.action();
    public static final ActionNode manegeAddress = UI.action();

    public static final ActionNode setCard = UI.action();
    public static final ActionNode updatePaymentView = UI.action();



    OrderView orderView;
    public OrderController(Controller parent, Entity restEntity, Entity profileEntity, Node mainWindowNode) {
        super(parent);

        Node viewNode = new ViewNode (
                UI.actions(DishOrderPreview.INCREASE_QUANTITY, increaseQuantity),
                UI.actions(OrderView.CHANGE_DELIVERY_PAYMENT, manegePayment),
                UI.actions(OrderView.CHANGE_DELIVERY_ADDRESS, manegeAddress),
                UI.actions(PaymentMethodView.EDIT_PAYMENT, manegePayment),
                UI.actions(CreditCardView.SET_CARD_TO_PAY, setCard),
                UI.actions(EditPaymentView.UPDATE_PAYMENT_VIEW, updatePaymentView),
                UI.actions(DishOrderPreview.DECREASE_QUANTITY, decreaseQuantity)
        );

        Form orderForm = new Form(restEntity.getText(Restaurant.name), new BorderLayout());
        orderForm.getToolbar().hideToolbar();

        orderView = new OrderView(restEntity, profileEntity, viewNode, mainWindowNode);
        orderForm.add(BorderLayout.CENTER, orderView);
        setView(orderForm);

        addActionListener(increaseQuantity, evt -> {
            evt.consume();
            Entity dishEntity = evt.getEntity();
            dishEntity.set(OrderDishModel.quantity, dishEntity.getInt(OrderDishModel.quantity) + 1);
            if(evt.getSource() instanceof DishOrderPreview){
                ((DishOrderPreview)evt.getSource()).update();
            }
            orderView.update();

        });

        addActionListener(decreaseQuantity, evt -> {
            evt.consume();
            Entity dishEntity = evt.getEntity();
            int currentQuantity = dishEntity.getInt(OrderDishModel.quantity);
            if (currentQuantity > 0){
                dishEntity.set(OrderDishModel.quantity, currentQuantity - 1);
                if(evt.getSource() instanceof DishOrderPreview){
                    ((DishOrderPreview)evt.getSource()).update();
                }
            }
            orderView.update();
        });

        addActionListener(manegeAddress, evt -> {
            evt.consume();
            new EditAddressesController(this, (AccountModel)profileEntity).getView().show();
        });

        addActionListener(manegePayment, evt -> {
            evt.consume();
            new EditPaymentController(this, evt.getEntity(), profileEntity, viewNode).getView().show();
        });

        addActionListener(setCard, evt -> {
            evt.consume();
            Entity card = evt.getEntity();
            orderView.setCreditCard(card);
            getView().showBack();
        });

        addActionListener(updatePaymentView, evt -> {
            evt.consume();
            orderView.update();
            getView().showBack();
        });
    }

    public void updateOrderView(){
        orderView.update();
    }
}
