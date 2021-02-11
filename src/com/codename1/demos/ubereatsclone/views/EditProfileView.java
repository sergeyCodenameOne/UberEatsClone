package com.codename1.demos.ubereatsclone.views;

import com.codename1.demos.ubereatsclone.interfaces.Account;
import com.codename1.rad.controllers.ActionSupport;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.Property;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;


public class EditProfileView extends AbstractEntityView {

    Node viewNode;
    Property firstNameProp, lastNameProp, emailProp, passwordProp, mobileNumberProp;

    public EditProfileView(Entity entity, Node viewNode) {
        super(entity);
        this.viewNode = viewNode;
        setLayout(new BorderLayout());
        setUIID("EditProfile");

        firstNameProp = entity.findProperty(Account.firstName);
        lastNameProp = entity.findProperty(Account.lastName);
        emailProp = entity.findProperty(Account.emailAddress);
        passwordProp = entity.findProperty(Account.password);
        mobileNumberProp = entity.findProperty(Account.mobileNumber);

        Button backButton = new Button(FontImage.MATERIAL_KEYBOARD_ARROW_LEFT);
        backButton.setUIID("EditProfileBackButton");
        backButton.addActionListener(evt -> {
            evt.consume();
            ActionSupport.dispatchEvent(new FormController.FormBackEvent(backButton));
        });
        Label headerLabel = new Label("EDIT PROFILE", "EditProfileHeaderLabel");
        Container headerCnt = BorderLayout.center(headerLabel).add(BorderLayout.WEST, backButton);
        headerCnt.setUIID("EditProfileHeaderCnt");
        add(BorderLayout.NORTH, headerCnt);

        TextField firstName = new TextField("", "First Name", 20, TextArea.ANY);
        firstName.setUIID("EditProfileField");
        firstName.getHintLabel().setUIID("SignUpFieldHint");

        TextField lastName = new TextField("", "Last Name", 20, TextArea.ANY);
        lastName.setUIID("EditProfileField");
        lastName.getHintLabel().setUIID("SignUpFieldHint");

        TextField emailAddress = new TextField("", "Email Address", 20, TextArea.EMAILADDR);
        emailAddress.setUIID("EditProfileField");
        emailAddress.getHintLabel().setUIID("SignUpFieldHint");

        TextField password = new TextField("", "Password", 20, TextArea.PASSWORD);
        password.setUIID("EditProfileField");
        password.getHintLabel().setUIID("SignUpFieldHint");

        TextField phoneNumber = new TextField("", "Mobile Number", 20, TextArea.PHONENUMBER);
        phoneNumber.setUIID("EditProfileField");
        phoneNumber.getHintLabel().setUIID("SignUpFieldHint");
        add(BorderLayout.CENTER, BoxLayout.encloseY(firstName, lastName, emailAddress, password, phoneNumber));

        Validator validator = new Validator();
        validator.setValidationFailedEmblem(FontImage.createMaterial(FontImage.MATERIAL_ERROR, UIManager.getInstance().getComponentStyle("TextErrorIcon")));
        validator.setValidationEmblemPositionX(0.9f);
        validator.addConstraint(firstName, new LengthConstraint(1));
        validator.addConstraint(lastName, new LengthConstraint(1));
        validator.addConstraint(emailAddress, RegexConstraint.validEmail());
        validator.addConstraint(password, new LengthConstraint(8));
        validator.addConstraint(phoneNumber, new LengthConstraint(10));

        Button saveButton = new Button("Save", "EditProfileSaveButton");
        validator.addSubmitButtons(saveButton);
        saveButton.addActionListener(evt -> {
            evt.consume();
            entity.set(Account.firstName, firstName.getText());
            entity.set(Account.lastName, lastName.getText());
            entity.set(Account.emailAddress, emailAddress.getText());
            entity.set(Account.password, password.getText());
            entity.set(Account.mobileNumber, phoneNumber.getText());
            ActionSupport.dispatchEvent(new FormController.FormBackEvent(saveButton));
        });
        add(BorderLayout.SOUTH, BoxLayout.encloseY(saveButton));

    }

    @Override
    public void update() {

    }

    @Override
    public void commit() {

    }

    @Override
    public Node getViewNode() {
        return viewNode;
    }
}
