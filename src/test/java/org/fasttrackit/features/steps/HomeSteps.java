package org.fasttrackit.features.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.features.pages.HomePage;

public class HomeSteps {
    private HomePage homePage;

    @Step
    public void assertUserIsLoggedIn(String message) {
        homePage.isLoggedIn(message);
    }

    @Step
    public void clickShopTab() {
        homePage.clickOnShopHyperLink();
    }

    @Step
    public void clickCheckoutTab() {
        homePage.clickOnCheckoutHyperLink();
    }
}
