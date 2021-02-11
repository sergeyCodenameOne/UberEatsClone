package com.codename1.demos.ubereatsclone.interfaces;

import com.codename1.rad.models.Tag;

public interface Filter {
    Tag categories = new Tag("categories");
    Tag sortBy = new Tag("sortBy");
    Tag freeText = new Tag("freeText");

    public static final int SORT_BY_DELIVERY_TIME = 0;
    public static final int SORT_BY_TRENDING = 1;
    public static final int SORT_BY_NEAR_YOU = 2;
    public static final int SORT_BY_POPULAR = 3;


}
