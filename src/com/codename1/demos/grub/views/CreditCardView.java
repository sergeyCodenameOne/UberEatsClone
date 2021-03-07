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

import com.codename1.demos.grub.interfaces.CreditCard;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.Property;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.Label;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;

import static com.codename1.ui.CN.convertToPixels;

public class CreditCardView extends AbstractEntityView {

    Property numberProp, expirationYearProp, expirationMonthProp;

    public static final ActionNode.Category SET_CARD_TO_PAY = new ActionNode.Category();

    public CreditCardView(Entity creditCard, Node viewNode) {
        super(creditCard);
        setLayout(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER));
        setUIID("CreditCard");

        numberProp = creditCard.findProperty(CreditCard.number);
        expirationYearProp = creditCard.findProperty(CreditCard.expirationYear);
        expirationMonthProp = creditCard.findProperty(CreditCard.expirationMonth);

        String number = creditCard.getText(numberProp);
        String expirationYear = creditCard.getText(expirationYearProp);
        String expirationMonth = creditCard.getText(expirationMonthProp);
        String cardLastFourNumbers = number.substring(12);

        Button numberButton = new Button("****  ****  ****  " + cardLastFourNumbers, "CreditCardNumber");
        Label expirationDate = new Label(expirationMonth + "/" + expirationYear, "CreditCardExpirationDate");

        add(BorderLayout.CENTER, numberButton);
        add(BorderLayout.SOUTH, expirationDate);

        numberButton.addActionListener(evt -> {
            evt.consume();
            if (viewNode != null){
                ActionNode action = viewNode.getInheritedAction(SET_CARD_TO_PAY);
                if (action != null) {
                    action.fireEvent(creditCard, CreditCardView.this);
                }
            }
        });
        setLeadComponent(numberButton);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension dim =  super.getPreferredSize();
        int width = Display.getInstance().getDisplayWidth() - getComponentForm().getContentPane().getAllStyles().getHorizontalPadding() - convertToPixels(2);
        dim.setWidth(width);
        dim.setHeight((Display.getInstance().getDisplayWidth() - this.getParent().getAllStyles().getHorizontalPadding()) / 2);
        return dim;
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
