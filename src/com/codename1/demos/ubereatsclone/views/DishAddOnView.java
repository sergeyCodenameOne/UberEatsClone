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
import com.codename1.demos.ubereatsclone.interfaces.DishAddOn;
import com.codename1.l10n.L10NManager;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.Property;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.Button;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;

import static com.codename1.ui.util.Resources.getGlobalResources;

public class DishAddOnView<T extends Entity> extends AbstractEntityView<T> {

    private Node viewNode;
    private Property nameProp, pictureUrlProp, priceProp;
    private boolean isSelected = false;

    private static EncodedImage placeHolder = EncodedImage.createFromImage(getGlobalResources().getImage("dish-placeholder.png"), false);//TODO change the placeHolder

    public DishAddOnView(T entity) {
        super(entity);
        this.setUIID("DishAddOn");
        setLayout(new BorderLayout());

        nameProp = entity.findProperty(DishAddOn.name);
        pictureUrlProp = entity.findProperty(DishAddOn.pictureUrl);
        priceProp = entity.findProperty(DishAddOn.price);

        Image addOnImage = entity.createImageToStorage(pictureUrlProp, placeHolder);
        ScaleImageLabel addOnImageLabel = new ScaleImageLabel(addOnImage){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(200, 200);
            }
        };

        Button nameLabel = new Button(entity.getText(nameProp), "DishAddOnName");
        Label priceLabel = new Label(L10NManager.getInstance().formatCurrency(entity.getDouble(priceProp)), "DishAddOnPrice");
        nameLabel.addActionListener(evt->{
            isSelected = !isSelected;
            if (isSelected){
                nameLabel.getAllStyles().setFgColor(0xffffff);
                priceLabel.getAllStyles().setFgColor(0xffffff);
            }else{
                nameLabel.getAllStyles().setFgColor(0x2b83eb);
                priceLabel.getAllStyles().setFgColor(0x2b83eb);
            }
            update();
        });
        setLeadComponent(nameLabel);

        add(BorderLayout.NORTH, addOnImageLabel);
        add(BorderLayout.CENTER, nameLabel);
        add(BorderLayout.SOUTH, priceLabel);

        update();
    }

    @Override
    public void update() {
        if (isSelected){
            getStyle().setBgTransparency(255);
        }else{
            getStyle().setBgTransparency(0);
        }
        revalidate();
    }

    @Override
    public void commit() {

    }

    @Override
    public Node getViewNode() {
        return null;
    }


}
