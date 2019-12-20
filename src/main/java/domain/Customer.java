package domain;

import java.util.Arrays;
import java.util.List;

public class Customer {
    private int customerId;
    private double point;
    private List<Payment> payments;

    public Customer(int customerId, double point, Payment... payments) {
        this.customerId = customerId;
        this.point = point;
        this.payments = Arrays.asList(payments);
    }

    public boolean hasPointOverFee(int totalFee) {
        return point > totalFee;
    }

    public boolean isPointZero() {
        return point == 0;
    }

    public boolean isOverPoint(int pointUsage) {
        return pointUsage > point;
    }

    @Override
    public String toString() {
        return "" + customerId + "의 현재 포인트는 " + point + "점 입니다.";
    }
}
