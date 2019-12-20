package domain;

public class Payment {
    private double pointRatio;
    private String sort;

    public Payment(String sort, double pointRatio) {
        this.pointRatio = pointRatio;
        this.sort = sort;
    }
}
