package com.wallethub.TestCase;

import com.wallethub.PageObject.FacebookHomePage;
import com.wallethub.TestConfig.BaseTest;
import org.testng.Assert;
import org.testng.SuiteRunner;
import org.testng.annotations.Test;

public class FacebookTest extends BaseTest {

    private final static String STATUS_MESSAGE = "Hello World";
    private final static String LOGIN_USERNAME = "";
    private final static String LOGIN_PASSWORD = "";
    private final static String URL = "https://www.facebook.com/";

    @Test
    public void postStatusMessageOnFacebookAndVerifyPostedMessage() {

        goToUrl(URL);
        webCoreElement.getInstance(FacebookHomePage.class).login(LOGIN_USERNAME, LOGIN_PASSWORD);
        webCoreElement.getInstance(FacebookHomePage.class).postStatusMessage(STATUS_MESSAGE);
        boolean postMessageDisplayed = webCoreElement.getInstance(FacebookHomePage.class).isPostMessageDisplayed(STATUS_MESSAGE);
        Assert.assertTrue(postMessageDisplayed);

    }
}
