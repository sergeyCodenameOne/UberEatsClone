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

import com.codename1.demos.grub.interfaces.FoodCategory;
import com.codename1.demos.grub.interfaces.Restaurant;
import com.codename1.rad.models.*;

import java.util.List;
import java.util.Random;

public class RestaurantModel extends Entity{
    public static StringProperty name;
    public static StringProperty pictureUrl;
    public static StringProperty iconUrl;
    public static StringProperty category;
    public static IntProperty distance;
    public static DoubleProperty rating;
    public static DoubleProperty deliveryFee;
    public static DoubleProperty restDiscount;
    public static IntProperty estimatedDeliveryTime;
    public static ListProperty menu;
    public static ListProperty order;

    public static class RestaurantMenu extends EntityList {}
    public static class RestaurantOrder extends EntityList {}

    private static final EntityType TYPE = new EntityType() {{
        name = string(tags(Restaurant.name));
        pictureUrl = string(tags(Restaurant.picture));
        iconUrl = string(tags(Restaurant.icon));
        category = string(tags(Restaurant.category));
        rating = Double(tags(Restaurant.rating));
        estimatedDeliveryTime = Integer(tags(Restaurant.estimatedDeliveryTime));
        deliveryFee = Double(tags(Restaurant.deliveryFee));
        restDiscount = Double(tags(Restaurant.restDiscount));
        distance = Integer(tags(Restaurant.distance));
        menu = list(RestaurantMenu.class, tags(Restaurant.menu));
        order = list(RestaurantOrder.class, tags(Restaurant.order));
    }};

    {
        setEntityType(TYPE);
    }

    public RestaurantModel(String name, String pictureUrl, String category, double rating, double deliveryFee, String icon, int estimatedDeliveryTime, List<Entity> menu) {
        set(this.name, name);
        set(this.pictureUrl, pictureUrl);
        set(this.category, category);
        set(this.rating, rating);
        set(this.order, new RestaurantOrder());
        set(this.estimatedDeliveryTime, estimatedDeliveryTime);
        set(this.deliveryFee, deliveryFee);
        set(this.iconUrl, icon);
        set(this.restDiscount, 0.0);

        Random random = new Random();
        int randomDistance = random.nextInt();
        if (randomDistance < 0){
            randomDistance = randomDistance * (-1);
        }
        randomDistance = randomDistance % 20;
        set(this.distance, randomDistance);
        RestaurantMenu categories = new RestaurantMenu();
        for (Entity menuCategory : menu){
            categories.add(menuCategory);
        }
        set(this.menu, categories);
    }

    public Entity addToOrder(Entity dish){
        RestaurantOrder order = (RestaurantOrder)get(Restaurant.order);
        order.add(dish);
        return this;
    }

    public RestaurantOrder getOrder(){
        return (RestaurantOrder)get(Restaurant.order);
    }

    public double getTotalPrice(){
        double totalPrice = getTotalItemPrice() + getDouble(Restaurant.deliveryFee);
        totalPrice = totalPrice - totalPrice * (double)get(Restaurant.restDiscount);
        return totalPrice;
    }

    public double getTotalItemPrice(){
        double totalPrice = 0;
        if (get(Restaurant.order) instanceof EntityList) {
            EntityList<Entity> dishList = (EntityList)(get(Restaurant.order));
            for (Entity dishEntity : dishList) {
                totalPrice += ((OrderDishModel)dishEntity).getTotalPrice();
            }
        }
        return totalPrice;
    }

    public int getDishesCount(){
        int totalDishes = 0;

        if (get(Restaurant.menu) instanceof EntityList){
            EntityList<Entity> categories = (EntityList<Entity>) get(Restaurant.menu);
            for(Entity category : categories){
                if(category.get(FoodCategory.dishes) instanceof EntityList){
                    EntityList<Entity> dishes = (EntityList<Entity>) category.get(FoodCategory.dishes);
                    totalDishes += dishes.size();
                }
            }
        }
        return totalDishes;
    }

    public void clearOrder(){
        ((RestaurantOrder)get(Restaurant.order)).clear();
    }
}
