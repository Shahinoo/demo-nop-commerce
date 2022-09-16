package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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
    By currencyDDL = By.id("customerCurrency");


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

    public void changeCurrency() {
        WebElement currencyDDLWebEle = driver.findElement(currencyDDL);
        Select select = new Select(currencyDDLWebEle);
        select.selectByVisibleText("Euro");
    }

    public List<WebElement> prices() {
        List<WebElement> prices = driver.findElements(By.cssSelector(".actual-price.price"));
        return prices;
    }
}
