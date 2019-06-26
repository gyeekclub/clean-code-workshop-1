package hu.gyeekclub.workshop;

public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        checkPriceCode(priceCode);
        this.title = title;
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int arg) {
        checkPriceCode(arg);
        priceCode = arg;
    }

    public String getTitle() {
        return title;
    }

    private void checkPriceCode(int priceCode) {
        if (priceCode < 0 || priceCode > 2) {
            throw new IllegalArgumentException();
        }
    }
}
