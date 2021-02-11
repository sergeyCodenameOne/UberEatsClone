package com.codename1.demos.ubereatsclone.controllers;

import com.codename1.demos.ubereatsclone.models.AddressModel;
import com.codename1.demos.ubereatsclone.views.EditAddressView;
import com.codename1.rad.controllers.Controller;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.nodes.Node;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

public class EditAddressController extends FormController {

    public EditAddressController(Controller parent, AddressModel address, Node viewNode) {
        super(parent);
        Form addAddressForm = new Form(new BorderLayout());
        addAddressForm.getToolbar().hideToolbar();
        addAddressForm.add(BorderLayout.CENTER, new EditAddressView(address, viewNode));

        setView(addAddressForm);
    }
}
