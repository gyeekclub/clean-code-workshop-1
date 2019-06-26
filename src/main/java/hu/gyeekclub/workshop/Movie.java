package hu.gyeekclub.workshop;

public class Movie {

	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String title;
	private int priceCode;

	public Movie(String title, int priceCode) {

		if (priceCode == CHILDRENS || priceCode == REGULAR || priceCode == NEW_RELEASE) {
			this.priceCode = priceCode;
		} else {
			throw new IllegalArgumentException();
		}
		this.title = title;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int arg) {
		if (priceCode == CHILDRENS || priceCode == REGULAR || priceCode == NEW_RELEASE) {
			priceCode = arg;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public String getTitle() {
		return title;
	}
}
