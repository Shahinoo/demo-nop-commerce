package org.example.stepDefs;

import io.cucumber.java.en.Given;
import org.example.pages.HomePage;
import org.example.pages.RegistrationPage;

public class RegisterStepDef {

    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();

    @Given("user go to register page")
    public void userGoToRegisterPage() {
        System.out.println("Test before Start Coding");
        homePage.clickOnRegistrationLink();
    }
}
