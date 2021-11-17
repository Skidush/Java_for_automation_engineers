package resources;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class MenuOption {
    private static String[] enumAsStringArray(final EnumSet<?> optionsEnum) {
        List<String> options = new ArrayList<>();

        optionsEnum.forEach(option -> {
            options.add(option.toString());
        });

        return options.toArray(new String[0]);
    }

    public enum MainMenu {
        LOGIN("Login"),
        EXIT("Exit");

        private final String text;

        MainMenu(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    public enum AuthorizedMenu {
        VIEW_MOVIE_CATALOGS("View movie catalogs"),
        VIEW_CURRENT_MOVIE_RENTALS("View current movie rentals"),
        VIEW_CART("View cart"),
        LOGOUT("Logout");

        private final String text;

        AuthorizedMenu(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    public enum ViewMovieCatalogsMenu {
        SORT_MOVIES_LIST("Sort movies list"),
        ADD_MOVIE_TO_CART("Add movie to cart"),
        GO_BACK("Go back");

        private final String text;

        ViewMovieCatalogsMenu(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    public enum AddToCartMenu {
        PURCHASE_MOVIE("Purchase movie"),
        RENT_MOVIE("Rent movie"),
        CANCEL("Cancel");

        private final String text;

        AddToCartMenu(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    public enum ViewCartMenu {
        CHECKOUT_MOVIES("Checkout movies"),
        REMOVE_MOVIE("Remove movie"),
        GO_BACK("Go back");

        private final String text;

        ViewCartMenu(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }


    public static final String[] MAIN_MENU_OPTIONS = enumAsStringArray(EnumSet.allOf(MainMenu.class));
    public static final String[] AUTHORIZED_MENU_OPTIONS = enumAsStringArray(EnumSet.allOf(AuthorizedMenu.class));
    public static final String[] VIEW_MOVIE_CATALOGS_MENU_OPTIONS = enumAsStringArray(EnumSet.allOf(ViewMovieCatalogsMenu.class));
    public static final String[] FILTER_MOVIES_MENU_OPTIONS = enumAsStringArray(EnumSet.allOf(MovieFilter.class));
    public static final String[] ADD_TO_CART_MENU_OPTIONS = enumAsStringArray(EnumSet.allOf(AddToCartMenu.class));
    public static final String[] VIEW_CART_MENU_OPTIONS = enumAsStringArray(EnumSet.allOf(ViewCartMenu.class));
}
