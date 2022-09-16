package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.data.JsonDataReader;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.RegistrationPage;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.IOException;

import static org.example.stepDefs.Hooks.driver;

public class LoginStepDef {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);
    RegisterStepDef registerStepDef = new RegisterStepDef();
    JsonDataReader jsonReader = new JsonDataReader();


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


    @When("user login with valid email and password")
    public void userLoginWithValidEmailAndPassword() throws IOException, ParseException {
        //  System.out.println(registerStepDef.randomEmail);
        jsonReader.JsonReader();
        loginPage.enterLoginCredentials(jsonReader.email, jsonReader.password);


    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        loginPage.clickOnLoginBtn();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {

    }
}
