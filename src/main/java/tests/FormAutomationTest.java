package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.Constants;
import utils.ExcelUtils;

import java.io.IOException;

public class FormAutomationTest extends BaseTest {

    @Test
    public void automateForm() throws IOException {
        ExcelUtils excel = new ExcelUtils(Constants.TEST_DATA_PATH);
        String inputData = excel.getCellValue(1, 0); // Example: Read from first row, first column

        // Example: Locate input field and submit button
        WebElement inputField = driver.findElement(By.id("inputField"));
        WebElement submitButton = driver.findElement(By.id("submitButton"));

        // Enter data and submit the form
        inputField.sendKeys(inputData);
        submitButton.click();

        // Capture ID from the web after submission
        WebElement idElement = driver.findElement(By.id("resultId"));
        String resultId = idElement.getText();

        // Write captured ID to Excel
        excel.setCellValue(1, 1, resultId, Constants.OUTPUT_PATH);

        // Close workbook
        excel.closeWorkbook();
    }
}

