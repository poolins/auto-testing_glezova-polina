package homework4.steps;

import homework4.pages.differentElements.DifferentElements;
import homework4.pages.homePage.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.Properties;
import java.util.stream.Stream;

public class Action extends StepsSetup {
    public Action(WebDriver driver, Properties properties) {
        super(driver, properties);
    }

    @Step("Navigating to Home Page")
    public void navigateToHomePage() {
        homePage = new HomePage(driver, properties);
    }

    @Step("Logging in")
    public void performLogin() {
        homePage.performLogin();
    }

    @Step("Switching to the original window")
    public void switchToOriginalWindow() {
        homePage.switchToOriginalWindow();
    }

    @Step("Navigating to Different Elements page")
    public void navigateToDifferentElementsPage() {
        differentElements = new DifferentElements(driver, homePage);
    }

    @Step("Selecting checkboxes")
    public void selectCheckboxes(String... names) {
        Stream.of(names).forEach(name -> differentElements.selectCheckbox(name));
    }

    @Step("Selecting radio")
    public void selectRadio(String name) {
        differentElements.selectRadio(name);
    }

    @Step("Selecting dropdown option")
    public void selectDropdownOption(String name) {
        differentElements.selectDropdownOption(name);
    }
}
