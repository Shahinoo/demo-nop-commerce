package org.example.pages;

import org.openqa.selenium.By;

public class RegistrationPage {
    /**
     * Locators of Register page
     */
    By genderRadioButton = By.id("gender");
    By firstNameTxtField = By.id("FirstName");
    By lastNameTxtField = By.id("LastName");
    By emailTxtField = By.id("Email");
    By passwordTxtField = By.id("Password");
    By confirmPasswordTxtField = By.id("ConfirmPassword");
    By registerBtn = By.id("register-button");

    /**
     * Locators of Register Result page
     */
    By successRegisterMessage = By.cssSelector(".result");
    By logOutLink = By.cssSelector(".ico-logout");
    By continueBtn = By.cssSelector("a[class=\"button-1 register-continue-button\"]");


}
