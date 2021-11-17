package resources;

public enum MovieFilter {
    GENRE("Genre"),
    TITLE("Title"),
    COUNTRY("Country"),
    YEAR("Year"),
    PRICE("Price"),
    RENTAL_PRICE("Rental Price"),
    DESCRIPTION("Description");

    private final String text;

    MovieFilter(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
