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

import com.codename1.demos.grub.interfaces.Filter;
import com.codename1.demos.grub.interfaces.Restaurant;
import com.codename1.rad.models.*;

import java.util.ArrayList;

public class FilterModel extends Entity {
    public static IntProperty sortBy;
    public static SimpleProperty categories;
    public static StringProperty freeText;

    public static class CategoriesList extends ArrayList {}

    public static final EntityType TYPE = new EntityType(){{
        categories = object(CategoriesList.class, tags(Filter.categories));
        sortBy = Integer(tags(Filter.sortBy));
        freeText = string(tags(Filter.freeText));
    }};

    {
        setEntityType(TYPE);
    }

    public FilterModel(){
        set(sortBy, Filter.SORT_BY_POPULAR);
        set(freeText, "");
        CategoriesList categoriesList = new CategoriesList();
        categoriesList.add(Restaurant.CATEGORY_ALL);
        set(categories, categoriesList);
    }

    public void setFreeText(String text){
        set(freeText, text);
    }
}
