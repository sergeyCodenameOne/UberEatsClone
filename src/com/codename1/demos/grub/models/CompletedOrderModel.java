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

import com.codename1.demos.grub.interfaces.CompletedOrder;
import com.codename1.rad.models.*;

import java.util.Random;

public class CompletedOrderModel extends Entity {
    public static EntityProperty restaurant;
    public static StringProperty date;
    public static IntProperty deliveredTo;
    public static IntProperty orderId;
    public static ListProperty order;

    public static class RestaurantOrder extends EntityList {}

    private static final EntityType TYPE = new EntityType() {{
        restaurant = entity(RestaurantModel.class, tags(CompletedOrder.restaurant));
        order = list(RestaurantOrder.class, tags(CompletedOrder.order));
        date = string(tags(CompletedOrder.date));
        deliveredTo = Integer(tags(CompletedOrder.deliveredTo));
        orderId = Integer(tags(CompletedOrder.orderId));
    }};

    {
        setEntityType(TYPE);
    }

    public CompletedOrderModel(Entity restaurant, EntityList<Entity> order, String date, int deliveredTo) {
        set(this.restaurant, restaurant);
        set(this.date, date);
        set(this.deliveredTo, deliveredTo);
        Random idMaker = new Random();
        int id = idMaker.nextInt();
        if (id < 0){
            id = id * -1;
        }
        set(this.orderId, id);

        RestaurantOrder orderList = new RestaurantOrder();
        for (Entity menuCategory : order){
            orderList.add(menuCategory);
        }
        set(this.order, orderList);
    }
}
