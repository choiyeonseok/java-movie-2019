package view;

import domain.Movie;
import domain.PlaySchedule;

import java.util.List;

public class OutputView {
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
}
