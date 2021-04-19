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

package com.codename1.demos.grub.views;

import com.codename1.demos.grub.interfaces.Account;
import com.codename1.demos.grub.models.RestaurantModel;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.EntityList;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;

import java.util.List;

public class FavoriteRestaurantsView extends AbstractEntityView {

    Container restsCnt;
    Node viewNode;

    public FavoriteRestaurantsView(Entity account, Node viewNode) {
        super(account);
        setUIID("FavoriteRestaurantsView");
        this.viewNode = viewNode;
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        Label headerLabel = new Label("FAVORITES", "FavoriteHeaderLabel");
        Container headerCnt = BorderLayout.center(headerLabel);
        headerCnt.setUIID("FavoriteHeaderCnt");
        add(headerCnt);
        restsCnt = new Container();
//        ((GridLayout)restsCnt.getLayout()).
        restsCnt.setScrollableY(true);
        restsCnt.setScrollVisible(false);
        add(restsCnt);

        update();
    }

    @Override
    public void update() {
        restsCnt.removeAll();
        if (getEntity().get(Account.favoriteRestaurants) instanceof EntityList){
            EntityList<Entity> restList = (EntityList<Entity>)getEntity().get(Account.favoriteRestaurants);
            final int restListSize = restList.size();
            if (restListSize > 0){
                int landScapeRows = restListSize / 2;
                if (restListSize % 2 != 0){
                    landScapeRows++;
                }
                restsCnt.setLayout(new GridLayout(restListSize, 1, landScapeRows, 2));
                for(Entity rest : restList){
                    restsCnt.add(new FavoriteRestView((RestaurantModel) rest, viewNode));
                }
            }
        }
    }

    @Override
    public void commit() {

    }

    @Override
    public Node getViewNode() {
        return null;
    }

    public void addFavorite(Entity rest){
        restsCnt.add(new FavoriteRestView((RestaurantModel) rest, viewNode));
        update();
    }

    public void removeFavorite(Entity rest){
        List<Component> restaurants = restsCnt.getChildrenAsList(true);
        for(Component currRest : restaurants){
            if (currRest instanceof FavoriteRestView){
                if (((FavoriteRestView) currRest).getEntity() == rest){
                    restsCnt.removeComponent(currRest);
                }
            }
        }
        update();
    }
}
