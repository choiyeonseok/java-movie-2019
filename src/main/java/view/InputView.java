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
        if (id <= 0 | movies.stream().filter(m -> m.isMatchId(id)).count() == 0) {
            throw new IllegalArgumentException();
        }
    }

    public static int inputSequence(Movie movie) {
        scanner = new Scanner(System.in);
        System.out.println("## 예약할 상영 회차를 선택하세요.");
        try {
            int sequence = scanner.nextInt();
            verifySequence(sequence, movie);
            return sequence;
        } catch (IllegalArgumentException e){
            System.out.println("유효한 상영 회차 번호를 입력해 주세요");
        } catch (Exception e) {
            System.out.println("숫자를 입력해 주세요");
        }
        return inputSequence(movie);
    }

    private static void verifySequence(int sequence, Movie movie) {
        if (sequence <= 0 | sequence > movie.maxSequence()){
            throw new IllegalArgumentException();
        }
    }

    public static int inputHeadCount(Movie movie, int sequence) {
        scanner = new Scanner(System.in);
        System.out.println("## 예약할 인원를 입력하세요.");
        try {
            int headCount = scanner.nextInt();
            verifyHeadCount(headCount, movie, sequence);
            return headCount;
        } catch (IllegalArgumentException e){
            System.out.println("예매 가능 인원을 초과했습니다.");
        } catch (Exception e) {
            System.out.println("숫자를 입력해 주세요");
        }
        return inputHeadCount(movie, sequence);
    }

    private static void verifyHeadCountWithCapacity(int headCount, Movie movie, int sequence) {
        // 0이하의 예외처리는 따로 분리할 예정.
        if (headCount <= 0 | movie.getPlaySchedule(sequence).isOverCapacity(headCount)) {
            throw new IllegalArgumentException();
        }
    }


}
