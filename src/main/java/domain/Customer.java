package domain;

import java.util.Arrays;
import java.util.List;

public class Customer {
    private int customerId;
    private double point;
    private List<PayOption> payOptions;

    public Customer(int customerId, double point, PayOption... payOptions) {
        this.customerId = customerId;
        this.point = point;
        this.payOptions = Arrays.asList(payOptions);
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

    public boolean isPayingAvailable(double actualAmount, int paymentChoice) {
        return getBalance(paymentChoice) > actualAmount;
    }

    public int getBalance(double paymentChoice){
        if (paymentChoice == 1) {
            return payOptions.stream().filter(p -> p.isMatchSort("Card")).findAny().get().getAmount();
        }
        return payOptions.stream().filter(p -> p.isMatchSort("Cash")).findAny().get().getAmount();
    }

    public void proceedPayment(double actualAmount, int paymentChoice) {
        if (paymentChoice == 1) {
            payOptions.stream().filter(p -> p.isMatchSort("Card")).findAny().get().minusAmount(actualAmount);
            return;
        }
        payOptions.stream().filter(p -> p.isMatchSort("Cash")).findAny().get().minusAmount(actualAmount);
    }

    public void addPoint(double actualAmount, int paymentChoice){
        if (paymentChoice == 1) {
            point += payOptions.stream().filter(p -> p.isMatchSort("Card")).findAny().get().getPointAmount(actualAmount);
            return;
        }
        point += payOptions.stream().filter(p -> p.isMatchSort("Cash")).findAny().get().getPointAmount(actualAmount);
    }

}
