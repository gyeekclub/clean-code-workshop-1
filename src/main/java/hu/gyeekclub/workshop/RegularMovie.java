package hu.gyeekclub.workshop;

public class RegularMovie extends Movie {
	
	public RegularMovie(String title) {
		super(title);
	}
	
	public int getPriceCode() {
		return 0;
	}

	public double getBasePrice() {
		return 2.0;
	}
	
	public double getAdditionalPrice(int daysRented) {
		if (daysRented > 2) {
			return (daysRented - 2) * 1.5;
		}
		return 0.0;
	}
}
