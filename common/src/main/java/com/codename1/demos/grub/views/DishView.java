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
import com.codename1.components.SpanLabel;
import com.codename1.demos.grub.Util;
import com.codename1.demos.grub.interfaces.Dish;
import com.codename1.demos.grub.models.DishModel;
import com.codename1.rad.controllers.ActionSupport;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.EntityList;
import com.codename1.rad.models.Property;
import com.codename1.rad.models.PropertySelector;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.rad.ui.image.RoundRectImageRenderer;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;

import java.util.HashMap;
import java.util.Map;

import static com.codename1.ui.util.Resources.getGlobalResources;

public class DishView extends AbstractEntityView{

    private Node viewNode;
    private Property nameProp, descriptionProp, pictureUrlProp, priceProp, addOnsProp;
    private int quantity = 1;
    private Label quantityLabel , totalPriceLabel;
    private MultiButton addToCart;
    private Container addToCartCnt;

    public static final ActionNode.Category ADD_TO_CART = new ActionNode.Category();

    private static EncodedImage placeHolder = EncodedImage.createFromImage(getGlobalResources().getImage("placeholder.png"), false);
    public DishView(Entity entity, Node viewNode, Node addOnNode) {
        super(entity);
        setUIID("Dish");
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        setScrollableY(true);
        setScrollVisible(false);

        this.viewNode = viewNode;
        nameProp = entity.findProperty(Dish.name);
        descriptionProp = entity.findProperty(Dish.description);
        pictureUrlProp = entity.findProperty(Dish.pictureUrl);
        priceProp = entity.findProperty(Dish.price);
        addOnsProp = entity.findProperty(Dish.addOns);

        Button backButton = new Button(FontImage.MATERIAL_KEYBOARD_ARROW_LEFT);
        backButton.setUIID("DishBackButton");
        backButton.addActionListener(evt -> {
            evt.consume();
            ActionSupport.dispatchEvent(new FormController.FormBackEvent(backButton));
        });
        Label headerLabel = new Label("ADD TO ORDER", "DishHeaderLabel");
        Container headerCnt = BorderLayout.centerAbsolute(headerLabel).add(BorderLayout.WEST, backButton);
        headerCnt.setUIID("DishHeaderCnt");

        PropertySelector imagePropertySelector = new PropertySelector(entity, pictureUrlProp);
        RoundRectImageRenderer renderer = new RoundRectImageRenderer(400, 400, 2);

        Image dishImage = renderer.createImage(imagePropertySelector);
        ScaleImageLabel dishImageLabel= new ScaleImageLabel(dishImage);
        dishImageLabel.setUIID("DishImageLabel");

        add(BoxLayout.encloseY(headerCnt, dishImageLabel));

        Label dishName = new Label(entity.getText(nameProp), "DishName");
        SpanLabel dishDescription = new SpanLabel(entity.getText(descriptionProp), "DishDescription");

        Label dishPrice = new Label(Util.getPriceAsString(entity.getDouble(priceProp)), "DishPrice");
        Button increaseQuantity = new Button(FontImage.MATERIAL_ADD);
        increaseQuantity.setUIID("OrderDishIncreaseButton");
        increaseQuantity.addActionListener(evt->{
            quantity++;
            update();
        });

        Button decreaseQuantity = new Button(FontImage.MATERIAL_REMOVE);
        decreaseQuantity.setUIID("OrderDishDecreaseButton");
        decreaseQuantity.addActionListener(evt->{
            if(quantity > 0){
                quantity--;
                update();
            }
        });
        
        quantityLabel = new Label("1", "OrderDishQuantityLabel");
        Container quantityContainer = FlowLayout.encloseCenter(decreaseQuantity, quantityLabel, increaseQuantity);
        quantityContainer.setUIID("DishQuantityContainer");

        Container dishQuantityAndPrice = new Container(new FlowLayout(Component.CENTER));
        dishQuantityAndPrice.addAll(quantityContainer, dishPrice);
        Container descriptionCnt = BoxLayout.encloseY(dishName, dishDescription, dishQuantityAndPrice);

        Container dishRemarksCnt = new Container(new BorderLayout(), "DishRemarksCnt");
        TextArea dishRemarks = new TextArea(3, 20, TextArea.ANY);
        dishRemarks.setUIID("DishRemarksTextArea");
        dishRemarksCnt.add(BorderLayout.NORTH, new Label("Remarks:", "DishRemarksHeader"));
        dishRemarksCnt.add(BorderLayout.CENTER, dishRemarks);

        Container addOnsCnt = new Container(new BorderLayout(), "AddOnsCnt");
        Container addOns = new Container();
        addOns.setScrollableX(true);
        if (getEntity().get(addOnsProp) instanceof EntityList) {
            EntityList<Entity> addOnsList = (EntityList) (getEntity().get(addOnsProp));
            addOns.setLayout(new GridLayout(addOnsList.size()));
            for (Entity addOnEntity : addOnsList) {
                DishAddOnView addOn = new DishAddOnView(addOnEntity, addOnNode);
                addOns.add(addOn);
            }
        }

        addOnsCnt.add(BorderLayout.NORTH, new Label("Add ons", "AddOnHeader")).
                add(BorderLayout.CENTER, addOns);

        Container dishBody = new Container(new BoxLayout(BoxLayout.Y_AXIS), "DishBody");
        dishBody.add(descriptionCnt);
        dishBody.add(addOnsCnt);
        dishBody.add(dishRemarksCnt);
        add(dishBody);

        Button addToCartButton = new Button("Add To Cart", "DishAddToCartText");
        totalPriceLabel = new Label(Util.getPriceAsString(entity.getDouble(Dish.price)), "DishAddToCartPrice");

        addToCartCnt = BorderLayout.centerEastWest(null, totalPriceLabel, addToCartButton);
        addToCartCnt.setUIID("DishAddToCartCnt");
        addToCartCnt.setLeadComponent(addToCartButton);
        addToCartButton.addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(ADD_TO_CART);
            if (action != null) {
                Map extraData = new HashMap<String, Integer>();
                extraData.put("quantity", quantity);
                action.fireEvent(entity, DishView.this, extraData);
                ActionSupport.dispatchEvent(new FormController.FormBackEvent(backButton));
            }
        });
        add(BorderLayout.center(addToCartCnt));
    }

    @Override
    public void update() {
        quantityLabel.setText(String.valueOf(quantity));
        totalPriceLabel.setText(Util.getPriceAsString(((DishModel)getEntity()).getTotalPrice(quantity)));

        addToCartCnt.revalidateWithAnimationSafety();
    }

    @Override
    public void commit() {

    }

    @Override
    public Node getViewNode() {
        return viewNode;
    }
}
