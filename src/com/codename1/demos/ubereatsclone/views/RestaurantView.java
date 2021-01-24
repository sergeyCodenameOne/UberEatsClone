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

package com.codename1.demos.ubereatsclone.views;

import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.demos.ubereatsclone.interfaces.Restaurant;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.EntityList;
import com.codename1.rad.models.Property;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.*;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.*;
import com.codename1.ui.plaf.Style;

import static com.codename1.ui.CN.getDisplayHeight;
import static com.codename1.ui.CN.getDisplayWidth;
import static com.codename1.ui.util.Resources.getGlobalResources;

public class RestaurantView<T extends Entity> extends AbstractEntityView<T> {

    private Node viewNode;
    private Property nameProp, pictureUrlProp, categoryProp, ratingProp, menuProp, orderProp, estimatedDeliveryTimeProp;
    private Image restaurantImage;
    private Container restInfo;
    private static EncodedImage placeHolder = EncodedImage.createFromImage(getGlobalResources().getImage("dish-placeholder.png"), false).
            scaledEncoded(getDisplayWidth(), getDisplayHeight() / 3);//TODO change the placeHolder

    public RestaurantView(T entity, Node node) {
        super(entity);
        viewNode = node;
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        setScrollableY(true);

        nameProp = entity.findProperty(Restaurant.name);
        pictureUrlProp = entity.findProperty(Restaurant.picture);
        categoryProp = entity.findProperty(Restaurant.category);
        ratingProp = entity.findProperty(Restaurant.rating);
        menuProp = entity.findProperty(Restaurant.menu);
        orderProp = entity.findProperty(Restaurant.order);
        estimatedDeliveryTimeProp = entity.findProperty(Restaurant.estimatedDeliveryTime);

        restaurantImage = entity.createImageToStorage(pictureUrlProp, placeHolder);

        restInfo = new Container(new LayeredLayout());
        ScaleImageLabel restaurantImageLabel = new ScaleImageLabel(restaurantImage);
        restaurantImageLabel.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        restaurantImageLabel.setUIID("RestImage");
        Container emptyCnt = new Container(new BorderLayout()) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(getDisplayWidth(), getDisplayHeight() / 6);
            }
        };

        emptyCnt.setUIID("emptyRestaurantCnt");
        Container imageContainer = BorderLayout.center(restaurantImageLabel);
        imageContainer.add(BorderLayout.SOUTH, emptyCnt);
        restInfo.add(imageContainer);

        Label restName = new Label(entity.getText(nameProp));
        restName.setUIID("RestaurantNameHeader");

        Label restCategory = new Label(entity.getText(categoryProp));
        restCategory.setUIID("RestaurantCategory");

        SpanLabel restRating = new SpanLabel(entity.getText(ratingProp), "RestaurantRating");
        restRating.setMaterialIcon(FontImage.MATERIAL_STAR_RATE);
        restRating.setIconUIID("RestaurantRating");
        restRating.setIconPosition("North");

        SpanLabel estimatedDeliveryTime = new SpanLabel("" + entity.getInt(estimatedDeliveryTimeProp), "RestDeliveryTime");
        estimatedDeliveryTime.setMaterialIcon(FontImage.MATERIAL_QUERY_BUILDER);
        estimatedDeliveryTime.setIconUIID("RestDeliveryTime");
        estimatedDeliveryTime.setIconPosition("North");

        Container restDetails = new Container(new BoxLayout(BoxLayout.Y_AXIS), "RestDetails");
        Container timeRating = new Container(new FlowLayout(Component.CENTER), "RestTimeRatingCnt");
        timeRating.addAll(restRating, estimatedDeliveryTime);
        restDetails.addAll(restName, restCategory, timeRating);
        restInfo.add(restDetails);

        Container menuContainer = new Container();
        menuContainer.setUIID("MenuContainer");

        if (getEntity().get(menuProp) instanceof EntityList) {
            EntityList<Entity> dishList = (EntityList) (getEntity().get(menuProp));
            int numOdDishes = dishList.size();
            int rows = (numOdDishes % 2 == 0) ? numOdDishes / 2 : numOdDishes / 2 + 1;
            menuContainer.setLayout(new GridLayout(rows, 2));
            for (Entity dishEntity : dishList) {
                DishPreview dish = new DishPreview(dishEntity, viewNode);
                menuContainer.add(dish);
            }
        }

        addAll(restInfo, menuContainer);
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
