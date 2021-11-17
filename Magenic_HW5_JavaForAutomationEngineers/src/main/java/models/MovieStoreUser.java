package models;

import java.util.*;

public class MovieStoreUser {
    private final String username;
    private final String password;
    private final MovieCart movieCart;
    private final List<HashMap<Date, Movie>> moviesCurrentlyBeingRented;

    public MovieStoreUser(String username, String password) {
        this.username = username;
        this.password = password;
        this.moviesCurrentlyBeingRented = new ArrayList<>();
        this.movieCart = new MovieCart();
    }

    /**
     * @return the username of the user
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the movie cart instance of the user
     */
    public MovieCart getMovieCart() { return movieCart; }

    /**
     * Adds the specified movie to the current movie rentals of the user
     * @param movie the movie rented
     */
    public void addMovieToCurrentRentals(Movie movie) {
        moviesCurrentlyBeingRented.add(new HashMap<Date, Movie>() {{ put(new Date(System.currentTimeMillis()), movie); }});
    }

    /**
     * Copies the contents of the Rental cart to the user's current rentals record
     */
    public void addRentalMoviesInCartToCurrentRentals() {
        movieCart.getMoviesInRentalCart().forEach(this::addMovieToCurrentRentals);
    }

    /**
     * Displays the current movies being rented by the user in human readable text
     */
    public void displayMoviesCurrentlyBeingRented() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("==== You are currently renting " + moviesCurrentlyBeingRented.size() + " movies ====");

        int idx = 0;
        for (HashMap<Date, Movie> movieDetails : moviesCurrentlyBeingRented) {
            Map.Entry<Date, Movie> entry = movieDetails.entrySet().iterator().next();
            Date date = entry.getKey();
            Movie movie = entry.getValue();

            movie.displayDetails(idx);
            System.out.println("Rental start date: " + date.toString());
            idx++;
        }
    }

}
