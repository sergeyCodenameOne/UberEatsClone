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
import com.codename1.demos.grub.interfaces.DishOrder;
import com.codename1.demos.grub.models.OrderDishModel;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.Property;
import com.codename1.rad.models.PropertySelector;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.rad.ui.image.RoundRectImageRenderer;
import com.codename1.ui.*;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;

import static com.codename1.ui.util.Resources.getGlobalResources;

public class DishOrderPreview<T extends Entity> extends AbstractEntityView<T> {

    Node viewNode;
    Property nameProp, quantityProp, pictureProp, priceProp, addOnsProp;
    Label quantityLabel, dishPrice;

    private static EncodedImage placeHolder = EncodedImage.createFromImage(getGlobalResources().getImage("placeholder.png"), false);

    public static final ActionNode.Category INCREASE_QUANTITY = new ActionNode.Category();
    public static final ActionNode.Category DECREASE_QUANTITY = new ActionNode.Category();

    public DishOrderPreview(T entity, Node viewNode) {
        super(entity);
        setLayout(new BorderLayout());
        this.viewNode = viewNode;
        setUIID("OrderDish");

        nameProp = entity.findProperty(DishOrder.name);
        quantityProp = entity.findProperty(DishOrder.quantity);
        pictureProp = entity.findProperty(DishOrder.pictureUrl);
        priceProp = entity.findProperty(DishOrder.price);
        addOnsProp = entity.findProperty(DishOrder.addOns);

        PropertySelector imagePropertySelector = new PropertySelector(entity, pictureProp);
        RoundRectImageRenderer renderer = new RoundRectImageRenderer(200, 200, 2);

        Image dishImage = renderer.createImage(imagePropertySelector);
        ScaleImageLabel dishImageLabel = new ScaleImageLabel(dishImage){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(200, 200);
            }
        };
        dishImageLabel.setUIID("OrderDishImage");

        quantityLabel = new Label("", "OrderDishQuantityLabel");

        Button increaseQuantity = new Button(FontImage.MATERIAL_ADD);
        increaseQuantity.setUIID("OrderDishIncreaseButton");
        increaseQuantity.addActionListener(evt->{
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(INCREASE_QUANTITY);
            if (action != null) {
                action.fireEvent(entity, DishOrderPreview.this);
            }

        });

        Button decreaseQuantity = new Button(FontImage.MATERIAL_REMOVE);
        decreaseQuantity.setUIID("OrderDishDecreaseButton");
        decreaseQuantity.addActionListener(evt->{
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(DECREASE_QUANTITY);
            if (action != null) {
                action.fireEvent(entity, DishOrderPreview.this);
            }
        });

        Label dishName = new Label(entity.getText(nameProp), "OrderDishName");
        Container nameAndQuantity = new Container(new BorderLayout());
        Container quantityContainer = FlowLayout.encloseCenter(decreaseQuantity, quantityLabel, increaseQuantity);
        nameAndQuantity.add(BorderLayout.NORTH, dishName).
                add(BorderLayout.CENTER, quantityContainer);

        dishPrice = new Label("", "OrderDishPrice");

        add(BorderLayout.EAST, dishPrice);
        add(BorderLayout.CENTER, nameAndQuantity);
        add(BorderLayout.WEST, dishImageLabel);
        update();
    }

    @Override
    public void update() {
        quantityLabel.setText(String.valueOf(getEntity().getInt(quantityProp)));
        dishPrice.setText(Util.getPriceAsString(((OrderDishModel) getEntity()).getTotalPrice()));
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
