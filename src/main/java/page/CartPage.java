package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends BasicPage{

        public CartPage(WebDriver driver, WebDriverWait wait) {
            super(driver, wait);
        }
        public int getTheNumberOfItemsInTheCart () {
            List<WebElement> items = driver.findElements(By.cssSelector(".cart_list .cart_item"));
            return items.size();
        }
        public String getNumberInSpan () {
            return driver.findElement(By.className("shopping_cart_badge")).getText();
        }
        public boolean areTheItemsAdded () {
            return elementExists(By.className("cart_item"));
        }
        public boolean doesnItemsTitleIsPresented () {
            By by = By.cssSelector("#item_4_title_link .inventory_item_name");
            return elementExists(by);
        }
        public boolean doesnItemsDescriptionIsPresented () {
            By by = By.cssSelector(".cart_item .inventory_item_desc");
            return elementExists(by);
        }
        public boolean doesnItemsPriceIsPresented () {
            By by = By.cssSelector(".cart_item .inventory_item_price");
            return elementExists(by);
        }
        public boolean doesnItemsQuantityIsPresented () {
            By by = By.cssSelector(".cart_item .cart_quantity");
            return elementExists(by);
        }
        public List<WebElement> getTheTitlesOfItems () {
            List<WebElement> titles = driver.findElements(By.className("inventory_item_name"));
            return titles;
        }
        public boolean checkTheTitlesAreClickable () {
            int numberOfClickable = 0;
            for (int i = 0; i < getTheTitlesOfItems().size(); i++) {
                if (getTheTitlesOfItems().get(i).isEnabled()) {
                    numberOfClickable++;
                }
            }
            if (numberOfClickable == getTheTitlesOfItems().size()) {
                return true;
            } else {
                return false;
            }
        }
        public void clickOnTheTitles () {
            for (int i = 0; i < getTheTitlesOfItems().size(); i++) {
                getTheTitlesOfItems().get(i).click();
            }
        }
        public void clickOnTheFirstTitle () {
            getTheTitlesOfItems().get(0).click();
        }
        public boolean doesRemoveButtonsAreVisible () {
            return elementExists((By.cssSelector(".cart_item_label button.cart_button")));
        }
        public WebElement removeButtonForBackpack () {
            return driver.findElement(By.id("remove-sauce-labs-backpack"));
        }
        public void clickOnTheRemoveButtonForBackpack () {
            removeButtonForBackpack().click();
        }
        public boolean doesItemExistAfterRemoving () {
            By by = By.id("remove-sauce-labs-backpack");
            return elementExists(by);
        }
        public WebElement getContinueShoppingButton () {
            return driver.findElement(By.id("continue-shopping"));
        }
        public void clickOnTheContinueShoppingButton () {
            getContinueShoppingButton().click();
        }
        public WebElement getCheckoutButton () {
            return driver.findElement(By.id("checkout"));
        }
        public void clickOnTheCheckoutButton () {
            getCheckoutButton().click();
        }


    }

