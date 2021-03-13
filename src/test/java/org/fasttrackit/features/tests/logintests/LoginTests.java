package org.fasttrackit.features.tests.logintests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.features.steps.HomeSteps;
import org.fasttrackit.features.steps.LoginSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginTests {

    private final String username = "admin";
    private final String password = "parola11";

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private HomeSteps homeSteps;

    @Test
    public void successfulLoginTest() {
        loginSteps.login(username, password);
        homeSteps.assertUserIsLoggedIn("Hello admin");
    }

    @Test
    public void invalidPasswordLoginTest() {
        loginSteps.login(username, "");
        loginSteps.assertWarningMessageContains("The password field is empty.");
    }

    @Test
    public void invalidUserLoginTest() {
        loginSteps.login("", password);
        loginSteps.assertWarningMessageContains("Username is required.");
    }

    @Test
    public void invalidLoginWithUpperCaseCredentialsTest() {
        loginSteps.login(username.toUpperCase(), password.toUpperCase());
        loginSteps.assertWarningMessageContains("The password you entered for the username ADMIN is incorrect.");
    }

    @Test
    public void invalidLoginWithSpecialCharactersTest() {
        loginSteps.login("!@#@#$%$&ˆˆ&", "!@##$%ˆˆˆˆ&*(");
        loginSteps.assertWarningMessageContains("Invalid username.");
    }
}
