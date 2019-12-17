package view;

import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        try {
            int movieId = scanner.nextInt();
            verifyMovieAvailable(movieId);
            return movieId;
        } catch (Exception e) {
            OutputView.invalidMessage();
            return inputMovieId();
        }
    }

    private static void verifyMovieAvailable(int id) throws Exception {
        if (!MovieRepository.getMovies().stream().anyMatch(m -> m.checkMovieId(id))) {
            throw new Exception();
        }
    }

    public static int inputScheduleSequence(Movie movie) {
        System.out.println("## 예약할 상영 스케줄을 선택하세요");
        try {
            int sequence = scanner.nextInt() - 1;
            verifyScheduleAvailable(movie, sequence);
            return sequence;
        } catch (Exception e) {
            OutputView.invalidMessage();
            return inputScheduleSequence(movie);
        }
    }

    private static void verifyScheduleAvailable(Movie movie, int sequence) throws Exception {
        if (!movie.checkScheduleSequence(sequence) | movie.getSchedule(sequence).isOneHourRange() | movie.getSchedule(sequence).isPastSchedule()){
            throw new Exception();
        }
    }

    public static int inputHeadCount(Movie movie, int sequence) {
        System.out.println("## 예약할 인원 수를 입력하세요");
        try {
            int headCount = scanner.nextInt();
            verifyHeadCount(movie.getSchedule(sequence), headCount); // => @실패 시 맨 처음 영화 선택 단계로 돌아가야 함
            return headCount;
        } catch (Exception e) {
            OutputView.invalidMessage();
            return inputHeadCount(movie, sequence);
        }
    }

    private static void verifyHeadCount(PlaySchedule playSchedule, int headCount) throws Exception {
        if (!playSchedule.isCapacityAvailable(headCount) | headCount <= 0) {
            throw new Exception();
        }
    }

}
