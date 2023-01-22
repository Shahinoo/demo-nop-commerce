package org.example.stepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.data.JsonDataReader;
import org.example.pages.HomePage;
import org.example.pages.RegistrationPage;
import org.json.simple.parser.ParseException;

import java.io.IOException;

import static org.example.stepDefs.Hooks.driver;

public class RegisterStepDef {

    HomePage homePage = new HomePage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);
    JsonDataReader jsonReader = new JsonDataReader();

    @Given("user go to register page")
    public void userGoToRegisterPage() {
        homePage.clickOnRegistrationLink();
    }

    @When("user select gender type male")
    public void userSelectGenderTypeMale() {
        registrationPage.selectGenderMale();
    }

    @And("user enter first name {string} and last name {string}")
    public void userEnterFirstNameAndLastName(String first, String last) {
        registrationPage.enterFirstAndLastName(first, last);
    }

    @And("user enter date of birth")
    public void userEnterDateOfBirth(DataTable dt) {
        registrationPage.selectBirthDate(dt.cell(1, 0), dt.cell(1, 1), dt.cell(1, 2));
    }

    @And("user enter email field")
    public void userEnterEmailField() {
        String generatedString = RandomStringUtils.randomAlphabetic(4);
        String randomEmail = generatedString + "@gmail.com";
        // verify
        System.out.println(randomEmail);
        // Enter email
        registrationPage.enterEmail(randomEmail);
    }

    @And("user fills Password fields {string} and {string}")
    public void userFillsPasswordFieldsAnd(String password, String confirmPassword) {
        registrationPage.enterPasswords(password, confirmPassword);
    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
        registrationPage.clickOnRegisterBtn();
    }

    @Then("Success message is displayed")
    public void successMessageIsDisplayed() {
        registrationPage.displaySuccessMessage();

    }

    @When("User do registration")
    public void userDoRegistration() throws IOException, ParseException {

        // Random Email
        String generatedString = RandomStringUtils.randomAlphabetic(6);
        String randomEmail = generatedString + "@gmail.com";
        // verify
        System.out.println(randomEmail);
        // Register with values from jsonReader and the generated random email
        jsonReader.JsonReader();
        registrationPage.doRegister(jsonReader.firstName, jsonReader.lastName, randomEmail, jsonReader.password);

    }

}
