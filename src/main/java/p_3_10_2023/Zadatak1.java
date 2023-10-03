package p_3_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Zadatak1 {
 private WebDriver driver;
 private WebDriverWait wait;



 @BeforeClass
    public void setup(){
     WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @BeforeMethod
    public void beforeMethod(){
     driver.navigate().to("https://cms.demo.katalon.com ");
}
@Test
    public void  visitLoginPageFromNavBar(){
    WebElement myAccountLink=driver.findElement(By.cssSelector(" li.page_item.page-item-10>a"));
    myAccountLink.click();
    String pageTitle=driver.getTitle();
    Assert.assertEquals(pageTitle, "My account-Katalon Shop","Naslov stranice nije ispravan");

   String currentUrl=driver.getCurrentUrl();
    Assert.assertTrue(currentUrl.contains("//my-account"),"Url ne sadrzi /my-account");

    }

    @Test
    public void checkInputTypes(){
        String baseUrl = "https://cms.demo.katalon.com/my-account";

        driver = new ChromeDriver();
        driver.get(baseUrl);

        WebElement email = driver.findElement(By.id("username"));
        String emailType = email.getAttribute("type");
        Assert.assertEquals(emailType, "text");

        WebElement password = driver.findElement(By.id("password"));
        String passwordType = password.getAttribute("type");
        Assert.assertEquals(passwordType, "password");

        WebElement rememberMeCheckbox= driver.findElement(By.name("rememberme"));
        String checkBoxRemeberMe = rememberMeCheckbox.getAttribute("type");
        Assert.assertEquals(checkBoxRemeberMe, "checkbox");
        Assert.assertFalse(rememberMeCheckbox.isSelected(), "Cekirano je");
    }
    @Test
    public void  displayErrorWhenCredentialsAreWrong(){
     String email="invalidemail@gmail.com";
     String password="invalid123";
    WebElement myAccountLink=driver.findElement(By.cssSelector(" li.page_item.page-item-10>a"));
    myAccountLink.click();
    driver.findElement(By.id("username")).sendKeys(email);
    WebElement password1=driver.findElement(By.id("password"));
            password1.sendKeys(password);
            WebElement button=driver.findElement(By.name("login"));
            button.click();
            WebElement error=driver.findElement(By.cssSelector("#post-10 > div > div > div > ul"));
        String expectedErrorMessage = "ERROR: Invalid email address. Lost your password?";
        String actualErrorMessage = error.getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

        String expectedUrl = "https://cms.demo.katalon.com/my-account/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));


}

    @AfterClass
    public void afterClass(){
     driver.quit();
    }
}
