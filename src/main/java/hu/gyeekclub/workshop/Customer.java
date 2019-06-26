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

	public double getTotalRentalAmount() {
		Enumeration rentals = this.rentals.elements();
		double totalRentalAmount = 0;
		while (rentals.hasMoreElements()) {
			Rental rental = (Rental) rentals.nextElement();
			double thisAmount = rental.getAmount();
			totalRentalAmount += thisAmount;
		}
		return totalRentalAmount;
	}

	public int getTotalLoyaltyPoints() {
		Enumeration rentals = this.rentals.elements();
		int totalLoyaltyPoints = 0;
		while (rentals.hasMoreElements()) {
			Rental rental = (Rental) rentals.nextElement();
			double loyaltyPoints = rental.getFrequentPointsForRental();
			totalLoyaltyPoints += loyaltyPoints;
		}
		return totalLoyaltyPoints;
	}

	public String statement() {
		Enumeration rentals = this.rentals.elements();
		String rentalRecord = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			Rental rental = (Rental) rentals.nextElement();
			rentalRecord += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getAmount()) + "\n";
		}
		rentalRecord += "Amount owed is " + String.valueOf(this.getTotalRentalAmount()) + "\n";
		rentalRecord += "You earned " + String.valueOf(this.getTotalLoyaltyPoints()) + " frequent renter points";
		return rentalRecord;
	}

}
