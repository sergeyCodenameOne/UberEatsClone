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
import com.codename1.components.ScaleImageLabel;
import com.codename1.demos.grub.interfaces.Account;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.Property;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;

import static com.codename1.ui.CN.convertToPixels;
import static com.codename1.ui.CN.getDisplayHeight;
import static com.codename1.ui.util.Resources.getGlobalResources;

public class ProfileView<T extends Entity> extends AbstractEntityView<T> {

    private Property firstNameProp, lastNameProp, phoneNumberProp;
    Node viewNode;

    public static final ActionNode.Category EDIT_PROFILE = new ActionNode.Category();
    public static final ActionNode.Category EDIT_ADDRESSES = new ActionNode.Category();
    public static final ActionNode.Category EDIT_CREDIT_CARDS = new ActionNode.Category();
    public static final ActionNode.Category LOG_OUT = new ActionNode.Category();
    public static final ActionNode.Category UPDATE_VIEW = new ActionNode.Category();

    public ProfileView(T account, Node mainWindowNode, Node appNode) {
        super(account);
        this.viewNode = mainWindowNode;
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        setScrollableY(true);
        setScrollVisible(false);
        setUIID("ProfileCnt");

        firstNameProp = account.findProperty(Account.firstName);
        lastNameProp = account.findProperty(Account.lastName);
        phoneNumberProp = account.findProperty(Account.mobileNumber);

        Label header = new Label("Profile", "ProfileHeader");
        Container headerCnt = BorderLayout.center(header);
        headerCnt.setUIID("ProfileHeaderCnt");

        Style buttonEmblemStyle = UIManager.getInstance().getComponentStyle("ProfileButtonEmblemStyle");
        Label firstNameLabel = new Label(account.getText(firstNameProp), "ProfileFirstNameLabel");
        Label lastNameLabel = new Label(account.getText(lastNameProp), "ProfileLastNameLabel");
        Label mobileNumberLabel  = new Label(account.getText(phoneNumberProp), "ProfilePhoneLabel");
        Image phoneImage= FontImage.createMaterial(FontImage.MATERIAL_STAY_CURRENT_PORTRAIT, buttonEmblemStyle);
        mobileNumberLabel.setIcon(phoneImage);
        ScaleImageLabel profileImageLabel = new ScaleImageLabel(getGlobalResources().getImage("account-place-holder.png").fill(convertToPixels(8), convertToPixels(8)));
        profileImageLabel.setUIID("ProfileImageLabel");

        Container profileCnt = new Container(new BorderLayout());
        profileCnt.setUIID("ProfileInfoCnt");
        profileCnt.add(BorderLayout.NORTH, profileImageLabel).
                add(BorderLayout.CENTER, BoxLayout.encloseY(FlowLayout.encloseCenter(firstNameLabel, lastNameLabel), mobileNumberLabel));


        Image buttonGoToIcon = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_RIGHT,
                UIManager.getInstance().getComponentStyle("ProfileButtonsGoToIcon"));

        MultiButton editProfile = new MultiButton("Edit Profile");
        editProfile.setEmblem(FontImage.createMaterial(FontImage.MATERIAL_INFO, buttonEmblemStyle));
        editProfile.setEmblemPosition("West");
        editProfile.setIcon(buttonGoToIcon);
        editProfile.setUIID("ProfileActionButton");
        editProfile.setUIIDLine1("ProfileActionButtonText");
        editProfile.setIconPosition("East");
        editProfile.addActionListener(evt-> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(EDIT_PROFILE);
            if (action != null){
                action.fireEvent(account, ProfileView.this);
            }
        });

        MultiButton myAddressButton = new MultiButton("My Address");
        myAddressButton.setEmblem(FontImage.createMaterial(FontImage.MATERIAL_LOCATION_ON, buttonEmblemStyle));
        myAddressButton.setEmblemPosition("West");
        myAddressButton.setIcon(buttonGoToIcon);
        myAddressButton.setUIID("ProfileActionButton");
        myAddressButton.setUIIDLine1("ProfileActionButtonText");
        myAddressButton.setIconPosition("East");
        myAddressButton.addActionListener(evt-> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(EDIT_ADDRESSES);
            if (action != null){
                action.fireEvent(account, ProfileView.this);
            }
        });

        MultiButton paymentButton = new MultiButton("Payment");
        paymentButton.setEmblem(FontImage.createMaterial(FontImage.MATERIAL_CREDIT_CARD, buttonEmblemStyle));
        paymentButton.setEmblemPosition("West");
        paymentButton.setIcon(buttonGoToIcon);
        paymentButton.setUIID("ProfileActionButton");
        paymentButton.setUIIDLine1("ProfileActionButtonText");
        paymentButton.setIconPosition("East");
        paymentButton.addActionListener(evt-> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(EDIT_CREDIT_CARDS);
            if (action != null){
                action.fireEvent(account, ProfileView.this);
            }
        });

        MultiButton logoutButton = new MultiButton("Logout");
        logoutButton.setEmblem(FontImage.createMaterial(FontImage.MATERIAL_LOGOUT, buttonEmblemStyle));
        logoutButton.setEmblemPosition("West");
        logoutButton.setIcon(buttonGoToIcon);
        logoutButton.setUIID("ProfileActionButton");
        logoutButton.setUIIDLine1("ProfileActionButtonText");
        logoutButton.setIconPosition("East");
        logoutButton.addActionListener(evt->{
            evt.consume();
            ActionNode action = appNode.getInheritedAction(LOG_OUT);
            if (action != null){
                action.fireEvent(account, ProfileView.this);
            }
        });

        Container profileActions = new Container(new BoxLayout(BoxLayout.Y_AXIS)){
            @Override
            public Dimension getPreferredSize() {
                Dimension dim =  super.getPreferredSize();
                dim.setHeight(getDisplayHeight() / 2);
                return dim;
            }
        };
        profileActions.addAll(editProfile, myAddressButton, paymentButton, logoutButton);
        profileActions.setUIID("ProfileActionsCnt");

        add(headerCnt).
        add(profileCnt).
        add(profileActions);
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
