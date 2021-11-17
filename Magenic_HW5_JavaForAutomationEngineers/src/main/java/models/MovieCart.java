package models;

import utils.UserHelper;

import java.util.ArrayList;
import java.util.List;

public class MovieCart {
    private final List<Movie> movieRentalCart = new ArrayList<>();
    private final List<Movie> moviePurchaseCart = new ArrayList<>();

    /**
     * Adds the movie to the Rental Cart
     * @param movie - the movie to be added
     */
    public void addMovieToRentalCart(Movie movie) {
        if (movieRentalCart.contains(movie)) {
            System.out.println("The movie is already in your cart!");
        } else {
            movieRentalCart.add(movie);
            System.out.println("The movie has been added to your cart!");
        }
    }

    /**
     * Adds the movie to the Purchase Cart
     * @param movie - the movie to be added
     */
    public void addMovieToPurchaseCart(Movie movie) {
        if (moviePurchaseCart.contains(movie)) {
            System.out.println("The movie is already in your cart!");
        } else {
            moviePurchaseCart.add(movie);
            System.out.println("The movie has been added to your cart!");
        }
    }

    /**
     * Removes the movie from the Rental Cart
     * @param movie - the movie to be removed
     */
    public void removeMovieFromRentalCart(Movie movie) {
        movieRentalCart.remove(movie);
        System.out.println("The movie has been removed from your cart!");
    }

    /**
     * Removes the movie from the Purchase Cart
     * @param movie - the movie to be removed
     */
    public void removeMovieFromPurchaseCart(Movie movie) {
        moviePurchaseCart.remove(movie);
        System.out.println("The movie has been removed from your cart!");
    }

    /**
     * Removes the movie either from the Rental or the Purchase Cart
     * @param movie - the movie to be removed
     */
    public void removeMovieFromCart(Movie movie) {
        if (movieRentalCart.contains(movie)) {
            removeMovieFromRentalCart(movie);
        } else {
            removeMovieFromPurchaseCart(movie);
        }
    }

    /**
     * @return the combined list of movies in the Rental and Purchase Carts
     */
    public List<Movie> getAllMoviesInCart() {
        List<Movie> allMoviesCart = new ArrayList<>(movieRentalCart);
        allMoviesCart.addAll(moviePurchaseCart);

        return allMoviesCart;
    }

    /**
     * @return the list of movies in the Rental Cart
     */
    public List<Movie> getMoviesInRentalCart() {
        return this.movieRentalCart;
    }

    /**
     * @return the amount of movies in the Rental Cart
     */
    public int getMovieRentalCartSize() {
        return movieRentalCart.size();
    }

    /**
     * @return the amount of movies in the Purchase Cart
     */
    public int getMoviePurchaseCartSize() {
        return moviePurchaseCart.size();
    }

    /**
     * @return the amount of movies both in the Rental and Purchase Carts
     */
    public int getTotalMoviesInCart() {
        return getMoviePurchaseCartSize() + getMovieRentalCartSize();
    }

    /**
     * @return the sum of the Rental price of movies in the Rental Cart
     */
    public double getTotalRentalCartPrice() {
        return movieRentalCart.stream().mapToDouble(Movie::getRentalPrice).sum();
    }

    /**
     * @return the sum of the Purchase price of movies in the Purchase Cart
     */
    public double getTotalPurchaseCartPrice() {
        return moviePurchaseCart.stream().mapToDouble(Movie::getPrice).sum();
    }

    /**
     * Displays the movies in both Rental and Purchase carts in human readable text
     */
    public void displayCartDetails() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("==== Your Movie Cart ====");
        System.out.println("---- You have " + getTotalMoviesInCart() + " total movies in your cart ----");
        System.out.println("__________________________");
        System.out.println("MOVIES YOU WANT TO RENT(" + getMovieRentalCartSize() + "): ");

        int idx = 0;
        for (Movie movie : movieRentalCart) {
            System.out.println();
            movie.displayDetails(idx);
            idx++;
        }

        System.out.println("----");
        System.out.println("TOTAL: " + getTotalRentalCartPrice());
        System.out.println("__________________________");
        System.out.println("MOVIES YOU WANT TO PURCHASE(" + getMoviePurchaseCartSize() + "): ");

        for (Movie movie : moviePurchaseCart) {
            System.out.println();
            movie.displayDetails(idx);
            idx++;
        }

        System.out.println("----");
        System.out.println("TOTAL: " + getTotalPurchaseCartPrice());
        System.out.println("__________________________");
    }

    /**
     * Logic and display for checking out both carts.
     * @return a boolean value indicating if the checkout was successful
     */
    public boolean checkoutCart() {
        boolean checkedOut = false;
        if (getTotalMoviesInCart() == 0) {
            System.out.println("You have no movies in your cart to checkout!");
        } else {
            System.out.println("==== You will be checking out the following ====");
            System.out.println();

            displayCartDetails();

            System.out.print("Are you sure you want to checkout? (Y/N): ");

            if (UserHelper.takeUserInputAsString().equalsIgnoreCase("Y")) {
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("Your purchase is successful!");
                System.out.println("For rentals, the movies will automatically be removed from your account after 15 days.");
                System.out.println("Thank you for shopping with my Movie Store system.");
                System.out.println("Have a good day!");

                checkedOut = true;
            } else {
                System.out.print("You have cancelled your checkout.");
            }
        }

        return checkedOut;
    }

    /**
     * Clears both carts of their elements
     */
    public void clearCart() {
        movieRentalCart.clear();
        moviePurchaseCart.clear();
    }
}
