package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;

public class ExcelUtils {
    private Workbook workbook;
    private Sheet sheet;

    public ExcelUtils(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
    }

    public String getCellValue(int rowNumber, int cellNumber) {
        sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(rowNumber);
        Cell cell = row.getCell(cellNumber);
        return cell.toString();
    }

    public void setCellValue(int rowNumber, int cellNumber, String value, String filePath) throws IOException {
        sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(rowNumber);
        if (row == null) row = sheet.createRow(rowNumber);
        Cell cell = row.createCell(cellNumber);
        cell.setCellValue(value);

        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        fos.close();
    }

    public void closeWorkbook() throws IOException {
        workbook.close();
    }
}

