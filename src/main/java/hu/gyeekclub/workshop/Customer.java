package hu.gyeekclub.workshop;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

	private String name;
	private Vector<Rental> rentals = new Vector<>();

	int frequentRenterPoints = 0;
	
	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentals.addElement(arg);
	}

	public String getName() {
		return name;
	}
	
	private double getAmountForMovie(Rental rental) {
		double thisAmount = 0;
		switch (rental.getMovie().getPriceCode()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if (rental.getDaysRented() > 2)
					thisAmount += (rental.getDaysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				thisAmount += rental.getDaysRented() * 3;
				break;
			case Movie.CHILDRENS:
				thisAmount += 1.5;
				if (rental.getDaysRented() > 3)
					thisAmount += (rental.getDaysRented() - 3) * 1.5;
				break;
		}
		return thisAmount;
	}

	public String getStatement() {
		double thisAmount = 0;
		double totalAmount = 0;
		Enumeration rentals = this.rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		
		while (rentals.hasMoreElements()) {	
			Rental rental = (Rental) rentals.nextElement();
			//determine amounts for each line
			thisAmount = getAmountForMovie(rental);
			frequentRenterPoints = calculateFrequentRenterPoints(rental);
			//show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		
		//add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}

	private int calculateFrequentRenterPoints(Rental rental) {
		// add frequent renter points
		frequentRenterPoints++;
		// add bonus for a two day new release rental
		if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1) {
			frequentRenterPoints++;
		}
		return frequentRenterPoints;
	}
}
