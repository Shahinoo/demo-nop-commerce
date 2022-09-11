package org.example.stepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.pages.HomePage;
import org.example.pages.RegistrationPage;

import static org.example.stepDefs.Hooks.driver;

public class RegisterStepDef {

    HomePage homePage = new HomePage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);

    @Given("user go to register page")
    public void userGoToRegisterPage() {
        System.out.println("Test before Start Coding");
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
        String generatedString = RandomStringUtils.randomAlphabetic(8);
        String email = generatedString + "@gmail.com";
        // verify
        System.out.println(email);
        // Enter email
        registrationPage.enterEmail(email);
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
}
