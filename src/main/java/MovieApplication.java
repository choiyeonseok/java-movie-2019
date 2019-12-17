import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    private static final double ZERO = 0.0;

    public static void main(String[] args) {

        Customer customer1 = new Customer(1004,
                                            5000,
                                            new Card(15000),
                                            new Cash(20000));

        /** 1. 영화 목록 출력 */
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        Movie selectedMovie;

        /** 2. 영화 선택 */
        int movieId = InputView.inputMovieId();
        selectedMovie = movies.stream()
                .filter(m -> m.checkMovieId(movieId))
                .findAny()
                .get();
        OutputView.printSchedules(selectedMovie);

        /** 3. 상영 회차 선택 */
        int scheduleSequence = InputView.inputScheduleSequence(selectedMovie);
        PlaySchedule selectedSchedule = selectedMovie.getSchedule(scheduleSequence);
        OutputView.printScreening(selectedSchedule);

        /** 4. 관람 인원 입력 */
        int headCount = InputView.inputHeadCount(selectedMovie, scheduleSequence);

        /** 5. Point 사용 입력 */
        double moviePrice = ZERO;
        if (!customer1.isPointOverPrice(selectedMovie.getPrice())){
            moviePrice = selectedMovie.calculateMoviePrice(headCount) - InputView.inputUsingPointAmount(customer1);
        }
        OutputView.printAfterPointPrice(moviePrice);

        /** 6. 결제 수단 선택 */
        int paymentChoice = InputView.inputPaymentChoice();
        OutputView.printPaymentChoice(paymentChoice);

        /** 7. 결제 금액 지불 후 영화 예매 */
        List<Reservation> reservationList = new ArrayList<>();
        if (customer1.whenReserveAvailable(moviePrice, paymentChoice)) {
            selectedSchedule.minusCapacity(headCount);
            reservationList.add(new Reservation(customer1.getCustomerId(),
                    selectedMovie.getName(),
                    selectedSchedule.getStartDateTime(),
                    headCount,
                    moviePrice));
        }
        OutputView.printReservationList(reservationList);

    }
}
