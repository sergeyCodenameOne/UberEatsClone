package com.codename1.demos.ubereatsclone.controllers;

import com.codename1.demos.ubereatsclone.models.AccountModel;
import com.codename1.demos.ubereatsclone.models.AddressModel;
import com.codename1.demos.ubereatsclone.views.EditAddressView;
import com.codename1.demos.ubereatsclone.views.EditAddressesView;
import com.codename1.demos.ubereatsclone.views.NewAddressView;
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
            showBack();
        });
    }
}
