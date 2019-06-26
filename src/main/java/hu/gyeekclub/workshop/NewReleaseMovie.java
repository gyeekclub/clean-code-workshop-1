package hu.gyeekclub.workshop;

public class NewReleaseMovie extends Movie {

	public NewReleaseMovie(String title) {
		super(title);
	}

	public int getPriceCode() {
		return 1;
	}

	public double getBasePrice() {
		return 0.0;
	}
}
