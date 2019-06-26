package hu.gyeekclub.workshop;

public abstract class Movie {

	private String title;

	public Movie(String title) {
		if(title == null){
			throw new IllegalArgumentException();
		}
		this.title = title;
	}


	public String getTitle() {
		return title;
	}

	public abstract double getBasePrice();
	public abstract double getIncriesedPrice(int rentedDays);
	public abstract boolean isFrequentRent(int rentedDays);

}
