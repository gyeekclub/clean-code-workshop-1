package hu.gyeekclub.workshop;

public class ChildrenMovie extends Movie {


    public ChildrenMovie(String title ) {
        super(title);
    }

    @Override
    public double getBasePrice() {
        return 1.5;
    }

    @Override
    public double getIncriesedPrice(int rentedDays) {
        if (rentedDays> 3){
            return getBasePrice() + (rentedDays - 3) * 1.5;
        }
        return getBasePrice();
    }

    @Override
    public boolean isFrequentRent(int rentedDays) {
        return false;
    }
}
