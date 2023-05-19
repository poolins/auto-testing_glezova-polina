package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

@Test
public class Task2 extends DriverTest {
    @Test
    public void test() {
        SoftAssert softAssert = new SoftAssert();
        //5. Open through the header menu Service -> Different Elements Page
        driver.findElement(By.className("dropdown-toggle")).click();
        driver.findElement(By.xpath("/html/body/header/div/nav/ul[1]/li[3]/ul/li[8]")).click();

        //6. Select checkboxes
        List<WebElement> chekboxes = driver.findElements(By.className("label-checkbox"));
        for (WebElement i : chekboxes) {
            if (i.getText().equals("Water") || i.getText().equals("Wind")) {
                i.click();
            }
        }

        //7. Select radio
        driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[3]/label[4]"));

        //8. Select in dropdown
        driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[4]/select/option[4]"));

        //9. Assert logs
        List<WebElement> actualLogs = driver.findElements(By.cssSelector("ul [class='panel-body-list logs'] > li"));

        String[] expectedLogs = {
                "Colors: value changed to Yellow",
                "metal: value changed to Selen",
                "Wind: condition changed to true",
                "Water: condition changed to true"
        };

        for (int i = 0; i < actualLogs.size(); i++) {
            softAssert.assertEquals(actualLogs.get(i).getText().substring(9), expectedLogs[i]);
        }

        softAssert.assertAll();
    }


}
