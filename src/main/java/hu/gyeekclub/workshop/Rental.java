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

	public double getMoviePrice() {

		double baseAmount = 0;

		switch (movie.getPriceCode()) {
			case Movie.REGULAR:
				baseAmount += 2;
				if (this.getDaysRented()> 2)
					baseAmount += (this.getDaysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				baseAmount += this.getDaysRented() * 3;
				break;
			case Movie.CHILDRENS:
				baseAmount += 1.5;
				if (this.getDaysRented() > 3)
					baseAmount += (this.getDaysRented() - 3) * 1.5;
				break;
		}
		return baseAmount;
	}

	public int calculateFrequentRenterPoints(int frequentRenterPoints) {
		frequentRenterPoints++;
		// add bonus for a two day new release rental
		if (isLongPeriodRentalForNewRelease()) frequentRenterPoints++;

		return frequentRenterPoints;
	}

	private boolean isLongPeriodRentalForNewRelease() {
		return (this.getMovie().getPriceCode() == Movie.NEW_RELEASE) && this.getDaysRented() > 1;
	}

}
