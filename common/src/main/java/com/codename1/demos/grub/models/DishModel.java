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
