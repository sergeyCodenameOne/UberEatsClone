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

import com.codename1.demos.grub.models.CreditCardModel;
import com.codename1.rad.controllers.ActionSupport;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.validation.Constraint;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.Validator;

public class AddCreditCardView extends AbstractEntityView {

    Node viewNode;
    public static final ActionNode.Category FINISH_CREATING_CARD = new ActionNode.Category();

    public AddCreditCardView(Entity entity, Node viewNode) {
        super(entity);
        this.viewNode = viewNode;
        Container wrapper = new Container(new BorderLayout());
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        setScrollableY(true);
        setUIID("AddCreditCardView");

        Button backButton = new Button(FontImage.MATERIAL_KEYBOARD_ARROW_LEFT);
        backButton.setUIID("NewCreditCardBackButton");
        backButton.addActionListener(evt -> {
            evt.consume();
            ActionSupport.dispatchEvent(new FormController.FormBackEvent(backButton));
        });

        Label headerLabel = new Label("EDIT ADDRESS", "NewCreditCardHeaderLabel");
        Container headerCnt = BorderLayout.center(headerLabel).add(BorderLayout.WEST, backButton);
        headerCnt.setUIID("NewCreditCardHeaderCnt");
        wrapper.add(BorderLayout.NORTH, headerCnt);

        TextField name = new TextField("", "", 20, TextArea.ANY);
        name.setUIID("NewCardField");

        TextField month = new TextField("", "Month", 20, TextArea.NUMERIC);
        month.setUIID("NewCardField");
        month.getHintLabel().setUIID("NewCardFieldHint");

        TextField year = new TextField("", "Year", 20, TextArea.NUMERIC);
        year.setUIID("NewCardField");
        year.getHintLabel().setUIID("NewCardFieldHint");

        TextField num1 = new TextField("", "1234", 4, TextArea.NUMERIC);
        num1.setUIID("NewCardField");
        num1.getHintLabel().setUIID("NewCardFieldHint");
        TextField num2 = new TextField("", "1234", 4, TextArea.NUMERIC);
        num2.setUIID("NewCardField");
        num2.getHintLabel().setUIID("NewCardFieldHint");
        TextField num3 = new TextField("", "1234", 4, TextArea.NUMERIC);
        num3.setUIID("NewCardField");
        num3.getHintLabel().setUIID("NewCardFieldHint");
        TextField num4 = new TextField("", "1234", 4, TextArea.NUMERIC);
        num4.setUIID("NewCardField");
        num4.getHintLabel().setUIID("NewCardFieldHint");

        num1.addDataChangedListener((i, ii) -> {
            if(num1.getText().length() == 4) {
                num1.stopEditing(()->{
                    num2.startEditing();
                });
            }
        });

        num2.addDataChangedListener((i, ii) -> {
            if(num2.getText().length() == 4) {
                num2.stopEditing(num3::startEditing);
            }
        });
        num3.addDataChangedListener((i, ii) -> {
            if(num3.getText().length() == 4) {
                num3.stopEditing(num4::startEditing);
            }
        });
        num4.addDataChangedListener((i, ii) -> {
            if(num4.getText().length() == 4) {
                num4.stopEditing();
            }
        });

        Validator validator = new Validator();
        validator.addConstraint(name, new LengthConstraint(1));
        Constraint monthConstraint = new Constraint(){
            @Override
            public boolean isValid(Object value) {
                if (value instanceof String){
                    String text = (String) value;
                    try{
                        return (Integer.valueOf(text) < 13 && Integer.valueOf(text) > 0);
                    }catch(NumberFormatException e){
                        return false;
                    }
                }
                return false;
            }
            @Override
            public String getDefaultFailMessage() {
                return null;
            }
        };
        validator.addConstraint(month, monthConstraint);
        Constraint yearConstraint = new Constraint(){
            @Override
            public boolean isValid(Object value) {
                if (value instanceof String){
                    String text = (String) value;
                    try{
                        return (Integer.valueOf(text) > 2000 && Integer.valueOf(text) < 2100);
                    }catch(NumberFormatException e){
                        return false;
                    }
                }
                return false;
            }
            @Override
            public String getDefaultFailMessage() {
                return null;
            }
        };
        validator.addConstraint(year, yearConstraint);
        Constraint creditCardFieldConstraint = new Constraint(){
            @Override
            public boolean isValid(Object value) {
                if (value instanceof String){
                    String text = (String) value;
                        return (text.length() == 4);
                }
                return false;
            }
            @Override
            public String getDefaultFailMessage() {
                return null;
            }
        };
        validator.addConstraint(num1, creditCardFieldConstraint);
        validator.addConstraint(num2, creditCardFieldConstraint);
        validator.addConstraint(num3, creditCardFieldConstraint);
        validator.addConstraint(num4, creditCardFieldConstraint);
        wrapper.add(BorderLayout.CENTER, BoxLayout.encloseY(
                new Label("Cardholder Name", "AddNewCardExplanation"),
                name,
                new Label("Credit Card Number", "AddNewCardExplanation"),
                GridLayout.encloseIn(4, num1, num2, num3, num4),
                new Label("Expiration Date", "AddNewCardExplanation"),
                GridLayout.encloseIn(2, month, year)
                ));

        Button saveCard = new Button("SAVE CARD", "SaveCardConfirmButton");
        validator.addSubmitButtons(saveCard);
        saveCard.addActionListener(evt -> {
            evt.consume();
            Entity creditCard = new CreditCardModel(name.getText(), num1.getText() + num2.getText() +num3.getText() +num4.getText(), year.getText(), month.getText());

            ActionNode action = viewNode.getInheritedAction(AddCreditCardView.FINISH_CREATING_CARD);
            if (action != null) {
                action.fireEvent(creditCard, AddCreditCardView.this);
            }
        });

        wrapper.add(BorderLayout.SOUTH, saveCard);
        add(wrapper);
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
