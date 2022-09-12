package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

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

    public void doLogin(String loginEmail, String loginPassword) {
        driver.findElement(loginEmailTxtField).sendKeys(loginEmail);
        driver.findElement(loginPasswordTxtField).sendKeys(loginPassword);
        driver.findElement(loginBtn).click();
    }

}
