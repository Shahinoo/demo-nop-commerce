package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.data.JsonDataReader;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.RegistrationPage;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static org.example.stepDefs.Hooks.driver;

public class LoginStepDef {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);
    RegisterStepDef registerStepDef = new RegisterStepDef();
    JsonDataReader jsonReader = new JsonDataReader();
    SoftAssert soft = new SoftAssert();


    @When("user go to login page")
    public void userGoToLoginPage() {
        homePage.clickOnLoginLink();
    }

    @When("user logout")
    public void userLogout() {
        registrationPage.doLogout();
    }

    @Then("user on home page")
    public void userOnHomePage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
    }


    @And("user login with valid email and password")
    public void userLoginWithValidEmailAndPassword() throws IOException, ParseException {
        jsonReader.JsonReader();
        loginPage.enterLoginCredentials(jsonReader.email, jsonReader.password);
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        loginPage.clickOnLoginBtn();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        // Assert on Current page after login
        soft.assertEquals(loginPage.getLoginPageURL(), "https://demo.nopcommerce.com/login?returnurl=%2F");
        // Assert on my Account tab
        soft.assertTrue(loginPage.getMyAccountWebEle().isDisplayed());
        soft.assertAll();

    }

    @When("user login with invalid {string} and {string}")
    public void userLoginWithInvalidAnd(String wrongEmail, String password) {
        loginPage.enterLoginCredentials(wrongEmail, password);
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        // Assert on failed message
        soft.assertTrue(loginPage.getFailedLoginMessageText().contains("Login was unsuccessful."));
        // Assert on message color

        soft.assertEquals(loginPage.getLoginMessageColor(), "rgba(228, 67, 75, 1)");
        soft.assertAll();
    }
}
