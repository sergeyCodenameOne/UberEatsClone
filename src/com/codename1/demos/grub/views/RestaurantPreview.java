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
