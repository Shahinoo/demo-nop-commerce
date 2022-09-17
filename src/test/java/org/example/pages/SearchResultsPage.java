package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage {
    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    By productTitle = By.cssSelector(".product-item  h2 > a");
    By skuTitle = By.cssSelector(".sku > .value");


    public List<WebElement> findResults() {
        List<WebElement> results = driver.findElements(productTitle);
        return results;
    }

    public void clickOnProduct() {
        driver.findElement(productTitle).click();
    }

    public String findSpecificResults() {
        String specific = driver.findElement(skuTitle).getText();
        return specific;
    }

}
