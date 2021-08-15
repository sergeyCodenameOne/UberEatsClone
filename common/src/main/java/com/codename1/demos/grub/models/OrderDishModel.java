/**
 * Licensed to Codename One LTD under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  Codename One licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
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
