package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelReader {
    public List<String> readFieldPaths(String filePath) throws IOException {

        List<String> fieldPaths = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getZeroHeight() || row.getCell(0) == null || row.getCell(0).getStringCellValue().isEmpty()) {
                    continue; // Skip filtered out rows
                }
                fieldPaths.add(row.getCell(0).getStringCellValue());
            }
            workbook.close();
            fis.close();
            return fieldPaths;
        } catch (Exception e) {
            return Arrays.asList("error");
        }
    }
}
