package domain;

public class Cash extends Payment {
    private static final double RATIO = 0.03;
    private static final int PAYMENT_ID = 2;

    public Cash(double amount) {
        super(amount);
    }

    @Override
    protected boolean checkPaymentId(int paymentChoice) {
        return PAYMENT_ID == paymentChoice;
    }

    @Override
    protected double accumulateAmount(double price) {
        return RATIO * price;
    }
}
