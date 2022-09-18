package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;

public class SearchStepDef {
    HomePage homePage = new HomePage(driver);
    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
    SoftAssert soft = new SoftAssert();

    @When("user clicks on search field")
    public void userClicksOnSearchField() {
        homePage.clickOnSearchTextField();
    }

    @And("user search by {string}")
    public void userSearchBy(String productName) {
        homePage.doSearch(productName);
    }


    @Then("user will find {string} relative results")
    public void userWillFindRelativeResults(String productName) {
        for (int x = 0; x < searchResultsPage.findResults().size(); x++) {
            String result = searchResultsPage.findResults().get(x).getText().toLowerCase();
            // Verify displaying product name
            System.out.println(result);
            // Assert on displaying products
            soft.assertTrue(result.contains(productName));
        }
        // Verify url
        System.out.println(driver.getCurrentUrl());
        // Assert on url
        soft.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="));
        soft.assertAll();
    }

    @Then("user will find {string} specific results")
    public void userWillFindSpecificResults(String sku) {
        searchResultsPage.clickOnProduct();
        // Verify
        System.out.println(searchResultsPage.findSpecificResults());
        // Assert on displaying products
        Assert.assertTrue(searchResultsPage.findSpecificResults().contains(sku), "failed to assert products");
    }
}
