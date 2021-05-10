package com.wallethub.TestCase;

import com.wallethub.PageObject.WalletHubHomePage;
import com.wallethub.TestConfig.BaseTest;
import com.wallethub.Utilities.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WalletHubTest extends BaseTest {

    private final static String URL = "https://wallethub.com/profile/test-insurance-company-13732055i";
    private final static int PREFERRED_RATING = 4;
    private final static int NUMBER_OF_CHARACTER = 200;
    private final static String POLICY_OPTION = "Health Insurance";
    private final static String RESPONSE_MESSAGE = "Your review has been posted.";

    @Test
    public void postHelloWorldOnFacebookAfterSuccessfulLogin() {
        goToUrl(URL);
        webCoreElement.getInstance(WalletHubHomePage.class).starClick(PREFERRED_RATING);
        webCoreElement.getInstance(WalletHubHomePage.class).selectPolicy(POLICY_OPTION);
        webCoreElement.getInstance(WalletHubHomePage.class).writeReview(Utils.randomCharacter(NUMBER_OF_CHARACTER));
        String actualMessage = webCoreElement.getInstance(WalletHubHomePage.class).successResponseMessage();
        Assert.assertEquals(actualMessage, RESPONSE_MESSAGE);
        webCoreElement.getInstance(WalletHubHomePage.class).movetoReviewPage();
       Boolean postMessageDisplayed = webCoreElement.getInstance(WalletHubHomePage.class).isPostMessageDisplayed(Utils.randomCharacter(NUMBER_OF_CHARACTER));
        Assert.assertTrue(postMessageDisplayed);


    }

}
