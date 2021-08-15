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

import com.codename1.demos.grub.interfaces.PaymentMethod;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.EntityProperty;
import com.codename1.rad.models.EntityType;
import com.codename1.rad.models.IntProperty;

public class PaymentMethodModel extends Entity {

    public static IntProperty method;
    public static EntityProperty creditCard;

    public static final EntityType TYPE = new EntityType(){{
        method = Integer(tags(PaymentMethod.method));
        creditCard = entity(CreditCardModel.class ,tags(PaymentMethod.creditCard));
    }};

    {
        setEntityType(TYPE);
    }

    public PaymentMethodModel(int method, Entity creditCard){
        set(this.method, method);
        if (method == PaymentMethod.CREDIT_CARD){

        set(this.creditCard, creditCard);
        }
    }
}
