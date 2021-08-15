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
import com.codename1.demos.grub.interfaces.Account;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;

import static com.codename1.ui.CN.convertToPixels;
import static com.codename1.ui.util.Resources.getGlobalResources;

public class SignUpView extends AbstractEntityView {

    public SignUpView(Entity entity, Node applicationControllerViewNode, Node accountViewNode) {
        super(entity);
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        setUIID("SignUpCnt");
        setScrollableY(true);
        Container wrapper = new Container(new BorderLayout());

        Label signUpHeader = new Label("Create An Account", "SignUpHeader");
        Image grubLogo = getGlobalResources().getImage("grub-logo.png");
        ScaleImageLabel logoLabel = new ScaleImageLabel(grubLogo);
        Container signUpTopView = BoxLayout.encloseY(logoLabel, signUpHeader);
        signUpTopView.setUIID("SignUpTopView");
        wrapper.add(BorderLayout.NORTH, signUpTopView);


        TextField firstName = new TextField("", "First Name", 20, TextArea.ANY);
        firstName.setUIID("SignUpField");
        firstName.getHintLabel().setUIID("SignUpFieldHint");

        TextField lastName = new TextField("", "Last Name", 20, TextArea.ANY);
        lastName.setUIID("SignUpField");
        lastName.getHintLabel().setUIID("SignUpFieldHint");

        TextField emailAddress = new TextField("", "Email Address", 20, TextArea.EMAILADDR);
        emailAddress.setUIID("SignUpField");
        emailAddress.getHintLabel().setUIID("SignUpFieldHint");

        TextField password = new TextField("", "Password", 20, TextArea.PASSWORD);
        password.setUIID("SignUpField");
        password.getHintLabel().setUIID("SignUpFieldHint");

        TextField phoneNumber = new TextField("", "Mobile Number", 20, TextArea.PHONENUMBER);
        phoneNumber.setUIID("SignUpField");
        phoneNumber.getHintLabel().setUIID("SignUpFieldHint");
        wrapper.add(BorderLayout.CENTER, BoxLayout.encloseY(firstName, lastName, emailAddress, password, phoneNumber));

        Validator validator = new Validator();
        validator.addConstraint(firstName, new LengthConstraint(1));
        validator.addConstraint(lastName, new LengthConstraint(1));
        validator.addConstraint(emailAddress, RegexConstraint.validEmail());
        validator.addConstraint(password, new LengthConstraint(8));
        validator.addConstraint(phoneNumber, new LengthConstraint(10));

        Button confirmSignUp = new Button("Sign Up", "SignUpConfirmButton");
        validator.addSubmitButtons(confirmSignUp);
        confirmSignUp.addActionListener(evt -> {
            evt.consume();
            entity.set(Account.firstName, firstName.getText());
            entity.set(Account.lastName, lastName.getText());
            entity.set(Account.emailAddress, emailAddress.getText());
            entity.set(Account.password, password.getText());
            entity.set(Account.mobileNumber, phoneNumber.getText());

            ActionNode action = applicationControllerViewNode.getInheritedAction(SignInView.COMPLETE_SIGNING_IN);
            if (action != null) {
                action.fireEvent(entity, SignUpView.this);
            }
        });

        Label goToSignInLabel = new Label("ALREADY HAVE AN ACCOUNT?", "SignUpLabel");
        Button goToSignInButton = new Button("SIGN IN", "GoToSighInButton");

        goToSignInButton.addActionListener(evt->{
            evt.consume();
            ActionNode action = accountViewNode.getInheritedAction(AccountView.SIGN_IN);
            if (action != null) {
                action.fireEvent(entity, SignUpView.this);
            }
        });

        Label continueWith = new Label("----OR CONTINUE WITH----", "SignUpLabel");
        Button forgotPassword = new Button("FORGOT PASSWORD?", "SignUpLabel");

        Image facebookIconImage = getGlobalResources().getImage("facebook-icon.png").scaled(convertToPixels(5), convertToPixels(5));
        Image googleIconImage = getGlobalResources().getImage("google-icon.png").scaled(convertToPixels(5), convertToPixels(5));
        Image appleIconImage = getGlobalResources().getImage("apple-icon.png").scaled(convertToPixels(5), convertToPixels(5));

        Button faceBookIconButton = new Button(facebookIconImage);
        Button googleIconButton = new Button(googleIconImage);
        Button appleIconButton = new Button(appleIconImage);


        Container signUpOptionsCnt = BoxLayout.encloseY(confirmSignUp,
                FlowLayout.encloseCenter(goToSignInLabel, goToSignInButton),
                continueWith,
                FlowLayout.encloseCenter(faceBookIconButton, googleIconButton, appleIconButton),
                forgotPassword);
        signUpOptionsCnt.setUIID("SignUpOptionsCnt");

        wrapper.add(BorderLayout.SOUTH, signUpOptionsCnt);
        if (CN.isTablet()){
            setLayout(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
            add(BorderLayout.CENTER, wrapper);
        }else{
            add(wrapper);
        }
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
