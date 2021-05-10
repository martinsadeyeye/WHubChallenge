package com.wallethub.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookHomePage extends BasePage {

    public FacebookHomePage(WebDriver webDriver, WebElement webElement, By locator) {
        super(webDriver, webElement, locator);
    }

    By loginUsernameTextField = By.name("email");
    By loginPasswordTextField = By.name("pass");
    By loginButton = By.name("login");
    By statusMessageField = By.cssSelector("div[role=\"button\"] > div > span[style*=\"webkit-box-orient\"]");
    By creatPostMessageField = By.cssSelector("div[aria-describedby*=\"placeholder\"]");
    By postStatusMessage = By.cssSelector("div[aria-label=\"Post\"]");

    public void login(String username, String password) {

        findElement(loginUsernameTextField).sendKeys(username);
        findElement(loginPasswordTextField).sendKeys(password);
        doClick(loginButton);
    }

    public void postStatusMessage(String message) {

        waitForElementToBeClickable(statusMessageField);
        waitForElementToBeClickable(creatPostMessageField);
        waitAndFindElement(creatPostMessageField).sendKeys(message);
        doClick(postStatusMessage);
    }

}