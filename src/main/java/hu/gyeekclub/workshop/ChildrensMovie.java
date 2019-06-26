package hu.gyeekclub.workshop;

public class ChildrensMovie extends Movie {

	public ChildrensMovie(String title) {
		super(title);
	}

	public int getPriceCode() {
		return 2;
	}

	public double getBasePrice() {
		return 1.5;
	}
	
	public double getAdditionalPrice(int daysRented) {
		if (daysRented > 3) {
			return (daysRented - 3) * 1.5;
		}
		return 0.0;
	}
}
