package p_25_9_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        ArrayList<String> urls = new ArrayList<>();
        urls.add("https://google.com/");
        urls.add("https://youtube.com/");
        urls.add("https://ebay.com/");
        urls.add("https://kupujemprodajem.com/");

        driver.manage().window().maximize();

        for (String url: urls) {
        driver.navigate().to(url);
        System.out.println(driver.getTitle());
        Thread.sleep(1000);


        driver.quit();

    }
    }
}

