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

import com.codename1.demos.grub.models.AccountModel;
import com.codename1.demos.grub.models.AddressModel;
import com.codename1.demos.grub.views.EditAddressView;
import com.codename1.demos.grub.views.EditAddressesView;
import com.codename1.demos.grub.views.NewAddressView;
import com.codename1.rad.controllers.Controller;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.nodes.ViewNode;
import com.codename1.rad.ui.UI;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

public class EditAddressesController extends FormController {

    public static final ActionNode addAddress = UI.action();
    public static final ActionNode editAddress = UI.action();
    public static final ActionNode finishedEditing = UI.action();
    public static final ActionNode finishedNewAddress = UI.action();



    public EditAddressesController(Controller parent, AccountModel account) {
        super(parent);
        Node viewNode = new ViewNode(
                UI.actions(EditAddressesView.ADD_NEW_ADDRESS, addAddress),
                UI.actions(NewAddressView.FINISHED_NEW_ADDRESS, finishedNewAddress),
                UI.actions(EditAddressesView.EDIT_ADDRESS, editAddress),
                UI.actions(EditAddressView.FINISHED_EDIT_ADDRESS, finishedEditing)
        );

        Form editAddressesForm = new Form(new BorderLayout());
        editAddressesForm.getToolbar().hideToolbar();
        EditAddressesView view = new EditAddressesView(account, viewNode);
        editAddressesForm.add(BorderLayout.CENTER, view);
        setView(editAddressesForm);

        addActionListener(addAddress, evt -> {
            evt.consume();
            new NewAddressController(this, viewNode).getView().show();
        });

        addActionListener(finishedNewAddress, evt -> {
            evt.consume();
            Entity address = evt.getEntity();
            account.addAddress(address);
            view.update();
            view.revalidateWithAnimationSafety();
            if(parent instanceof OrderController){
                ((OrderController) parent).updateOrderView();
            } else if(parent instanceof MainWindowController){
                ((MainWindowController) parent).updateDefaultAddressView();
            }
            showBack();
        });

        addActionListener(editAddress, evt -> {
            evt.consume();
            AddressModel address = (AddressModel)evt.getEntity();
            new EditAddressController(this, address, viewNode).getView().show();
        });

        addActionListener(finishedEditing, evt -> {
            evt.consume();
            account.checkValidation(evt.getEntity());
            view.update();
            view.revalidateWithAnimationSafety();
            if(parent instanceof OrderController){
                ((OrderController) parent).updateOrderView();
            }else if(parent instanceof MainWindowController){
                ((MainWindowController) parent).updateDefaultAddressView();
            }
            showBack();
        });
    }
}
