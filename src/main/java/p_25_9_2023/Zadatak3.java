package p_25_9_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");
        for (int i=1; i<=3; i++){
            String fullName = "jovana" + i;
            String email = "jovana" + i + "@gmail.com";
            String currentAddress = "Adresa " + i;
            String permanentAddress = "Stalna adresa " + i;

            driver.findElement(By.id("userName"))
                    .sendKeys(fullName);
            driver.findElement(By.id("userEmail"))
                    .sendKeys(email);
            driver.findElement(By.id("currentAddress"))
                    .sendKeys(currentAddress);
            driver.findElement(By.id("permanentAddress"))
                    .sendKeys(permanentAddress);
            driver.findElement(By.id("submit"))
                    .click();

            Thread.sleep(2000);
            driver.navigate().refresh();
        }
        driver.quit();
    }
}

