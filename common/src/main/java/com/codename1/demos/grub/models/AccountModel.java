/*
 * Copyright (c) 2012, Codename One and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Codename One designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Codename One through http://www.codenameone.com/ if you
 * need additional information or have any questions.
 */

package com.codename1.demos.grub.models;

import com.codename1.demos.grub.interfaces.Account;
import com.codename1.demos.grub.interfaces.Address;
import com.codename1.rad.models.*;

import java.util.List;

public class AccountModel extends Entity {
    public static StringProperty firstName, lastName, emailAddress, password, mobileNumber;
    public static ListProperty addresses, creditCards, favoriteRestaurants, completedOrders;

    public static class Addresses extends EntityList {}
    public static class CreditCards extends EntityList {}
    public static class FavoriteRestaurants extends EntityList {}
    public static class CompletedOrders extends EntityList {}

    public static final EntityType TYPE = new EntityType(){{
        firstName = string(tags(Account.firstName));
        lastName = string(tags(Account.lastName));
        emailAddress = string(tags(Account.emailAddress));
        password = string(tags(Account.password));
        mobileNumber = string(tags(Account.mobileNumber));

        addresses = list(Addresses.class, tags(Account.addresses));
        creditCards = list(CreditCards.class, tags(Account.creditCards));
        favoriteRestaurants = list(FavoriteRestaurants.class, tags(Account.favoriteRestaurants));
        completedOrders = list(CompletedOrders.class, tags(Account.completedOrders));
    }};

    {
        setEntityType(TYPE);
    }

    public AccountModel(){
        this("", "", "", "", "", null, null, null);
    }

    public AccountModel(String firstName,
                        String lastName,
                        String emailAddress,
                        String password,
                        String mobileNumber,
                        List<Entity> addresses,
                        List<Entity> creditCards,
                        List<Entity> completedOrders){

        set(this.firstName, firstName);
        set(this.lastName, lastName);
        set(this.emailAddress, emailAddress);
        set(this.password, password);
        set(this.mobileNumber, mobileNumber);

        Addresses addressesList = new Addresses();
        if (addresses != null){
            for (Entity address : addresses){
                addressesList.add(address);
            }
        }
        set(this.addresses, addressesList);

        CreditCards creditCardsList = new CreditCards();
        if (creditCards != null){
            for (Entity creditCard : creditCards){
                addressesList.add(creditCard);
            }
        }
        set(this.creditCards, creditCardsList);

        CompletedOrders completedOrdersList = new CompletedOrders();
        if (completedOrders != null){
            for (Entity completeOrder : completedOrders){
                completedOrdersList.add(completeOrder);
            }
        }
        set(this.completedOrders, completedOrdersList);

        FavoriteRestaurants favoriteRestaurantsList = new FavoriteRestaurants();
        set(this.favoriteRestaurants, favoriteRestaurantsList);
    }

    public EntityList getCreditCards(){
        return (CreditCards)get(Account.creditCards);
    }

    public EntityList getAddresses(){
        return (CreditCards)get(Account.addresses);
    }

    public EntityList getCompletedOrders(){
        return (CompletedOrders)get(Account.completedOrders);
    }

    public void addCreditCard(Entity creditCard){
        CreditCards creditCards = (CreditCards)get(Account.creditCards);
        creditCards.add(creditCard);
    }

    public void addAddress(Entity address){
        EntityList<Entity> addresses = (Addresses)get(Account.addresses);
        if(addresses.size() == 0){
            address.set(Address.isDefault, true);
        }else{
            if(address.getBoolean(Address.isDefault)){
                for(Entity currAddress : addresses){
                    if(currAddress.getBoolean(Address.isDefault)){
                        currAddress.set(Address.isDefault, false);
                    }
                }
            }
        }
        addresses.add(address);
    }

    public void addFavorite(Entity rest){
        EntityList<Entity> favoriteRests = (FavoriteRestaurants)get(Account.favoriteRestaurants);
        favoriteRests.add(rest);
    }
    public void removeFavorite(Entity rest){
        EntityList<Entity> favoriteRests = (FavoriteRestaurants)get(Account.favoriteRestaurants);
        favoriteRests.remove(rest);
    }

    public void checkValidation(Entity address){
        EntityList<Entity> addresses = (Addresses)get(Account.addresses);
        if(address.getBoolean(Address.isDefault)){
            for(Entity currAddress : addresses){
                if(currAddress.getBoolean(Address.isDefault) && address != currAddress){
                    currAddress.set(Address.isDefault, false);
                }
            }
        }
    }

    public Entity getDefaultAddress(){
        EntityList<Entity> addresses = (Addresses)get(Account.addresses);
        for(Entity currAddress : addresses){
            if(currAddress.getBoolean(Address.isDefault)){
                return currAddress;
            }
        }
        return null;
    }

    public boolean isFavorite(Entity rest){
        EntityList<Entity> favoriteRests = (FavoriteRestaurants)get(Account.favoriteRestaurants);
        for (Entity currRest : favoriteRests){
            if(currRest == rest){
                return true;
            }
        }
        return false;
    }
}
