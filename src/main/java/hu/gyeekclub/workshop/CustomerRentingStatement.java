package hu.gyeekclub.workshop;

import java.util.Enumeration;

public class CustomerRentingStatement {
    private Customer customer;
    private double totalAmount;
    private int frequentRenterPoints;

    public CustomerRentingStatement(Customer customer) {
        this.customer = customer;
        totalAmount = 0;
        frequentRenterPoints = 0;
        calculate();
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    protected void calculate() {
        Enumeration rentals = customer.getRentals().elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            int daysRented = each.getDaysRented();

            frequentRenterPoints++;
            if (each.getMovie().isFrequentRent(daysRented)) {
                frequentRenterPoints++;
            }

            totalAmount += each.getMovie().getIncriesedPrice(daysRented);
        }
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Rental Record for %s \n %s", customer.getName(), movieRentalInfo()));
        result.append(String.format("Amount owed is %s \n", totalAmount));
        result.append(String.format("You earned %s frequent renter points", frequentRenterPoints));
        return result.toString();
    }

    protected String movieRentalInfo() {
        StringBuilder result = new StringBuilder();
        Enumeration rentals = customer.getRentals().elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result.append("\t")
                    .append(each.getMovie().getTitle())
                    .append("\t")
                    .append(each.getMovie().getIncriesedPrice(each.getDaysRented()))
                    .append("\n");
        }
        return result.toString();
    }

}
