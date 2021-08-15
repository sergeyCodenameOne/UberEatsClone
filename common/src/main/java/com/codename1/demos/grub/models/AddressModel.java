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

import com.codename1.demos.grub.interfaces.Address;
import com.codename1.rad.models.*;

public class AddressModel extends Entity {
    public static StringProperty city, street, additionalInfo;
    public static IntProperty type;
    public static BooleanProperty isDefault;


    public static final EntityType TYPE = new EntityType(){{
        city = string(tags(Address.city));
        street = string(tags(Address.street));
        additionalInfo = string(tags(Address.additionalInfo));
        type = Integer(tags(Address.type));
        isDefault = Boolean(tags(Address.isDefault));
    }};

    {
        setEntityType(TYPE);
    }

    public AddressModel(){
        this("", "", "", Address.HOME);
    }


    public AddressModel(String city, String street, String additionalInfo, int type){
        set(this.city, city);
        set(this.street, street);
        set(this.additionalInfo, additionalInfo);
        set(this.type, type);
        set(this.isDefault, false);
    }

   public void setCity(String city){
        set(this.city, city);
   }

    public void setStreet(String street) {
        set(this.street, street);
    }

    public void setAdditionalInfo(String additionalInfo) {
        set(this.additionalInfo, additionalInfo);
    }

    public void setType(int type) {
        set(this.type, type);
    }

    public void setDefault(boolean isDefault) {
        set(this.isDefault, isDefault);
    }
}
