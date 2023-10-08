package p_5_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SwagLabsTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://www.saucedemo.com/");


    }

    @Test
    public void verifyErrorIsDisplayedWhenUsernameIsMissing() {
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();
        WebElement error = driver.findElement(By.cssSelector("data-test='error']"));
        String expectedError = "Epic sadface: Username is required";

        Assert.assertEquals(error.getText(), expectedError);
    }

    @Test
    public void verifyErrorIsDisplayedWhenPasswordIsMissing() {
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys(" standard_user");
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement error = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-test='error']")));
        String expectedError = "Epic sadface: Password is required";
        Assert.assertEquals(error.getText(), expectedError);

    }

    @Test(priority = 1, retryAnalyzer = SwagLabsRetry.class)
    public void verifyErrorIsDisplayedWhenCredentialsAreWrong() {
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("standard_user");
        password.sendKeys(" secret_sauce");
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement error = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-test='error']")));
        String expected = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(error.getText(),expected);

    }

    @Test
    public void verifyErrorIsDisplayedWhenUserIsLocked() {
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys(" locked_out_user");
        password.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement error = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-test='error']")));
        String expected = "Sorry, this user has been locked out.";
        Assert.assertEquals(error.getText(), expected);

    }

    @Test
    public void verifySuccessfulLogin() {
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        WebElement menu = driver.findElement(By.id("react-burger-menu-btn"));
        menu.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logout = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("logout_sidebar_link")));
        Assert.assertTrue(logout.isDisplayed());
        logout.click();

        WebElement loginForm = driver.findElement(By.id("login-button"));
        Assert.assertTrue(loginForm.isDisplayed());

    }

    @Test
    public void addingProductsToCart() {

        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.name("login-button"));
        login.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        WebElement backpackProduct = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        WebElement addToCartBtn = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        addToCartBtn.click();
        WebElement removeButn = driver.findElement(By.name("remove-sauce-labs-backpack"));
        Assert.assertTrue(removeButn.isDisplayed());
        WebElement cartItem = driver.findElement(By.cssSelector(".shopping_cart_badge"));
        Assert.assertEquals(cartItem.getText(), "1");

    }
    @Test
    public void viewingProductdetails(){
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys(" locked_out_user");
        password.sendKeys("secret_sauce");
        username.sendKeys(" locked_out_user");
        password.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.name("login-button"));
        login.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        WebElement backPack=driver.findElement(By.xpath("//div[text()='Sauce Labs BackPack']"));
        backPack.click();
        WebElement price= driver.findElement(By.className("inventory_details_price"));
        WebElement description=driver.findElement(By.className("inventory_details_desc"));
        WebElement addCart=driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        Assert.assertTrue(price.isDisplayed());
        Assert.assertTrue(description.isDisplayed());
        Assert.assertTrue(addCart.isDisplayed());

    }
    @Test
    public void  removingProductsFromCart(){
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys(" locked_out_user");
        password.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.name("login-button"));
        login.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        WebElement backpackProduct = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        WebElement addToCartBtn = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        addToCartBtn.click();
        WebElement cartItem = driver.findElement(By.cssSelector(".shopping_cart_badge"));
        Assert.assertEquals(cartItem.getText(), "1");
        WebElement cart=driver.findElement(By.className("shopping_cart_link"));
        cart.click();
        List<WebElement> products= driver.findElements(By.xpath("//div[text()='Sauce Labs Bbackpack']"));
        WebElement removeButn = driver.findElement(By.name("remove-sauce-labs-backpack"));
        removeButn.click();
        products=driver.findElements(By.xpath("//div[text()='Sauce Labs Bbackpack']"));
        Assert.assertEquals(products.size(), 0);

    }
    @Test
public void productCheckout(){
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys(" locked_out_user");
        password.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.name("login-button"));
        login.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        WebElement backpackProduct = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        WebElement addToCartBtn = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        addToCartBtn.click();
        WebElement cartItem = driver.findElement(By.cssSelector(".shopping_cart_badge"));
        Assert.assertEquals(cartItem.getText(), "1");
        WebElement cart=driver.findElement(By.className("shopping_cart_link"));
        cart.click();
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();

        WebElement firstName = driver.findElement(By.name("firstName"));
        WebElement lastName = driver.findElement(By.name("lastName"));
        WebElement zipCode = driver.findElement(By.name("postalCode"));
        firstName.sendKeys("Jovana");
        lastName.sendKeys("Jovanovic");
        zipCode.sendKeys("1800");
        WebElement continuee = driver.findElement(By.id("continue"));
        continuee.click();
        WebElement overviewName = driver.findElement(By.cssSelector("#item_4_title_link > div"));
        Assert.assertTrue(overviewName.isDisplayed());

        WebElement finish = driver.findElement(By.id("finish"));
        finish.click();

        WebElement orderConfirmation = driver.findElement(By.cssSelector("#checkout_complete_container > h2"));
        Assert.assertTrue(orderConfirmation.isDisplayed());

    }
   @AfterMethod
    public void afterMethod(){
       ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
    }
}




