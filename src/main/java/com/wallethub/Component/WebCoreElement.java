package com.wallethub.Component;

import com.wallethub.PageObject.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class WebCoreElement {

    private final WebDriver webDriver;
    private final WebElement webElement;
    private WebDriverWait wait;
    private final By locator;
    private Actions actions;

    public WebCoreElement(WebDriver webDriver, WebElement webElement, By locator) {
        this.webDriver = webDriver;
        this.webElement = webElement;
        this.locator = locator;
    }

    // create a method with Java Generics and return a new page
    public <TestPage extends BasePage> TestPage getInstance(Class<TestPage> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class, WebElement.class, By.class)
                    .newInstance(this.webDriver, this.webElement, this.locator);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public WebElement findElement(By locator) {
        return webDriver.findElement(locator);
    }

    public WebElement waitAndFindElement(By locator) {

        return new WebDriverWait(webDriver, 30).until(ExpectedConditions.visibilityOfElementLocated(locator));
       // return new FluentWait<WebDriver>(webDriver).withTimeout(140, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
              //  .ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(By locator) {
        new WebDriverWait(webDriver, 300).
                until(ExpectedConditions.elementToBeClickable(waitAndFindElement(locator))).click();
    }

    public void doClick(By locator) {
        webDriver.findElement(locator).click();
    }


    public boolean isAlertPresent() {

        try {
            webDriver.switchTo().alert().accept();
            return true;
        } catch (NoAlertPresentException ex) {
            return false;
        }
    }

    public void switchToActiveframe() {
        webDriver.switchTo().frame(1);
    }

    public void hoverAndClick(By locator) {
        actions = new Actions(webDriver);
        WebElement element = findElement(locator);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
        actions.moveToElement(findElement(locator)).click().build().perform();
    }

}