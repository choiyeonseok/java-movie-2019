import domain.Movie;
import domain.MovieRepository;
import domain.PickedScreening;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
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

        List<PickedScreening> baskets = new ArrayList<>();
        baskets.add(pickedScreening);



    }
}
