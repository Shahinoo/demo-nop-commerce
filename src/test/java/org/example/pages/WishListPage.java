package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListPage {
    WebDriver driver;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
    }

    By qtyValue = By.cssSelector("input.qty-input");

//    By table = By.className("table-wrapper");
//    By row = By.tagName("tr");
//    By col = By.tagName("td");

    public String getQtyValue() {
        System.out.println(driver.findElement(qtyValue).getAttribute("value"));
        return driver.findElement(qtyValue).getAttribute("value");
    }

}
