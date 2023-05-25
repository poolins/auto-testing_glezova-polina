package homework4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

import java.util.List;
import java.util.Properties;

public class Assertion extends StepsSetup {
    public Assertion(WebDriver driver, Properties properties) {
        super(driver, properties);
    }

    @Step("Asserting Home Page's title")
    public void assertHomePageTitle(String expectedTitle) {
        assertEquals(homePage.getTitle(), expectedTitle);
    }

    @Step("Asserting Username is loggined")
    public void assertUsernameIsLoggined(String expectedUserName) {
        assertEquals(homePage.getLoggedName(), expectedUserName);
    }

    @Step("Asserting Header Section items properties")
    public void assertHeaderSectionItemsProperties(int expectedItemsSize, List<String> expectedItemsNames) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(homePage.getHeaderSection().getItemsSize(), expectedItemsSize);
        softAssert.assertEquals(homePage.getHeaderSection().getItemsNames(), expectedItemsNames);

        homePage.getHeaderSection().getItems().forEach(item -> {
            softAssert.assertTrue(item.isDisplayed());
        });

        softAssert.assertAll();
    }

    @Step("Asserting Index Page images properties")
    public void assertIndexPageImages(int expectedImagesSize) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(homePage.getBenefitIconsSize(), expectedImagesSize);

        homePage.getBenefitIcons().forEach(icon -> {
            softAssert.assertTrue(icon.isDisplayed());
        });

        softAssert.assertAll();
    }

    @Step("Asserting Index Page texts properties")
    public void assertIndexPageTexts(int expectedTextsSize, List<String> expectedTextsStrings) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(homePage.getBenefitIconsTextsSize(), expectedTextsSize);
        softAssert.assertEquals(homePage.getBenefitIconsTextsStrings(), expectedTextsStrings);

        softAssert.assertAll();
    }

    @Step("Asserting iframe existence")
    public void assertFrameExistence() {
        assertTrue(homePage.getFrame().isDisplayed());
    }

    @Step("Asserting Frame Button existence")
    public void assertFrameButtonExistence() {
        assertTrue(homePage.getFrameButton().isDisplayed());
    }

    @Step("Asserting Left Section properties")
    public void assertLeftSectionProperties(int expectedItemsSize, List<String> expectedItemsNames) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(homePage.getLeftSection().getItemsSize(), expectedItemsSize);

        homePage.getLeftSection().getItems().forEach(item -> {
            softAssert.assertTrue(item.isDisplayed());
        });

        softAssert.assertEquals(homePage.getLeftSection().getItemsNames(), expectedItemsNames);

        softAssert.assertAll();
    }

    @Step("Asserting logs")
    public void assertLogs(List<String> logs) {
        assertEquals(differentElements.getLogs(), logs);
    }
}
