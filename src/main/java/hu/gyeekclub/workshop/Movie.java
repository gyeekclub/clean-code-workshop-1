package hu.gyeekclub.workshop;

public abstract class Movie {




	private String title;
	private int priceCode;

	public Movie(String title, int priceCode) {
		if (title == null) {
			throw new IllegalArgumentException();
		}
		if (priceCode > 2 ) {
			throw new IllegalArgumentException();
		}
		this.title = title;
		this.priceCode = priceCode;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int priceCode) {
		if (priceCode > 2 ) {
			throw new IllegalArgumentException();
		}
		this.priceCode = priceCode;
	}

	public String getTitle() {
		return title;
	}

	public abstract double CalculateAmount(int daysRented);
	public abstract double calculateFrequentRenterPoints(int daysRented);
}
