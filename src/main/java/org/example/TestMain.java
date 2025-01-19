package org.example;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) throws IOException {
//src/main/java/org/beyounik/book
        String excelFilePath = "D:/learning/test.xlsx";
        //String projectPath = "D:/Learning/Java_Backend_Development/src/main/java/com/exercise/programs";
        String projectPath = "D:/microservices/book_service";
        String reportFilePath = "report.html";

        if (!isValidExcelFile(excelFilePath)){
            System.out.println("Invalid fileType or Please provide valid excel sheet path..!");
            return ;
        }

        ExcelReader excelReader = new ExcelReader();
        List<String> fieldPaths = excelReader.readFieldPaths(excelFilePath);
        FieldPathChecker checker = new FieldPathChecker();
        Map<String, List<String>> results = checker.checkFieldPaths(fieldPaths, projectPath);
        HtmlReportGenerator reportGenerator = new HtmlReportGenerator();
        reportGenerator.generateReport(results, reportFilePath);
        System.out.println("Report generated at: " + reportFilePath);
    }
    private static boolean isValidExcelFile(String filename) {
        // String fileName = file.getOriginalFilename();
        if (!filename.isEmpty()){
            if (filename.contains(".xls") || filename.contains("xlsx")){
                return true;
            }
        }return false;
    }
}
