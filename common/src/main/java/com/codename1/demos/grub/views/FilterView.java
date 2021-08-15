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
import com.codename1.demos.grub.interfaces.Filter;
import com.codename1.demos.grub.interfaces.Restaurant;
import com.codename1.rad.controllers.ActionSupport;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.Property;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.*;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;

import java.util.List;

import static com.codename1.ui.CN.convertToPixels;
import static com.codename1.ui.util.Resources.getGlobalResources;

public class FilterView extends AbstractEntityView{

    private Property categoriesProp, sortByProp, freeTextProp;
    private Entity filterEntity;

    public FilterView(Entity filterEntity, Node viewNode) {
        super(filterEntity);
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        setScrollableY(true);
        setUIID("FilterCnt");
        this.filterEntity = filterEntity;

        categoriesProp = filterEntity.findProperty(Filter.categories);
        sortByProp = filterEntity.findProperty(Filter.sortBy);
        freeTextProp = filterEntity.findProperty(Filter.freeText);

        Button backButton = new Button(FontImage.MATERIAL_KEYBOARD_ARROW_LEFT);
        backButton.setUIID("FilterBackButton");
        backButton.addActionListener(evt -> {
            evt.consume();
            ActionSupport.dispatchEvent(new FormController.FormBackEvent(backButton));
        });
        Label headerLabel = new Label("SET FILTER", "FilterHeaderLabel");
        Container headerCnt = BorderLayout.centerCenter(headerLabel).add(BorderLayout.WEST, backButton);
        headerCnt.setUIID("FilterHeaderCnt");

        add(headerCnt);

        Label categoryLabel = new Label("Category", "FilterHeader");
        add(categoryLabel);

        List categories = null;
        if (filterEntity.get(categoriesProp) instanceof List){
            categories = (List)filterEntity.get(categoriesProp);
        }

        CategoryButton riceButton = new CategoryButton("Rice",
                "rice-icon.png",
                "rice-icon-selected.png",
                Restaurant.CATEGORY_RICE);
        if(categories.contains(Restaurant.CATEGORY_RICE)){
            riceButton.setSelected(true, false);
        }

        CategoryButton pizzaButton = new CategoryButton("Pizza",
                "pizza-icon.png",
                "pizza-icon-selected.png",
                Restaurant.CATEGORY_PIZZA);
        if(categories.contains(Restaurant.CATEGORY_PIZZA)){
            pizzaButton.setSelected(true, false);
        }

        CategoryButton donutButton = new CategoryButton("Donut",
                "donut-icon.png",
                "donut-icon-selected.png",
                Restaurant.CATEGORY_DONUT);
        if(categories.contains(Restaurant.CATEGORY_DONUT)){
            donutButton.setSelected(true, false);
        }

        CategoryButton chickenButton = new CategoryButton("Chicken",
                "chicken-icon.png",
                "chicken-icon-selected.png",
                Restaurant.CATEGORY_CHICKEN);
        if(categories.contains(Restaurant.CATEGORY_CHICKEN)){
            chickenButton.setSelected(true, false);
        }

        CategoryButton steakButton = new CategoryButton("Steak",
                "steak-icon.png",
                "steak-icon-selected.png",
                Restaurant.CATEGORY_STEAK);
        if(categories.contains(Restaurant.CATEGORY_STEAK)){
            steakButton.setSelected(true, false);
        }

        CategoryButton mealButton = new CategoryButton("Meal",
                "meal-icon.png",
                "meal-icon-selected.png",
                Restaurant.CATEGORY_MEAL);
        if(categories.contains(Restaurant.CATEGORY_MEAL)){
            mealButton.setSelected(true, false);
        }

        CategoryButton kebabButton = new CategoryButton("Kebab",
                "kebab-icon.png",
                "kebab-icon-selected.png",
                Restaurant.CATEGORY_KEBAB);
        if(categories.contains(Restaurant.CATEGORY_KEBAB)){
            kebabButton.setSelected(true, false);
        }

        CategoryButton allButton = new CategoryButton("All",
                "all-icon.png",
                "all-icon-selected.png",
                Restaurant.CATEGORY_ALL);
        if(categories.contains(Restaurant.CATEGORY_ALL)){
            allButton.setSelected(true, false);
        }

        Container categoriesCnt = new Container(new GridLayout(2, 4));
        categoriesCnt.addAll(riceButton, pizzaButton, donutButton, chickenButton, steakButton, mealButton, kebabButton, allButton);
        add(categoriesCnt);

        Label sortByLabel = new Label("Sort By", "FilterHeader");
        add(sortByLabel);
        ButtonGroup bg = new ButtonGroup();

        Style sortByIconStyle = UIManager.getInstance().getComponentStyle("FilterSortedByIconStyle");
        Style sortByIconSelectedStyle = UIManager.getInstance().getComponentStyle("FilterSortedByIconStyleSelected");

        RadioButton fastDelivery = RadioButton.createToggle(" Fast Delivery", FontImage.createMaterial(FontImage.MATERIAL_LOCAL_SHIPPING, sortByIconStyle), bg);
        fastDelivery.setUIID("FilerSortByButton");
        fastDelivery.setPressedIcon(FontImage.createMaterial(FontImage.MATERIAL_LOCAL_SHIPPING, sortByIconSelectedStyle));

        RadioButton nearYou = RadioButton.createToggle(" Near You", FontImage.createMaterial(FontImage.MATERIAL_LOCATION_ON, sortByIconStyle), bg);
        nearYou.setUIID("FilerSortByButton");
        nearYou.setPressedIcon(FontImage.createMaterial(FontImage.MATERIAL_LOCATION_ON, sortByIconSelectedStyle));

        RadioButton trending = RadioButton.createToggle(" Trending", FontImage.createMaterial(FontImage.MATERIAL_TRENDING_UP, sortByIconStyle), bg);
        trending.setUIID("FilerSortByButton");
        trending.setPressedIcon(FontImage.createMaterial(FontImage.MATERIAL_TRENDING_UP, sortByIconSelectedStyle));

        RadioButton popular = RadioButton.createToggle(" Popular", FontImage.createMaterial(FontImage.MATERIAL_STAR_RATE, sortByIconStyle), bg);
        popular.setUIID("FilerSortByButton");
        popular.setPressedIcon(FontImage.createMaterial(FontImage.MATERIAL_STAR_RATE, sortByIconSelectedStyle));
        switch (filterEntity.getInt(sortByProp)){
            case Filter.SORT_BY_DELIVERY_TIME:
                fastDelivery.setSelected(true);
                break;
            case Filter.SORT_BY_NEAR_YOU:
                nearYou.setSelected(true);
                break;
            case Filter.SORT_BY_TRENDING:
                trending.setSelected(true);
                break;
            case Filter.SORT_BY_POPULAR:
                popular.setSelected(true);
                break;
        }

        bg.addActionListener(evt->{
            Button selectedButton = bg.getSelected();
            if(selectedButton == fastDelivery){
                filterEntity.set(sortByProp, Filter.SORT_BY_DELIVERY_TIME);
            }else if(selectedButton == nearYou){
                filterEntity.set(sortByProp, Filter.SORT_BY_NEAR_YOU);
            }else if(selectedButton == trending){
                filterEntity.set(sortByProp, Filter.SORT_BY_TRENDING);
            }else if(selectedButton == popular){
                filterEntity.set(sortByProp, Filter.SORT_BY_POPULAR);
            }
        });
        add(GridLayout.encloseIn(2, fastDelivery, nearYou, trending, popular));

        Button applyFilterButton = new Button("APPLY FILTER", "FilterApplyButton");
        applyFilterButton.addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(HomeView.ENTER_SEARCH);
            if (action != null) {
                action.fireEvent(filterEntity, FilterView.this);
            }

        });
        add(applyFilterButton);
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

    private class CategoryButton extends Container{
        private boolean isSelected = false;
        private Container iconWrapper, iconSelectedWrapper;
        private Button categoryName;
        private Entity filter;
        private int value;

        public void setSelected(boolean selected, boolean revalidate){
            if(isSelected != selected){
                isSelected = selected;
                if (isSelected){
                    if (filterEntity.get(categoriesProp) instanceof List){
                        List categories = (List)filterEntity.get(categoriesProp);
                        if(!categories.contains(value)){
                            categories.add(value);
                        }
                    }
                    categoryName.setUIID("FilterCategoryNameSelectedLabel");
                    removeComponent(iconWrapper);
                    add(BorderLayout.CENTER, iconSelectedWrapper);
                }else{
                    if (filterEntity.get(categoriesProp) instanceof List){
                        List categories = (List)filterEntity.get(categoriesProp);
                        if(categories.contains(value)){
                            categories.remove(categories.indexOf(value));
                        }
                    }
                    categoryName.setUIID("FilterCategoryNameLabel");
                    removeComponent(iconSelectedWrapper);
                    add(BorderLayout.CENTER, iconWrapper);
                }
                if (revalidate){
                    revalidate();
                }
            }
        }
        public boolean isSelected(){
            return isSelected;
        }

        public CategoryButton(String name, String icon, String selectedIcon, int value){
            super(new BorderLayout());
            setUIID("FilterCategoryButton");
            this.filter = filter;
            this.value = value;

            Image categoryButtonImage = getGlobalResources().getImage(icon);
            ScaleImageLabel iconLabel = new ScaleImageLabel(categoryButtonImage) {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(convertToPixels(6), convertToPixels(6));
                }
            };
            iconLabel.setUIID("FilterCategoryIconLabel");
            iconWrapper = BorderLayout.centerCenter(iconLabel);
            iconWrapper.setUIID("FilterCategoryIconWrapper");


            Image categoryButtonSelectedImage = getGlobalResources().getImage(selectedIcon);
            ScaleImageLabel selectedIconLabel = new ScaleImageLabel(categoryButtonSelectedImage) {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(convertToPixels(6), convertToPixels(6));
                }
            };
            selectedIconLabel.setUIID("FilterCategoryIconLabel");
            iconSelectedWrapper = BorderLayout.centerCenter(selectedIconLabel);
            iconSelectedWrapper.setUIID("FilterCategoryIconSelectedWrapper");

            categoryName = new Button(name, "FilterCategoryNameLabel");
            categoryName.addActionListener(evt -> {
                setSelected(!isSelected, true);
            });

            add(BorderLayout.CENTER, iconWrapper);
            add(BorderLayout.SOUTH, categoryName);
            setLeadComponent(categoryName);
        }
    }
}
