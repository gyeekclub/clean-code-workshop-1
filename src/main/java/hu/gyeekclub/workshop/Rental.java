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
        
        public double getAmountByTypeAndDay(){
            double amount=0;
            switch (movie.getPriceCode()) {
                case REGULAR:
                    amount += 2;
                    if (daysRented > 2) {
                        amount += (daysRented - 2) * 1.5;
                    }
                    break;
                case NEW_RELEASE:
                    amount += daysRented * 3;
                    break;
                case CHILDRENS:
                    amount += 1.5;
                    if (daysRented > 3) {
                        amount += (daysRented - 3) * 1.5;
                    }
                    break;
            }
            return amount;
            
        }
}
