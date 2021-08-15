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
