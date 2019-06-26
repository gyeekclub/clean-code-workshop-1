package hu.gyeekclub.workshop;

abstract public class Movie {

	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	protected String title;

	public Movie(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	
	abstract public int getPriceCode();
	abstract public double getBasePrice();
	abstract public double getAdditionalPrice(int daysRented);
}
