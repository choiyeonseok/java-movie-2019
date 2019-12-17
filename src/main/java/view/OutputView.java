package view;

import domain.Movie;
import domain.PlaySchedule;

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

    public static void printScreening(Movie movie, int sequence) {
        System.out.println(movie.getSchedule(sequence).toString());
    }

    public static void printAfterPointPrice(double moviePrice) {
        System.out.println("결제 금액은 " + moviePrice + "원 입니다.");
    }

    public static void printPaymentChoice(int inputPaymentChoice) {
        if(inputPaymentChoice == CARD) {
            System.out.println("카드를 선택하셨습니다. ");
            return;
        }
        System.out.println("현금을 선택하셨습니다.");
    }

}
