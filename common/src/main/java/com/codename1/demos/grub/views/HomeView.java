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
import com.codename1.demos.grub.interfaces.Address;
import com.codename1.demos.grub.interfaces.Filter;
import com.codename1.demos.grub.interfaces.MainWindow;
import com.codename1.demos.grub.interfaces.Restaurant;
import com.codename1.demos.grub.models.AccountModel;
import com.codename1.demos.grub.models.FilterModel;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.EntityList;
import com.codename1.rad.models.Property;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.*;
import com.codename1.ui.plaf.Style;

import java.util.Calendar;
import java.util.List;

import static com.codename1.ui.CN.convertToPixels;
import static com.codename1.ui.CN.isTablet;
import static com.codename1.ui.util.Resources.getGlobalResources;

public class HomeView extends AbstractEntityView {

    Node viewNode;
    Property restaurantsProp, accountProp, filterProp;
    Entity appEntity;
    Container deliverToCnt;
    Label deliverToLabel;

    public static final ActionNode.Category POPULAR_EXPLORE = new ActionNode.Category();
    public static final ActionNode.Category RECOMMENDED_EXPLORE = new ActionNode.Category();
    public static final ActionNode.Category ENTER_REST = new ActionNode.Category();
    public static final ActionNode.Category ENTER_FILTER = new ActionNode.Category();
    public static final ActionNode.Category ENTER_SEARCH = new ActionNode.Category();

    public HomeView(Entity appEntity, Node viewNode) {
        super(appEntity);
        this.viewNode = viewNode;
        this.appEntity = appEntity;
        setUIID("HomeView");
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        setScrollableY(true);
        setScrollVisible(false);

        restaurantsProp = appEntity.findProperty(MainWindow.restaurants);
        accountProp = appEntity.findProperty(MainWindow.profile);
        filterProp = appEntity.findProperty(MainWindow.filter);

        Container topViewImage = new Container(new BorderLayout()) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(Display.getInstance().getDisplayWidth(), (int) (Display.getInstance().getDisplayHeight() / 2.5));
            }
        };
        topViewImage.setUIID("HomeTopViewImage");
        Image homeTopViewImage;
        String welcomeText;
        int currHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (currHour >= 0 && currHour <= 12){
            homeTopViewImage = getGlobalResources().getImage("morning.png");
            welcomeText = "Good Morning";
        }else if(currHour < 18){
            homeTopViewImage = getGlobalResources().getImage("afternoon.png");
            welcomeText = "Good Afternoon";
        }else{
            homeTopViewImage = getGlobalResources().getImage("evening.png");
            welcomeText = "Good Evening";
        }
        ScaleImageLabel topViewLabel = new ScaleImageLabel(homeTopViewImage){
            @Override
            public Dimension getPreferredSize() {
                return topViewImage.getPreferredSize();
            }
        };
        topViewLabel.setUIID("HomeTopViewImage");
        topViewLabel.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED);

        topViewImage.add(BorderLayout.CENTER, topViewLabel);

        Container emptyGreyContainer = new Container() {
            @Override
            public Dimension getPreferredSize() {
                if (isTablet()){
                    return new Dimension(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight() / 35);
                }else{
                    return new Dimension(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight() / 15);
                }
            }
        };
        emptyGreyContainer.setUIID("EmptyGreyContainer");

        Container topView = new Container(new LayeredLayout());
        topView.add(BoxLayout.encloseY(topViewImage, emptyGreyContainer));

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
                action.fireEvent(appEntity, HomeView.this);
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
            if (filter instanceof FilterModel){
                ((FilterModel) filter).setFreeText(searchField.getText());
                ActionNode action = viewNode.getInheritedAction(HomeView.ENTER_SEARCH);
                if (action != null) {
                    action.fireEvent(appEntity, HomeView.this);
                }
            }
        });

        Container topViewLabelsLayer = new Container(new BorderLayout());
        Container searchCnt = FlowLayout.encloseCenter(searchField, filterButton);
        searchCnt.setUIID("HomeSearchCnt");
        topViewLabelsLayer.add(BorderLayout.SOUTH, searchCnt);
        topView.add(topViewLabelsLayer);

        AccountModel accountModel = (AccountModel) appEntity.getEntity(accountProp);
        deliverToLabel = new Label("", "HomeDeliverToLabel");
        deliverToCnt = BoxLayout.encloseY(new Button("DELIVER TO", "HomeDeliverToHeaderButton"), deliverToLabel);
        deliverToCnt.setUIID("HomeDeliverToCnt");
        deliverToCnt.setVisible(false);
        Entity defaultAddress = accountModel.getDefaultAddress();
        if (defaultAddress != null){
            String city = defaultAddress.getText(Address.city);
            String street = defaultAddress.getText(Address.street);
            deliverToLabel.setText(city + ", " + street);
            deliverToCnt.setVisible(true);
        }

        Container topViewLabelsCnt = BorderLayout.north(BoxLayout.encloseY(deliverToCnt, new Label(welcomeText, "HomeWelcomeTextFirstLine"),
                new Label("Codename One!", "HomeWelcomeTextSecondLine")));

        topView.add(topViewLabelsCnt);
        add(topView);

        Container categoryRiceButton = createCategoryButton("Rice", "rice-icon.png", evt -> {
            updateFilter(Restaurant.CATEGORY_RICE);
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(HomeView.ENTER_SEARCH);
            if (action != null) {
                action.fireEvent(appEntity, HomeView.this);
            }
        });

        Container categoryRiceButton1 = createCategoryButton("Pizza", "pizza-icon.png", evt -> {
            updateFilter(Restaurant.CATEGORY_PIZZA);
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(HomeView.ENTER_SEARCH);
            if (action != null) {
                action.fireEvent(appEntity, HomeView.this);
            }
        });

        Container categoryRiceButton2 = createCategoryButton("Donut", "donut-icon.png", evt -> {
            updateFilter(Restaurant.CATEGORY_DONUT);
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(HomeView.ENTER_SEARCH);
            if (action != null) {
                action.fireEvent(appEntity, HomeView.this);
            }
        });

        Container categoryRiceButton3 = createCategoryButton("Chicken", "chicken-icon.png", evt -> {
            updateFilter(Restaurant.CATEGORY_CHICKEN);
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(HomeView.ENTER_SEARCH);
            if (action != null) {
                action.fireEvent(appEntity, HomeView.this);
            }
        });

        Container categoryRiceButton4 = createCategoryButton("Steak", "steak-icon.png", evt -> {
            updateFilter(Restaurant.CATEGORY_STEAK);
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(HomeView.ENTER_SEARCH);
            if (action != null) {
                action.fireEvent(appEntity, HomeView.this);
            }
        });

        Container categoryRiceButton5 = createCategoryButton("Meal", "meal-icon.png", evt -> {
            updateFilter(Restaurant.CATEGORY_MEAL);
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(HomeView.ENTER_SEARCH);
            if (action != null) {
                action.fireEvent(appEntity, HomeView.this);
            }
        });

        Container categoryRiceButton6 = createCategoryButton("Kebab", "kebab-icon.png", evt -> {
            updateFilter(Restaurant.CATEGORY_KEBAB);
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(HomeView.ENTER_SEARCH);
            if (action != null) {
                action.fireEvent(appEntity, HomeView.this);
            }
        });

        Container categoryRiceButton7 = createCategoryButton("All", "all-icon.png", evt -> {
            updateFilter(Restaurant.CATEGORY_ALL);
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(HomeView.ENTER_SEARCH);
            if (action != null) {
                action.fireEvent(appEntity, HomeView.this);
            }
        });
        Container categoryContainer;
        if (isTablet()){
            categoryContainer = new Container(new GridLayout(1, 8));
        }else{
            categoryContainer = new Container(new GridLayout(2, 4));
        }
        categoryContainer.setUIID("CategoryContainer");
        categoryContainer.addAll(categoryRiceButton,
                categoryRiceButton1,
                categoryRiceButton2,
                categoryRiceButton3,
                categoryRiceButton5,
                categoryRiceButton4,
                categoryRiceButton6,
                categoryRiceButton7
        );
        add(categoryContainer);

        Container popularCnt = new Container(new BorderLayout());
        popularCnt.setUIID("PopularCnt");
        Label popularLabel = new Label("Popular Near You", "CategoryHeader");
        Button popularExploreButton = new Button("EXPLORE >", "ExploreButton");
        popularCnt.add(BorderLayout.NORTH, BorderLayout.centerEastWest(null, popularExploreButton, popularLabel));
        popularCnt.add(BorderLayout.CENTER, createPopularCnt(appEntity.getEntityList(restaurantsProp)));
        popularExploreButton.addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(HomeView.ENTER_SEARCH);
            if (action != null) {
                action.fireEvent(appEntity, HomeView.this);
            }

        });
        add(popularCnt);

        Container recommendCnt = new Container(new BorderLayout());
        recommendCnt.setUIID("RecommendCnt");
        Label recommendedLabel = new Label("We Recommended", "CategoryHeader");
        Button recommendedExploreButton = new Button("EXPLORE >", "ExploreButton");
        recommendedExploreButton.addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(HomeView.ENTER_SEARCH);
            if (action != null) {
                action.fireEvent(appEntity, HomeView.this);
            }
        });

        recommendCnt.add(BorderLayout.NORTH, BorderLayout.centerEastWest(null, recommendedExploreButton, recommendedLabel));
        recommendCnt.add(BorderLayout.CENTER, createRecommendedCnt(appEntity.getEntityList(restaurantsProp)));
        add(recommendCnt);

        Container allRestaurantsCnt = new Container(new BorderLayout());
        allRestaurantsCnt.setUIID("AllRestaurantsCnt");
        Label allRestaurantsLabel = new Label("All Restaurants", "CategoryHeader");
        allRestaurantsCnt.add(BorderLayout.NORTH, allRestaurantsLabel);
        allRestaurantsCnt.add(BorderLayout.CENTER, createAllRestaurantsCnt(appEntity.getEntityList(restaurantsProp)));
        add(allRestaurantsCnt);

        Button backToTopButton = new Button("BACK TO TOP", "BackToTopButton");
        backToTopButton.addActionListener(evt -> {
            scrollComponentToVisible(topView);
        });
        add(backToTopButton);

    }

    @Override
    public void update() {
        AccountModel account = (AccountModel) getEntity().getEntity(MainWindow.profile);
        Entity defaultAddress = account.getDefaultAddress();
        if(defaultAddress != null){
            String city = defaultAddress.getText(Address.city);
            String street = defaultAddress.getText(Address.street);
            deliverToLabel.setText(city + ", " + street);
            deliverToCnt.setVisible(true);
        }
    }

    @Override
    public void commit() {

    }

    @Override
    public Node getViewNode() {
        return viewNode;
    }

    private Container createCategoryButton(String name, String icon, ActionListener action) {
        Container categoryButton = new Container(new BorderLayout());
        categoryButton.setUIID("HomeCategoryButton");

        Image categoryButtonImage = getGlobalResources().getImage(icon);
        ScaleImageLabel categoryIcon = new ScaleImageLabel(categoryButtonImage) {
            @Override
            public Dimension getPreferredSize() {
                if(CN.isTablet()){
                    return new Dimension(convertToPixels(8), convertToPixels(8));
                }else{
                    return new Dimension(convertToPixels(6), convertToPixels(6));
                }
            }
        };
        categoryIcon.setUIID("CategoryIconLabel");
        Container iconWrapper = BorderLayout.centerCenter(categoryIcon);
        iconWrapper.setUIID("CategoryIconWrapper");

        Button categoryName = new Button(name, "CategoryNameLabel");
        categoryName.addActionListener(action);
        categoryButton.add(BorderLayout.CENTER, iconWrapper);
        categoryButton.add(BorderLayout.SOUTH, categoryName);
        categoryButton.setLeadComponent(categoryName);
        return categoryButton;
    }

    private Container createPopularCnt(EntityList<Entity> restaurants) {
        Container popularCnt = new Container(new BoxLayout(BoxLayout.X_AXIS));
        popularCnt.setScrollableX(true);
        for (Entity rest : restaurants) {
            popularCnt.add(new RestaurantPreview(rest, viewNode));
        }
        return popularCnt;
    }

    private Container createRecommendedCnt(EntityList<Entity> restaurants) {
        Container recommendedCnt = new Container(new BoxLayout(BoxLayout.X_AXIS));
        recommendedCnt.setScrollableX(true);
        for (Entity rest : restaurants) {
            recommendedCnt.add(new RestaurantPreview(rest, viewNode));
        }
        return recommendedCnt;
    }

    private Container createAllRestaurantsCnt(EntityList<Entity> restaurants) {
        final int restsCount = restaurants.size();
        final int landscapeRows = restsCount % 2 == 0 ? restsCount / 2 : restsCount / 2 + 1;
        Container allRestsCnt;
        if (isTablet()){
            allRestsCnt = new Container(new GridLayout(landscapeRows, 2));
        }else{
            allRestsCnt = new Container(new GridLayout(restsCount, 1, landscapeRows, 2));
        }

        for (Entity rest : restaurants) {
            allRestsCnt.add(new RestaurantPreview(rest, viewNode));
        }

        return allRestsCnt;

    }

    private void updateFilter(int category){
        Entity filter = appEntity.getEntity(filterProp);
        if(filter.get(Filter.categories) instanceof List){
            List categories = (List)filter.get(Filter.categories);
            categories.clear();
            categories.add(category);
        }
    }
}