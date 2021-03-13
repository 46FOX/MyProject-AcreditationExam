package org.fasttrackit.features.logintests;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.RandomStringUtils;
import org.fasttrackit.features.steps.HomeSteps;
import org.fasttrackit.features.steps.LoginSteps;
import org.fasttrackit.features.steps.ShopSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class ShopTests {

    private final String username = "admin";
    private final String password = "parola11";

    @Steps
    ShopSteps shopSteps;
    @Managed(uniqueSession = true)
    private WebDriver driver;
    @Steps
    private LoginSteps loginSteps;
    @Steps
    private HomeSteps homeSteps;

    @Test
    public void addProductToCartTest() {
        loginSteps.login(username, password);
        homeSteps.clickShopTab();
        shopSteps.addProductToCart();
        shopSteps.assertPriceDisplayedIs("16,00");
        shopSteps.removeProduct();
    }

    @Test
    public void checkoutItemTest() throws InterruptedException {
        String randomStrings = RandomStringUtils.randomAlphabetic(25);
        String phone = RandomStringUtils.randomNumeric(10);

        loginSteps.login(username, password);
        homeSteps.clickShopTab();
        shopSteps.addProductToCart();
        homeSteps.clickCheckoutTab();
        shopSteps.fillBillingDetails(randomStrings, randomStrings, randomStrings, randomStrings, "405300", phone);
        shopSteps.assertOrderIsReceived();
    }
}
