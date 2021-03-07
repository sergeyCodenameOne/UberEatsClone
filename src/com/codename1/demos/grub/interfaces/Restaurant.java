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

package com.codename1.demos.grub.interfaces;

import com.codename1.rad.models.Tag;

public interface Restaurant {
    Tag name = new Tag("name");
    Tag description= new Tag("description");
    Tag picture = new Tag("picture");
    Tag icon = new Tag("icon");
    Tag category = new Tag("category");
    Tag rating = new Tag("rating");
    Tag menu = new Tag("menu");
    Tag order = new Tag("order");
    Tag estimatedDeliveryTime = new Tag("estimatedDeliveryTime");
    Tag deliveryFee = new Tag("deliveryFee");
    Tag distance = new Tag("distance");

    public static final int CATEGORY_RICE = 0;
    public static final int CATEGORY_PIZZA = 1;
    public static final int CATEGORY_DONUT = 2;
    public static final int CATEGORY_CHICKEN = 3;
    public static final int CATEGORY_MEAL = 4;
    public static final int CATEGORY_STEAK = 5;
    public static final int CATEGORY_KEBAB = 6;
    public static final int CATEGORY_ALL = 7;
}
