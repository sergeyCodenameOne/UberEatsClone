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
import com.codename1.rad.models.*;

import java.util.List;

public class FoodCategoryModel extends Entity{
    public static StringProperty name;
    public static ListProperty dishes;

    public static class Dishes extends EntityList {}

    public static final EntityType TYPE = new EntityType(){{
        name = string(tags(FoodCategory.name));
        dishes = list(Dishes.class, tags(FoodCategory.dishes));
    }};

    {
        setEntityType(TYPE);
    }

    public FoodCategoryModel(String name , List<Entity> dishes){
        set(this.name, name);
        Dishes dishesList = new Dishes();
        for (Entity addOn : dishes){
            dishesList.add(addOn);
        }
        set(this.dishes, dishesList);
    }
}
