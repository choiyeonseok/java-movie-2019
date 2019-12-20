package domain;

import java.util.Arrays;
import java.util.List;

public class Customer {
    private int customerId;
    private double point;
    private List<Payment> payments;

    public Customer(int customerId, double point, Payment ... payments) {
        this.customerId = customerId;
        this.point = point;
        this.payments = Arrays.asList(payments);
    }
}
