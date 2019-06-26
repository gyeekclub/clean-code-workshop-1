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
	
	public double getAmount() {
		double thisAmount = 0.0;
		switch (movie.getPriceCode()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if (daysRented > 2)
					thisAmount += (daysRented - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				thisAmount += daysRented * 3;
				break;
			case Movie.CHILDRENS:
				thisAmount += 1.5;
				if (daysRented > 3)
					thisAmount += (daysRented - 3) * 1.5;
				break;
		}
		return thisAmount;
	}

	public int countFrequentRenterPoints() {
		return (movie.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1 ? 2 : 1; 
	}
}
