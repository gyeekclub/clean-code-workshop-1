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

	public double getAmount() {
		double thisAmount = 0;
		switch (this.getMovie().getPriceCode()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if (this.getDaysRented() > 2)
					thisAmount += (this.getDaysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				thisAmount += this.getDaysRented() * 3;
				break;
			case Movie.CHILDRENS:
				thisAmount += 1.5;
				if (this.getDaysRented() > 3)
					thisAmount += (this.getDaysRented() - 3) * 1.5;
				break;
		}
	return thisAmount;
	}

	public int getFrequentPointsForRental() {
		int frequentRenterPoints = 0;
		// add frequent renter points
		frequentRenterPoints++;
		// add bonus for a two day new release rental
		if ((this.getMovie().getPriceCode() == Movie.NEW_RELEASE) && this.getDaysRented() > 1) frequentRenterPoints++;
		//show figures for this rental
		return frequentRenterPoints;
	}

}
