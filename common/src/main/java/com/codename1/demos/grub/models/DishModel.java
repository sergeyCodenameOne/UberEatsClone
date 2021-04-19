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

import com.codename1.demos.grub.interfaces.Dish;
import com.codename1.demos.grub.interfaces.DishAddOn;
import com.codename1.rad.models.*;

import java.util.List;

public class DishModel extends Entity{
    public static StringProperty name, description, thumbnailUrl;
    public static DoubleProperty price;
    public static ListProperty addOns;

    public static class DishAddOns extends EntityList {}

    public static final EntityType TYPE = new EntityType(){{
        name = string(tags(Dish.name));
        description = string(tags(Dish.description));
        thumbnailUrl = string(tags(Dish.pictureUrl));
        price = Double(tags(Dish.price));
        addOns = list(DishAddOns.class, tags(Dish.addOns));
    }};

    {
        setEntityType(TYPE);
    }

    public DishModel(String dishName, String dishDescription, String dishPictureUrl, double dishPrice, List<Entity> addOns){
        set(name, dishName);
        set(description, dishDescription);
        set(thumbnailUrl, dishPictureUrl);
        set(price, dishPrice);

        DishAddOns addOnsList = new DishAddOns();
        for (Entity addOn : addOns){
            addOnsList.add(addOn);
        }
        set(this.addOns, addOnsList);
    }

    public double getTotalPrice(){
        return getTotalPrice(1);
    }

    public double getTotalPrice(int quantity){
        double totalPrice = getDouble(Dish.price);
        if (get(Dish.addOns) instanceof EntityList) {
            EntityList<Entity> addOnsList = (EntityList)(get(Dish.addOns));
            for (Entity addOnEntity : addOnsList) {
                if (addOnEntity.getBoolean(DishAddOn.isSelected)) {
                    totalPrice += addOnEntity.getDouble(DishAddOn.price);
                }
            }
        }
        return totalPrice * quantity;
    }
}
