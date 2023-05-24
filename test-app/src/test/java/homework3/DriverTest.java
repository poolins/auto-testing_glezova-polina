package homework3;

import homework3.pages.homePage.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class DriverTest {
    protected static WebDriver driver;

    protected static HomePage homePage;

    @BeforeTest
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(Path.of("src/test/resources/properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver, properties.getProperty("site.url"));

        // 3. Perform login
        homePage.performLogin(properties.getProperty("user.name"), properties.getProperty("user.password"));
    }

    @AfterTest
    public static void exit() {
        //10. Close Browser
        driver.close();
    }
}

