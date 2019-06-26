package hu.gyeekclub.workshop;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

	private String name;
	private Vector<Rental> rentals = new Vector<>();

	public Customer(String name) {
		if(name == null){
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	public Vector<Rental> getRentals() {
		return rentals;
	}

	public void addRental(Rental arg) {
		if(arg == null){
			throw new IllegalArgumentException();
		}
		rentals.addElement(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		CustomerRentingStatement customerRentingStatement = new CustomerRentingStatement(this);
		return customerRentingStatement.toString();
	}
}
