package org.example.stepDefs;

import io.cucumber.java.en.Given;
import org.example.pages.HomePage;

public class RegisterStepDef {

    HomePage homePage = new HomePage();

    @Given("user go to register page")
    public void userGoToRegisterPage() {
        System.out.println("Test before Start Coding");
        homePage.clickOnRegistrationLink();
    }
}
