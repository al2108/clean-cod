package functions.example;

import functions.example.report.Report;

public class Example {
    public static void main(final String[] parArgs) {
        Report report;

        report = new Report();
        System.out.println(String.join("\n", report.createReport()));
    }
}
