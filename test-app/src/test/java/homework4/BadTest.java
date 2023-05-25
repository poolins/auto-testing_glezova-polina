package homework4;

import homework4.expectedData.ExpectedData;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static homework4.steps.StepsSetup.homePage;

public class BadTest {
    @Test
    public void testTask1Bad() {
        SoftAssert softAssert = new SoftAssert();

        // 2. Assert browser title
        softAssert.assertEquals(homePage.getTitle(), "CAT");

        // 4. Assert Username is loggined
        softAssert.assertEquals(homePage.getLoggedName(), "BAD CAT");

        // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        softAssert.assertEquals(homePage.getHeaderSection().getItemsSize(), ExpectedData.HEADER_SECTION_ITEMS_SIZE);
        softAssert.assertEquals(homePage.getHeaderSection().getItemsNames(), ExpectedData.HEADER_SECTION_ITEMS_NAMES);

        homePage.getHeaderSection().getItems().forEach(item -> {
            softAssert.assertTrue(!item.isDisplayed());
        });

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        softAssert.assertEquals(homePage.getBenefitIconsSize(), ExpectedData.BENEFIT_ICONS_SIZE);

        homePage.getBenefitIcons().forEach(icon -> {
            softAssert.assertTrue(!icon.isDisplayed());
        });

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        softAssert.assertEquals(homePage.getBenefitIconsTextsSize(), ExpectedData.BENEFIT_ICONS_TEXTS_SIZE);
        softAssert.assertEquals(homePage.getBenefitIconsTextsStrings(), ExpectedData.BENEFIT_ICONS_TEXTS_STRINGS);

        // 8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(!homePage.getFrame().isDisplayed());

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        softAssert.assertTrue(!homePage.getFrameButton().isDisplayed());

        // 10. Switch to original window back
        homePage.switchToOriginalWindow();

        softAssert.assertAll();
    }
}
