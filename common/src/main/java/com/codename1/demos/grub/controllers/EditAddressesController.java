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
