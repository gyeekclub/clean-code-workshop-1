package hu.gyeekclub.workshop;

import java.util.Set;

public class Movie {

	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String title;
	private Price price;

	public Movie(String title, int priceCode) {
		if (null == title) {
			throw new IllegalArgumentException();
		}
		this.title = title;
		if (!Set.of(CHILDRENS, REGULAR, NEW_RELEASE).contains(priceCode)) {
			throw new IllegalArgumentException();
		}
		setPriceByCode(priceCode);
	}

	private void setPriceByCode(int priceCode) {
		switch(priceCode) {
		case CHILDRENS:
			price = new ChildrenPrice();
			break;
		case REGULAR:
			price = new RegularPrice();
			break;
		case NEW_RELEASE:
			price = new NewReleasePrice();
			break;
			default:
				throw new IllegalArgumentException();
		}
	}
	
	public double getAmountByDays(int days) {
		return price.getAmountByDays(days);
	}

	public String getTitle() {
		return title;
	}

	public boolean isNewRelease() {
		return false;
	}

	public int getFrequentRentalPoints(int daysRented) {
		return price.getFrequentRentalPoints(daysRented);
	}
}
