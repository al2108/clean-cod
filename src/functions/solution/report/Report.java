package functions.solution.report;

import functions.solution.customer.Customer;
import functions.solution.customer.CustomerDatabase;
import functions.solution.order.Order;
import functions.solution.order.OrderDatabase;
import functions.solution.order.OrderLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
  }

  public List<String> createReport() {
    readReportData();
    initializeReportWithHeader();
    for (Order order : orders) {
      addOrderHeaderToReport(order);
      addOrderLinesToReport(order);
    }
    addFooterToReport();

    return reportLines;
  }

  private void initializeReportWithHeader() {
    reportLines = new ArrayList<>();
    reportLines.add("Report for all Orders");
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
    Optional<Customer> customerFound;

    customerFound = customers.stream().filter(customer -> customer.id == parCustomerId).findFirst();

    return customerFound.isPresent() ? customerFound.get().name : "";
  }

  private void addFooterToReport() {
    reportLines.add("Report created by ReportMonster");
  }

  private void readReportData() {
    customers = customerDatabase.getCustomers();
    orders = orderDatabase.getOrders();
    orderLines = orderDatabase.getOrderLines();
  }

  private void setupDatabase() {
    customerDatabase = new CustomerDatabase();
    orderDatabase = new OrderDatabase();
  }

}