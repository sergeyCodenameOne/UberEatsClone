package com.codename1.demos.ubereatsclone.models;

import com.codename1.demos.ubereatsclone.interfaces.CreditCard;
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
