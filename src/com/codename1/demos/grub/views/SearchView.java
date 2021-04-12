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

import com.codename1.demos.grub.interfaces.MainWindow;
import com.codename1.demos.grub.models.FilterModel;
import com.codename1.rad.controllers.ActionSupport;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.EntityList;
import com.codename1.rad.models.Property;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.*;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;

import static com.codename1.ui.CN.convertToPixels;
import static com.codename1.ui.util.Resources.getGlobalResources;

public class SearchView extends AbstractEntityView {

    Node viewNode;
    Property restsProp, filterProp;
    Entity appEntity;
    Container rests;

    public SearchView(Entity appEntity, Node viewNode) {
        super(appEntity);
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        this.viewNode = viewNode;
        this.appEntity = appEntity;
        setScrollableY(true);
        setScrollVisible(false);
        setUIID("SearchView");

        restsProp = appEntity.findProperty(MainWindow.restaurants);
        filterProp = appEntity.findProperty(MainWindow.filter);

        Button backButton = new Button(FontImage.MATERIAL_KEYBOARD_ARROW_LEFT);
        backButton.setUIID("SearchBackButton");
        backButton.addActionListener(evt -> {
            evt.consume();
            ActionSupport.dispatchEvent(new FormController.FormBackEvent(backButton));
        });
        Label headerLabel = new Label("RESTAURANTS", "SearchHeaderLabel");
        Container headerCnt = BorderLayout.centerCenter(headerLabel).add(BorderLayout.WEST, backButton);
        headerCnt.setUIID("SearchHeaderCnt");
        add(headerCnt);

        Image filterButtonImage = getGlobalResources().getImage("filter-button.png").scaled(convertToPixels(5), convertToPixels(5));
        Button filterButton = new Button(filterButtonImage, "HomeFilterButton") {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(convertToPixels(8), convertToPixels(8));
            }
        };
        filterButton.addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(HomeView.ENTER_FILTER);
            if (action != null) {
                action.fireEvent(appEntity, SearchView.this);
            }
        });

        TextField searchField = new TextField() {
            @Override
            public Dimension getPreferredSize() {
                Dimension dim = super.getPreferredSize();
                dim.setWidth(Display.getInstance().getDisplayWidth() / 4 * 3);
                return dim;
            }
        };

        searchField.setUIID("HomeSearchField");
        searchField.setHint("Search ...");
        searchField.getHintLabel().setUIID("HomeSearchFieldHint");
        searchField.addActionListener(evt -> {
            evt.consume();

            Entity filter = appEntity.getEntity(filterProp);
            if (filter instanceof FilterModel) {
                ((FilterModel) filter).setFreeText(searchField.getText());
                update();
                revalidateWithAnimationSafety();
            }
        });

        Container filterCnt = new Container(new FlowLayout(Component.CENTER)){
            @Override
            public Dimension getPreferredSize() {
                Dimension dim = super.getPreferredSize();
                dim.setHeight(searchField.getPreferredH() + getAllStyles().getVerticalPadding());
                return dim;
            }
        };
        filterCnt.addAll(searchField, filterButton);

        filterCnt.setUIID("SearchFilterCnt");
        add(filterCnt);
        Label categoryHeaderLabel = new Label("All Restaurants", "CategoryHeader");
        add(categoryHeaderLabel);
        final int restsCount = ((EntityList)appEntity.get(restsProp)).size();
        final int landscapeRows = restsCount % 2 == 0 ? restsCount / 2 : restsCount / 2 + 1;
        if(CN.isTablet()){
            rests = new Container(new GridLayout(landscapeRows, 2));
        }else{
            rests = new Container(new GridLayout(restsCount, 1, landscapeRows, 2));
        }
        add(rests);
        update();
    }

    @Override
    public void update() {
        if(appEntity.get(restsProp) instanceof EntityList){
            EntityList<Entity> restaurants = (EntityList)appEntity.get(restsProp);
            for (Entity rest : restaurants) {
                rests.add(new RestaurantPreview(rest, viewNode));
            }
        }
    }

    @Override
    public void commit() {

    }

    @Override
    public Node getViewNode() {
        return null;
    }

    private Container create(EntityList<Entity> restaurants) {
        Container popularCnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        popularCnt.setScrollableX(true);
        for (Entity rest : restaurants) {
            popularCnt.add(new RestaurantPreview(rest, viewNode));
        }
        return popularCnt;
    }
}
