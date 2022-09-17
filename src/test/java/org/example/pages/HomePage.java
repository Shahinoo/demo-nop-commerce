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
    By searchTextField = By.cssSelector("input#small-searchterms");
    By searchBTN = By.cssSelector(".button-1.search-box-button");
    By iPhoneSlider = By.cssSelector("div#nivo-slider > a:nth-of-type(1)");
    By nokiaSlider = By.cssSelector("div#nivo-slider > a:nth-of-type(2)");


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

    public void clickOnSearchTextField() {
        driver.findElement(searchTextField).click();
    }

    public void doSearch(String text) {
        driver.findElement(searchTextField).sendKeys(text);
        driver.findElement(searchBTN).click();
    }

    public void clickOniPhoneSlider() {
        driver.findElement(iPhoneSlider).click();
    }

    public void clickOnNokiaSlider() {
        driver.findElement(nokiaSlider).click();
    }
}
