package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.testng.Assert;

import static org.example.stepDefs.Hooks.driver;

public class CurrencyStepDef {
    HomePage homePage = new HomePage(driver);

    @When("user select Euro currency from currency dropdown list")
    public void userSelectEuroCurrencyFromCurrencyDropdownList() {
        homePage.changeCurrency();
    }

    @Then("euro symbol is shown in the displayed products")
    public void euroSymbolIsShownInTheDisplayedProducts() {
        for (int x = 0; x < homePage.prices().size(); x++) {
            String pricesValue = homePage.prices().get(x).getText();
            // Verify
            System.out.println(pricesValue);
            //Assert
            Assert.assertTrue(pricesValue.contains("€"));
        }
    }
}
