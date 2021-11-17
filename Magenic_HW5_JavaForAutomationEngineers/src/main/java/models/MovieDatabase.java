package models;

import resources.MovieFilter;

import java.util.*;

public class MovieDatabase {
    private List<Movie> movies;

    public MovieDatabase() {
        this.movies = new ArrayList<>();
    }

    /**
     * @return the list of movies saved in the "Movie Database"
     */
    public List<Movie> getMovies() {
        return this.movies;
    }

    /**
     * Sorts the movie list in the database based on the filter provided in ascending order
     * @param movieFilter the filter to use
     */
    public void sortMovies(MovieFilter movieFilter) {
        switch(movieFilter) {
            case TITLE:
                movies.sort(new TitleComparator());
                break;
            case GENRE:
                movies.sort(new GenreComparator());
                break;
            case YEAR:
                movies.sort(new YearComparator());
                break;
            case COUNTRY:
                movies.sort(new CountryComparator());
                break;
            case PRICE:
                movies.sort(new PriceComparator());
                break;
            case RENTAL_PRICE:
                movies.sort(new RentalPriceComparator());
                break;
            case DESCRIPTION:
                movies.sort(new DescriptionComparator());
                break;
            default:
                // add error
                break;
        }
    }

    /**
     * Adds the movie to the database
     * @param movie the movie to be added
     */
    public void add(Movie movie) {
        this.movies.add(movie);
    }
}
