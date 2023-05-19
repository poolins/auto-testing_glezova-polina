package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

import java.util.List;

public class Task1 extends DriverTest {
    @Test
    public void test() {
        SoftAssert softAssert = new SoftAssert();

        //5. Assert that there are 4 items on the header..
        List<WebElement> headerItems = driver.findElements(By.xpath("//nav/ul[1]/li"));
        int expectedHeaderItems = 4;
        //..section are displayed..
        softAssert.assertEquals(headerItems.size(), expectedHeaderItems);
        for (WebElement i : headerItems) {
            softAssert.assertTrue(i.isDisplayed());
        }
        //..and they have proper texts
        String[] expectedTexts = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        for (int i = 0; i < expectedTexts.length; i++) {
            softAssert.assertEquals(headerItems.get(i).getText(), expectedTexts[i]);
        }

        //6. Assert that there are 4 images on the Index Page..
        List<WebElement> indexPageImages = driver.findElements(By.className("benefit-icon"));
        int expectedNumberOfImages = 4;
        softAssert.assertEquals(indexPageImages.size(), expectedNumberOfImages);
        //..and they are displayed
        for (WebElement i : indexPageImages) {
            softAssert.assertTrue(i.isDisplayed());
        }

        //7. Assert that there are 4 texts on the Index Page
        List<WebElement> indexPageTexts = driver.findElements(By.className("benefit-txt"));
        int expectedNumberOfTexts = 4;
        softAssert.assertEquals(indexPageTexts.size(), expectedNumberOfTexts);
        String[] expectedPageTexts = {
                "To include good practices\n" + "and ideas from successful\n" + "EPAM project",
                "To be flexible and\n" + "customizable",
                "To be multiplatform",
                "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"
        };
        //Page under icons and they have proper text
        for (int i = 0; i < expectedPageTexts.length; i++) {
            softAssert.assertEquals(indexPageTexts.get(i).getText(), expectedPageTexts[i]);
        }

        //8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertEquals(driver.findElement(By.tagName("iframe")).getAttribute("src"), "https://jdi-testing.github.io/jdi-light/frame-button.html");

        //9. Switch to the iframe
        String iframeId = "frame";
        driver.switchTo().frame(iframeId);
        // and check that there is “Frame Button” in the iframe
        String expectedButtonText = "Frame Button";
        softAssert.assertEquals(driver.findElement(By.id("frame-button")).getAttribute("value"), expectedButtonText);

        //10. Switch to original window back
        driver.switchTo().defaultContent();

        //11. Assert that there are 5 items in the Left Section are displayed
        List<WebElement> leftSectionItems = driver.findElements(By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li"));
        int expectedSectionItems = 5;
        softAssert.assertEquals(leftSectionItems.size(), expectedSectionItems);
        for (WebElement i : leftSectionItems) {
            softAssert.assertTrue(i.isDisplayed());
        }
        // and they have proper text
        String[] expectedLeftSectionText = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        for (int i = 0; i < expectedLeftSectionText.length; i++) {
            softAssert.assertEquals(leftSectionItems.get(i).getText(), expectedLeftSectionText[i]);
        }

        softAssert.assertAll();
    }
}
