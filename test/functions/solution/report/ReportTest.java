package functions.solution.report;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportTest {
    @Test
    public void testReport() {
        Report report;
        List<String> reportLines;
        String reportText;

        report = new Report();
        reportLines = report.createReport();
        reportText = reportLines.stream().collect(Collectors.joining("\n"));
        assertEquals(
                "Report for all Orders\n" +
                        "Order 1 - Customer-1\n" +
                        "1 - Part-1 - 100.11\n" +
                        "2 - Part-2 - 200.22\n" +
                        "Order 2 - Customer-1\n" +
                        "1 - Part-1 - 100.11\n" +
                        "Order 3 - Customer-2\n" +
                        "1 - Part-2 - 200.22\n" +
                        "Report created by ReportMonster", reportText);
    }
}
