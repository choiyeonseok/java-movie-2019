package view;

import domain.Customer;
import domain.Movie;
import domain.PickedScreening;

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

    public static int inputHeadCount(PickedScreening screening) {
        scanner = new Scanner(System.in);
        System.out.println("## 예약할 인원를 입력하세요.");
        try {
            int headCount = scanner.nextInt();
            verifyHeadCountWithCapacity(headCount, screening);
            return headCount;
        } catch (IllegalArgumentException e){
            System.out.println("예매 가능 인원을 초과했습니다.");
        } catch (Exception e) {
            System.out.println("숫자를 입력해 주세요");
        }
        return inputHeadCount(screening);
    }

    private static void verifyHeadCountWithCapacity(int headCount, PickedScreening screening) {
        // 0이하의 예외처리는 따로 분리할 예정.
        if (headCount <= 0 | screening.isNotCapableCount(headCount)) {
            throw new IllegalArgumentException();
        }
    }


    public static int inputAdditionalScreening() {
        System.out.println("추가로 영화를 예약하시겠습니까? (1)예 (2)아니오");
        Integer choice = getChoice();
        if (choice != null) return choice;
        return inputAdditionalScreening();
    }

    private static void verifyChoice(int choice) {
        if (choice != 1 && choice != 2) {
            throw new IllegalArgumentException();
        }
    }

    public static double inputPointUsage(Customer customer) {
        System.out.println("사용하실 포인트를 입력해 주세요");
        scanner = new Scanner(System.in);
        try {
            int pointUsage = scanner.nextInt();
            verifyPointUsage(pointUsage, customer);
            return pointUsage;
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력 범위입니다.");
        } catch (Exception e) {
            System.out.println("숫자를 입력해 주세요");
        }
        return inputPointUsage(customer);
    }

    private static void verifyPointUsage(int pointUsage, Customer customer) {
        if (pointUsage < 0 | customer.isOverPoint(pointUsage)){
            throw new IllegalArgumentException();
        }
    }

    public static Integer inputPaymentChoice() {
        System.out.println("결제수단을 선택해주세요 (1)카드 (2)현금");
        Integer choice = getChoice();
        if (choice != null) return choice;
        return inputPaymentChoice();
    }

    private static Integer getChoice() {
        scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            verifyChoice(choice);
            return choice;
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력 범위입니다.");
        } catch (Exception e) {
            System.out.println("숫자를 입력해 주세요");
        }
        return null;
    }
}
