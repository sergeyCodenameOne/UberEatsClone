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
import com.codename1.demos.grub.interfaces.Restaurant;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.Property;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;

import static com.codename1.ui.CN.convertToPixels;
import static com.codename1.ui.util.Resources.getGlobalResources;

public class RestaurantPreview extends AbstractEntityView {

    Property nameProp, categoryProp, ratingProp, deliveryTimeProp, pictureProp, distanceProp;
    Node viewNode;

    private static EncodedImage placeHolder = EncodedImage.createFromImage(getGlobalResources().getImage("placeholder.png"), false);

    public RestaurantPreview(Entity entity, Node viewNode){
        super(entity);
        setLayout(new BorderLayout());
        setUIID("RestaurantPreview");
        this.viewNode = viewNode;

        nameProp = entity.findProperty(Restaurant.name);
        categoryProp = entity.findProperty(Restaurant.category);
        ratingProp = entity.findProperty(Restaurant.rating);
        deliveryTimeProp = entity.findProperty(Restaurant.estimatedDeliveryTime);
        distanceProp = entity.findProperty(Restaurant.distance);

        pictureProp = entity.findProperty(Restaurant.picture);

        Image restImage = entity.createImageToStorage(pictureProp, placeHolder);

        ScaleImageButton restImageButton = new ScaleImageButton(restImage);
        restImageButton.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED);

        restImageButton.addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(HomeView.ENTER_REST);
            if (action != null) {
                action.fireEvent(entity, RestaurantPreview.this);
            }
        });

        setLeadComponent(restImageButton);

        Label restNameLabel = new Label(entity.getText(nameProp), "RestPreviewNameLabel");
        Label restCategoryLabel = new Label(entity.getText(categoryProp), "RestPreviewCategoryLabel");

        Container restTopView = new Container(new LayeredLayout());
        restTopView.add(restImageButton);

        Container nameAndCategoryCnt = new Container(new BorderLayout());
        nameAndCategoryCnt.setUIID("RestaurantPreviewDetailsCnt");
        Container restDetails = BoxLayout.encloseY(restNameLabel, restCategoryLabel);
        nameAndCategoryCnt.add(BorderLayout.SOUTH, restDetails);
        nameAndCategoryCnt.setUIID("BottomShadowContainer");
        restTopView.add(nameAndCategoryCnt);

        Label estimatedDeliveryTimeLabel = new Label(" " + entity.getInt(deliveryTimeProp) + " mins", "RestPreviewDeliveryTime");
        estimatedDeliveryTimeLabel.setIcon(getGlobalResources().getImage("delivery-time-icon.png").scaled(convertToPixels(4), convertToPixels(4)));
        Label ratingLabel = new Label(" " + entity.getDouble(ratingProp) + "/5", "RestPreviewRating");
        ratingLabel.setIcon(getGlobalResources().getImage("rating-icon.png").scaled(convertToPixels(4), convertToPixels(4)));
        Label distanceLabel = new Label(" " + entity.getDouble(distanceProp) + "km", "RestPreviewDistance");
        distanceLabel.setIcon(getGlobalResources().getImage("distance-icon.png").scaled(convertToPixels(4), convertToPixels(4)));

        add(BorderLayout.SOUTH, FlowLayout.encloseCenter(estimatedDeliveryTimeLabel, ratingLabel, distanceLabel));
        add(BorderLayout.CENTER, restTopView);

    }

    @Override
    public void update() {

    }

    @Override
    public void commit() {

    }

    @Override
    public Node getViewNode() {
        return viewNode;
    }
}
