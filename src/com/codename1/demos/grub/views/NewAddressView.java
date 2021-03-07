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

import com.codename1.demos.grub.interfaces.Address;
import com.codename1.demos.grub.models.AddressModel;
import com.codename1.rad.controllers.ActionSupport;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Property;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.Validator;

public class NewAddressView extends AbstractEntityView {

    Property cityProp, typeProp, streetProp, additionalInfoProp;

    public static final ActionNode.Category FINISHED_NEW_ADDRESS = new ActionNode.Category();


    public NewAddressView(AddressModel address, Node viewNode) {
        super(address);
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        setScrollableY(true);
        Container wrapper = new Container(new BorderLayout());
        setUIID("NewAddress");

        cityProp = address.findProperty(Address.city);
        typeProp = address.findProperty(Address.type);
        streetProp = address.findProperty(Address.street);
        additionalInfoProp = address.findProperty(Address.additionalInfo);

        Button backButton = new Button(FontImage.MATERIAL_KEYBOARD_ARROW_LEFT);
        backButton.setUIID("EditAddressesBackButton");
        backButton.addActionListener(evt -> {
            evt.consume();
            ActionSupport.dispatchEvent(new FormController.FormBackEvent(backButton));
        });
        Label headerLabel = new Label("ADD ADDRESS", "EditAddressesHeaderLabel");
        Container headerCnt = BorderLayout.center(headerLabel).add(BorderLayout.WEST, backButton);
        headerCnt.setUIID("EditAddressesHeaderCnt");
        wrapper.add(BorderLayout.NORTH, headerCnt);

        TextField city = new TextField("", "City", 20, TextArea.ANY);
        city.setUIID("AddressField");
        city.getHintLabel().setUIID("AddressFieldHint");

        TextField street = new TextField("", "Street", 20, TextArea.ANY);
        street.setUIID("AddressField");
        street.getHintLabel().setUIID("AddressFieldHint");

        TextField freeText = new TextField("", "Free Text", 20, TextArea.ANY);
        freeText.setUIID("AddressField");
        freeText.getHintLabel().setUIID("AddressFieldHint");

        Validator validator = new Validator();
        validator.addConstraint(city, new LengthConstraint(1));
        validator.addConstraint(street, new LengthConstraint(1));

        ButtonGroup bg = new ButtonGroup();

        Style addressTypeStyle = UIManager.getInstance().getComponentStyle("AddressTypeStyle");
        Style addressTypeSelectedStyle = UIManager.getInstance().getComponentStyle("AddressTypeSelectedStyle");

        RadioButton home = RadioButton.createToggle(" Home", FontImage.createMaterial(FontImage.MATERIAL_HOME, addressTypeStyle), bg);
        home.setUIID("AddressTypeButton");
        home.setPressedIcon(FontImage.createMaterial(FontImage.MATERIAL_HOME, addressTypeSelectedStyle));

        RadioButton work = RadioButton.createToggle(" Work", FontImage.createMaterial(FontImage.MATERIAL_WORK, addressTypeStyle), bg);
        work.setUIID("AddressTypeButton");
        work.setPressedIcon(FontImage.createMaterial(FontImage.MATERIAL_WORK, addressTypeSelectedStyle));

        RadioButton other = RadioButton.createToggle(" Other", FontImage.createMaterial(FontImage.MATERIAL_PLACE, addressTypeStyle), bg);
        other.setUIID("AddressTypeButton");
        other.setPressedIcon(FontImage.createMaterial(FontImage.MATERIAL_PLACE, addressTypeSelectedStyle));

        CheckBox defaultAddress = new CheckBox("Default Address");
        defaultAddress.setUIID("DefaultAddressCheckBox");
        bg.setSelected(0);

        wrapper.add(BorderLayout.CENTER, BoxLayout.encloseY(FlowLayout.encloseCenter(home, work, other), city, street, freeText, defaultAddress));

        Button saveAddress = new Button("SAVE ADDRESS", "SaveAddressConfirmButton");
        validator.addSubmitButtons(saveAddress);
        saveAddress.addActionListener(evt -> {
            evt.consume();
            if (address instanceof AddressModel){
                address.setCity(city.getText());
                address.setStreet(street.getText());
                if(freeText.getText() != null && freeText.getText().length() > 0){
                    address.setAdditionalInfo(city.getText());
                }
                switch (bg.getSelectedIndex()){
                    case 0:
                        address.setType(Address.HOME);
                        break;
                    case 1:
                        address.setType(Address.WORK);
                        break;
                    case 2:
                        address.setType(Address.OTHER);
                        break;
                }
                address.setDefault(defaultAddress.isSelected());
            }

            ActionNode action = viewNode.getInheritedAction(NewAddressView.FINISHED_NEW_ADDRESS);
            if (action != null) {
                action.fireEvent(address, NewAddressView.this);
            }
        });

        wrapper.add(BorderLayout.SOUTH, saveAddress);
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
