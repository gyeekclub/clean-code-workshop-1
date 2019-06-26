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

	public String toString() {

		Enumeration rentals = this.rentals.elements();
		String result = "Rental Record for " + getName() + "\n";

		while (rentals.hasMoreElements()) {

			Rental rental = (Rental) rentals.nextElement();

			result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getMoviePrice()) + "\n";

		}

		//add footer lines
		result += "Amount owed is " + String.valueOf(calculateTotalAmount()) + "\n";
		result += "You earned " + String.valueOf(calculateFrequentPoints()) + " frequent renter points";

		return result;
	}

	private double calculateTotalAmount(){

		double totalAmount = 0;
		Enumeration rentals = this.rentals.elements();

		while (rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental rental = (Rental) rentals.nextElement();

			thisAmount = rental.getMoviePrice();

			totalAmount += thisAmount;
		}
		return totalAmount;
	}


	private int calculateFrequentPoints(){

		Enumeration rentals = this.rentals.elements();
		int frequentRenterPoints = 0;

		while (rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental rental = (Rental) rentals.nextElement();


			frequentRenterPoints = rental.calculateFrequentRenterPoints(frequentRenterPoints);


		}
		return  frequentRenterPoints;

	}




}
