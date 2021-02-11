package com.codename1.demos.ubereatsclone.controllers;

import com.codename1.demos.ubereatsclone.views.FilterView;
import com.codename1.rad.controllers.Controller;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.Node;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

public class FilterController extends FormController {
    public FilterController(Controller parent, Entity filterEntity, Node viewNode) {
        super(parent);
        Form filterForm = new Form(new BorderLayout());
        filterForm.getToolbar().hideToolbar();
        filterForm.add(BorderLayout.CENTER, new FilterView(filterEntity, viewNode));

        setView(filterForm);
    }
}
