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

package com.codename1.demos.grub.controllers;

import com.codename1.demos.grub.interfaces.DishAddOn;
import com.codename1.demos.grub.views.DishAddOnView;
import com.codename1.demos.grub.views.DishView;
import com.codename1.rad.controllers.Controller;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.nodes.ViewNode;
import com.codename1.rad.ui.UI;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

public class DishController extends FormController {

    public static final ActionNode addOnSelected = UI.action();

    public DishController(Controller parent, Entity entity, Node node) {
        super(parent);
        Form dishForm =  new Form(new BorderLayout());
        dishForm.getToolbar().hideToolbar();

        ViewNode dishAddOnNode = new ViewNode(
                UI.actions(DishAddOnView.ADD_ON_CLICKED, addOnSelected)
        );

        DishView dishView = new DishView(entity, node, dishAddOnNode);
        dishForm.add(BorderLayout.CENTER, dishView);
        setView(dishForm);

        addActionListener(addOnSelected, evt->{
            evt.consume();
            evt.getEntity().set(DishAddOn.isSelected, !evt.getEntity().getBoolean(DishAddOn.isSelected));
            ((DishAddOnView)evt.getSource()).update();
            dishView.update();
        });
    }

}