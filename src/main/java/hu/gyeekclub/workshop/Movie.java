package hu.gyeekclub.workshop;

public class Movie {

    public enum MovieTypes {
        REGULAR,
        NEW_RELEASE,
        CHILDRENS;
    }

    private String title;
    private MovieTypes priceCode;

    public Movie(String title, MovieTypes priceCode) {
        checkMovieTitle(title);
        this.title = title;
        this.priceCode = priceCode;
    }

    public MovieTypes getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(MovieTypes arg) {
        priceCode = arg;
    }

    public String getTitle() {
        return title;
    }


    private void checkMovieTitle(String movieTitle) {
        if (movieTitle == null) {
            throw new IllegalArgumentException();
        }
    }
}
