import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {

        Customer customer1 = new Customer(1004,
                                            5000,
                                            new Card(15000),
                                            new Cash(20000));

        List<Movie> movies = MovieRepository.getMovies();
        Movie selectedMovie;
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();
        selectedMovie = movies.stream()
                .filter(m -> m.checkMovieId(movieId))
                .findAny()
                .get();
        OutputView.printSchedules(selectedMovie);

        int scheduleSequence = InputView.inputScheduleSequence(selectedMovie);
        OutputView.printScreening(selectedMovie, scheduleSequence);

        int headCount = InputView.inputHeadCount(selectedMovie, scheduleSequence);

    }
}
