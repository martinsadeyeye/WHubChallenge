package com.wallethub.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WalletHubHomePage extends BasePage {
    public WalletHubHomePage(WebDriver webDriver, WebElement webElement, By locator) {
        super(webDriver, webElement, locator);
    }

    private By getStarElement(int index) {
        return By.xpath("//div[3]/review-star[1]/div[@class=\"rating-box-wrapper\"]/*[" + index + "]");
    }

    private By selectDropDownOption(String option) {
        return By.xpath("//li[text()='" + option + "']");
    }

    By policyDropdown = By.xpath("//span[contains(text(),'Select...')]");
    By writeReviewMessageField = By.xpath("//textarea[@placeholder=\"Write your review...\"]");
    By submitReview = By.xpath("//div[contains(text(),'Submit')]");
    By successResponseField = By.xpath("//h4[contains(text(),'Your review has been posted.')]");
    By continueButton = By.xpath("//div[contains(text(),'Continue')]");

    public void starClick(int index) {

        hoverAndClick(getStarElement(index));
    }

    public void selectPolicy(String dropdownOption) {
        doClick(policyDropdown);
        doClick(selectDropDownOption(dropdownOption));

    }

    public void writeReview(String review) {
        findElement(writeReviewMessageField).sendKeys(review);
        doClick(submitReview);
    }


    private By getPostedMessage(String message) {
        return By.xpath("//div[contains(text(),'" + message + "')]");
    }

    public boolean isPostMessageDisplayed(String message) {

        try {
            return findElement(getPostedMessage(message)).isDisplayed();

        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String successResponseMessage(){

        return findElement(successResponseField).getText();

    }

    public void movetoReviewpage(){

        doClick(continueButton);
    }

}
