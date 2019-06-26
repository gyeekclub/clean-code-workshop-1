package hu.gyeekclub.workshop;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

	private String name;
	private Vector<Rental> rentals = new Vector<>();

	public Customer(String name) {
		if (name != null) {
			this.name = name;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void addRental(Rental arg) {
		if (arg == null) {
			throw new IllegalArgumentException();
		}
		rentals.addElement(arg);
	}

	public String getName() {
		return name;
	}

	private double CalculateAmount(int type, int daysRent) {
		double thisAmount = 0;
		switch (type) {
			case Movie.REGULAR:
				thisAmount += 2;
				if (daysRent > 2)
					thisAmount += (daysRent - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				thisAmount += daysRent * 3;
				break;
			case Movie.CHILDRENS:
				thisAmount += 1.5;
				if (daysRent > 3)
					thisAmount += (daysRent - 3) * 1.5;
				break;
			}
		
		return thisAmount;
	}

	public int increaseFrequentRenterPoints(int type, int daysRent) {
		int frequentRenterPoints = 1;
		if ((type == Movie.NEW_RELEASE) && daysRent > 1) frequentRenterPoints++;
		return frequentRenterPoints;
	} 

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = this.rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = (Rental) rentals.nextElement();
			//determine amounts for each line
			int movieType = each.getMovie().getPriceCode();
			int daysRent = each.getDaysRented();
			thisAmount = CalculateAmount(movieType, daysRent); 

			frequentRenterPoints += increaseFrequentRenterPoints(movieType, daysRent);
			//show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		//add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}
}
