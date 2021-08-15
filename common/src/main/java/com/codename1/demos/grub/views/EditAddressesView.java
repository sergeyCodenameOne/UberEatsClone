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
import com.codename1.demos.grub.interfaces.Account;
import com.codename1.rad.controllers.ActionSupport;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.EntityList;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;

public class EditAddressesView extends AbstractEntityView {

    public static final ActionNode.Category ADD_NEW_ADDRESS = new ActionNode.Category();
    public static final ActionNode.Category EDIT_ADDRESS = new ActionNode.Category();

    Node viewNode;

    Container addressesCnt;

    public EditAddressesView(Entity entity, Node viewNode) {
        super(entity);
        this.viewNode = viewNode;
        setLayout(new BorderLayout());
        setUIID("EditAddresses");

        Button backButton = new Button(FontImage.MATERIAL_KEYBOARD_ARROW_LEFT);
        backButton.setUIID("EditAddressesBackButton");
        backButton.addActionListener(evt -> {
            evt.consume();
            ActionSupport.dispatchEvent(new FormController.FormBackEvent(backButton));
        });

        Label headerLabel = new Label("MY ADDRESSES", "EditAddressesHeaderLabel");
        Container headerCnt = BorderLayout.center(headerLabel).add(BorderLayout.WEST, backButton);
        headerCnt.setUIID("EditAddressesHeaderCnt");

        Label savedAddresses = new Label("Saved Addresses", "SavedAddressesHeader");
        MultiButton addAddressButton = new MultiButton("ADD ADDRESS");
        addAddressButton.setUIID("AddAddressButton");
        addAddressButton.setUIIDLine1("AddAddressButtonText");

        addAddressButton.addActionListener(evt->{
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(ADD_NEW_ADDRESS);
            if (action != null) {
                action.fireEvent(entity, EditAddressesView.this);
            }
        });

        Image addAddressIcon = FontImage.createMaterial(FontImage.MATERIAL_ADD, UIManager.getInstance().getComponentStyle("AddAddressButtonText"));
        addAddressButton.setIcon(addAddressIcon);
        addAddressButton.setIconPosition("East");
        add(BorderLayout.NORTH, BoxLayout.encloseY(headerCnt, savedAddresses, addAddressButton));

        addressesCnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        addressesCnt.setScrollVisible(false);
        addressesCnt.setScrollableY(true);
        add(BorderLayout.CENTER, addressesCnt);
        update();
    }

    @Override
    public void update() {
        EntityList<Entity> addressesList = getEntity().getEntityList(Account.addresses);
        addressesCnt.removeAll();
        for (Entity address : addressesList){
            addressesCnt.add(new AddressView(address, viewNode));
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
