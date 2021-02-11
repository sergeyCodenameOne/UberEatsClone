package com.codename1.demos.ubereatsclone.views;

import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.demos.ubereatsclone.Util;
import com.codename1.demos.ubereatsclone.interfaces.Account;
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

public class ProfileView<T extends Entity> extends AbstractEntityView<T> {

    private Property firstNameProp, lastNameProp, phoneNumberProp;
    Node viewNode;

    public static final ActionNode.Category EDIT_PROFILE = new ActionNode.Category();
    public static final ActionNode.Category EDIT_ADDRESSES = new ActionNode.Category();
    public static final ActionNode.Category EDIT_CREDIT_CARDS = new ActionNode.Category();
    public static final ActionNode.Category LOG_OUT = new ActionNode.Category();
    public static final ActionNode.Category UPDATE_VIEW = new ActionNode.Category();

    public ProfileView(T account, Node viewNode) {
        super(account);
        this.viewNode = viewNode;
        setLayout(new BorderLayout());
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

        Image profileImage = FontImage.createMaterial(FontImage.MATERIAL_SENTIMENT_SATISFIED_ALT, UIManager.getInstance().getComponentStyle("ProfileImage")).
                toEncodedImage().
                fill(convertToPixels(8), convertToPixels(8));
        profileImage = profileImage.applyMask(Util.createRoundMask(profileImage.getWidth()));
        ScaleImageLabel profileImageLabel = new ScaleImageLabel(profileImage);
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

        add(BorderLayout.NORTH, headerCnt).add(BorderLayout.CENTER, profileCnt).add(BorderLayout.SOUTH, profileActions);
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
