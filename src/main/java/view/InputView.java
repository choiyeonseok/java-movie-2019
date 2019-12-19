package view;

import domain.Movie;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner;

    public static int inputMovieId(List<Movie> movies) {
        scanner = new Scanner(System.in);
        System.out.println("## 예약할 영화를 선택하세요.");
        try {
            int movieId = scanner.nextInt();
            verifyMovieId(movieId, movies);
            return movieId;
        } catch (IllegalArgumentException e){
            System.out.println("유효한 영화 ID 값을 입력해 주세요");
        } catch (Exception e) {
            System.out.println("숫자를 입력해 주세요");
        }
        return inputMovieId(movies);
    }

    private static void verifyMovieId(int id, List<Movie> movies) {
        if (id < 0 | movies.stream().filter(m -> m.isMatchId(id)).count() == 0) {
            throw new IllegalArgumentException();
        }
    }



}
