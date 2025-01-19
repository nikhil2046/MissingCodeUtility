package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class HtmlReportGenerator {
    /*public void generateReport(Map<String, List<String>> results, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write("<html><head><style>");
        writer.write("body { font-family: Arial, sans-serif; margin: 20px; }");
        writer.write("table { border-collapse: collapse; width: 100%; }");
        writer.write("th, td { border: 1px solid #dddddd; text-align: left; padding: 8px; }");
        writer.write("th { background-color: #f2f2f2; }");
        writer.write(".green { color: green; }");
        writer.write(".red { color: red; }");
        writer.write("</style></head><body>");
        writer.write("<h1>Missing Code Utility</h1>");
        writer.write("<table>");
        writer.write("<tr><th>Field Path</th><th>Status</th><th>Implemented Filenames</th></tr>");
        for (Map.Entry<String, List<String>> entry : results.entrySet()) {
            List<String> filenames = entry.getValue();
            String status = filenames.get(0).equals("Not Implemented") ? "Not Implemented" : "Implemented";
            String colorClass = status.equals("Implemented") ? "green" : "red";
            writer.write("<tr><td>" + entry.getKey() + "</td><td class='" + colorClass + "'>" + status + "</td><td>");
            writer.write("<ul class='" + colorClass + "'>");
            for (String filename : filenames) {
                if (!filename.equals("Not Implemented")) {
                    writer.write("<li>" + filename + "</li>");
                }
            }
            writer.write("</ul>");
            writer.write("</td></tr>");
        }
        writer.write("</table></body></html>");
        writer.close();
    }*/


    public void generateReport(Map<String, List<String>> results, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write("<html><head><style>");
        writer.write("body { font-family: Calibri, sans-serif; margin: 10px; background-color: #f4f4f4; }");
        writer.write("table { border-collapse: collapse; width: 100%; margin-bottom: 20px; }");
        writer.write("th, td { border: 1px solid #dddddd; text-align: left; padding: 12px; }");
        writer.write("th { background-color: #4CAF50; color: white; text-align: center;}");
        writer.write("tr:nth-child(even) { background-color: #f2f2f2; }");
        writer.write("tr:hover { background-color: #ddd; }");
        writer.write(".green { color: green; }");
        writer.write(".red { color: red; }");
        writer.write("h1 { color: #333; text-align: center; }");
        //writer.write("footer { text-align: center; padding: 10px; background-color: #4CAF50; color: white; position: fixed; bottom: 0; width: 100%; }");
        writer.write("header { text-align: center; padding: 5px; background-color: #4CAF50; color: white; position: fixed; top: 0; width: 100%; }");
        writer.write("</style></head><body>");
        // writer.write("<header>  <h1>Missing Code Utility Report </h1> </header>");
        writer.write("<h1>Missing Code Reports</h1>");
        writer.write("<table>");
        writer.write("<tr><th>EFX Fields Path</th><th>Status</th><th> File Name Location</th></tr>");

        if (results.entrySet().isEmpty()) {
            writer.write("<tr><td colspan='3' style='text-align:center; color:red;'>No Record Found</td></tr>");
        } else {
            for (Map.Entry<String, List<String>> entry : results.entrySet()) {
                List<String> filenames = entry.getValue();
                String status = filenames.get(0).equals("Not Implemented") ? "Not Implemented" : "Implemented";
                String colorClass = status.equals("Implemented") ? "green" : "red";

                writer.write("<tr><td>" + entry.getKey() + "</td><td class='" + colorClass + "'>" + status + "</td><td>");
                writer.write("<ul class='" + colorClass + "'>");
                for (String filename : filenames) {
                    if (!filename.equals("Not Implemented")) {
                        writer.write("<li>" + filename + "</li>");
                    }
                }
            }
            writer.write("</ul>");
            writer.write("</td></tr>");
        }

        writer.write("</table>");
        // writer.write("<footer>Report generated on " + java.time.LocalDateTime.now() + "</footer>");
        writer.write("</body></html>");
        writer.close();
    }

}

