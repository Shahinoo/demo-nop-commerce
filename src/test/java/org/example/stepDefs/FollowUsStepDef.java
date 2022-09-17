package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.testng.Assert;

import java.util.ArrayList;

import static org.example.stepDefs.Hooks.driver;

public class FollowUsStepDef {
    HomePage homePage = new HomePage(driver);

    @When("user click on facebook link")
    public void userClickOnFacebookLink() {
        homePage.clickOnFaceBookLink();
    }


    @Then("facebook page is opened on a new tab")
    public void facebookPageIsOpenedOnANewTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        // Verify before switch to facebook tab
        System.out.println(driver.getCurrentUrl());
        driver.switchTo().window(tabs.get(1));
        // Verify after switch to facebook tab
        System.out.println(driver.getCurrentUrl());
        // Assert
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/nopCommerce");
    }

    @When("user click on twitter link")
    public void userClickOnTwitterLink() {
        homePage.clickOnTwitterLink();
    }

    @Then("twitter page is opened on a new tab")
    public void twitterPageIsOpenedOnANewTab() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        // Verify before switch to twitter tab
        System.out.println(driver.getCurrentUrl());
        driver.switchTo().window(tabs.get(1));
        // Verify after switch to twitter tab
        System.out.println(driver.getCurrentUrl());
        // Assert
        Assert.assertEquals(driver.getCurrentUrl(), "https://twitter.com/nopCommerce");
    }

    @When("user click on RSS link")
    public void userClickOnRSSLink() {
        homePage.clickOnRssLink();
    }

    @Then("RSS page is opened on a new tab")
    public void rssPageIsOpenedOnANewTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        // Verify before switch to RSS tab
        System.out.println(driver.getCurrentUrl());
        driver.switchTo().window(tabs.get(1));
        // Verify after switch to RSS tab
        System.out.println(driver.getCurrentUrl());
        // Assert
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/new-online-store-is-open");
    }

    @When("user click on youTube link")
    public void userClickOnYouTubeLink() {
        homePage.clickOnYoutubeLink();
    }

    @Then("youTube page is opened on a new tab")
    public void youtubePageIsOpenedOnANewTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        // Verify before switch to YouTube tab
        System.out.println(driver.getCurrentUrl());
        driver.switchTo().window(tabs.get(1));
        // Verify after switch to YouTube tab
        System.out.println(driver.getCurrentUrl());
        // Assert
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.youtube.com/user/nopCommerce");
    }
}
