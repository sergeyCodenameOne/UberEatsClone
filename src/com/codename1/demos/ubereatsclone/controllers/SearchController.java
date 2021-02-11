package com.codename1.demos.ubereatsclone.controllers;

import com.codename1.demos.ubereatsclone.views.SearchView;
import com.codename1.rad.controllers.Controller;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.Node;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

public class SearchController extends FormController {
    public SearchController(Controller parent, Entity appEntity, Node viewNode) {
        super(parent);
        Form searchForm = new Form(new BorderLayout());
        searchForm.getToolbar().hideToolbar();
        searchForm.add(BorderLayout.CENTER, new SearchView(appEntity, viewNode));
        setView(searchForm);
    }
}
