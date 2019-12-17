package domain;

public class Customer {
    private static final double ZERO = 0.0;

    private int customerId;
    private double point;

    public Customer(int customerId, double point){
        this.customerId = customerId;
        this.point = point;
    }

    public boolean isPointOverPrice(int price){
        return point >= price;
    }

    public boolean isPointZero(){
        return point == ZERO;
    }

}
