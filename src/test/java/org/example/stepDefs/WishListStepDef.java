package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.WishListPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.example.stepDefs.Hooks.driver;

public class WishListStepDef {
    HomePage homePage = new HomePage(driver);
    WishListPage wishListPage = new WishListPage(driver);
    SoftAssert soft = new SoftAssert();

    @When("user add product to wishlist from home page")
    public void userAddProductToWishlistFromHomePage() {
        homePage.clickOnWishlistBtnProduct();
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {

        // Verify
        System.out.println(homePage.getNotificationBarSuccessMessage().getText());
        // Assert on success message
        soft.assertTrue(homePage.getNotificationBarSuccessMessage().getText().contains("The product has been added to your wishlist"));
//        // Verify green color
//        System.out.println(homePage.getNotificationBarSuccessMessage().getAttribute("background-color"));
        // Assert on Success message background color
        soft.assertEquals(homePage.getNotificationBackgroundColor(), "rgba(75, 176, 122, 1)");
        soft.assertAll();
    }

    @And("user open wishlist page")
    public void userOpenWishlistPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(homePage.getNotificationBarSuccessMessage()));
        homePage.clickOnWishlistLink();
    }

    @Then("product is displayed on wishlist")
    public void productIsDisplayedOnWishlist() {
        Assert.assertNotNull(wishListPage.getQtyValue(), "0");
    }
}
