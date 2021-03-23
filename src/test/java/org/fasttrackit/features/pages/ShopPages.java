package org.fasttrackit.features.pages;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;

public class ShopPages extends PageObject {

    @FindBy(css = ".item-wrap a[data-product_sku=\"woo-cap\"]")
    private WebElementFacade cap;

    @FindBy(css = ".cart-control .amount")
    private WebElementFacade price;

    @FindBy(css = ".wc-proceed-to-checkout a")
    private WebElementFacade proceedToCheckoutButton;

    @FindBy(css = ".product-remove a[aria-label=\"Remove this item\"]")
    private WebElementFacade removeItemButton;

    @FindBy(css = "#billing_first_name")
    private WebElementFacade billingFirstName;

    @FindBy(css = "#billing_last_name")
    private WebElementFacade billingLastName;

    @FindBy(css = ".woocommerce-billing-fields__field-wrapper #billing_address_1")
    private WebElementFacade billingHouseNumberAndStreetNameAddress;

    @FindBy(css = ".woocommerce-billing-fields__field-wrapper #billing_city")
    private WebElementFacade billingTownCity;

    @FindBy(css = ".woocommerce-billing-fields__field-wrapper #billing_postcode")
    private WebElementFacade billingPostCode;

    @FindBy(css = "#billing_phone")
    private WebElementFacade billingPhone;

    @FindBy(css = "#place_order")
    private WebElementFacade placeButton;

    @FindBy(css = ".status-publish .entry-header h2")
    private WebElementFacade entryTitle;

    @FindBy(css = ".woocommerce-error li")
    private WebElementFacade errorWarning;

    public void selectProduct() {
        waitFor(cap);
        clickOn(cap);
    }

    public void isProductAddedToCart(String productPrice) {
        waitFor(price);
        assertTrue(element(price).getText().contains(productPrice));
    }

    public void clickProceedToCheckout() {
        waitFor(proceedToCheckoutButton);
        clickOn(proceedToCheckoutButton);
    }

    public void removeFromCart() {
        waitFor(price);
        clickOn(price);
        waitFor(removeItemButton);
        clickOn(removeItemButton);
    }

    public void fillDataToMandatoryFields(String firstName, String lastName, String houseNumber, String townCity, String postCode, String phone) {
        waitOnPage();
        waitFor(billingFirstName);
        typeInto(billingFirstName, firstName);
        waitFor(billingLastName);
        typeInto(billingLastName, lastName);
        waitFor(billingHouseNumberAndStreetNameAddress);
        typeInto(billingHouseNumberAndStreetNameAddress, houseNumber);
        waitFor(billingTownCity);
        typeInto(billingTownCity, townCity);
        waitFor(billingPostCode);
        typeInto(billingPostCode, postCode);
        waitFor(billingPhone);
        typeInto(billingPhone, phone);
        clickOn(placeButton);
    }

    public void isOrderReceived() throws InterruptedException {
        Thread.sleep(7500);
        waitFor(entryTitle);
        assertTrue(element(entryTitle).getText().contains("Order received".toUpperCase()));
    }

    public void assertWarningMessageIs(String message) {
        assertTrue(element(errorWarning).containsText(message));
    }
}
