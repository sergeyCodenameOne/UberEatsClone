package com.codename1.demos.ubereatsclone.controllers;

import com.codename1.demos.ubereatsclone.models.AddressModel;
import com.codename1.demos.ubereatsclone.views.NewAddressView;
import com.codename1.rad.controllers.Controller;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.nodes.Node;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

public class NewAddressController extends FormController {


    public NewAddressController(Controller parent, Node viewNode) {
        super(parent);
        Form addAddressForm = new Form(new BorderLayout());
        addAddressForm.getToolbar().hideToolbar();
        addAddressForm.add(BorderLayout.CENTER, new NewAddressView(new AddressModel(), viewNode));

        setView(addAddressForm);
    }
}
