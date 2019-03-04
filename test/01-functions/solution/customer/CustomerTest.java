package solution.customer;

import example.CustomerDatabase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    private static CustomerDatabase customerDatabase;

    @BeforeAll
    public static void setup() {
        customerDatabase = new CustomerDatabase();
    }


    @Test
    public void testCustomers() {
        assertEquals(2, customerDatabase.getCustomers().size());
    }

}