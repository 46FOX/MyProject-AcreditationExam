package org.fasttrackit.features.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.Assert.assertTrue;

public class HomePage extends PageObject {

    @FindBy(css = ".woocommerce-MyAccount-content")
    private WebElementFacade myAccountContent;

    @FindBy(css = ".header-bot #menu-main li:nth-child(2) a")
    private WebElementFacade myAccountHyperLink;

    @FindBy(css = ".woocommerce-error li")
    private WebElementFacade errorWarning;

    @FindBy(css = ".header-bot #menu-main li:nth-child(3) a")
    private WebElementFacade shopHyperLink;

    @FindBy(css = ".header-bot #menu-main li:nth-child(4) a")
    private WebElementFacade checkoutHyperLink;

    @FindBy(css = ".cart-control .amount")
    private WebElementFacade cart;

    @FindBy(css = ".cart_item .remove")
    private WebElementFacade removeButton;

    @FindBy(css = ".cart-empty")
    private WebElementFacade emptyCartMessage;

    public void assertWarningMessageIs(String message) {
        assertTrue(element(errorWarning).containsText(message));
    }

    public void isLoggedIn(String message) {
        assertTrue(element(myAccountContent).containsText(message));

    }

    public void clickOnShopHyperLink() {
        waitFor(shopHyperLink);
        clickOn(shopHyperLink);
    }

    public void clickOnCheckoutHyperLink() {
        waitFor(checkoutHyperLink);
        clickOn(checkoutHyperLink);

    }

    public void removeItem() {
        waitFor(myAccountHyperLink);
        clickOn(cart);
        try {
            if (getDriver().findElement(By.cssSelector(".cart_item .remove")).isDisplayed()) {
                waitFor(removeButton);
                clickOn(removeButton);
                assertTrue(element(emptyCartMessage).getText().contains("Your cart is currently empty."));
            }
        } catch (NoSuchElementException ignore) {
        }
    }
}
