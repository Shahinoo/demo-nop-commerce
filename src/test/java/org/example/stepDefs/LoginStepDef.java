package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.RegistrationPage;
import org.testng.Assert;

import static org.example.stepDefs.Hooks.driver;

public class LoginStepDef {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);
    RegisterStepDef registerStepDef = new RegisterStepDef();


    @Given("user go to login page")
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

    @When("user login with valid email and {string}")
    public void userLoginWithValidEmailAndPassword(String password) {
        loginPage.enterLoginCredentials(registerStepDef.randomEmail, password);
        System.out.println(registerStepDef.randomEmail);
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        loginPage.clickOnLoginBtn();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {

    }
}
