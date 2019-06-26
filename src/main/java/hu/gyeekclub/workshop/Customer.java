package hu.gyeekclub.workshop;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

	private String name;
	private Vector<Rental> rentals = new Vector<>();

	public Customer(String name) {
		if (null == name) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	public void addRental(Rental rental) {
		if (null == rental) {
			throw new IllegalArgumentException();
		}
		rentals.addElement(rental);
	}

	public String getName() {
		return name;
	}

	public String printBill() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";
		for (Rental rental : rentals) {
			//determine amounts for each line
			double thisAmount = rental.getAmount();
			// add frequent renter points
			frequentRenterPoints += rental.countFrequentRenterPoints();
			//show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		//add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}
}
