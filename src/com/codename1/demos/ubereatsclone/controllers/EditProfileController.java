package com.codename1.demos.ubereatsclone.controllers;

import com.codename1.demos.ubereatsclone.views.EditProfileView;
import com.codename1.rad.controllers.Controller;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.Node;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

public class EditProfileController extends FormController {

    public EditProfileController(Controller parent, Entity account, Node viewNode) {
        super(parent);
        Form editProfileForm = new Form(new BorderLayout());
        editProfileForm.getToolbar().hideToolbar();
        editProfileForm.add(BorderLayout.CENTER, new EditProfileView(account, viewNode));
        setView(editProfileForm);
    }
}
