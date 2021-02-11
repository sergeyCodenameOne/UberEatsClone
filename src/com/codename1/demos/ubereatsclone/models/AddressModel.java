package com.codename1.demos.ubereatsclone.models;

import com.codename1.demos.ubereatsclone.interfaces.Address;
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
