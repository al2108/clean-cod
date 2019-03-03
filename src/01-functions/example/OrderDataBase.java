package example;

import java.util.ArrayList;
import java.util.List;

public class OrderDataBase {
  private ArrayList<Order> orders;
  private ArrayList<OrderLine> orderLines;

  public OrderDataBase() {
    orders = new ArrayList<>();
    orders.add(new Order(1, 1));
    orders.add(new Order(2, 1));
    orders.add(new Order(3, 2));
    orderLines = new ArrayList<>();
    orderLines.add(new OrderLine(1, 1, "Part-1", 100.11));
    orderLines.add(new OrderLine(1, 2, "Part-2", 200.22));

    orderLines.add(new OrderLine(2, 1, "Part-1", 100.11));
    orderLines.add(new OrderLine(3, 1, "Part-2", 200.22));
  }
  
  public List<Order> getOrders() {
    return orders;
  }

  public List<OrderLine> getOrderLines() {
    return orderLines;
  }
}