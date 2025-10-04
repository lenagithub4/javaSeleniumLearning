package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;

    private final By headerTitle = By.cssSelector("h1");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://reqres.in/");
    }

    public String getHeaderTitle() {
        return driver.findElement(headerTitle).getText();
    }
}
