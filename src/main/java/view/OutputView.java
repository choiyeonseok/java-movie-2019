package view;

import domain.Customer;
import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printSelectedMovie(Movie movie) {
        System.out.println(movie);
    }

    public static void printCustomerPoint(Customer customer) {
        if (customer.isPointZero()) {
            System.out.println(customer);
        }
    }
}
