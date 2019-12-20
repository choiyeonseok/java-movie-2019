import domain.*;
import view.InputView;
import view.OutputView;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        Customer customer = new Customer(1, 8000, new Payment("Card", 0.05), new Payment("Cash", 0.03));

        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId(movies);
        Movie selectedMovie = movies.stream().filter(m -> m.isMatchId(movieId)).findAny().get();
        OutputView.printSelectedMovie(selectedMovie);

        int sequence = InputView.inputSequence(selectedMovie) - 1;
        System.out.println(sequence);

        PickedScreening pickedScreening = new PickedScreening(selectedMovie, sequence);

        int headCount = InputView.inputHeadCount(pickedScreening);
        pickedScreening.minusCapacityAndSaveHeadCount(headCount);

        Basket basket = new Basket();
        basket.addScreening(pickedScreening);

        int BackToBeginning = InputView.inputAdditionalScreening();
        if(BackToBeginning == 2) { }

        OutputView.printCustomerPoint(customer);
        if(customer.hasPointOverFee(basket.getTotalFee())){
            basket.makeTotalFeeZero();
        }

        if(customer.isPointZero()){
            //바로 결제로
        }

        double pointUsage = InputView.inputPointUsage(customer);
        double actualAmount = basket.getTotalFee() - pointUsage;



    }
}
