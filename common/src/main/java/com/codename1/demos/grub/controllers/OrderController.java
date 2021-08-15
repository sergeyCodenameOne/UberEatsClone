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
