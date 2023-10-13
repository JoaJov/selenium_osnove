package tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import page.*;

import java.time.Duration;

public abstract class BasicTest {
        protected WebDriver driver;
        protected WebDriverWait wait;
        protected String baseUrl = "https://www.saucedemo.com";
        protected String baseTitle = "Swag Labs";
        protected String subHeaderCartPage = "Your Cart";
        protected LoginPage loginPage;
        protected LeftNavPage leftNavPage;
        protected InventoryPage inventoryPage;
        protected TopNavPage topNavPage;
        protected CartPage cartPage;
        protected SubHeaderPage subHeaderPage;
        protected ItemPage itemPage;
        protected CheckoutPage checkoutPage;
        protected Footer footer;
        @BeforeClass
        public void setup () {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            loginPage = new LoginPage(driver, wait);
            leftNavPage = new LeftNavPage(driver, wait);
            inventoryPage = new InventoryPage(driver, wait);
            topNavPage = new TopNavPage(driver, wait);
            cartPage = new CartPage(driver, wait);
            subHeaderPage = new SubHeaderPage(driver, wait);
            itemPage = new ItemPage(driver, wait);
            checkoutPage = new CheckoutPage(driver, wait);
            footer = new Footer(driver, wait);

        }
        @BeforeMethod
        public void beforeMethod () {
            driver.navigate().to(baseUrl);
        }
        @AfterMethod
        public void afterMethod () {
            driver.manage().deleteAllCookies();
            ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
        }
        @AfterClass
        public void afterClass () {
            driver.quit();
        }
    }

