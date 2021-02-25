package org.fasttrackit.features.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://qa2.fasttrackit.org:8008")
public class LoginPage extends PageObject {


    @FindBy(css = "#username")
    private WebElementFacade usernameField;

    @FindBy(css = ".header-bot #menu-main li:nth-child(2) a")
    private WebElementFacade myAccountHyperLink;

    @FindBy(css = "#password")
    private WebElementFacade passwordField;

    @FindBy(css = "button[name=\"login\"]")
    private WebElementFacade loginButton;

    public void fillUsernameAndPassword(String username, String password) {
        waitFor(myAccountHyperLink);
        clickOn(myAccountHyperLink);
        waitFor(usernameField);
        waitFor(passwordField);
        typeInto(usernameField, username);
        typeInto(passwordField, password);
    }


    public void clickLoginButton() {
        waitFor(loginButton);
        clickOn(loginButton);
    }
}
