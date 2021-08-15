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

import com.codename1.demos.grub.views.FirstIntroductionView;
import com.codename1.demos.grub.views.IntroductionView;
import com.codename1.demos.grub.views.SecondIntroductionView;
import com.codename1.rad.controllers.Controller;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.nodes.ViewNode;
import com.codename1.rad.ui.UI;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

public class IntroductionController extends FormController {

    public static final ActionNode enterSecondIntroduction = UI.action();
    public static final ActionNode enterThirdIntroduction = UI.action();

    public IntroductionController(Controller parent, Entity account, Node viewNode) {
        super(parent);

        ViewNode introNode = new ViewNode(
                UI.actions(FirstIntroductionView.FINISHED_FIRST_INTRO, enterSecondIntroduction),
                UI.actions(SecondIntroductionView.FINISHED_SECOND_INTRO, enterThirdIntroduction)
        );

        Form introForm = new Form(new BorderLayout());
        introForm.getToolbar().hideToolbar();
        IntroductionView introView = new IntroductionView(account, viewNode, introNode);
        introForm.add(BorderLayout.CENTER, introView);
        setView(introForm);

        addActionListener(enterSecondIntroduction, event->{
            event.consume();
            introView.setIntroPage(1);
        });

        addActionListener(enterThirdIntroduction, event->{
            event.consume();
            introView.setIntroPage(2);
        });
    }
}
