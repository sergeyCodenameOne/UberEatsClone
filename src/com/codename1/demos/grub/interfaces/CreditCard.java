package com.codename1.demos.grub.interfaces;

import com.codename1.rad.models.Tag;

public interface CreditCard {
    Tag cardHolderName = new Tag("cardHolderName");
    Tag number = new Tag("number");
    Tag expirationYear = new Tag("expirationYear");
    Tag expirationMonth = new Tag("expirationMonth");
    Tag secretCode = new Tag("secretCode");

}
