package domain;

public class Cash extends Payment {
    private static final double RATIO = 0.3;

    public Cash(double amount) {
        super(amount);
    }

    @Override
    protected double accumulateAmount(int price) {
        return RATIO * price;
    }
}
