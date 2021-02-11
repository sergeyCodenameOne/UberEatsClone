package com.codename1.demos.ubereatsclone.controllers;

import com.codename1.demos.ubereatsclone.models.AccountModel;
import com.codename1.demos.ubereatsclone.models.CreditCardModel;
import com.codename1.demos.ubereatsclone.views.AddCreditCardView;
import com.codename1.demos.ubereatsclone.views.EditCreditCardsView;
import com.codename1.rad.controllers.Controller;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.nodes.ViewNode;
import com.codename1.rad.ui.UI;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

public class EditCreditCardsController extends FormController {

    public final static ActionNode addNewCard = UI.action();
    public final static ActionNode finishCreatingCard = UI.action();


    public EditCreditCardsController(Controller parent, AccountModel account) {
        super(parent);

        Node viewNode = new ViewNode(
                UI.actions(EditCreditCardsView.ADD_NEW_CARD, addNewCard),
                UI.actions(AddCreditCardView.FINISH_CREATING_CARD, finishCreatingCard)
        );

        Form editCreditCardsForm = new Form(new BorderLayout());
        editCreditCardsForm.getToolbar().hideToolbar();
        EditCreditCardsView view = new EditCreditCardsView(account, viewNode);
        editCreditCardsForm.add(BorderLayout.CENTER, view);
        setView(editCreditCardsForm);

        addActionListener(addNewCard, evt -> {
            evt.consume();

            new AddCreditCardController(this, account, viewNode).getView().show();
        });

        addActionListener(finishCreatingCard, evt -> {
            evt.consume();
            CreditCardModel card = (CreditCardModel)evt.getEntity();
            account.addCreditCard(card);
            view.update();
            showBack();
        });
    }
}
