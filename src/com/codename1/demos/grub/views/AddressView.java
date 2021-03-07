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

import com.codename1.components.ScaleImageLabel;
import com.codename1.demos.grub.interfaces.Address;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;

public class AddressView extends AbstractEntityView {

    public AddressView(Entity entity, Node viewNode) {
        super(entity);
        setLayout(new BorderLayout());
        boolean isDefault = entity.getBoolean(Address.isDefault);
        char fontImageChar;
        String type = "";
        switch (entity.getInt(Address.type)){
            case Address.WORK:
                fontImageChar = FontImage.MATERIAL_WORK;
                type = "Work";
                break;
            case Address.OTHER:
                fontImageChar = FontImage.MATERIAL_LOCATION_ON;
                type = "Other";
                break;
            default:
                fontImageChar = FontImage.MATERIAL_HOME;
                type = "Home";
                break;
        }

        Style imageStyle;
        String addressViewStyle;

        if (isDefault){
            imageStyle = UIManager.getInstance().getComponentStyle("AddressViewImageSelectedStyle");
            addressViewStyle ="AddressViewSelectedStyle";
        }else{
            imageStyle = UIManager.getInstance().getComponentStyle("AddressViewImageStyle");
            addressViewStyle ="AddressViewStyle";
        }
        setUIID(addressViewStyle);

        Button typeButton = new Button(type, "AddressViewType");
        typeButton.addActionListener(evt->{
            ActionNode action = viewNode.getInheritedAction(EditAddressesView.EDIT_ADDRESS);
            if (action != null) {
                action.fireEvent(entity, AddressView.this);
            }
        });

        ScaleImageLabel addressImage = new ScaleImageLabel(FontImage.createMaterial(fontImageChar, imageStyle));
        Label locationLabel = new Label(entity.getText(Address.city) + ", " + entity.getText(Address.street), "AddressViewLocation");

        add(BorderLayout.WEST, addressImage).
                add(BorderLayout.CENTER, BoxLayout.encloseY(typeButton, locationLabel));

        setLeadComponent(typeButton);
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
