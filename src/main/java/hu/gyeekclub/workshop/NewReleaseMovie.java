package hu.gyeekclub.workshop;

public class NewReleaseMovie extends Movie{

    public static final int NEW_RELEASE_PRICE_CODE = 1;

    public NewReleaseMovie(String title) {
        super(title, NEW_RELEASE_PRICE_CODE);
    }

    @Override
    public double CalculateAmount(int daysRented) {
        return  daysRented * 3;
    }

    @Override
    public double calculateFrequentRenterPoints(int daysRented) {
        if (daysRented > 1) {
            return  1;
        }
        return 0;
    }

}
