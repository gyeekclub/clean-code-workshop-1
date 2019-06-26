package hu.gyeekclub.workshop;

public interface Price {

	double getAmountByDays(int days);
	
	int getFrequentRentalPoints(int days);
}
