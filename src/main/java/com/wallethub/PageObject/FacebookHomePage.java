package com.wallethub.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookHomePage extends BasePage {

    public FacebookHomePage(WebDriver webDriver, WebElement webElement, By locator) {
        super(webDriver, webElement, locator);
    }

    By loginUsernameTextField = By.name("email");
    By loginPasswordTextField = By.name("pass");
    By loginButton = By.name("login");
    By statusMessageField = By.xpath("//div[@aria-label='Create a post']/div[1]");
    By typeStatusMessageField = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]");
            //By.xpath("//div[contains(text(),\"What's on your mind\")]");
    By postMessage = By.xpath("//span[text()='Post']");

    public void login(String username, String password) {

        findElement(loginUsernameTextField).sendKeys(username);
        findElement(loginPasswordTextField).sendKeys(password);
        doClick(loginButton);
    }

    public void postStatusMessage(String message) {
        isAlertPresent();
        waitForElementToBeClickable(statusMessageField);
        switchToActiveframe();
        waitAndFindElement(typeStatusMessageField).sendKeys(message);
        doClick(postMessage);
    }

    private By getPostedMessage(String message) {
        return By.xpath("//div[text()=" + message + "]");
    }

    public boolean isPostMessageDisplayed(String message) {

        try {
            return findElement(getPostedMessage(message)).isDisplayed();

        } catch (NoSuchElementException e) {
            return false;
        }
    }


}