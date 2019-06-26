package hu.gyeekclub.workshop;

public class ChildrenPrice implements Price {

	@Override
	public double getAmountByDays(int days) {
		return 1.5 + ((days > 3) ? (days - 3) * 1.5 : 0);
	}

	@Override
	public int getFrequentRentalPoints(int days) {
		return 1;
	}

}
