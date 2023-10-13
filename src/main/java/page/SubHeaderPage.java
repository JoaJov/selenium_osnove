package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubHeaderPage extends BasicPage{

    public SubHeaderPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public String getTheSubHeader () {
        return driver.findElement(By.cssSelector(".header_secondary_container .title")).getText();
    }
}