package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.example.stepDefs.Hooks.driver;

public class HomePage {
    WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Home page Locators
    By registerLink = By.cssSelector(".ico-register");
    By loginLink = By.linkText("Log in");


    // Home page Functions
    public void clickOnRegistrationLink() {
        driver.findElement(registerLink).click();
    }

    public void clickOnLoginLink() {
        driver.findElement(loginLink).click();
    }

    public String getHomePageURL() {
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

}
