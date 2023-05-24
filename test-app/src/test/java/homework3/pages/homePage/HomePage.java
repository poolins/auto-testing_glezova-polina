package homework3.pages.homePage;

import homework3.pages.homePage.elements.Header;
import homework3.pages.homePage.elements.Iframe;
import homework3.pages.homePage.elements.LeftSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    private final WebDriver driver;

    private final Header headerSection;
    private final LeftSection leftSection;

    @FindBy(id = "name")
    private WebElement loginName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "html > body > header > div > nav > ul.uui-navigation.navbar-nav.navbar-right > li > a > span")
    private WebElement loginDropDownButton;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(className = "benefit-icon")
    private List<WebElement> benefitIcons;

    @FindBy(className = "benefit-txt")
    private List<WebElement> benefitIconsTexts;

    @FindBy(tagName = "iframe")
    private WebElement frame;

    public HomePage(WebDriver driver, String url) {
        this.driver = driver;

        // 1. Open test site by URL
        driver.navigate().to(url);

        PageFactory.initElements(this.driver, this);

        headerSection = new Header(driver);
        leftSection = new LeftSection(driver);
    }

    public void performLogin(String loginName, String password) {
        loginDropDownButton.click();
        this.loginName.sendKeys(loginName);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getLoggedName() {
        return userName.getText();
    }

    public Header getHeaderSection() {
        return headerSection;
    }

    public int getBenefitIconsSize() {
        return benefitIcons.size();
    }

    public List<WebElement> getBenefitIcons() {
        return benefitIcons;
    }

    public int getBenefitIconsTextsSize() {
        return benefitIconsTexts.size();
    }

    public List<String> getBenefitIconsTextsStrings() {
        return benefitIconsTexts.stream().map(WebElement::getText).toList();
    }

    public LeftSection getLeftSection() {
        return leftSection;
    }

    public WebElement getFrame() {
        return frame;
    }

    public WebElement getFrameButton() {
        return new Iframe(driver).getFrameButton();
    }

    public void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }
}
