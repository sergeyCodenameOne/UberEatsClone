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

package com.codename1.demos.ubereatsclone.models;

import com.codename1.demos.ubereatsclone.interfaces.Restaurant;
import com.codename1.rad.models.*;

import java.util.List;

public class RestaurantModel extends Entity{
    public static StringProperty name;
    public static StringProperty pictureUrl;
    public static StringProperty category;
    public static DoubleProperty rating;
    public static IntProperty estimatedDeliveryTime;
    public static ListProperty menu;
    public static ListProperty order;

    public static class RestaurantMenu extends EntityList {}
    public static class RestaurantOrder extends EntityList {}

    private static final EntityType TYPE = new EntityType() {{
        name = string(tags(Restaurant.name));
        pictureUrl = string(tags(Restaurant.picture));
        category = string(tags(Restaurant.category));
        rating = Double(tags(Restaurant.rating));
        estimatedDeliveryTime = Integer(tags(Restaurant.estimatedDeliveryTime));
        menu = list(RestaurantMenu.class, tags(Restaurant.menu));
        order = list(RestaurantOrder.class, tags(Restaurant.order));
    }};

    {
        setEntityType(TYPE);
    }

    public RestaurantModel(String name, String pictureUrl, String category, double rating, int estimatedDeliveryTime, List<Entity> menu) {
        set(this.name, name);
        set(this.pictureUrl, pictureUrl);
        set(this.category, category);
        set(this.rating, rating);
        set(this.order, new RestaurantOrder());
        set(this.estimatedDeliveryTime, estimatedDeliveryTime);
        RestaurantMenu dishes = new RestaurantMenu();
        for (Entity dish : menu){
            dishes.add(dish);
        }
        set(this.menu, dishes);
    }

    public Entity addToOrder(Entity dish){
        RestaurantOrder order = (RestaurantOrder)get(Restaurant.order);
        order.add(dish);
        return this;
    }

    public RestaurantOrder getOrder(){
        return (RestaurantOrder)get(Restaurant.order);
    }
}
