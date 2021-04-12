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
