import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
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
