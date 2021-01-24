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

package com.codename1.demos.ubereatsclone;


import com.codename1.demos.ubereatsclone.controllers.RestaurantController;
import com.codename1.demos.ubereatsclone.models.DishAddOnModel;
import com.codename1.demos.ubereatsclone.models.DishModel;
import com.codename1.demos.ubereatsclone.models.RestaurantModel;
import com.codename1.rad.controllers.ApplicationController;
import com.codename1.rad.controllers.ControllerEvent;
import com.codename1.rad.models.Entity;

import java.util.ArrayList;
import java.util.List;


public class UberEatsClone extends ApplicationController {
    @Override
    public void actionPerformed(ControllerEvent evt) {
        if (evt instanceof StartEvent) {
            evt.consume();
            new RestaurantController(this, createDemoModel()).getView().show();
        }
    }

    private Entity createDemoModel(){
        Entity restaurant = new RestaurantModel("Helena", "https://sergeycodenameone.github.io/rest.jpg", "sea food", 6.7, 30, createDemoMenu());
        return restaurant;
    }

    private List<Entity> createDemoMenu(){
        List<Entity> menu = new ArrayList<>();

        for(int i = 0; i < 6; i++){
            DishModel dish = new DishModel("salad", "very pretty salad", "https://sergeycodenameone.github.io/dish.jpg", 4.60, createDemoAddOns());
            menu.add(dish);
        }

        return menu;
    }

    private List<Entity> createDemoAddOns(){
        List addOns = new ArrayList();

        addOns.add(new DishAddOnModel("lettuce", "https://sergeycodenameone.github.io/dish.jpg", 4.0));
        addOns.add(new DishAddOnModel("tomato", "https://sergeycodenameone.github.io/dish.jpg", 2.0));
        addOns.add(new DishAddOnModel("cheese", "https://sergeycodenameone.github.io/dish.jpg", 3.0));
        addOns.add(new DishAddOnModel("onion", "https://sergeycodenameone.github.io/dish.jpg", 1.0));


        return addOns;
    }
}

