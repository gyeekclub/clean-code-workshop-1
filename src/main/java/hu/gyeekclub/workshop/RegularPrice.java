package hu.gyeekclub.workshop;

public class RegularPrice implements Price {

	@Override
	public double getAmountByDays(int days) {
		return 2 + ((days > 2) ? (days - 2) * 1.5 : 0);
	}

	@Override
	public int getFrequentRentalPoints(int days) {
		return 1;
	}

}
