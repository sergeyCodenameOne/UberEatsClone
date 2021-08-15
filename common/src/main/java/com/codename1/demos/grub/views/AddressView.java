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
