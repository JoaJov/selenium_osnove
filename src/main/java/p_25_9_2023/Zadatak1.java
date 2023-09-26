package p_25_9_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(" https://demoqa.com/login ");
        driver.findElement(By.xpath("//input[@id='userName']"))
                .sendKeys(" itbootcamp");
        driver.findElement(By.xpath("//input[@placeholder='Password']"))
                .sendKeys(" ITBootcamp2021!");

        driver.findElement(By.xpath("//form/div[4]/div[1]/button"))
                        .click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='Log out']"))
                        .click();


        driver.quit();

    }
}
