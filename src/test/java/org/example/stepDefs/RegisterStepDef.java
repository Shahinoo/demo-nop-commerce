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


//
//    String randomEmail = randomEmail();

    public static String randomEmail() {
        String generatedString = RandomStringUtils.randomAlphabetic(4);
        String randomEmail = generatedString + "@gmail.com";
        return randomEmail;
    }



//    public String getRandomEmail() {
//        return randomEmail;
//    }

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
        System.out.println(randomEmail);
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

//    @Given("User do registration")
//    public String userDoRegistration(DataTable dt) {
////        String generatedString = RandomStringUtils.randomAlphabetic(4);
////        String randomEmail = generatedString + "@gmail.com";
//        registrationPage.doRegister(dt.cell(1, 0), dt.cell(1, 1), randomEmail, dt.cell(1, 3));
//        System.out.println(randomEmail);
//        String storeEmail = randomEmail;
//       return storeEmail;
//    }

    @When("Userr do registration")
    public void userrDoRegistration() throws IOException, ParseException {
        jsonReader.JsonReader();
        registrationPage.doRegister(jsonReader.firstName, jsonReader.lastName, jsonReader.email, jsonReader.password);
    }

//    public  void getDataTable (DataTable dt) {
//        userDoRegistration()
//
//    }

//    public void getValueOfRandomEmail (String email) {
//        String value = String.valueOf(email);
//        System.out.println(value);
//    }

//    public String getStoreEmail() {
//        return storeEmail;
//    }

//    public String getRandomEmail() {
//
//        return randomEmail;
//    }
}
