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


package com.codename1.demos.grub.views;

import com.codename1.components.MultiButton;
import com.codename1.demos.grub.Util;
import com.codename1.demos.grub.interfaces.Address;
import com.codename1.demos.grub.interfaces.PaymentMethod;
import com.codename1.demos.grub.interfaces.Restaurant;
import com.codename1.demos.grub.models.AccountModel;
import com.codename1.demos.grub.models.CompletedOrderModel;
import com.codename1.demos.grub.models.PaymentMethodModel;
import com.codename1.demos.grub.models.RestaurantModel;
import com.codename1.l10n.L10NManager;
import com.codename1.rad.controllers.ActionSupport;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.EntityList;
import com.codename1.rad.models.Property;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.UIManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.codename1.ui.CN.convertToPixels;
import static com.codename1.ui.CN.isTablet;
import static com.codename1.ui.util.Resources.getGlobalResources;

public class OrderView extends AbstractEntityView {

    Node viewNode;
    Property orderProp, discountProp;
    List dishes = new ArrayList();
    Label totalPriceLabel, itemTotalCostLabel;
    Container totalPriceCnt, itemTotalCostCnt;
    AccountModel account;
    MultiButton deliverToButton;
    PaymentMethodModel paymentMethod;
    PaymentMethodView paymentView;

    public static final ActionNode.Category COMPLETE_ORDER = new ActionNode.Category();
    public static final ActionNode.Category CHANGE_DELIVERY_ADDRESS = new ActionNode.Category();
    public static final ActionNode.Category CHANGE_DELIVERY_PAYMENT = new ActionNode.Category();

    public OrderView(Entity restEntity, Entity profileEntity, Node viewNode, Node mainWindowNode) {
        super(restEntity);
        account = (AccountModel) profileEntity;
        setLayout(BoxLayout.y());
        setUIID("OrderCnt");
        Container orderDetails = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        setScrollableY(true);
        setScrollVisible(false);

        this.viewNode = viewNode;
        orderProp = restEntity.findProperty(Restaurant.order);
        discountProp = restEntity.findProperty(Restaurant.restDiscount);


        Button backButton = new Button(FontImage.MATERIAL_KEYBOARD_ARROW_LEFT);
        backButton.setUIID("AddDishBackButton");
        backButton.addActionListener(evt -> {
            evt.consume();
            ActionSupport.dispatchEvent(new FormController.FormBackEvent(backButton));
        });
        Label headerLabel = new Label("MY ORDERS", "AddDishHeaderLabel");
        Container headerCnt = BorderLayout.centerCenter(headerLabel).add(BorderLayout.WEST, backButton);
        headerCnt.setUIID("AddDishHeaderCnt");
        add(headerCnt);

        Container dishesCnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        if (restEntity.get(orderProp) instanceof EntityList) {
            EntityList<Entity> dishList = (EntityList) (restEntity.get(Restaurant.order));
            for(Entity dishOrderEntity : dishList){
                DishOrderPreview dish = new DishOrderPreview(dishOrderEntity, viewNode);
                dishes.add(dish);
                dishesCnt.add(dish);
            }
        }
        MultiButton addPromoCodeButton = new MultiButton("ADD PROMO CODE");
        addPromoCodeButton.setUIID("AddPromoCodeButton");
        addPromoCodeButton.setUIIDLine1("AddPromoCodeButtonTextLine1");
        addPromoCodeButton.setUIIDLine2("AddPromoCodeButtonTextLine2");
        if ((double)restEntity.get(discountProp) != 0.0){
            addPromoCodeButton.setTextLine2("You have 20% Discount!!!");
        }
        Image promCodeImage = getGlobalResources().getImage("ticket-icon.png").scaled(convertToPixels(4), convertToPixels(4));
        addPromoCodeButton.setIcon(promCodeImage);
        Image gotoIcon = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_RIGHT, UIManager.getInstance().getComponentStyle("GoToIcon"));
        addPromoCodeButton.setEmblem(gotoIcon);
        addPromoCodeButton.setEmblemPosition("East");
        orderDetails.add(addPromoCodeButton);
        addPromoCodeButton.addActionListener(evt->{
            Command okCommand = new Command("Ok");
            Command cancelCommand = new Command("Cancel");

            Command[] commands = {okCommand, cancelCommand};
            TextField promoCode = new TextField("", "Promo Code");
            promoCode.setUIID("PromoCodeTextField");
            promoCode.getHintLabel().setUIID("PromoCodeTextFieldHint");
            if (okCommand == Dialog.show("Enter Promo Code", promoCode, commands)){
                String promoCodeString = promoCode.getText();
                if (promoCodeString != null && promoCodeString.length() > 0){
                    restEntity.set(discountProp, 0.2);
                    addPromoCodeButton.setTextLine2("You have 20% Discount!!!");
                    this.update();
                }
            }
        });

        EntityList<Entity> cards = (EntityList<Entity>) account.getCreditCards();
        if (cards.size() == 0){
            paymentMethod = new PaymentMethodModel(PaymentMethod.CASH, null);
        }else{
            paymentMethod = new PaymentMethodModel(PaymentMethod.CREDIT_CARD, cards.get(0));
        }

        paymentView = new PaymentMethodView(paymentMethod, viewNode);
        orderDetails.add(paymentView);

        deliverToButton = new MultiButton("DELIVER TO");
        deliverToButton.setUIID("ManageAddressButton");
        deliverToButton.setUIIDLine1("ManageAddressButtonLine1");
        deliverToButton.setUIIDLine2("ManageAddressButtonLine2");
        Image mapPinIcon = getGlobalResources().getImage("map-pin-icon.png").scaled(convertToPixels(4), convertToPixels(4));
        deliverToButton.setIcon(mapPinIcon);
        deliverToButton.setEmblem(gotoIcon);
        deliverToButton.setTextLine2("");
        Entity address = ((AccountModel)profileEntity).getDefaultAddress();
        if (address != null){
            deliverToButton.setTextLine2(address.getText(Address.city) + ", " + address.getText(Address.street));
        }
        deliverToButton.addActionListener(evt->{
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(CHANGE_DELIVERY_ADDRESS);
            if (action != null) {
                action.fireEvent(null, OrderView.this);
            }
        });
        orderDetails.add(deliverToButton);

        Label deliveryFeeHeaderLabel = new Label("Delivery Fee", "OrderDeliveryFeeHeader");
        Label deliveryFeeLabel = new Label(restEntity.getDouble(Restaurant.deliveryFee) + " " + L10NManager.getInstance().getCurrencySymbol(), "OrderDeliveryFee");
        Container deliveryFeeCnt = BorderLayout.centerCenterEastWest(null, deliveryFeeLabel, deliveryFeeHeaderLabel);
        deliveryFeeCnt.setUIID("DeliveryFeeCnt");

        Label itemTotalHeaderLabel = new Label("Item Total", "ItemTotalHeader");
        itemTotalCostLabel = new Label("", "ItemTotalCost");
        itemTotalCostCnt = BorderLayout.centerCenterEastWest(null, itemTotalCostLabel, itemTotalHeaderLabel);
        itemTotalCostCnt.setUIID("ItemTotalCostCnt");

        Label totalHeaderLabel = new Label("Total:", "TotalCostHeader");
        totalPriceLabel = new Label("", "TotalCost");
        totalPriceCnt = BorderLayout.centerCenterEastWest(null, totalPriceLabel, totalHeaderLabel);
        totalPriceCnt.setUIID("TotalCostCnt");

        Button confirmOrder = new Button("Confirm Order", "OrderConfirmButton");
        confirmOrder.addActionListener(evt->{
            evt.consume();
            ActionNode action = mainWindowNode.getInheritedAction(COMPLETE_ORDER);
            if (action != null) {
                int year = Calendar.getInstance().get(Calendar.YEAR);
                int month = Calendar.getInstance().get(Calendar.MONTH);
                int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
                String date = month + "." + day + "." + year;
                action.fireEvent(new CompletedOrderModel(restEntity, (EntityList)restEntity.get(Restaurant.order), date, Address.HOME), OrderView.this);
            }
        });

        Container summaryCnt = new Container(new BorderLayout(), "OrderSummaryCnt");
        summaryCnt.add(BorderLayout.NORTH, BoxLayout.encloseY(deliveryFeeCnt, itemTotalCostCnt));
        summaryCnt.add(BorderLayout.CENTER, totalPriceCnt);

        orderDetails.add(summaryCnt);
        orderDetails.add(confirmOrder);
        if (isTablet()){
            Container wrapper = new Container(new GridLayout(2));
            wrapper.addAll(dishesCnt, orderDetails);
            add(wrapper);
        }else{
            add(dishesCnt);
            add(orderDetails);
        }
        update();
    }

    @Override
    public void update() {
        itemTotalCostLabel.setText(Util.getPriceAsString(((RestaurantModel)getEntity()).getTotalItemPrice()));
        totalPriceLabel.setText(Util.getPriceAsString(((RestaurantModel)getEntity()).getTotalPrice()));
        itemTotalCostCnt.revalidateWithAnimationSafety();
        Entity address = account.getDefaultAddress();
        if (address != null){
            deliverToButton.setTextLine2(address.getText(Address.city) + ", " + address.getText(Address.street));
        }
        deliverToButton.revalidateWithAnimationSafety();
        paymentView.update();
        revalidateWithAnimationSafety();
    }

    @Override
    public void commit() {

    }

    @Override
    public Node getViewNode() {
        return viewNode;
    }

    public void setCreditCard(Entity card){
        paymentMethod.set(PaymentMethod.method, PaymentMethod.CREDIT_CARD);
        paymentMethod.set(PaymentMethod.creditCard, card);
        paymentView.update();
    }

}
