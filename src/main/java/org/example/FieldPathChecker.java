package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class FieldPathChecker {
    public Map<String, List<String>> checkFieldPaths(List<String> fieldPaths, String projectPath) throws IOException {
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String path : fieldPaths) {
            List<String> result = isImplemented(path, projectPath);
            resultMap.put(path, result);
        }
        return resultMap;
    }

    private List<String> isImplemented(String path, String projectPath) throws IOException {
        List<String> resultList = new ArrayList<>();
        String[] parts = path.split("/");
        String fieldName = parts[parts.length - 1]; // Get the last part as the field name
        File directory = new File(projectPath);
        searchFiles(directory, fieldName, resultList);
        if (resultList.isEmpty()) {
            resultList.add("Not Implemented");
        }
        return resultList;
    }

    private void searchFiles(File directory, String fieldName, List<String> resultList) throws IOException {
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                searchFiles(file, fieldName, resultList);
            } else if (file.getName().endsWith(".java")) {
                boolean found = searchFileForField(file, fieldName);
                if (found) {
                    resultList.add("" + file);
                }
            }
        }
    }

    private boolean searchFileForField(File file, String fieldName) throws IOException {
        try (Stream<String> lines = Files.lines(file.toPath())) {
            return lines.anyMatch(line -> line.contains("get" + fieldName + "("));
        }
    }
}
