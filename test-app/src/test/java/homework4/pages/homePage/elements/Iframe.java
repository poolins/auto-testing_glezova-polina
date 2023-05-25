package homework4.pages.homePage.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Iframe {
    @FindBy(id = "frame-button")
    private WebElement frameButton;

    public Iframe(WebDriver driver) {
        driver.switchTo().frame("frame");
        PageFactory.initElements(driver, this);
    }

    public WebElement getFrameButton() {
        return frameButton;
    }
}
