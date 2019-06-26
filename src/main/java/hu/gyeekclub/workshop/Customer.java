package hu.gyeekclub.workshop;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

	private String name;
	private Vector<Rental> rentals = new Vector<>();

	public Customer(String name) {
		if (name == null) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	public void addRental(Rental rental) {
		if (rental == null) {
			throw new IllegalArgumentException();
		}
		rentals.addElement(rental);
	}

	public String getName() {
		return name;
	}

	public String createReceipt() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = this.rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			Rental rental = (Rental) rentals.nextElement();
			double amount = rental.CalculateAmount();

			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			frequentRenterPoints += rental.calculateFrequentRenterPoints();
			//show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(amount) + "\n";
			totalAmount += amount;
		}
		//add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}
}
