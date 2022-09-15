package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class RegistrationPage {
    WebDriver driver;
    public Select select;

    // constructor
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Locators of Register page
     */
    By genderRadioButtonMale = By.cssSelector("input#gender-male");
    By genderRadioButtonFemale = By.cssSelector("input#gender-female");
    By firstNameTxtField = By.id("FirstName");
    By lastNameTxtField = By.id("LastName");
    By birthDay = By.name("DateOfBirthDay");
    By birthMonth = By.name("DateOfBirthMonth");
    By birthYear = By.name("DateOfBirthYear");
    By emailTxtField = By.id("Email");
    By passwordTxtField = By.id("Password");
    By confirmPasswordTxtField = By.id("ConfirmPassword");
    By registerBtn = By.id("register-button");

    /**
     * Locators of Register Result page
     */
    By successRegisterMessage = By.cssSelector(".result");
    By logOutLink = By.cssSelector(".ico-logout");
    By continueBtn = By.cssSelector("a[class=\"button-1 register-continue-button\"]");

    /**
     * Actions of registration page
     */
    public void selectGenderMale() {
        driver.findElement(genderRadioButtonMale).click();
    }

    public void enterFirstAndLastName(String fName, String lName) {
        driver.findElement(firstNameTxtField).sendKeys(fName);
        driver.findElement(lastNameTxtField).sendKeys(lName);
    }

    public void selectBirthDate(String day, String month, String year) {
        WebElement birthDayWebEle = driver.findElement(birthDay);
        WebElement birthMonthWebEle = driver.findElement(birthMonth);
        WebElement birthYearWebEle = driver.findElement(birthYear);
        select = new Select(birthDayWebEle);
        select.selectByVisibleText(day);
        select = new Select(birthMonthWebEle);
        select.selectByVisibleText(month);
        select = new Select(birthYearWebEle);
        select.selectByVisibleText(year);
    }

    public void enterEmail(String email) {
        driver.findElement(emailTxtField).sendKeys(email);
    }

    public void enterPasswords(String password, String confirmPassword) {
        driver.findElement(passwordTxtField).sendKeys(password);
        driver.findElement(confirmPasswordTxtField).sendKeys(confirmPassword);
    }

    public void clickOnRegisterBtn() {
        driver.findElement(registerBtn).click();
    }

    public void displaySuccessMessage() {
        SoftAssert soft = new SoftAssert();
        String successMessageString = driver.findElement(successRegisterMessage).getText();
        String colorString = driver.findElement(successRegisterMessage).getCssValue("color");
        // First Assertion
        System.out.println(successMessageString);
        soft.assertTrue(successMessageString.contains("Your registration completed"));
        // second Assertion
        System.out.println(colorString);
        soft.assertEquals(colorString, "rgba(76, 177, 124, 1)");
        // Assert All
        soft.assertAll();
    }

    public void doRegister(String fName, String lName, String email, String password, String confirmPassword) {

        driver.findElement(firstNameTxtField).sendKeys(fName);
        driver.findElement(lastNameTxtField).sendKeys(lName);
        driver.findElement(emailTxtField).sendKeys(email);
        driver.findElement(passwordTxtField).sendKeys(password);
        driver.findElement(confirmPasswordTxtField).sendKeys(confirmPassword);
        driver.findElement(registerBtn).click();

    }



    public void doRegister(String email) {
        driver.findElement(emailTxtField).sendKeys(email);
    }


    public void doLogout() {
        driver.findElement(logOutLink).click();
    }

}
