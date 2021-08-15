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
import com.codename1.ui.plaf.Style;

import static com.codename1.ui.util.Resources.getGlobalResources;

public class SecondIntroductionView extends AbstractEntityView {

    public static final ActionNode.Category FINISHED_SECOND_INTRO = new ActionNode.Category();

    public SecondIntroductionView(Entity entity, Node grubNode, Node introNode) {
        super(entity);
        setLayout(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER));
        Container wrapper = new Container(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("IntroductionView");

        Label header = new Label("Order Your Favorite", "IntroductionHeader");

        String imageName = Grub.isDarkMode() ? "second-intro-image-dark.png" : "second-intro-image.png";
        ScaleImageLabel introImage = new ScaleImageLabel(getGlobalResources().getImage(imageName)){
            @Override
            public Dimension getPreferredSize() {
                Dimension dim = super.getPreferredSize();
                if (CN.isTablet()){
                    dim.setWidth(Display.getInstance().getDisplayWidth() / 2);
                    dim.setHeight((int) (Display.getInstance().getDisplayWidth() / 3));
                }else{
                    dim.setWidth(Display.getInstance().getDisplayWidth());
                    dim.setHeight((int) (Display.getInstance().getDisplayWidth() / 1.5));
                }
                return dim;
            }
        };
        introImage.setUIID("IntroImage");
        introImage.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED);

        Label emptyFirstLabel = new Label ("    ", "IntroEmptyLabelOff");
        Label emptySecondLabel = new Label ("    ", "IntroEmptyLabelOn");
        Label emptyThirdLabel = new Label ("    ", "IntroEmptyLabelOff");
        Container progressCnt = BoxLayout.encloseXCenter(emptyFirstLabel, emptySecondLabel, emptyThirdLabel);

        Button next = new Button("NEXT", "IntroductionNextButton");
        next.addActionListener(evt->{
            evt.consume();
            ActionNode action = introNode.getInheritedAction(FINISHED_SECOND_INTRO);
            if (action != null) {
                action.fireEvent(entity, SecondIntroductionView.this);
            }
        });

        Button skip = new Button("SKIP", "IntroductionSkipButton");
        skip.addActionListener(evt -> {
            evt.consume();
            ActionNode action = grubNode.getInheritedAction(Grub.SKIP_TO_MAIN_WINDOW);
            if (action != null) {
                action.fireEvent(null, SecondIntroductionView.this);
            }
        });

        wrapper.add(BorderLayout.CENTER, BoxLayout.encloseY(header, introImage));
        wrapper.add(BorderLayout.SOUTH, BoxLayout.encloseY(progressCnt, next, skip));

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
        return null;
    }
}
