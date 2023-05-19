package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class DriverTest {
    public static WebDriver driver;

    @BeforeMethod
    public static void setUpWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        SoftAssert softAssert = new SoftAssert();

        //1. Open test site by URL
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://jdi-testing.github.io/jdi-light/index.html";
        softAssert.assertEquals(actualUrl, expectedUrl);
        //2. Assert Browser title
        String actualTitle = driver.getTitle();
        String expectedTitle = "Home Page";
        softAssert.assertEquals(actualTitle, expectedTitle);

        //3. Perform login
        driver.findElements(By.className("dropdown-toggle")).stream().skip(1).peek(WebElement::click).findFirst();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();

        //4. Assert Username is logged
        String actualUsername = driver.findElement(By.id("user-name")).getText();
        String expectedUsername = "ROMAN IOVLEV";
        softAssert.assertEquals(actualUsername, expectedUsername);

        softAssert.assertAll();
    }

    //12. Close Browser
    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
