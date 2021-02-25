package org.fasttrackit.features.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import static org.junit.Assert.assertTrue;

public class HomePage extends PageObject {

    @FindBy(css = ".woocommerce-MyAccount-content")
    private WebElementFacade myAccountContent;

    @FindBy(css = ".header-bot #menu-main li:nth-child(2) a")
    private WebElementFacade myAccountHyperLink;

    @FindBy(css = ".woocommerce-error li")
    private WebElementFacade errorWarning;

    public void assertWarningMessageIs(String message) {
        assertTrue(element(errorWarning).containsText(message));

    }

    public void isLoggedIn(String message) {
        assertTrue(element(myAccountContent).containsText(message));

    }

}
