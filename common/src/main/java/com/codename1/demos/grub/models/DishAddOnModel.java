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

package com.codename1.demos.grub.models;

import com.codename1.demos.grub.interfaces.DishAddOn;
import com.codename1.rad.models.*;

public class DishAddOnModel extends Entity {
    public static StringProperty name, pictureUrl;
    public static DoubleProperty price;
    public static BooleanProperty isSelected;

    public static final EntityType TYPE = new EntityType(){{
        name = string(tags(DishAddOn.name));
        pictureUrl = string(tags(DishAddOn.pictureUrl));
        price = Double(tags(DishAddOn.price));
        isSelected = Boolean(tags(DishAddOn.isSelected));

    }};

    {
        setEntityType(TYPE);
    }

    public DishAddOnModel(String name, String pictureUrl, double price){
        set(this.name, name);
        set(this.pictureUrl, pictureUrl);
        set(this.price, price);
        set(isSelected, false);
    }

    public DishAddOnModel(Entity eddOnEntity){
        set(this.name, eddOnEntity.getText(DishAddOn.name));
        set(this.pictureUrl, eddOnEntity.getText(DishAddOn.pictureUrl));
        set(this.price, eddOnEntity.getDouble(DishAddOn.price));
    }


}
