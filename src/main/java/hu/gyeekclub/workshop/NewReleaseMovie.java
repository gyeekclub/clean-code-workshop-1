package hu.gyeekclub.workshop;

public class NewReleaseMovie extends Movie {


    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public double getBasePrice() {
        return 0;
    }

    @Override
    public double getIncriesedPrice(int rentedDays) {
            return getBasePrice() + rentedDays * 3 ;
    }

    @Override
    public boolean isFrequentRent(int rentedDays) {
        return rentedDays > 1;
    }
}
