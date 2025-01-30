package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.FormPage;
import utils.Constants;
import utils.ExcelUtils;

import java.io.IOException;

public class FormAutomationTest extends BaseTest {

    @Test
    public void automateForm() throws IOException {
        // Initialize Excel utility
        ExcelUtils excel = new ExcelUtils(Constants.TEST_DATA_PATH);
        String inputData = excel.getCellValue(1, 0); // Read from Excel file

        // Initialize the Page Object
        FormPage formPage = new FormPage(driver);

        // Perform form actions
        formPage.enterData(inputData);
        formPage.clickSubmit();

        // Capture result ID from the page
        String resultId = formPage.getResultId();

        // Write result to Excel
        excel.setCellValue(1, 1, resultId, Constants.OUTPUT_PATH);
        excel.closeWorkbook();
    }
}
