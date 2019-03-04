package solution.report;

import solution.customer.Customer;
import solution.customer.CustomerDatabase;
import solution.order.Order;
import solution.order.OrderDatabase;
import solution.order.OrderLine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Report {
  private CustomerDatabase customerDatabase;
  private OrderDatabase orderDatabase;
  private List<Customer> customers;
  private List<Order> orders;
  private List<OrderLine> orderLines;
  private List<String> reportLines;

  public Report() {
    setupDatabase();
    readReportBaseData();
  }

  public List<String> createReport() {
    initializeReportWithHeader();
    for (Order order : orders) {
      addOrderHeaderToReport(order);
      addOrderLinesToReport(order);
    }
    addFooterToReport();
    return reportLines;
  }

  private void addOrderHeaderToReport(final Order parOrder) {
    reportLines.add("Order " + parOrder.id + " - " + getCustomerName(parOrder.customerId));
  }

  private void addOrderLinesToReport(final Order parOrder) {
    List<OrderLine> orderLinesForOrder;

    orderLinesForOrder = orderLines.stream()
            .filter(orderLine -> orderLine.orderId == parOrder.id).collect(Collectors.toList());
    for (OrderLine orderLine : orderLinesForOrder) {
      reportLines.add(orderLine.position + " - " + orderLine.part + " - " + orderLine.value);
    }
  }

  private String getCustomerName(int parCustomerId) {
    Customer customerFound;

    customerFound = customers.stream().filter(customer -> customer.id == parCustomerId).findFirst().get();
    return customerFound  == null ? "" : customerFound.name;
  }

  private void initializeReportWithHeader() {
    reportLines = new ArrayList<>();
    reportLines.add("Report for all Orders");
  }

  private void addFooterToReport() {
    reportLines.add("Report created by ReportMonster");
  }

  private void readReportBaseData() {
    customers = customerDatabase.getCustomers();
    orders = orderDatabase.getOrders();
    orderLines  = orderDatabase.getOrderLines();
  }

  private void setupDatabase() {
    customerDatabase = new CustomerDatabase();
    orderDatabase = new OrderDatabase();
  }

  public static void main(final String[] parArgs) {
    Report report;

    report = new Report();
    System.out.println(report.createReport().stream().collect(Collectors.joining("\n")));
  }
}