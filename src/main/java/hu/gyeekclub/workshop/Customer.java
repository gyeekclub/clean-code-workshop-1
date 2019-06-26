package hu.gyeekclub.workshop;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

	private String name;
	private Vector<Rental> rentals = new Vector<>();

	public Customer(String name) {
		if (name == null)
		{
			throw new IllegalArgumentException("Do not allow null parameters to stay unpunished.");
		}
		
		this.name = name;
	}

	public void addRental(Rental arg) {
		if (arg == null)
		{
			throw new IllegalArgumentException("Do not allow null parameters to stay unpunished.");
		}
		
		rentals.addElement(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = this.rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental rental = (Rental) rentals.nextElement();
			//determine amounts for each line
			thisAmount = getAmount(rental);
			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((rental.getMovie().getPriceCode() == MovieType.NEW_RELEASE) && rental.getDaysRented() > 1) frequentRenterPoints++;
			//show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		//add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}

	private double getAmount(Rental rental) {
		double thisAmount = 0;
		
		switch (rental.getMovie().getPriceCode()) {
			case REGULAR:
				thisAmount += 2;
				if (rental.getDaysRented() > 2)
					thisAmount += (rental.getDaysRented() - 2) * 1.5;
				break;
			case NEW_RELEASE:
				thisAmount += rental.getDaysRented() * 3;
				break;
			case CHILDRENS:
				thisAmount += 1.5;
				if (rental.getDaysRented() > 3)
					thisAmount += (rental.getDaysRented() - 3) * 1.5;
				break;
		}
		return thisAmount;
	}
}
