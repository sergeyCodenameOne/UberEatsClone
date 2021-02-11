package com.codename1.demos.ubereatsclone.models;

import com.codename1.demos.ubereatsclone.interfaces.Filter;
import com.codename1.demos.ubereatsclone.interfaces.Restaurant;
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
