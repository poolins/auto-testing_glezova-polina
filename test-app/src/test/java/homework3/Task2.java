package homework3;

import homework3.expectedData.ExpectedData;
import homework3.pages.differentElements.DifferentElements;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task2 extends DriverTest {
    @Test
    public void testBrowserTitle() {
        // 2. Assert browser title
        assertEquals(homePage.getTitle(), ExpectedData.SITE_NAME);
    }

    @Test
    public void testLogin() {
        // 4. Assert Username is loggined
        assertEquals(homePage.getLoggedName(), ExpectedData.LOGGED_USER_NAME);
    }

    @Test
    public void testElements() {
        // 5. Open through the header menu Service -> Different Elements Page
        DifferentElements differentElementsPage = new DifferentElements(driver, homePage);

        // 6. Select checkboxes
        differentElementsPage.selectCheckbox("Water");
        differentElementsPage.selectCheckbox("Wind");

        // 7. Select radio
        differentElementsPage.selectRadio("Selen");

        // 8. Select in dropdown
        differentElementsPage.selectDropdownOption("Yellow");

        // 9. Assert logs
        assertEquals(differentElementsPage.getLogs(), ExpectedData.DIFFERENT_ELEMENTS_LOGS);
    }
}
