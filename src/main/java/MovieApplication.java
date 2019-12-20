import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        Customer customer = new Customer(1, 8000, new PayOption("Card", 0.05, 15000), new PayOption("Cash", 0.03, 25000));
        List<Movie> movies = MovieRepository.getMovies();

        MovieSelector selector = new MovieSelector(movies);
        selector.select();
        int totalMovieFee = selector.getTotalMovieFee();
        OutputView.printMovieFee(totalMovieFee);
        Payment payment = new Payment(totalMovieFee, customer);
        payment.pay();

        ReservationList reservationList = new ReservationList();
        selector.createReservationInBasket(reservationList);
        OutputView.printReservationList(reservationList);

    }

}
