package domain;

import view.OutputView;

import java.util.Arrays;
import java.util.List;

public class Customer {
    private static final double ZERO = 0.0;

    private int customerId;
    private double point;
    private List<Payment> payments;

    public Customer(int customerId, double point, Payment... payments) {
        this.customerId = customerId;
        this.point = point;
        this.payments = Arrays.asList(payments);
    }

    public boolean isUsingPointAmountOverPoint(double usingPointAmount) {
        return point < usingPointAmount;
    }

    public boolean isPointZero() {
        return point == ZERO;
    }

    @Override
    public String toString() {
        return "현재 포인트는 " + point + "점 입니다.";
    }

    public boolean whenReserveAvailable(double moviePrice, int paymentChoice){
        Payment payment = payments.stream().filter(p -> p.checkPaymentId(paymentChoice)).findAny().get();
        if (payment.payAvailable(moviePrice)) {
            point += payment.accumulateAmount(moviePrice);
            payment.minusAmount(moviePrice);
            return true;
        }
        OutputView.failReserveMessage();
        return false;
    }

    public int getCustomerId() {
        return customerId;
    }
}
