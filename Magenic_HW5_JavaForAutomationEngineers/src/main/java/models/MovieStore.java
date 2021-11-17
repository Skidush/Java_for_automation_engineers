package models;

import resources.MenuOption;
import resources.MovieFilter;
import utils.TestData;
import utils.UserHelper;

import java.util.ArrayList;
import java.util.List;

public class MovieStore {
    public MovieStore() { }

    private MovieDatabase movieDatabase;

    private MovieStoreUser authorizedUser;

    /**
     * Displays the main menu of the application. The very first menu on startup.
     */
    private void displayMainMenu() {
        System.out.println("==== Welcome to the Movie Store! Please login to use the system. ====");
        int userChoice = UserHelper.displayOptionsAndWaitForInput(MenuOption.MAIN_MENU_OPTIONS);

        if (MenuOption.MAIN_MENU_OPTIONS[userChoice].equals(MenuOption.MainMenu.LOGIN.toString())) {
            loginToMovieStore();
            displayAuthorizedMenuOptions();
        } else {
            System.out.print("Thank you for visiting the Movie Store. Please come again!");
        }
    }

    /**
     * Displays the menus a logged in user can only see. Contains the major functions of the app.
     */
    private void displayAuthorizedMenuOptions() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("==== What would you like to do? ====");
        int userChoice = UserHelper.displayOptionsAndWaitForInput(MenuOption.AUTHORIZED_MENU_OPTIONS);
        MenuOption.AuthorizedMenu menuOption = MenuOption.AuthorizedMenu.values()[userChoice];

        switch(menuOption) {
            case VIEW_MOVIE_CATALOGS:
                listMovies();
                displayViewMovieCatalogsMenuOptions();
                break;
            case VIEW_CART:
                authorizedUser.getMovieCart().displayCartDetails();
                displayViewCartMenu();
                break;
            case VIEW_CURRENT_MOVIE_RENTALS:
                authorizedUser.displayMoviesCurrentlyBeingRented();
                displayAuthorizedMenuOptions();
                break;
            case LOGOUT:
                System.out.println("Thank you for shopping!");
                displayMainMenu();
                break;
            default:
                System.out.println("Something went wrong. Please try again!");
                displayAuthorizedMenuOptions();
                break;
        }
    }

    /**
     * Displays the list of movies
     */
    private void displayViewMovieCatalogsMenuOptions() {
        System.out.println();
        System.out.println("==== What would you like to do? ====");
        int userChoice = UserHelper.displayOptionsAndWaitForInput(MenuOption.VIEW_MOVIE_CATALOGS_MENU_OPTIONS);
        MenuOption.ViewMovieCatalogsMenu menuOption = MenuOption.ViewMovieCatalogsMenu.values()[userChoice];

        switch(menuOption) {
            case SORT_MOVIES_LIST:
                displaySortMoviesMenu();
                break;
            case ADD_MOVIE_TO_CART:
                displaySelectMovieScreen();
                displayViewMovieCatalogsMenuOptions();
                break;
            case GO_BACK:
                displayAuthorizedMenuOptions();
                break;
            default:
                System.out.println("Something went wrong. Please try again!");
                displayViewMovieCatalogsMenuOptions();
                break;
        }
    }

    /**
     * Displays the sorting options for the movies list
     */
    private void displaySortMoviesMenu() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("==== How would you like to sort the movie list? ====");
        int userChoice = UserHelper.displayOptionsAndWaitForInput(MenuOption.FILTER_MOVIES_MENU_OPTIONS);
        MovieFilter movieFilter = MovieFilter.values()[userChoice];

        listMovies(movieFilter);
        displayViewMovieCatalogsMenuOptions();
    }

    /**
     * Displays selection options for movies
     */
    private void displaySelectMovieScreen() {
        System.out.println();
        System.out.print("Select the number of the movie you would like to add to cart: ");
        List<String> movieTitles = new ArrayList<>();
        List<Movie> movies = movieDatabase.getMovies();

        movies.forEach(movie -> movieTitles.add(movie.getTitle()));

        int movieNumberToView = UserHelper.validateUserInput(movieTitles.toArray(new String[0]));
        displayAddToCartMenu(movies.get(movieNumberToView));
    }

    /**
     * Displays the add to cart menu options
     * @param movieSelected the movie selected to be added to the cart
     */
    private void displayAddToCartMenu(Movie movieSelected) {
        int userChoice = UserHelper.displayOptionsAndWaitForInput(MenuOption.ADD_TO_CART_MENU_OPTIONS);
        MenuOption.AddToCartMenu menuOption = MenuOption.AddToCartMenu.values()[userChoice];

        switch(menuOption) {
            case PURCHASE_MOVIE:
                authorizedUser.getMovieCart().addMovieToPurchaseCart(movieSelected);
                break;
            case RENT_MOVIE:
                authorizedUser.getMovieCart().addMovieToRentalCart(movieSelected);
                break;
            case CANCEL:
                displayViewMovieCatalogsMenuOptions();
                break;
            default:
                System.out.println("Something went wrong. Please try again!");
                displayAddToCartMenu(movieSelected);
                break;
        }
    }

    /**
     * Displays the movies in the cart
     */
    private void displayViewCartMenu() {
        System.out.println();
        System.out.println("==== What would you like to do? ====");
        int userChoice = UserHelper.displayOptionsAndWaitForInput(MenuOption.VIEW_CART_MENU_OPTIONS);
        MenuOption.ViewCartMenu menuOption = MenuOption.ViewCartMenu.values()[userChoice];

        switch(menuOption) {
            case CHECKOUT_MOVIES:
                if(authorizedUser.getMovieCart().checkoutCart()) {
                    authorizedUser.addRentalMoviesInCartToCurrentRentals();
                    authorizedUser.getMovieCart().clearCart();
                }
                displayViewCartMenu();
                break;
            case REMOVE_MOVIE:
                displayRemoveMovieFromCartMenu();
                authorizedUser.getMovieCart().displayCartDetails();
                displayViewCartMenu();
                break;
            case GO_BACK:
                displayAuthorizedMenuOptions();
                break;
            default:
                System.out.println("Something went wrong. Please try again!");
                displayViewCartMenu();
                break;
        }
    }

    /**
     * Displays the confirmation and remove options of the cart page
     */
    private void displayRemoveMovieFromCartMenu() {
        System.out.println();
        System.out.print("Select the number of the movie you would like to remove from your cart: ");
        List<String> movieTitles = new ArrayList<>();
        List<Movie> movies = authorizedUser.getMovieCart().getAllMoviesInCart();

        movies.forEach(movie -> movieTitles.add(movie.getTitle()));

        int movieNumberToView = UserHelper.validateUserInput(movieTitles.toArray(new String[0]));
        authorizedUser.getMovieCart().removeMovieFromCart(movies.get(movieNumberToView));
    }

    /**
     * Authorizes the user to the application
     */
    private void loginToMovieStore() {
        System.out.println("==== Logging in to the Movie Store ====");
        System.out.print("Enter your username: ");
        String username = UserHelper.takeUserInputAsString();
        System.out.print("Enter your password: ");
        String password = UserHelper.takeUserInputAsString();

        authorizedUser = UserHelper.authorizeUser(username, password);

        if (authorizedUser == null) {
            System.out.println("User doesn't exist!");
            System.out.print("Try again? (Y/N): ");

            if (UserHelper.takeUserInputAsString().equalsIgnoreCase("Y")) {
                loginToMovieStore();
            } else {
                displayMainMenu();
            }
        }
    }

    /**
     * Overload method of listMovies without movieFilter
     */
    private void listMovies() {
        listMovies(null);
    }

    /**
     * Lists the movies based on the filter provided
     * @param movieFilter the sorting filter of the movie list
     */
    private void listMovies(MovieFilter movieFilter) {
        System.out.println();
        System.out.println();
        System.out.println();
        if (movieFilter != null) {
            movieDatabase.sortMovies(movieFilter);
            System.out.println("==== Available movies sorted by: " + movieFilter.toString() + " ====");
        } else {
            System.out.println("==== Available movies ====");
        }

        int idx = 0;
        for (Movie movie : movieDatabase.getMovies()) {
            System.out.println();
            movie.displayDetails(idx);
            idx++;
        }
    }

    /**
     * Main method of the application
     * @param args
     */
    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();

        TestData.InitializeTestUsers();
        TestData.InitializeTestMovies();
        movieStore.movieDatabase = TestData.movies;

        movieStore.displayMainMenu();
    }
}
