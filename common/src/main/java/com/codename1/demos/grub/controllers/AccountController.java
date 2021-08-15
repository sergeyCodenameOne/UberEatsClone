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

package com.codename1.demos.grub.controllers;

import com.codename1.demos.grub.views.AccountView;
import com.codename1.rad.controllers.Controller;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.nodes.ViewNode;
import com.codename1.rad.ui.UI;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

public class AccountController extends FormController {

    public static final ActionNode signUp = UI.action();
    public static final ActionNode singIn = UI.action();

    public AccountController(Controller parent, Entity accountEntity, Node viewNode) {
        super(parent);

        Form accountForm = new Form(new BorderLayout());
        accountForm.getToolbar().hideToolbar();

        ViewNode accountViewNode = new ViewNode(
                UI.actions(AccountView.SIGN_UP, signUp),
                UI.actions(AccountView.SIGN_IN, singIn)
        );

        AccountView accountView = new AccountView(accountEntity, accountViewNode, viewNode);
        accountForm.add(BorderLayout.CENTER, accountView);
        setView(accountForm);

        addActionListener(singIn, evt -> {
            evt.consume();
            new SignInController(this, accountEntity, viewNode, accountViewNode).getView().show();
        });

        addActionListener(signUp, evt -> {
            evt.consume();
            new SignUpController(this, accountEntity, viewNode, accountViewNode).getView().show();
        });


    }
}
