package hu.gyeekclub.workshop;

public class Rental {

	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		if (movie == null) {
			throw new IllegalArgumentException();
		}
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public double CalculateAmount() {
		return movie.CalculateAmount(daysRented);
	}

	public double calculateFrequentRenterPoints() {
		return  movie.calculateFrequentRenterPoints(daysRented);
	}
}
