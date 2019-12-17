package domain;

public class Card extends Payment {
    private final static double RATIO = 0.5;

    public Card(double amount) {
        super(amount);
    }

    @Override
    protected double accumulateAmount(int price) {
        return RATIO * price;
    }
}
