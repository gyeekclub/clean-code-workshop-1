package hu.gyeekclub.workshop;

public class Rental {

	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}
	
	public double getPrice() {
		return movie.getBasePrice() + movie.getAdditionalPrice(daysRented);
	}
	
	public int getFrequentRenterPoints() {
		if (movie instanceof NewReleaseMovie && daysRented > 1) {
			return 2;
		}

		return 1;
	}
}
