package functions.solution;

import functions.solution.report.Report;

public class Solution {
  public static void main(final String[] parArgs) {
    Report report = new Report();
    System.out.println(String.join("\n", report.createReport()));
  }
}
