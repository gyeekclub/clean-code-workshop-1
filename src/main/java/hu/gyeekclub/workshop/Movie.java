package hu.gyeekclub.workshop;

import java.util.Set;

public class Movie {

	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String title;
	private int priceCode;

	public Movie(String title, int priceCode) {
		if (null == title) {
			throw new IllegalArgumentException();
		}
		this.title = title;
		if (!Set.of(CHILDRENS, REGULAR, NEW_RELEASE).contains(priceCode)) {
			throw new IllegalArgumentException();
		}
		this.priceCode = priceCode;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int arg) {
		priceCode = arg;
	}

	public String getTitle() {
		return title;
	}
}
