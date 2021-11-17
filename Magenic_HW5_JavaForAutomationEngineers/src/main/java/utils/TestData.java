package utils;

import models.Movie;
import models.MovieDatabase;
import models.MovieStoreUser;

import java.util.ArrayList;
import java.util.List;

public class TestData {
    public static final List<MovieStoreUser> users = new ArrayList<>();
    public static final MovieDatabase movies = new MovieDatabase();

    public static void InitializeTestUsers() {
        users.add(new MovieStoreUser("pablo_escobar", "password"));
        users.add(new MovieStoreUser("saul_goodman", "password"));
        users.add(new MovieStoreUser("russian_doll", "password"));
        users.add(new MovieStoreUser("walter_white", "password"));
        users.add(new MovieStoreUser("lalo", "password"));
    }

    public static void InitializeTestMovies() {
        movies.add(new Movie(
                "Shade", "Suspense", 2002, "United States", 1.49, 0.49,
                "The hand is quicker than the eye. In LA's underground gambling scene, hustlers get hustle and fortunes ride on every deal."));
        movies.add(new Movie(
                "Law Abiding Citizen", "Action", 2009, "United States", 3.99, 0.99,
                "A psychopathic mastermind, captured for the murder of his wife's killers, threatens to unleash a gruesome killing spree" +
                        " across the city of Philadelphia unless he is released."));
        movies.add(new Movie(
                "The Vault", "Horror", 2017, "United States", 2.99, 0.99,
                "The estranged sisters hatch a scheme to rob a bank to save their brother. The heist begins smoothly, but mayhem soon" +
                        " ensues when the defiant manager sends them to a basement-level vault where something truly evil dwells."));
        movies.add(new Movie(
                "Intouchables", "Drama", 2012, "France", 2.99, 0.99,
                "When Driss, an ex-con from the projects, is hired to take care of an French aristocrat named Philippe, his newfound job" +
                        " quickly becomes an unpredictable adventure."));
        movies.add(new Movie(
                "Amelie", "Comedy", 2001, "France", 1.49, 0.49,
                "Amelie, an innocent and naive girl in Paris, with her own sense of justice, decides to help those around her and along the way" +
                        " discovers love."));
        movies.add(new Movie(
                "Budapest", "Comedy", 2018, "France", 3.99, 0.99,
                "The college friends become bachelor party planners to escape the corporate rat race, promising to fulfill their client's" +
                        " wildest dreams."));
        movies.add(new Movie(
                "Heneral Luna", "Biography", 2015, "Philippines", 1.49, 0.49,
                "A historical biopic film depicting General Antonio Luna's leadership of the Philippine Revolutionary Army during the" +
                        " Philippine-American War."));
        movies.add(new Movie(
                "The Super Parental Guardians", "Comedy", 2016, "Philippines", 1.49, 0.49,
                "After his best friend's death, Arci takes charge of her two boisterous children with the help from their gang-affiliated uncle."));
        movies.add(new Movie(
                "D' Anothers", "Comedy", 2005, "Philippines", 1.49, 0.49,
                "A man makes the frightening discover that the mansion he inherited contains a portal to the afterlife and that only he has the" +
                        " power to open it, which will allow the restless spirits inhabiting the mansion passage into the afterlife."));
        movies.add(new Movie(
                "Agent X44", "Comedy", 2007, "Philippines", 1.49, 0.49,
                "A fledgling agent does everything he can prove himself when he is assigned to find a stolen dagger once owned by a national hero."));
        movies.add(new Movie(
                "The Platform", "Thriller", 2019, "Spain", 3.99, 0.99,
                "In the future, prisoners housed in vertical cells watch as inmates in the upper cells are fed while those below starve."));
    }
}
