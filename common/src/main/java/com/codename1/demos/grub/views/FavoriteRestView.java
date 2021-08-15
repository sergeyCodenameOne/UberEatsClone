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

import com.codename1.components.ScaleImageButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.demos.grub.interfaces.Dish;
import com.codename1.demos.grub.interfaces.FoodCategory;
import com.codename1.demos.grub.interfaces.Restaurant;
import com.codename1.demos.grub.models.RestaurantModel;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.EntityList;
import com.codename1.rad.models.PropertySelector;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.rad.ui.image.RoundRectImageRenderer;
import com.codename1.ui.*;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;

import static com.codename1.ui.util.Resources.getGlobalResources;

public class FavoriteRestView extends AbstractEntityView {

    private static EncodedImage placeHolder = EncodedImage.createFromImage(getGlobalResources().getImage("placeholder.png"), false);

    public FavoriteRestView(RestaurantModel rest, Node viewNode) {
        super(rest);
        setUIID("FavoriteRestView");
        setLayout(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER));
        Label dishesNumber = new Label(rest.getDishesCount() + " Dishes", "DishesCount");
        Image dishesImage = FontImage.createMaterial(FontImage.MATERIAL_RESTAURANT, UIManager.getInstance().getComponentStyle("DishesCountImage"));

        dishesNumber.setIcon(dishesImage);

        PropertySelector imagePropertySelector = new PropertySelector(rest, Restaurant.picture);
        RoundRectImageRenderer restImageRenderer = new RoundRectImageRenderer(1000, 1000, 2);

        Image restImage = restImageRenderer.createImage(imagePropertySelector);
        ScaleImageButton restImageButton = new ScaleImageButton(restImage);
        restImageButton.addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(HomeView.ENTER_REST);
            if (action != null) {
                action.fireEvent(rest, FavoriteRestView.this);
            }
        });
        setLeadComponent(restImageButton);
        restImageButton.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        Container restImageCnt = new Container(new BorderLayout()){
            @Override
            public Dimension getPreferredSize() {
                Dimension dim =  super.getPreferredSize();
                dim.setHeight(Display.getInstance().getDisplayHeight() / 4);
                return dim;
            }
        };
        restImageCnt.setUIID("FavoriteRestImageCnt");
        restImageCnt.add(BorderLayout.SOUTH, dishesNumber).add(BorderLayout.CENTER, restImageButton);

        EntityList<Entity> dishes;
        Image firstDish, secondDish, thirdDish;
        if(rest.getEntity(Restaurant.menu) instanceof EntityList){
            EntityList<Entity> categories = (EntityList<Entity>) rest.getEntity(Restaurant.menu);
            if (categories.get(0).get(FoodCategory.dishes) instanceof EntityList){
                dishes = (EntityList) categories.get(0).get(FoodCategory.dishes);

                PropertySelector firstImageSelect = new PropertySelector(dishes.get(0), Dish.pictureUrl);
                PropertySelector secondImageSelect = new PropertySelector(dishes.get(1), Dish.pictureUrl);
                PropertySelector thirdImageSelect = new PropertySelector(dishes.get(2), Dish.pictureUrl);
                RoundRectImageRenderer renderer = new RoundRectImageRenderer(200, 200, 2);

                firstDish = renderer.createImage(firstImageSelect);
                secondDish = renderer.createImage(secondImageSelect);
                thirdDish = renderer.createImage(thirdImageSelect);

                ScaleImageLabel firstDishImageLabel = new ScaleImageLabel(firstDish);
                ScaleImageLabel secondDishImageLabel = new ScaleImageLabel(secondDish);
                ScaleImageLabel thirdDishImageLabel = new ScaleImageLabel(thirdDish);
                firstDishImageLabel.setUIID("FavoriteDishExample");
                secondDishImageLabel.setUIID("FavoriteDishExample");
                thirdDishImageLabel.setUIID("FavoriteDishExample");
                Container dishesSampleCnt = new Container(new GridLayout(1)){
                    @Override
                    public Dimension getPreferredSize() {
                        Dimension dim =  super.getPreferredSize();
                        dim.setHeight(Display.getInstance().getDisplayHeight() / 4);
                        return dim;
                    }
                };
                dishesSampleCnt.setUIID("DishesSampleCnt");
                dishesSampleCnt.addAll(firstDishImageLabel, secondDishImageLabel, thirdDishImageLabel);
                add(BorderLayout.CENTER, restImageCnt).
                        add(BorderLayout.NORTH, new Label(rest.getText(Restaurant.name), "FavoriteRestName")).
                        add(BorderLayout.EAST, dishesSampleCnt);
            }
        }
    }


    @Override
    public Dimension getPreferredSize() {
        Dimension dim = super.getPreferredSize();
        dim.setHeight(Display.getInstance().getDisplayHeight() / 3);
        return dim;
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
