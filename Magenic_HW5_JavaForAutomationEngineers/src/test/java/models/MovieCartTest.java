package models;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class MovieCartTest {
    public Movie movie;
    @BeforeTest
    public void testSetup() {
        movie = new Movie(
                "Aswad", "Comedy", 2013, "Jamaica", 1.99, 0.19,
                "Test description.");
    }

    @Test
    public void testAddMovieToRentalCart() {
        MovieCart movieCart = new MovieCart();
        movieCart.addMovieToRentalCart(movie);

        Assert.assertEquals(movieCart.getMoviesInRentalCart().size(), 1);
        Assert.assertEquals(movieCart.getAllMoviesInCart().size(), 1);
        Assert.assertEquals(new ArrayList<Movie>() {{ add(movie); }}, movieCart.getMoviesInRentalCart());
    }

    @Test
    public void testAddMovieToCart() {
        MovieCart movieCart = new MovieCart();
        movieCart.addMovieToRentalCart(movie);
        movieCart.addMovieToPurchaseCart(movie);

        Assert.assertEquals(movieCart.getAllMoviesInCart().size(), 2);
        Assert.assertEquals(new ArrayList<Movie>() {{ add(movie); }}, movieCart.getMoviesInRentalCart());
    }

    @Test
    public void testRemoveMovieFromRentalCart() {
        MovieCart movieCart = new MovieCart();
        movieCart.addMovieToRentalCart(movie);
        movieCart.removeMovieFromCart(movie);

        Assert.assertEquals(movieCart.getAllMoviesInCart().size(), 0);
        Assert.assertEquals(new ArrayList<Movie>(), movieCart.getMoviesInRentalCart());
    }

    @Test
    public void testRemoveMovieFromPurchaseCart() {
        MovieCart movieCart = new MovieCart();
        movieCart.addMovieToPurchaseCart(movie);
        movieCart.removeMovieFromCart(movie);

        Assert.assertEquals(movieCart.getAllMoviesInCart().size(), 0);
    }

    @Test
    public void testRemoveMovieFromCart() {
        MovieCart movieCart = new MovieCart();
        movieCart.addMovieToRentalCart(movie);
        movieCart.removeMovieFromCart(movie);

        Assert.assertEquals(movieCart.getAllMoviesInCart().size(), 0);
        Assert.assertEquals(new ArrayList<Movie>(), movieCart.getMoviesInRentalCart());
    }

    @Test
    public void testDuplicateMoviesInCarts() {
        MovieCart movieCart = new MovieCart();
        movieCart.addMovieToRentalCart(movie);
        movieCart.addMovieToPurchaseCart(movie);

        movieCart.addMovieToRentalCart(movie);
        movieCart.addMovieToPurchaseCart(movie);

        Assert.assertEquals(movieCart.getAllMoviesInCart().size(), 2);
        Assert.assertEquals(new ArrayList<Movie>() {{ add(movie); }}, movieCart.getMoviesInRentalCart());
    }
}
