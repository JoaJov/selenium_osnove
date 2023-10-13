package tests;

import Retry.SwagLabsRetry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwagLabsTest extends BasicTest {

    @Test(retryAnalyzer = SwagLabsRetry.class)
    public void verifyErrorIsDisplayedWhenUsernameIsMissing() {
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageText(),
                "Epic sadface: Username is required",
                "Error is not valid when username is missing.");
    }
}
