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

import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.demos.grub.Util;
import com.codename1.demos.grub.interfaces.Dish;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.Property;
import com.codename1.rad.models.PropertySelector;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.rad.ui.image.RoundRectImageRenderer;
import com.codename1.ui.Button;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.layouts.BorderLayout;

import static com.codename1.ui.ComponentSelector.$;
import static com.codename1.ui.util.Resources.getGlobalResources;

public class DishPreview<T extends Entity> extends AbstractEntityView<T> {

    private Node viewNode;
    private Property nameProp, descriptionProp, pictureUrlProp, priceProp;

    public static final ActionNode.Category DISH_CLICKED = new ActionNode.Category();

    private static EncodedImage placeHolder = EncodedImage.createFromImage(getGlobalResources().getImage("placeholder.png"), false);

    public DishPreview(T entity, Node viewNode) {
        super(entity);
        setUIID("DishPreview");
        setLayout(new BorderLayout());

        this.viewNode = viewNode;
        nameProp = entity.findProperty(Dish.name);
        descriptionProp = entity.findProperty(Dish.description);
        pictureUrlProp = entity.findProperty(Dish.pictureUrl);
        priceProp = entity.findProperty(Dish.price);


        PropertySelector imagePropertySelector = new PropertySelector(entity, pictureUrlProp);
        RoundRectImageRenderer renderer = new RoundRectImageRenderer(300, 300, 2);

        Image dishImage = renderer.createImage(imagePropertySelector);
        ScaleImageLabel dishImageLabel = new ScaleImageLabel(dishImage);

        Button lead = new Button();
        lead.setVisible(false);
        add(BorderLayout.SOUTH, lead);
        setLeadComponent(lead);

        MultiButton dishPreview = new MultiButton(entity.getText(nameProp));
        dishPreview.setTextLine2(entity.getText(descriptionProp));
        dishPreview.setTextLine3(Util.getPriceAsString(entity.getDouble(priceProp)));
        dishPreview.setUIID("DishPreviewInfo");
        dishPreview.setUIIDLine1("DishPreviewName");
        dishPreview.setUIIDLine2("DishPreviewDescription");
        dishPreview.setUIIDLine3("DishPreviewPrice");

        add(BorderLayout.NORTH, dishImageLabel);
        add(BorderLayout.CENTER, dishPreview);

        $(lead, dishPreview).addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(DISH_CLICKED);
            if (action != null) {
                action.fireEvent(entity, DishPreview.this);
            }
        });
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
