package org.fasttrackit.features.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.features.pages.HomePage;
import org.fasttrackit.features.pages.LoginPage;

public class LoginSteps {


    private LoginPage loginPage;
    private HomePage homePage;

    @Step
    public void login(String username, String password) {
        loginPage.open();
        loginPage.fillUsernameAndPassword(username, password);
        loginPage.clickLoginButton();
    }

    @Step
    public void assertWarningMessageContains(String message) {
        homePage.assertWarningMessageIs(message);
    }
}
