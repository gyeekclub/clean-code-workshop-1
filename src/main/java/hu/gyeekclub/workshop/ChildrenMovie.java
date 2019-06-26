package hu.gyeekclub.workshop;

public class ChildrenMovie extends Movie {
    public static final int CHILDREN_PRICE_CODE = 2;

    public ChildrenMovie(String title) {
        super(title, CHILDREN_PRICE_CODE);
    }

    @Override
    public double CalculateAmount(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3)
            amount += (daysRented - 3) * 1.5;
        return amount;
    }

    @Override
    public double calculateFrequentRenterPoints(int daysRented) {
        return 0;
    }
}
