package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

/**
 * Hooks are blocks of code that can run at various points in the Cucumber execution cycle.
 * They are typically used for setup and teardown of the environment before and after each scenario.
 */
public class Hooks {

    public static WebDriver driver;

    @Before
    public static void OpenBrowser() {
        //1. using chrome driver
        WebDriverManager.chromedriver().setup();
        //1.1. use headless from ChromeOptions Class
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        //2. instantiate object from Chrome driver
        driver = new ChromeDriver(chromeOptions);
        //3. configurations
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //4. Navigation
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @After
    public static void quitBrowser() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}


