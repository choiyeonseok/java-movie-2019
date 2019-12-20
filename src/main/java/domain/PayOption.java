package domain;

import java.util.stream.DoubleStream;

public class PayOption {
    private double pointRatio;
    private String sort;
    private int amount;

    public PayOption(String sort, double pointRatio, int amount) {
        this.pointRatio = pointRatio;
        this.sort = sort;
        this.amount = amount;
    }

    public boolean isMatchSort(String sort) {
        return this.sort == sort;
    }

    public int getAmount(){
        return amount;
    }

    public void minusAmount(double actualAmount) {
        this.amount -= actualAmount;
    }

    public double getPointAmount(double actualAmount) {
        return pointRatio * actualAmount;
    }
}
