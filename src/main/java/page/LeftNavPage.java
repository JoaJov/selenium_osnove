package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LeftNavPage extends BasicPage{
    public LeftNavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getMenuButton () {
        return driver.findElement(By.id("react-burger-menu-btn"));
    }
    public void clickOnMenuButton () {
        getMenuButton().click();
    }
    public WebElement getLeftMenu () {
        return driver.findElement(By.cssSelector(".bm-menu"));
    }
    public void waitForLeftMenuToBeVisible () {
        wait    .withMessage("Left menu is not visible in 10s.")
                .until(ExpectedConditions.visibilityOf(getLeftMenu()));
    }
    public void waitForLeftMenuToBeInvisible () {
        wait    .withMessage("Left menu is still visible after closing.")
                .until(ExpectedConditions.invisibilityOf(getLeftMenu()));
    }
    public WebElement getButtonLogout () {
        return driver.findElement(By.id("logout_sidebar_link"));
    }
    public void clickOnButtonLogout () {
        getButtonLogout().click();
    }
    public boolean doesLogoutButtonExist () {
        return elementExists(By.linkText("Logout"));
    }
    public List<WebElement> getTheMenuOptions () {
        List<WebElement> options = driver.findElements(By.cssSelector(".bm-item-list a"));
        return options;
    }
    public int numberOfMenuOptions () {
        return getTheMenuOptions().size();
    }
    public boolean spellingOfAllOptions () {
        boolean correctSpelling = false;
        if (getTheMenuOptions().get(0).getText().equals("All Items")
                && getTheMenuOptions().get(1).getText().equals("About")
                && getTheMenuOptions().get(2).getText().equals("Logout")
                && getTheMenuOptions().get(3).getText().equals("Reset App State")) {
            correctSpelling = true;
        }
        return correctSpelling;
    }
    public WebElement getTheAllItemsFromMenuOption () {
        return driver.findElement(By.id("inventory_sidebar_link"));
    }
    public void clickOnTheAllItemsFromMenuOption () {
        getTheAllItemsFromMenuOption().click();
    }
    public WebElement getTheAboutFromMenuOption () {
        return driver.findElement(By.id("about_sidebar_link"));
    }
    public void clickOnTheAboutFromMenuOption () {
        getTheAboutFromMenuOption().click();
    }
    public WebElement getTheLogoutFromMenuOption () {
        return driver.findElement(By.id("logout_sidebar_link"));
    }
    public void clickOnTheLogoutFromMenuOption () {
        getTheLogoutFromMenuOption().click();
    }
    public WebElement getTheResetFromMenuOption () {
        return driver.findElement(By.id("reset_sidebar_link"));
    }
    public void clickOnTheResetFromMenuOption () {
        getTheResetFromMenuOption().click();
    }
    public boolean doesEkisButtonExistInMenu () {
        return elementExists(By.id("react-burger-cross-btn"));
    }
    public WebElement getEkisButtonFromMenu () {
        return driver.findElement(By.id("react-burger-cross-btn"));
    }
    public void clickOnTheEkisButtonFromMenu () {
        getEkisButtonFromMenu().click();
    }

}