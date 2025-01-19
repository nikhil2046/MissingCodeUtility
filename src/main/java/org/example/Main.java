package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            System.out.println("Usage: java -jar <utility_name>.jar <excelFilePath> <projectPath> <reportFilePath>");
            return;
        }
        if (!isValidExcelFile(args[0])) {
            System.out.println("Invalid fileType or Please provide valid excel sheet path..!");
            return;
        }
        String excelFilePath = args[0];
        String projectPath = args[1];
        String reportFilePath = args[2];
        ExcelReader excelReader = new ExcelReader();
        List<String> fieldPaths = excelReader.readFieldPaths(excelFilePath);
        FieldPathChecker checker = new FieldPathChecker();
        Map<String, List<String>> results = checker.checkFieldPaths(fieldPaths, projectPath);
        HtmlReportGenerator reportGenerator = new HtmlReportGenerator();
        reportGenerator.generateReport(results, reportFilePath);
        System.out.println("Report generated at: " + reportFilePath);
    }

    private static boolean isValidExcelFile(String filename) {
        if (!filename.isEmpty()) {
            if (filename.contains(".xls") || filename.contains("xlsx")) {
                return true;
            }
        }
        return false;
    }
}
