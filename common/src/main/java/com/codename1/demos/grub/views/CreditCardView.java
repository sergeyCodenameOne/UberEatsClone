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
