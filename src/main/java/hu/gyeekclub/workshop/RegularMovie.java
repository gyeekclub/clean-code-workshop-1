package hu.gyeekclub.workshop;

public class RegularMovie extends Movie {


    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public double getBasePrice() {
        return 2;
    }

    @Override
    public double getIncriesedPrice(int rentedDays) {
        if (rentedDays> 2){
            return getBasePrice() + (rentedDays - 2) * 1.5;
        }
        return getBasePrice();
    }

    @Override
    public boolean isFrequentRent(int rentedDays) {
        return false;
    }
}
