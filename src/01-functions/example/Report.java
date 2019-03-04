package example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Report {
  private CustomerDatabase db1;
  private OrderDatabase db2;

  public Report() {
    db1 = new CustomerDatabase();
    db2 = new OrderDatabase();
  }

  public List<String> createReport() {
    List<Customer> cust = db1.getCustomers();
    List<Order> orders = db2.getOrders();
    List<OrderLine> olines = db2.getOrderLines();
    List<String> lines = new ArrayList<>();

    lines.add("Report for all Orders");
    for (int i = 0; i < orders.size(); i++) {
      Order order = orders.get(i);
      List<OrderLine> olines2 = new ArrayList<>();
      for (int j = 0; j < olines.size(); j++) {
        OrderLine line = olines.get(j);
        if (line.orderId == order.id) {
          olines2.add(line);
        }
      }
      Customer cust2 = null;
      for (int k = 0; k < cust.size(); k++) {
        Customer c = cust.get(k);
        if (order.customerId == c.id) {
          cust2 = c;
        }
      }
      lines.add("Order " + order.id + " - " + cust2.name);
      for (int l = 0; l < olines2.size(); l++) {
        lines.add(olines2.get(l).position + " - " + olines2.get(l).part + " - " + olines2.get(l).value);
      }
    }
    lines.add("Report created by ReportMonster");

    return lines;
  }

  public static void main(final String[] parArgs) {
    Report report;

    report = new Report();
    System.out.println(report.createReport().stream().collect(Collectors.joining("\n")));
  }
}