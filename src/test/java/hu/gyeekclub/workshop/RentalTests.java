package hu.gyeekclub.workshop;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RentalTests {

    @Test
    public void testChildrenRentalAmountCalculation() {
        Movie movie = new Movie("Winnie the Pooh", Movie.CHILDRENS);
        Rental rental = new Rental(movie, 3);
        Customer customer = new Customer("Judy Jusper");
        customer.addRental(rental);
        String result = customer.statement();

        double expectedAmount = 1.5;
        String expected = "Amount owed is " + expectedAmount;
        assertTrue(result.contains(expected));
    }

    @Test
    public void testLongTermChildrenRentalAmountCalculation() {
        Movie movie = new Movie("Winnie the Pooh", Movie.CHILDRENS);
        Rental rental = new Rental(movie, 6);
        Customer customer = new Customer("Judy Jusper");
        customer.addRental(rental);
        String result = customer.statement();

        double expectedAmount = 6.0;
        String expected = "Amount owed is " + expectedAmount;
        assertTrue(result.contains(expected));
    }

    @Test
    public void testOneDayNewReleaseRentalAmountCalculation() {
        Movie movie1 = new Movie("John Wick: Chapter 3 - Parabellum", Movie.NEW_RELEASE);
        Rental rental1 = new Rental(movie1, 1);
        Customer customer1 = new Customer("John Doe");
        customer1.addRental(rental1);

        String customer1Statement = customer1.statement();

        assertEquals(customer1Statement,
                "Rental Record for John Doe\n\tJohn Wick: Chapter 3 - Parabellum\t3.0\nAmount owed is 3.0\nYou earned 1 frequent renter points");
    }

    @Test
    public void testTwoDaysNewReleaseRentalAmountCalculation() {
        Movie movie1 = new Movie("John Wick: Chapter 3 - Parabellum", Movie.NEW_RELEASE);
        Rental rental1 = new Rental(movie1, 2);
        Customer customer1 = new Customer("John Doe");
        customer1.addRental(rental1);

        String customer1Statement = customer1.statement();

        assertEquals(customer1Statement,
                "Rental Record for John Doe\n\tJohn Wick: Chapter 3 - Parabellum\t6.0\nAmount owed is 6.0\nYou earned 2 frequent renter points");
    }

    @Test
    public void testMoreThanTwoDaysNewReleaseRentalAmountCalculation() {
        Movie movie1 = new Movie("John Wick: Chapter 3 - Parabellum", Movie.NEW_RELEASE);
        Rental rental1 = new Rental(movie1, 6);
        Customer customer1 = new Customer("John Doe");
        customer1.addRental(rental1);

        String customer1Statement = customer1.statement();

        assertEquals(
            customer1Statement,
            "Rental Record for John Doe\n\tJohn Wick: Chapter 3 - Parabellum\t18.0\nAmount owed is 18.0\nYou earned 2 frequent renter points");
    }
}
