package view;

import domain.Customer;
import domain.Movie;
import domain.Reservation;
import domain.ReservationList;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printSelectedMovie(Movie movie) {
        System.out.println(movie);
    }

    public static void printCustomerPoint(Customer customer) {
        if (!customer.isPointZero()) {
            System.out.println(customer);
        }
    }

    public static void printMovieFee(int totalMovieFee) {
        System.out.println("영화의 총 가격은 " + totalMovieFee + "원 입니다.");
    }

    public static void printFailMessage() {
        System.out.println("잔액 부족으로 결제가 실패했습니다.");
    }

    public static void printSuccessMessage(int balance) {
        System.out.println("결제가 완료되었습니다. 남은 잔액은 " + balance + "원 입니다.");
    }

    public static void printReservationList(ReservationList reservationList) {
        System.out.println(reservationList.toString());
    }
}
