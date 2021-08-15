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

import com.codename1.components.MultiButton;
import com.codename1.demos.grub.interfaces.CreditCard;
import com.codename1.demos.grub.interfaces.PaymentMethod;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.UIManager;

import static com.codename1.ui.CN.convertToPixels;
import static com.codename1.ui.util.Resources.getGlobalResources;

public class PaymentMethodView extends AbstractEntityView {

    MultiButton view;

    public static final ActionNode.Category EDIT_PAYMENT = new ActionNode.Category();

    public PaymentMethodView(Entity model, Node viewNode) {
        super(model);
        setLayout(new BorderLayout());
        view = new MultiButton("PAYMENT METHOD");
        view.setUIID("PaymentMethodView");
        view.setUIIDLine1("PaymentMethodViewHeader");
        view.setUIIDLine2("PaymentMethodViewText");
        Image icon = getGlobalResources().getImage("wallet-icon.png").scaled(convertToPixels(4), convertToPixels(4));
        view.setIcon(icon);
        Image gotoIcon = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_RIGHT, UIManager.getInstance().getComponentStyle("GoToIcon"));
        view.setEmblem(gotoIcon);
        view.setEmblemPosition("East");
        view.addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(EDIT_PAYMENT);
            if (action != null) {
                action.fireEvent(model, PaymentMethodView.this);
            }
        });
        add(BorderLayout.CENTER, view);
        update();
    }

    @Override
    public void update() {
        int method = getEntity().getInt(PaymentMethod.method);

        if (method == PaymentMethod.CASH){
            view.setTextLine2("Cash on delivery");
        }else if(method == PaymentMethod.CREDIT_CARD){
            Entity card = getEntity().getEntity(PaymentMethod.creditCard);
            String cardNumber = card.getText(CreditCard.number);
            String cardLastFourNumbers = cardNumber.substring(12);
            view.setTextLine2("**** **** **** " + cardLastFourNumbers);
        }else if(method == PaymentMethod.APPLE_PAY){
            view.setTextLine2("Apple Pay");
        }else if(method == PaymentMethod.PAYPAL){
            view.setTextLine2("PayPal");
        }
    }

    @Override
    public void commit() {

    }

    @Override
    public Node getViewNode() {
        return null;
    }
}
