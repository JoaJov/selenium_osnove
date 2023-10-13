package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class InventoryPage extends BasicPage{
    public InventoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getAddToCartButtonForSauceLabsBackpack () {
        return driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }
    public void clickOnAddToCartButtonForSauceLabsBackpack () {
        getAddToCartButtonForSauceLabsBackpack().click();
    }

    public boolean doesRemoveButtonForSauceLabsBackpackExist () {
        return elementExists(By.id("remove-sauce-labs-backpack"));
    }
    public List<WebElement> getTheAddToCartButtons () {
        List<WebElement> btnsAddToCart = driver.findElements(By.className("btn_inventory"));
        return btnsAddToCart;
    }
    public void clickOnTheAddToCartButtons () {
        for (int i = 0; i < getTheAddToCartButtons().size(); i++) {
            getTheAddToCartButtons().get(i).click();
        }
    }
}