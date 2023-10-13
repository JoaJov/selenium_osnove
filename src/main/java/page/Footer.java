package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Footer extends BasicPage{

    public Footer(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getTheTwitterButton () {
        return driver.findElement(By.cssSelector(".social_twitter a"));
    }
    public WebElement getTheFacebookButton () {
        return driver.findElement(By.cssSelector(".social_facebook a"));
    }
    public WebElement getTheLinkedinButton () {
        return driver.findElement(By.cssSelector(".social_linkedin a"));
    }
    public void clickOnTheTwitterButton () {
        getTheTwitterButton().click();
    }
    public void clickOnTheFacebookButton () {
        getTheFacebookButton().click();
    }
    public void clickOnTheLinkedinButton () {
        getTheLinkedinButton().click();
    }
    public String getTheCopyRightMessage () {
        return driver.findElement(By.className("footer_copy")).getText();
    }
}