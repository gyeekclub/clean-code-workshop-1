package hu.gyeekclub.workshop;

public class NewReleasePrice implements Price {

	@Override
	public double getAmountByDays(int days) {
		return days * 3;
	}

	@Override
	public int getFrequentRentalPoints(int days) {
		return days > 1 ? 2 : 1;
	}

}
