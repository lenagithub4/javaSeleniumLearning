package tests;

import api.ApiClient;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.DriverFactory;

import static org.testng.Assert.assertEquals;

public class UserFlowTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver();
        homePage = new HomePage(driver);
    }

    @Test
    public void testCreateUserAndCheckUI() {
        // 1️⃣ Создаём пользователя через API
        Response response = ApiClient.createUser("Alex", "tester");
        assertEquals(response.statusCode(), 201);
        String createdName = response.jsonPath().getString("name");
        System.out.println("Создан пользователь: " + createdName);

        // 2️⃣ Проверяем UI (условно — что сайт работает)
        homePage.open();
        String title = homePage.getHeaderTitle();
        assertEquals(title, "ReqRes");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
