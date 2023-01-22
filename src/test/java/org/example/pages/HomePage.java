package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {
    WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Home page Locators
    By registerLink = By.cssSelector(".ico-register");
    By loginLink = By.className("ico-login");
    By currencyDDL = By.id("customerCurrency");
    By searchTextField = By.cssSelector("input#small-searchterms");
    By searchBTN = By.cssSelector(".button-1.search-box-button");
    By iPhoneSlider = By.cssSelector("div#nivo-slider > a:nth-of-type(1)");
    By nokiaSlider = By.cssSelector("div#nivo-slider > a:nth-of-type(2)");
    By faceBookLink = By.cssSelector(".facebook>a[target='_blank']");
    By twitterLink = By.cssSelector(".twitter > a[target='_blank']");
    By rssLink = By.linkText("RSS");
    By youTubeLink = By.linkText("YouTube");
    By wishlistBtnProduct = By.xpath("//div[3]/div[@class='product-item']//button[@title='Add to wishlist']");
    By notificationBarSuccessMessage = By.cssSelector("p.content");
    By wishlistLink = By.cssSelector(".ico-wishlist > .wishlist-label");
    By computerHover = By.cssSelector(".notmobile.top-menu > li:nth-of-type(1) > a");
    By notBooksSubHover = By.cssSelector(".notmobile.top-menu > li:nth-of-type(1) > .first-level.sublist > li:nth-of-type(2) > a");
    //homepage/subcategory ex: notebooks
    By pageTitle = By.cssSelector("div[class='page-title']");


    public WebElement pageTitleWebEle() {
        return driver.findElement(pageTitle);
    }

    public void hoverOnCategories() {
        Actions hover = new Actions(driver);
        hover.moveToElement(driver.findElement(computerHover));
        hover.moveToElement(driver.findElement(notBooksSubHover));
        hover.click().build().perform();
        System.out.println(driver.findElement(notBooksSubHover).getAttribute("href"));

    }
//
//    public List<WebElement> mainCategories() {
//        return driver.findElements(By.cssSelector(".notmobile.top-menu>li"));
//    }
//
//    public void hoverOnAndSelect() throws InterruptedException {
//        int randomNumber = new Random().nextInt(3);
//        Actions hover = new Actions(driver);
//        hover.moveToElement(mainCategories().get(randomNumber)).build().perform();
//         String mainCategory = mainCategories().get(randomNumber).getText();
//        // verify
//         System.out.println(mainCategory);
//        //mainCategories().get(randomNumber).click();
//        /////////////////////////////
//        Thread.sleep(2000);
//        List<WebElement> subCategories = driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[" + randomNumber + "]/ul[@class=\"sublist first-level\"]/li/a"));
//        int randomNumberSub = new Random().nextInt(3);
//        String subCat = subCategories.get(randomNumberSub).getAttribute("href");
//        // Verify
//        System.out.println(subCat);
//        hover.moveToElement(subCategories.get(randomNumberSub)).build().perform();
//        //hover.click().perform();
//        subCategories.get(randomNumberSub).click();
//
//    }

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

    public void clickOnFaceBookLink() {
        driver.findElement(faceBookLink).click();
    }

    public void clickOnTwitterLink() {
        driver.findElement(twitterLink).click();
    }

    public void clickOnRssLink() {
        driver.findElement(rssLink).click();
    }

    public void clickOnYoutubeLink() {
        driver.findElement(youTubeLink).click();
    }

    public void clickOnWishlistBtnProduct() {
        driver.findElement(wishlistBtnProduct).click();
    }

    public WebElement getNotificationBarSuccessMessage() {
        return driver.findElement(notificationBarSuccessMessage);
    }

    public String getNotificationBackgroundColor() {
        String backgroundColor = driver.findElement(By.cssSelector("div#bar-notification > .bar-notification.success")).getCssValue("background-color");
        System.out.println(backgroundColor);
        return backgroundColor;
    }

    public void clickOnWishlistLink() {
        driver.findElement(wishlistLink).click();
    }
}
