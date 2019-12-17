package domain;

public abstract class Payment {
    private double amount;

    public Payment (double amount){
        this.amount = amount;
    }

    public boolean payAvailable(int price){
        return amount >= price;
    }

    abstract protected double accumulateAmount(int price);
}
