package view;

import domain.Movie;
import domain.PlaySchedule;
import domain.Reservation;

import java.util.List;

public class OutputView {
    private static final int CARD = 1;
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printSchedules(Movie movie) {
        System.out.println(movie);
    }

    public static void invalidMessage() {
        System.out.println("잘못된 입력입니다.");
    }

    public static void printScreening(PlaySchedule selectedSchedule) {
        System.out.println(selectedSchedule.toString());
    }

    public static void printMoviePrice(double moviePrice) {
        System.out.println("\n결제 금액은 " + moviePrice + "원 입니다.");
    }

    public static void printAfterPointPrice(double moviePrice) {
        System.out.println("\n결제 금액은 " + moviePrice + "원 입니다.");
    }

    public static void printPaymentChoice(int inputPaymentChoice) {
        if(inputPaymentChoice == CARD) {
            System.out.println("카드를 선택하셨습니다. ");
            return;
        }
        System.out.println("현금을 선택하셨습니다.");
    }

    public static void successReserveMessage() {
        System.out.println("결제에 성공했습니다.");
    }

    public static void failReserveMessage() {
        System.out.println("잔액 부족으로 결제에 실패했습니다.");
    }

    public static void printReservationList(List<Reservation> reservationList) {
        for (Reservation reservation : reservationList) {
            if (reservation != null) {
                System.out.println(reservation);
            }
        }
    }
}
