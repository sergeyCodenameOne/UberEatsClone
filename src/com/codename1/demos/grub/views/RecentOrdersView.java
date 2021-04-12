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

import com.codename1.demos.grub.models.AccountModel;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.EntityList;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

public class RecentOrdersView extends AbstractEntityView {

    Container completedOrdersCnt;
    Node viewNode;

    public RecentOrdersView(Entity account, Node viewNode) {
        super(account);
        this.viewNode = viewNode;
        setLayout(new BorderLayout());
        completedOrdersCnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        completedOrdersCnt.setScrollableY(true);
        completedOrdersCnt.setScrollVisible(false);
        completedOrdersCnt.setUIID("CompletedOrdersCnt");
        add(BorderLayout.CENTER, completedOrdersCnt);
        update();
    }

    @Override
    public void update() {
        completedOrdersCnt.removeAll();
        if (getEntity() instanceof AccountModel){
            EntityList<Entity> completedOrders = ((AccountModel)getEntity()).getCompletedOrders();
            for (Entity completedOder : completedOrders){
                completedOrdersCnt.add(new CompletedOrderView(completedOder, viewNode));
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

    public void addRecentOrder(Entity completedOrder){
        completedOrdersCnt.add(new CompletedOrderView(completedOrder, viewNode));
        completedOrdersCnt.revalidateWithAnimationSafety();
    }
}
