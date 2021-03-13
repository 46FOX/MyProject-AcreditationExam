package org.fasttrackit.features.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.features.pages.ShopPages;

public class ShopSteps {

    private ShopPages shopPages;

    @Step
    public void assertPriceDisplayedIs(String price) {
        shopPages.isProductAddedToCart(price);
    }

    @Step
    public void addProductToCart() {
        shopPages.selectProduct();
    }

    @Step
    public void proceedToCheckout() {
        shopPages.clickProceedToCheckout();
    }

    @Step
    public void removeProduct() {
        shopPages.removeFromCart();
    }

    @Step
    public void fillBillingDetails(String firstName, String lastName, String houseNumber, String townCity, String postCode, String phone) {
        shopPages.fillDataToMandatoryFields(firstName, lastName, houseNumber, townCity, postCode, phone);
    }

    @Step
    public void assertOrderIsReceived() throws InterruptedException {
        shopPages.isOrderReceived();
    }

    public void assertErrorMessageContains(String errorMessage) {
        shopPages.assertWarningMessageIs(errorMessage);
    }
}
