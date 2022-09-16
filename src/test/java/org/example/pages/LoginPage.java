package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    RegistrationPage registrationPage = new RegistrationPage(driver);

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Locators
     */
    By loginEmailTxtField = By.id("Email");
    By loginPasswordTxtField = By.id("Password");
    By loginBtn = By.cssSelector(".button-1.login-button");

    /**
     * Actions
     */

//    public void doRegisterAndLogin(String fName, String lName, String email, String password, String confirmPassword) {
//        registrationPage.doRegister(fName, lName, email, password);
//        registrationPage.doLogout();
//        enterLoginCredentials(email, password);
//        clickOnLoginBtn();
//    }

    public void enterLoginCredentials(String loginEmail, String loginPassword) {
        driver.findElement(loginEmailTxtField).sendKeys(loginEmail);
        driver.findElement(loginPasswordTxtField).sendKeys(loginPassword);
    }

    public void clickOnLoginBtn() {
        driver.findElement(loginBtn).click();

    }


}
