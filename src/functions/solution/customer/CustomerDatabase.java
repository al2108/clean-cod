package functions.solution.customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDatabase {
    private ArrayList<Customer> customers;

    public CustomerDatabase() {
        customers = new ArrayList<>();
        customers.add(new Customer(1, "Customer-1"));
        customers.add(new Customer(2, "Customer-2"));
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}