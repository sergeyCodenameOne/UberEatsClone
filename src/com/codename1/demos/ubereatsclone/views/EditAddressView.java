package com.codename1.demos.ubereatsclone.views;

import com.codename1.demos.ubereatsclone.interfaces.Address;
import com.codename1.demos.ubereatsclone.models.AddressModel;
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

public class EditAddressView extends AbstractEntityView {

    Property cityProp, typeProp, streetProp, additionalInfoProp;

    public static final ActionNode.Category FINISHED_EDIT_ADDRESS = new ActionNode.Category();


    public EditAddressView(AddressModel address, Node viewNode) {
        super(address);
        setLayout(new BorderLayout());
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
        Label headerLabel = new Label("EDIT ADDRESS", "EditAddressesHeaderLabel");
        Container headerCnt = BorderLayout.center(headerLabel).add(BorderLayout.WEST, backButton);
        headerCnt.setUIID("EditAddressesHeaderCnt");
        add(BorderLayout.NORTH, headerCnt);

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

        add(BorderLayout.CENTER, BoxLayout.encloseY(FlowLayout.encloseCenter(home, work, other), city, street, freeText, defaultAddress));

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

            ActionNode action = viewNode.getInheritedAction(EditAddressView.FINISHED_EDIT_ADDRESS);
            if (action != null) {
                action.fireEvent(address, EditAddressView.this);
            }
        });

        add(BorderLayout.SOUTH, saveAddress);



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
