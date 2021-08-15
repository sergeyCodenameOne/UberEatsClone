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

import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.Tabs;
import com.codename1.ui.layouts.BorderLayout;

public class IntroductionView extends AbstractEntityView {

    Tabs tabs;

    public IntroductionView(Entity entity, Node grubNode, Node introNode) {
        super(entity);
        setLayout(new BorderLayout());
        tabs = new Tabs();
        tabs.getTabsContainer().setVisible(false);
        tabs.getTabsContainer().setHidden(true);
        tabs.addTab("", new FirstIntroductionView(entity, grubNode, introNode));
        tabs.addTab("", new SecondIntroductionView(entity, grubNode, introNode));
        tabs.addTab("", new ThirdIntroductionView(entity, grubNode, introNode));
        add(BorderLayout.CENTER, tabs);
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

    public void setIntroPage(int index){
        tabs.setSelectedIndex(index, true);
    }
}
