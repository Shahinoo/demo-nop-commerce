package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.testng.Assert;

import static org.example.stepDefs.Hooks.driver;

public class HoverStepDef {
    HomePage homePage = new HomePage(driver);

    @When("user hover and select random value")
    public void userHoverOnRandomValue() {
        homePage.hoverOnCategories();

    }

    @Then("title of random value is displayed")
    public void titleOfRandomValueIsDisplayed() {
        System.out.println(homePage.pageTitleWebEle().getText());
        Assert.assertTrue(homePage.pageTitleWebEle().getText().contains("Notebooks"));

    }

//    @When("user hover and select random value again")
//    public void userHoverAndSelectRandomValueAgain() throws InterruptedException {
//        homePage.hoverOnAndSelect();
//    }
}
