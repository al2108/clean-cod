package solution.order;

public class OrderLine {
  public int orderId;
  public int position;
  public String part;
  public double value;

  public OrderLine(final int parOrderId, final int parPosition, final String parPart, final double parValue) {
    orderId = parOrderId;
    position = parPosition;
    part = parPart;
    value = parValue;
  }
}