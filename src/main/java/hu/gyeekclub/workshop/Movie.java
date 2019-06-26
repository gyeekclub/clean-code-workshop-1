package hu.gyeekclub.workshop;

public class Movie {

	private String title;
	private MovieType priceCode;

	public Movie(String title, MovieType priceCode) {
		if (title == null)
		{
			throw new IllegalArgumentException("Do not allow null parameters to stay unpunished.");
		}
		
		this.title = title;
		this.priceCode = priceCode;
	}

	public MovieType getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(MovieType arg) {
		priceCode = arg;
	}

	public String getTitle() {
		return title;
	}
}
