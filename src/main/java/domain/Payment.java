package domain;

public abstract class Payment {
    private double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public void minusAmount(double price) {
        amount -= price;
    }

    public boolean payAvailable(double price) {
        return amount >= price;
    }

    abstract protected boolean checkPaymentId(int paymentChoice);

    abstract protected double accumulateAmount(double price);
}
