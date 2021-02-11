package com.codename1.demos.ubereatsclone.interfaces;

import com.codename1.rad.models.Tag;

public interface Address {
    Tag type = new Tag("type");
    Tag city = new Tag("city");
    Tag street = new Tag("street");
    Tag additionalInfo = new Tag("additionalInfo");
    Tag isDefault = new Tag("isDefault");


    public static final int HOME = 1;
    public static final int WORK = 2;
    public static final int OTHER = 3;
}
