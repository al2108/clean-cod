package functions.example.report;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTests {
    private static OrderDatabase orderDatabase;

    @BeforeAll
    public static void setup() {
        orderDatabase = new OrderDatabase();
    }


    @Test
    public void testOrders() {
        assertEquals(3, orderDatabase.getOrders().size());
    }

    @Test
    public void testOrderLines() {
        assertEquals(4, orderDatabase.getOrderLines().size());
    }
}