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

import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.demos.ubereatsclone.interfaces.Dish;
import com.codename1.l10n.L10NManager;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.EntityList;
import com.codename1.rad.models.Property;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;

import static com.codename1.ui.CN.getDisplayHeight;
import static com.codename1.ui.CN.getDisplayWidth;
import static com.codename1.ui.util.Resources.getGlobalResources;

public class DishView<T extends Entity> extends AbstractEntityView<T> {
    private Node viewNode;
    private Property nameProp, descriptionProp, pictureUrlProp, priceProp, addOnsProp;

    public static final ActionNode.Category ADD_TO_CART = new ActionNode.Category();
    public static final ActionNode.Category GO_BACK = new ActionNode.Category();

    private static EncodedImage placeHolder = EncodedImage.createFromImage(getGlobalResources().getImage("dish-placeholder.png"), false).
            scaledEncoded(400, 400);//TODO change the placeHolder

    public DishView(T entity, Node viewNode) {
        super(entity);
        setUIID("Dish");
        setLayout(new BorderLayout());

        this.viewNode = viewNode;
        nameProp = entity.findProperty(Dish.name);
        descriptionProp = entity.findProperty(Dish.description);
        pictureUrlProp = entity.findProperty(Dish.pictureUrl);
        priceProp = entity.findProperty(Dish.price);
        addOnsProp = entity.findProperty(Dish.addOns);

        Image dishImage = entity.createImageToStorage(pictureUrlProp, placeHolder);

        Container emptyWhiteContainer = new Container(new BorderLayout(), "DishEmptyWhite"){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(getDisplayWidth(), getDisplayHeight() / 8);
            }
        };

        Container emptyBlueContainer = new Container(new BorderLayout(), "DishEmptyBlue"){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(getDisplayWidth(), getDisplayHeight() / 8);
            }
        };

        ScaleImageLabel dishImageLabel= new ScaleImageLabel(dishImage);

        Button backButton = new Button(FontImage.MATERIAL_ARROW_BACK_IOS, "BackButton");
        backButton.addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(GO_BACK);
            if (action != null) {
                ActionEvent ae = action.fireEvent(entity, DishView.this);
                if (ae.isConsumed()) {
                    return;
                }
            }
        });

        Container dishTopView = new Container(new LayeredLayout());
        dishTopView.add(BoxLayout.encloseY(emptyBlueContainer, emptyWhiteContainer));
        dishTopView.add(BorderLayout.centerCenter(dishImageLabel));
        dishTopView.add(Container.encloseIn(new FlowLayout(Component.LEFT), backButton));
        add(BorderLayout.NORTH, dishTopView);

        Label dishName = new Label(entity.getText(nameProp), "DishName");
        SpanLabel dishDescription = new SpanLabel(entity.getText(descriptionProp), "DishDescription");

        Container dishQuantityAndPrice = new Container(new FlowLayout(Component.CENTER));
        Label dishPrice = new Label(L10NManager.getInstance().formatCurrency(entity.getDouble(priceProp)), "DishPrice");

        dishQuantityAndPrice.addAll(dishPrice); //TODO add quantity
        Container descriptionCnt = BoxLayout.encloseY(dishName, dishDescription, dishQuantityAndPrice);

        Container dishRemarksCnt = new Container(new BorderLayout(), "DishRemarksCnt");
        TextArea dishRemarks = new TextArea(3, 20, TextArea.ANY);
        dishRemarks.setUIID("DishRemarksTextArea");
        dishRemarksCnt.add(BorderLayout.NORTH, new Label("Remarks:", "DishRemarksHeader"));
        dishRemarksCnt.add(BorderLayout.CENTER, dishRemarks);

        Container addOnsCnt = new Container(new BorderLayout(), "AddOnsCnt");
        Container addOns = new Container(new BoxLayout(BoxLayout.X_AXIS));
        addOns.setScrollableX(true);
        if (getEntity().get(addOnsProp) instanceof EntityList) {
            EntityList<Entity> addOnsList = (EntityList) (getEntity().get(addOnsProp));
            for (Entity addOnEntity : addOnsList) {
                DishAddOnView addOn = new DishAddOnView(addOnEntity);
                addOns.add(addOn);
            }
        }
        addOnsCnt.add(BorderLayout.NORTH, new Label("Add ons", "AddOnHeader")).
                add(BorderLayout.CENTER, addOns);

        Container dishBody = new Container(new BorderLayout(), "DishBody");
        dishBody.add(BorderLayout.NORTH, descriptionCnt);
        dishBody.add(BorderLayout.CENTER,  addOnsCnt);
        dishBody.add(BorderLayout.SOUTH, dishRemarksCnt);


        add(BorderLayout.CENTER, dishBody);

        MultiButton addToCart = new MultiButton("Add To Cart");
        addToCart.setUIID("DishAddToCart");

        add(BorderLayout.SOUTH, BorderLayout.centerCenter(addToCart));

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
