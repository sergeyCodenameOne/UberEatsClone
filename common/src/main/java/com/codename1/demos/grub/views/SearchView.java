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
