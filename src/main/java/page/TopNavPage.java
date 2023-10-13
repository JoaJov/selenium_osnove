package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TopNavPage extends BasicPage{
    public TopNavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public String getTheNumberOfItemInShoppingCast () {
        return driver.findElement(By.className("shopping_cart_badge")).getText();
    }
    public boolean invisibilityOfNumberItemsInCart () {
        return !elementExists(By.className("shopping_cart_badge"));
    }
    public WebElement getTheShoppingCartButton () {
        return driver.findElement(By.className("shopping_cart_link"));
    }

    public void clickOnTheShoppingCartButton () {
        getTheShoppingCartButton().click();
    }
    public boolean doesShoppingCartButtonIsEnabled () {
        return getTheShoppingCartButton().isEnabled();
    }
    public String getTheTitleInHeader () {
        return driver.findElement(By.className("app_logo")).getText();
    }
    public boolean doesHamburgerMenuButtonExist () {
        return elementExists(By.id("react-burger-menu-btn"));
    }
    public WebElement getHamburgerMenuButton () {
        return driver.findElement(By.id("react-burger-menu-btn"));
    }
    public boolean doesCartIconExist () {
        return elementExists(By.className("shopping_cart_link"));
    }
    public void clickOnTheHamburgerMenuButton () {
        getHamburgerMenuButton().click();
    }
    public boolean doesHamburgerMenuIsEnabled () {
        return getHamburgerMenuButton().isEnabled();
    }
}