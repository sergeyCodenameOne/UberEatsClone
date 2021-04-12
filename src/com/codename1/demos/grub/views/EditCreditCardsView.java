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

import com.codename1.demos.grub.interfaces.Account;
import com.codename1.rad.controllers.ActionSupport;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.EntityList;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;

public class EditCreditCardsView extends AbstractEntityView {

    Node viewNode;
    Container cardsCnt;

    public static final ActionNode.Category ADD_NEW_CARD = new ActionNode.Category();

    public EditCreditCardsView(Entity entity, Node viewNode) {
        super(entity);
        this.viewNode = viewNode;
        setUIID("EditCreditCardsView");
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        setScrollVisible(false);
        setScrollableY(true);

        Button backButton = new Button(FontImage.MATERIAL_KEYBOARD_ARROW_LEFT);
        backButton.setUIID("EditCreditCardsBackButton");
        backButton.addActionListener(evt -> {
            evt.consume();
            ActionSupport.dispatchEvent(new FormController.FormBackEvent(backButton));
        });
        Label headerLabel = new Label("PAYMENT METHOD", "EditCreditCardsHeaderLabel");
        Container headerCnt = BorderLayout.center(headerLabel).add(BorderLayout.WEST, backButton);
        headerCnt.setUIID("EditCreditCardsHeaderCnt");
        add(headerCnt);

        Label savedCards = new Label("Saved Cards", "SavedCardsHeader");
        add(savedCards);
        cardsCnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        add(cardsCnt);

        Button addCreditCardIcon = new Button(FontImage.createMaterial(FontImage.MATERIAL_ADD, UIManager.getInstance().getComponentStyle("AddCreditCardIcon")));
        Label addCreditCardText = new Label("Add Card", "AddCreditCardText");
        Container addCreditCardButton = BorderLayout.centerAbsolute(BoxLayout.encloseY(addCreditCardIcon, addCreditCardText));
        addCreditCardButton.setUIID("AddCreditCardButton");
        addCreditCardButton.setLeadComponent(addCreditCardIcon);
        addCreditCardIcon.addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(EditCreditCardsView.ADD_NEW_CARD);
            if (action != null) {
                action.fireEvent(entity, EditCreditCardsView.this);
            }
        });
        add(addCreditCardButton);
        update();
    }

    @Override
    public void update() {
        cardsCnt.removeAll();
        if(getEntity().get(Account.creditCards) instanceof EntityList){
        EntityList<Entity> cardsList = (EntityList<Entity>) getEntity().get(Account.creditCards);
            for(Entity currCard : cardsList){
                cardsCnt.add(new CreditCardView(currCard, null));
            }
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
