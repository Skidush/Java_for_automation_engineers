package models;

import java.util.Comparator;

public class Movie implements Comparable<Movie> {
    private final String title;
    private final String genre;
    private final int year;
    private final String country;
    private final double price;
    private final double rentalPrice;
    private final String description;

    public Movie(String title, String genre, int year, String country, double price, double rentalPrice, String description) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.country = country;
        this.price = price;
        this.rentalPrice = rentalPrice;
        this.description = description;
    }

    /**
     * @return the title of the Movie
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the genre of the Movie
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @return the year when the Movie was released
     */
    public int getYear() {
        return year;
    }

    /**
     * @return the country of origin of the Movie
     */
    public String getCountry() {
        return country;
    }

    /**
     * @return the purchasing price of the Movie
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return the rental of the Movie
     */
    public double getRentalPrice() {
        return rentalPrice;
    }

    /**
     * @return the description of the Movie
     */
    public String getDescription() {
        return description;
    }

    /**
     * Displays the complete details of the movie in human readable text
     * @param idx the index of the movie. Used for tracking in the console
     */
    public void displayDetails(int idx) {
        System.out.println(idx + ". ==========");
        System.out.println("Title:             " + this.getTitle());
        System.out.println("Genre:             " + this.getGenre());
        System.out.println("Year:              " + this.getYear());
        System.out.println("Country:           " + this.getCountry());
        System.out.println("Description:       " + this.getDescription());
        System.out.println("Buy Price:         " + this.getPrice());
        System.out.println("Rental Price:      " + this.getRentalPrice());
    }

    @Override
    public int compareTo(Movie otherMovie) {
        return this.getTitle().compareTo(otherMovie.getTitle());
    }
}

/**
 * Below are the comparators used for the sorting of the movies in the application.
 * Very self explanatory
 */
class TitleComparator implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        return m1.getTitle().compareTo(m2.getTitle());
    }
}

class GenreComparator implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        return m1.getGenre().compareTo(m2.getGenre());
    }
}

class YearComparator implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        return Integer.compare(m1.getYear(), m2.getYear());
    }
}

class CountryComparator implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        return m1.getCountry().compareTo(m2.getCountry());
    }
}

class PriceComparator implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        return Double.compare(m1.getPrice(), m2.getPrice());
    }
}

class RentalPriceComparator implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        return Double.compare(m1.getRentalPrice(), m2.getRentalPrice());
    }
}

class DescriptionComparator implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        return m1.getDescription().compareTo(m2.getDescription());
    }
}