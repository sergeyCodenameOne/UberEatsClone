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
