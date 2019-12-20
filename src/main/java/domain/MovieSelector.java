package domain;

import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieSelector {
    private List<Movie> movies;
    private Movie selectedMovie;
    private PickedScreening screening;
    private Basket basket = new Basket();


    public MovieSelector(List<Movie> movies) {
        this.movies = movies;
    }

    /** 예약 선택 파트 */
    public void select(){
        OutputView.printMovies(movies);
        chooseMovie();
        chooseSequence();
        chooseHeadCount();
        chooseAdditionalScreening();
    }

    private void chooseMovie(){
        int movieId = InputView.inputMovieId(movies);
        selectedMovie = movies.stream().filter(m -> m.isMatchId(movieId)).findAny().get();
        OutputView.printSelectedMovie(selectedMovie);
    }

    private void chooseSequence(){
        int sequence = InputView.inputSequence(selectedMovie) - 1;
        screening = new PickedScreening(selectedMovie, sequence);
        System.out.println(selectedMovie.getPlaySchedule(sequence));
    }

    private void chooseHeadCount(){
        int headCount = InputView.inputHeadCount(screening);
        screening.minusCapacityAndSaveHeadCount(headCount);
        basket.addScreening(screening);
    }


    private void chooseAdditionalScreening(){
        int BackToBeginning = InputView.inputAdditionalScreening();
        if(BackToBeginning == 1) {
            select();
            return;
        }
    }

    public int getTotalMovieFee(){
        return basket.getTotalFee();
    }

    public void createReservationInBasket(ReservationList reservationList){
        basket.createReservation(reservationList);
    }

}
