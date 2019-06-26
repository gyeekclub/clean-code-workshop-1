package hu.gyeekclub.workshop;

public class Rental {

	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		if (null == movie || daysRented < 1) {
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

	public int countFrequentRenterPoints() {
		return movie.getFrequentRentalPoints(daysRented); 
	}

	public double getAmount() {
		return movie.getAmountByDays(daysRented);
	}
}
