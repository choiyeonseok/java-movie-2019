package domain;

import view.InputView;
import view.OutputView;

public class Payment {
    private int totalMovieFee;
    private Customer customer;

    public Payment(int totalMovieFee, Customer customer){
        this.totalMovieFee = totalMovieFee;
        this.customer = customer;
    }

    public double pay(){
        double actualAmount = calculateActualAmount();
        int option = choosePayOption();
        proceedPaying(actualAmount, option);
        return actualAmount;
    }

    private double calculateActualAmount(){
        OutputView.printCustomerPoint(customer);
        double pointUsage = 0;
        if(!customer.isPointZero()){                             // 포인트 0이상일 경우
            pointUsage = InputView.inputPointUsage(customer);    // 포인트 사용량
        }
        return totalMovieFee - pointUsage;// 실제 가격 계산
    }

    private int choosePayOption(){
        return InputView.inputPaymentChoice();
    }

    private void proceedPaying(double actualAmount, int choice){
        if(!customer.isPayingAvailable(actualAmount, choice)){
            OutputView.printFailMessage();
            pay();
            return;
        }
        customer.proceedPayment(actualAmount, choice);
        customer.addPoint(actualAmount, choice);
        succeedPaying(customer, choice);
    }

    private void succeedPaying(Customer customer, int option){
        int balance = customer.getBalance(option);
        OutputView.printSuccessMessage(balance);
    }


}
