package org.example.pages;

import org.openqa.selenium.By;

import static org.example.stepDefs.Hooks.driver;

public class HomePage {

    // Home page Locators
    By registerLink = By.cssSelector(".ico-register");


    // Home page Functions
    public void clickOnRegistrationLink() {
        driver.findElement(registerLink).click();
    }
    
}
