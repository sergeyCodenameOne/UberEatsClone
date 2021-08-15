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
