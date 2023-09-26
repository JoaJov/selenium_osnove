package p_25_9_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://cms.demo.katalon.com/");
        driver.findElement(By.cssSelector("#search-2 > form > label > input"))
                .sendKeys("Flying Ninja");
        driver.findElement(By.cssSelector("#search-2 > form > button"))
                .click();
        Thread.sleep(5000);

        driver.quit();
    }
}