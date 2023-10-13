package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage extends BasicPage{
    public String SauceLabsBackpackUrl = "https://www.saucedemo.com/inventory-item.html?id=4";

    public ItemPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

}