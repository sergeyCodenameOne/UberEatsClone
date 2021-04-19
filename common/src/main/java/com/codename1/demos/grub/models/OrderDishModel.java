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
import com.codename1.demos.grub.interfaces.DishOrder;
import com.codename1.rad.models.*;

import java.util.List;

public class OrderDishModel extends Entity {
    public static StringProperty name, thumbnailUrl;
    public static IntProperty quantity;
    public static DoubleProperty price;
    public static ListProperty addOns;


    public static class DishOrderAddOns extends EntityList {}

    public static final EntityType TYPE = new EntityType(){{
        name = string(tags(DishOrder.name));
        quantity = Integer(tags(DishOrder.quantity));
        thumbnailUrl = string(tags(DishOrder.pictureUrl));
        price = Double(tags(DishOrder.price));
        addOns = list(DishOrderAddOns.class, tags(DishOrder.addOns));
    }};

    {
        setEntityType(TYPE);
    }

    public OrderDishModel(String name, String dishPictureUrl, double dishPrice, int quantity, List<Entity> addOns){
        set(this.name, name);
        set(this.quantity, quantity);
        set(thumbnailUrl, dishPictureUrl);
        set(price, dishPrice);

        DishOrderAddOns addOnsList = new DishOrderAddOns();
        for (Entity addOn : addOns){
            addOnsList.add(addOn);
        }
        set(this.addOns, addOnsList);
    }

    public OrderDishModel(Entity dish, int quantity){
        if(dish instanceof DishModel){
            set(this.name, dish.getText(Dish.name));
            set(this.quantity, quantity);
            set(thumbnailUrl, dish.getText(Dish.pictureUrl));
            set(price, dish.getDouble(Dish.price));
            DishOrderAddOns addOnsList = new DishOrderAddOns();

            if (dish.get(Dish.addOns) instanceof EntityList) {
                EntityList<Entity> dishAddOnsList = (EntityList)(dish.get(Dish.addOns));
                for (Entity addOnEntity : dishAddOnsList) {
                    boolean isSelected = addOnEntity.getBoolean(DishAddOn.isSelected);
                    if (isSelected){
                        addOnsList.add(new DishAddOnModel(addOnEntity));
                    }
                }
            }
            set(this.addOns, addOnsList);
        }
    }

    public double getTotalPrice(){
        double totalPrice = getDouble(DishOrder.price);
        int quantity = getInt(DishOrder.quantity);
        if (get(DishOrder.addOns) instanceof EntityList) {
            EntityList<Entity> addOnsList = (EntityList)get(DishOrder.addOns);
            for (Entity addOnEntity : addOnsList) {
                totalPrice += addOnEntity.getDouble(DishAddOn.price);
            }
        }
        return quantity * totalPrice;
    }
}
