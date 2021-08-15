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


package com.codename1.demos.grub.interfaces;

import com.codename1.rad.models.Tag;

public interface Restaurant {
    Tag name = new Tag("name");
    Tag description= new Tag("description");
    Tag picture = new Tag("picture");
    Tag icon = new Tag("icon");
    Tag category = new Tag("category");
    Tag rating = new Tag("rating");
    Tag menu = new Tag("menu");
    Tag order = new Tag("order");
    Tag estimatedDeliveryTime = new Tag("estimatedDeliveryTime");
    Tag deliveryFee = new Tag("deliveryFee");
    Tag distance = new Tag("distance");
    Tag restDiscount = new Tag("restDiscount");

    public static final int CATEGORY_RICE = 0;
    public static final int CATEGORY_PIZZA = 1;
    public static final int CATEGORY_DONUT = 2;
    public static final int CATEGORY_CHICKEN = 3;
    public static final int CATEGORY_MEAL = 4;
    public static final int CATEGORY_STEAK = 5;
    public static final int CATEGORY_KEBAB = 6;
    public static final int CATEGORY_ALL = 7;
}
