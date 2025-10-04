package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class SearchTest {
    @Test
    public void openGoogleComInChromeTest() {
        File file = new File("src/test/resources/chromedriver.exe");
               System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
               WebDriver driver = new ChromeDriver();
               driver.get("https://www.google.com");
               System.out.println(driver.getTitle());
               driver.quit();
    }

    @Test
    public void openGoogleComInChromeTest2() {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
