package com.codename1.demos.ubereatsclone.views;

import com.codename1.demos.ubereatsclone.interfaces.CreditCard;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.Property;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.Display;
import com.codename1.ui.Label;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;

import static com.codename1.ui.util.Resources.getGlobalResources;

public class CreditCardView extends AbstractEntityView {

    Property numberProp, expirationYearProp, expirationMonthProp;

    public CreditCardView(Entity creditCard) {
        super(creditCard);
        setLayout(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER));
        setUIID("CreditCard");

        numberProp = creditCard.findProperty(CreditCard.number);
        expirationYearProp = creditCard.findProperty(CreditCard.expirationYear);
        expirationMonthProp = creditCard.findProperty(CreditCard.expirationMonth);

        String number = creditCard.getText(numberProp);
        String expirationYear = creditCard.getText(expirationYearProp);
        String expirationMonth = creditCard.getText(expirationMonthProp);
        String cardLastFourNumbers = number.substring(12);
        String expirationYearLastTwoNumbers = expirationYear.substring(2);

        getStyle().setBgImage(getGlobalResources().getImage("credit-card.png"));

        Label numberLabel = new Label("****  ****  ****  " + cardLastFourNumbers, "CreditCardNumber");
        Label expirationDate = new Label(expirationMonth + "/" + expirationYear, "CreditCardExpirationDate");

        add(BorderLayout.CENTER, numberLabel);
        add(BorderLayout.SOUTH, expirationDate);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension dim =  super.getPreferredSize();
        dim.setHeight((Display.getInstance().getDisplayWidth() - this.getParent().getAllStyles().getHorizontalPadding()) / 2);
        return dim;
    }

    @Override
    public void update() {

    }

    @Override
    public void commit() {

    }

    @Override
    public Node getViewNode() {
        return null;
    }
}
