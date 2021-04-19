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
