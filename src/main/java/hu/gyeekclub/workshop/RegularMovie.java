package hu.gyeekclub.workshop;

public class RegularMovie extends Movie {

    public static final int REGULAR_PRICE_CODE = 0;

    public RegularMovie(String title) {
        super(title, REGULAR_PRICE_CODE);
    }

    @Override
    public double CalculateAmount(int daysRented) {
        double amount = 2;
        if (daysRented > 2)
            amount += (daysRented - 2) * 1.5;
        return amount;
    }

    @Override
    public double calculateFrequentRenterPoints(int daysRented) {
        return 0;
    }
}
