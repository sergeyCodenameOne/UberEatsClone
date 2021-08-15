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

import com.codename1.demos.grub.interfaces.MainWindow;
import com.codename1.rad.models.*;

import java.util.List;

public class MainWindowModel extends Entity {
    public static EntityProperty profile, filter;
    public static ListProperty restaurants;

    public static class Restaurants extends EntityList {}

    public static final EntityType TYPE = new EntityType(){{
        profile = entity(AccountModel.class, tags(MainWindow.profile));
        filter = entity(FilterModel.class, tags(MainWindow.filter));
        restaurants = list(Restaurants.class, tags(MainWindow.restaurants));
    }};

    {
        setEntityType(TYPE);
    }

    public MainWindowModel(Entity profile, List<Entity> restaurants){
        set(this.profile, profile);
        set(filter, new FilterModel());
        Restaurants restaurantsList = new Restaurants();
        for (Entity rest : restaurants){
            restaurantsList.add(rest);
        }
        set(this.restaurants, restaurantsList);
    }
}
