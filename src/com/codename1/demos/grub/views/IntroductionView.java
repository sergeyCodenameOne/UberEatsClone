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
