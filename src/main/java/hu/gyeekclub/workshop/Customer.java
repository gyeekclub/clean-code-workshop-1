package hu.gyeekclub.workshop;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

	private String name;
	private Vector<Rental> rentals = new Vector<>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentals.addElement(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalRentalAmount = 0;
		int totalLoyaltyPoints = 0;
		Enumeration rentals = this.rentals.elements();
		String rentalRecord = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			Rental rental = (Rental) rentals.nextElement();
			double thisAmount = rental.getAmount();
			//determine amounts for each line
			rentalRecord += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalRentalAmount += thisAmount;
			totalLoyaltyPoints += rental.getFrequentPointsForRental();
		}

		//add footer lines
		rentalRecord += "Amount owed is " + String.valueOf(totalRentalAmount) + "\n";
		rentalRecord += "You earned " + String.valueOf(totalLoyaltyPoints) + " frequent renter points";
		return rentalRecord;
	}





}
