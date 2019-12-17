package domain;

public class Card extends Payment {
    private static final double RATIO = 0.5;
    private static final int PAYMENT_ID = 1;

    public Card(double amount) {
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
