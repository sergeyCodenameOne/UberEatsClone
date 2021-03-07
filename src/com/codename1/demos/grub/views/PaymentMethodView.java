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
