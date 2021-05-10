package com.wallethub.PageObject;

import com.wallethub.Component.WebCoreElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage extends WebCoreElement {

    private WebDriver webDriver;
    private WebCoreElement classInstance;
    private WebElement webElement;
    private By locator;


    public BasePage(WebDriver webDriver, WebElement webElement, By locator) {
        super(webDriver, webElement, locator);
    }

}
