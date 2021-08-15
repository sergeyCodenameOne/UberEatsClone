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

import com.codename1.demos.grub.interfaces.CreditCard;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.EntityType;
import com.codename1.rad.models.StringProperty;

public class CreditCardModel extends Entity {

    public static StringProperty number, expirationYear, expirationMonth, cardHolderName;

    public static final EntityType TYPE = new EntityType(){{
        number = string(tags(CreditCard.number));
        cardHolderName = string(tags(CreditCard.cardHolderName));
        expirationYear = string(tags(CreditCard.expirationYear));
        expirationMonth = string(tags(CreditCard.expirationMonth));
    }};

    {
        setEntityType(TYPE);
    }

    public CreditCardModel(String cardHolderName, String number, String expirationYear, String expirationMonth){
        set(this.number, number);
        set(this.expirationYear, expirationYear);
        set(this.expirationMonth, expirationMonth);
        set(this.cardHolderName, cardHolderName);
    }
}
