import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();
        for (Movie movie : movies){
            if (movie.checkMovieId(movieId)) {
                OutputView.printSchedules(movie);
            }
        }

        int scheduleId = InputView.inputScheduleId();
        int headCount = InputView.inputHeadCount();
    }
}
