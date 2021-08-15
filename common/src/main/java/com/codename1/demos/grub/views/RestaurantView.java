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
import com.codename1.demos.grub.interfaces.FoodCategory;
import com.codename1.demos.grub.interfaces.Restaurant;
import com.codename1.demos.grub.models.AccountModel;
import com.codename1.demos.grub.models.FoodCategoryModel;
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
import com.codename1.ui.layouts.*;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;

import static com.codename1.ui.CN.*;
import static com.codename1.ui.util.Resources.getGlobalResources;

public class RestaurantView extends AbstractEntityView{

    private Node viewNode;
    private Property nameProp, pictureUrlProp, categoryProp, ratingProp, menuProp, orderProp, estimatedDeliveryTimeProp, deliveryFeeProp, distanceProp;
    private Image restaurantImage;
    private Container restInfo;
    private static EncodedImage placeHolder =  EncodedImage.createFromImage(getGlobalResources().getImage("placeholder.png").scaled(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayWidth() / 2), false);

    public static final ActionNode.Category SHOW_ORDER = new ActionNode.Category();
    public static final ActionNode.Category ADD_TO_FAVORITE = new ActionNode.Category();
    public static final ActionNode.Category REMOVE_FAVORITE = new ActionNode.Category();

    public RestaurantView(Entity rest, Entity account, Node node, Node mainWindowNode) {
        super(rest);
        viewNode = node;
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        setScrollableY(true);
        setScrollVisible(false);

        nameProp = rest.findProperty(Restaurant.name);
        pictureUrlProp = rest.findProperty(Restaurant.picture);
        categoryProp = rest.findProperty(Restaurant.category);
        ratingProp = rest.findProperty(Restaurant.rating);
        menuProp = rest.findProperty(Restaurant.menu);
        distanceProp = rest.findProperty(Restaurant.distance);
        orderProp = rest.findProperty(Restaurant.order);
        deliveryFeeProp = rest.findProperty(Restaurant.deliveryFee);
        estimatedDeliveryTimeProp = rest.findProperty(Restaurant.estimatedDeliveryTime);

        restaurantImage = rest.createImageToStorage(pictureUrlProp, placeHolder);

        restInfo = new Container(new LayeredLayout());

        Button backButton = new Button(FontImage.MATERIAL_KEYBOARD_ARROW_LEFT);
        backButton.setUIID("RestBackButton");
        backButton.addActionListener(evt -> {
            evt.consume();
            ActionSupport.dispatchEvent(new FormController.FormBackEvent(backButton));
        });

        Button cart = new Button(FontImage.MATERIAL_SHOPPING_CART, "RestaurantActionButton");
        cart.addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(SHOW_ORDER);
            if (action != null) {
                action.fireEvent(rest, RestaurantView.this);
            }
        });

        Style likeStyle = UIManager.getInstance().getComponentStyle("RestaurantActionButton");
        CheckBox like = CheckBox.createToggle(FontImage.createMaterial(FontImage.MATERIAL_FAVORITE_BORDER, likeStyle));
        like.setSelected(((AccountModel)account).isFavorite(rest));
        like.setUIID("RestaurantActionButton");
        like.setPressedIcon(FontImage.createMaterial(FontImage.MATERIAL_FAVORITE, likeStyle));
        AccountModel accountModel = (AccountModel) account;
        accountModel.isFavorite(rest);

        like.addActionListener(evt -> {
            evt.consume();
            if(like.isSelected()){
                ActionNode action = mainWindowNode.getInheritedAction(ADD_TO_FAVORITE);
                if (action != null) {
                    action.fireEvent(rest, RestaurantView.this);
                }
            }else{
                ActionNode action = mainWindowNode.getInheritedAction(REMOVE_FAVORITE);
                if (action != null) {
                    action.fireEvent(rest, RestaurantView.this);
                }
            }
        });

        ScaleImageLabel restaurantImageLabel = new ScaleImageLabel(restaurantImage);
        restaurantImageLabel.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED);

        restaurantImageLabel.setUIID("RestImage");
        Container emptyCnt = new Container(new BorderLayout()) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(getDisplayWidth(), getDisplayHeight() / 10);
            }
        };

        Container shadowContainer = new Container();
        shadowContainer.setUIID("ShadowContainer");

        emptyCnt.setUIID("emptyRestaurantCnt");
        Container imageContainer = BorderLayout.center(LayeredLayout.encloseIn(restaurantImageLabel, shadowContainer));
        imageContainer.add(BorderLayout.SOUTH, emptyCnt);
        restInfo.add(imageContainer);

        Label restName = new Label(rest.getText(nameProp));
        restName.setUIID("RestaurantNameHeader");

        Label restCategory = new Label(rest.getText(categoryProp));
        restCategory.setUIID("RestaurantCategory");

        Label estimatedDeliveryTimeLabel = new Label(" " + rest.getInt(estimatedDeliveryTimeProp) + " mins", "RestPreviewDeliveryTime");
        estimatedDeliveryTimeLabel.setIcon(getGlobalResources().getImage("delivery-time-icon.png").scaled(convertToPixels(4), convertToPixels(4)));
        Label ratingLabel = new Label(" " + rest.getDouble(ratingProp) + "/5", "RestPreviewRating");
        ratingLabel.setIcon(getGlobalResources().getImage("rating-icon.png").scaled(convertToPixels(4), convertToPixels(4)));
        Label distanceLabel = new Label(" " + rest.getDouble(distanceProp) + "km", "RestPreviewDistance");
        distanceLabel.setIcon(getGlobalResources().getImage("distance-icon.png").scaled(convertToPixels(4), convertToPixels(4)));

        Container restDetails = new Container(new BoxLayout(BoxLayout.Y_AXIS), "RestDetails");
        Container timeRating = new Container(new FlowLayout(Component.CENTER), "RestTimeRatingCnt");
        timeRating.addAll(ratingLabel, estimatedDeliveryTimeLabel, distanceLabel);
        restDetails.addAll(restName, restCategory, timeRating);
        restInfo.add(BorderLayout.south(restDetails));
        restInfo.add(BorderLayout.centerCenterEastWest(null, FlowLayout.encloseRight(like, cart), BorderLayout.north(backButton)));
        add(restInfo);

        Tabs menuContainer = new Tabs(Component.TOP);
        menuContainer.getTabsContainer().setUIID("RestTabContainer");
        menuContainer.setTabUIID("RestTab");

        if (getEntity().get(menuProp) instanceof EntityList) {
            EntityList<Entity> categoryList = (EntityList) (getEntity().get(menuProp));
            for (Entity category : categoryList) {
                FoodCategoryModel fc = ((FoodCategoryModel) category);
                if (fc.get(FoodCategory.dishes) instanceof EntityList){
                    EntityList dishesList = (EntityList)fc.get(FoodCategory.dishes);
                    menuContainer.addTab(fc.getText(FoodCategory.name), createCategoryView(dishesList));
                }
            }
        }
        add(menuContainer);
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

    private Component createCategoryView(EntityList<Entity> dishes) {
        Container dishesContainer = new Container();
        dishesContainer.setUIID("MenuContainer");

        int numOdDishes = dishes.size();
        int rows = (numOdDishes % 2 == 0) ? numOdDishes / 2 : numOdDishes / 2 + 1;
        int landscapeRows = (numOdDishes % 4 == 0) ? numOdDishes / 4 : numOdDishes / 4 + 1;
        if (CN.isTablet()){
            dishesContainer.setLayout(new GridLayout(landscapeRows, 4));
        }else{
            dishesContainer.setLayout(new GridLayout(rows, 2, landscapeRows, 4));
        }
        for (Entity dishEntity : dishes) {
            DishPreview dish = new DishPreview(dishEntity, viewNode);
            dishesContainer.add(dish);
        }
        return dishesContainer;
    }
}