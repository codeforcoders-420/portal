package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class FormPage {
    private WebDriver driver;

    // Locators using @FindBy annotation
    @FindBy(id = "inputField")
    private WebElement inputField;

    @FindBy(id = "submitButton")
    private WebElement submitButton;

    @FindBy(id = "resultId")
    private WebElement resultId;

    // Constructor - Initialize PageFactory elements
    public FormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to enter data in the form
    public void enterData(String input) {
        WaitUtils.waitForPageToLoad(driver, 10);
        inputField.sendKeys(input);
    }

    // Method to click the submit button
    public void clickSubmit() {
        submitButton.click();
    }

    // Method to get the result ID after submission
    public String getResultId() {
        WaitUtils.waitForPageToLoad(driver, 10);
        return resultId.getText();
    }
}
