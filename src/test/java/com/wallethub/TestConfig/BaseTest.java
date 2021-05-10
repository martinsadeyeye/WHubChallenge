package com.wallethub.TestConfig;

import com.wallethub.Component.WebCoreElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver webDriver;
    private WebDriverWait wait;
    public WebCoreElement webCoreElement;
    private WebElement webElement;
    private  By locator;

    @BeforeMethod
    public void testInit() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
      //options.addArguments("headless");
        options.addArguments("--disable-notifications");

        webDriver = new ChromeDriver(options);
        wait = new WebDriverWait(webDriver, 15);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // create the object of page class: Instantiate Page Class
        webCoreElement = new WebCoreElement(webDriver, webElement, locator);

    }

    public void goToUrl(String Url){
        webDriver.navigate().to(Url);
    }

    @AfterMethod
    public void testCleanUp() {
        if ( webDriver != null ) {
            webDriver.quit();
        }
    }

}
