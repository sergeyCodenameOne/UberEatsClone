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

import com.codename1.demos.grub.interfaces.DishAddOn;
import com.codename1.rad.models.*;

public class DishAddOnModel extends Entity {
    public static StringProperty name, pictureUrl;
    public static DoubleProperty price;
    public static BooleanProperty isSelected;

    public static final EntityType TYPE = new EntityType(){{
        name = string(tags(DishAddOn.name));
        pictureUrl = string(tags(DishAddOn.pictureUrl));
        price = Double(tags(DishAddOn.price));
        isSelected = Boolean(tags(DishAddOn.isSelected));

    }};

    {
        setEntityType(TYPE);
    }

    public DishAddOnModel(String name, String pictureUrl, double price){
        set(this.name, name);
        set(this.pictureUrl, pictureUrl);
        set(this.price, price);
        set(isSelected, false);
    }

    public DishAddOnModel(Entity eddOnEntity){
        set(this.name, eddOnEntity.getText(DishAddOn.name));
        set(this.pictureUrl, eddOnEntity.getText(DishAddOn.pictureUrl));
        set(this.price, eddOnEntity.getDouble(DishAddOn.price));
    }


}
