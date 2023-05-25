package homework4.pages.differentElements;

import homework4.pages.homePage.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class DifferentElements {
    private static final int LOGS_BEGIN_INDEX = 9;

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(className = "label-radio")
    private List<WebElement> radios;

    @FindBy(tagName = "option")
    private List<WebElement> dropdownOptions;

    @FindBy(css = "ul.panel-body-list.logs")
    private WebElement logs;

    public DifferentElements(WebDriver webDriver, HomePage homePage) {
        homePage.getHeaderSection().clickServiceDropDown();
        homePage.getHeaderSection().clickDifferentElement();
        PageFactory.initElements(webDriver, this);
    }

    public void selectCheckbox(String name) {
        checkboxes.stream().filter(checkbox -> checkbox.getText().equals(name))
                .forEach(WebElement::click);
    }

    public void selectRadio(String name) {
        radios.stream().filter(radio -> radio.getText().equals(name))
                .forEach(WebElement::click);
    }

    public void selectDropdownOption(String name) {
        dropdownOptions.stream().filter(option -> option.getText().equals(name))
                .forEach(WebElement::click);
    }

    public List<String> getLogs() {
        return Arrays.stream(logs.getText().split("\n"))
                .map(log -> log.substring(LOGS_BEGIN_INDEX)).toList();
    }

}
