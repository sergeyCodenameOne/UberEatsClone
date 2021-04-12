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
