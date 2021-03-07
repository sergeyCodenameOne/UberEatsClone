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

import com.codename1.components.ScaleImageLabel;
import com.codename1.demos.grub.Util;
import com.codename1.demos.grub.interfaces.DishAddOn;
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
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;

import static com.codename1.ui.util.Resources.getGlobalResources;

public class DishAddOnView extends AbstractEntityView {

    public static final ActionNode.Category ADD_ON_CLICKED = new ActionNode.Category();

    private Node viewNode;
    private Property nameProp, pictureUrlProp, priceProp, isSelectedProp;
    Button nameLabel;
    Label priceLabel;

    private static EncodedImage placeHolder = EncodedImage.createFromImage(getGlobalResources().getImage("placeholder.png"), false);

    public DishAddOnView(Entity entity, Node node) {
        super(entity);
        viewNode = node;
        this.setUIID("DishAddOn");
        setLayout(new BorderLayout());

        nameProp = entity.findProperty(DishAddOn.name);
        pictureUrlProp = entity.findProperty(DishAddOn.pictureUrl);
        priceProp = entity.findProperty(DishAddOn.price);
        isSelectedProp = entity.findProperty(DishAddOn.isSelected);


        PropertySelector imagePropertySelector = new PropertySelector(entity, pictureUrlProp);
        RoundRectImageRenderer renderer = new RoundRectImageRenderer(200, 200, 2);

        Image addOnImage = renderer.createImage(imagePropertySelector);
        ScaleImageLabel addOnImageLabel = new ScaleImageLabel(addOnImage);

        nameLabel = new Button(entity.getText(nameProp), "DishAddOnName");
        priceLabel = new Label(Util.getPriceAsString(entity.getDouble(priceProp)), "DishAddOnPrice");
        nameLabel.addActionListener(evt->{
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(ADD_ON_CLICKED);
            if (action != null) {
                action.fireEvent(entity, DishAddOnView.this);
            }
        });
        setLeadComponent(nameLabel);

        add(BorderLayout.NORTH, addOnImageLabel);
        add(BorderLayout.CENTER, nameLabel);
        add(BorderLayout.SOUTH, priceLabel);

        update();
    }

    @Override
    public void update() {
        boolean isSelected = getEntity().getBoolean(isSelectedProp);
        if (isSelected){
            setUIID("DishAddOnPressed");
            nameLabel.setUIID("DishAddOnNamePressed");
            priceLabel.setUIID("DishAddOnPricePressed");
        }else{
            setUIID("DishAddOn");
            nameLabel.setUIID("DishAddOnName");
            priceLabel.setUIID("DishAddOnPrice");
        }
        revalidateWithAnimationSafety();

    }

    @Override
    public void commit() {

    }

    @Override
    public Node getViewNode() {
        return null;
    }


}
