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
import com.codename1.demos.grub.Grub;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.*;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;

import static com.codename1.ui.CN.getDisplayWidth;
import static com.codename1.ui.util.Resources.getGlobalResources;

public class AccountView extends AbstractEntityView {

    Node viewNode;

    public static final ActionNode.Category SIGN_IN = new ActionNode.Category();
    public static final ActionNode.Category SIGN_UP = new ActionNode.Category();
    public static final ActionNode.Category DARK_MODE = new ActionNode.Category();


    public AccountView(Entity entity, Node viewNode, Node grubNode) {
        super(entity);
        this.viewNode = viewNode;

        Container wrapper = new Container(new BorderLayout());
        setUIID("AccountCnt");

        Button darkModeButton = new Button("LIGHT", "DarkModeButton");
        darkModeButton.setIcon(FontImage.createMaterial(FontImage.MATERIAL_FIBER_MANUAL_RECORD, UIManager.getInstance().getComponentStyle("DarkModeButtonIcon")));
        darkModeButton.addActionListener(evt->{
            evt.consume();
            if (Grub.isDarkMode()){
                darkModeButton.setText("LIGHT");
            }else{
                darkModeButton.setText("DARK");
            }
            ActionNode action = grubNode.getInheritedAction(DARK_MODE);
            if (action != null) {
                action.fireEvent(entity, AccountView.this);
            }
            darkModeButton.getParent().revalidateWithAnimationSafety();
        });


        Button signIn = new Button("Sign In", "SignInButton");
        signIn.addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(SIGN_IN);
            if (action != null) {
                action.fireEvent(entity, AccountView.this);
            }
        });

        Button signUp = new Button("Sign Up", "SignUpButton");
        signUp.addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(SIGN_UP);
            if (action != null) {
                action.fireEvent(entity, AccountView.this);
            }
        });

        Image grubLogo = getGlobalResources().getImage("grub-logo-full.png");
        ScaleImageLabel logoLabel = new ScaleImageLabel(grubLogo){
            @Override
            public Dimension getPreferredSize() {

                int width = CN.isTablet() ? getDisplayWidth() / 4 : getDisplayWidth() / 2;
                return new Dimension(getDisplayWidth() / 2 , (int)(width / 1.4));
            }
        };
        Label welcomeText = new Label("WELCOME TO GRUB APP", "AccountWelcomeText");

        Container topView = BoxLayout.encloseY(logoLabel, welcomeText, BorderLayout.centerAbsolute(darkModeButton));
        topView.setUIID("AccountTopView");
        wrapper.add(BorderLayout.NORTH, topView);
        wrapper.add(BorderLayout.SOUTH, BoxLayout.encloseY(signUp, signIn));
        if (CN.isTablet()){
            setLayout(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        } else{
            setLayout(new BorderLayout());
        }
        add(BorderLayout.CENTER, wrapper);
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
