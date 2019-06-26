package hu.gyeekclub.workshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalTests {

    @Test
    public void testChildrenRentalAmountCalculation() {
        Movie movie = new Movie("Winnie the Pooh", Movie.MovieTypes.CHILDRENS);
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
        Movie movie = new Movie("Winnie the Pooh", Movie.MovieTypes.CHILDRENS);
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
        Movie movie = new Movie("John Wick: Chapter 3 - Parabellum", Movie.MovieTypes.NEW_RELEASE);
        Rental rental = new Rental(movie, 1);
        Customer customer = new Customer("John Doe");
        customer.addRental(rental);

        String result = customer.statement();

        double expectedAmount = 3.0;
        String expectedAmountText = "Amount owed is " + expectedAmount;
        assertTrue(result.contains(expectedAmountText));

        int expectedFrequentRenterPoints = 1;
        String expectedFrequentRenterPointsText = "You earned " + expectedFrequentRenterPoints + " frequent renter points";
        assertTrue(result.contains(expectedFrequentRenterPointsText));
    }

    @Test
    public void testTwoDaysNewReleaseRentalAmountCalculation() {
        Movie movie = new Movie("John Wick: Chapter 3 - Parabellum", Movie.MovieTypes.NEW_RELEASE);
        Rental rental = new Rental(movie, 2);
        Customer customer = new Customer("John Doe");
        customer.addRental(rental);

        String result = customer.statement();

        double expectedAmount = 6.0;
        String expectedAmountText = "Amount owed is " + expectedAmount;
        assertTrue(result.contains(expectedAmountText));

        int expectedFrequentRenterPoints = 2;
        String expectedFrequentRenterPointsText = "You earned " + expectedFrequentRenterPoints + " frequent renter points";
        assertTrue(result.contains(expectedFrequentRenterPointsText));
    }

    @Test
    public void testMoreThanTwoDaysNewReleaseRentalAmountCalculation() {
        Movie movie = new Movie("John Wick: Chapter 3 - Parabellum", Movie.MovieTypes.NEW_RELEASE);
        Rental rental = new Rental(movie, 6);
        Customer customer = new Customer("John Doe");
        customer.addRental(rental);

        String result = customer.statement();

        double expectedAmount = 18.0;
        String expectedAmountText = "Amount owed is " + expectedAmount;
        assertTrue(result.contains(expectedAmountText));

        int expectedFrequentRenterPoints = 2;
        String expectedFrequentRenterPointsText = "You earned " + expectedFrequentRenterPoints + " frequent renter points";
        assertTrue(result.contains(expectedFrequentRenterPointsText));
    }

    @Test
    void testRegularRentalAmountCalculation() {
        Customer customer = new Customer("John Doe");
        Movie movie = new Movie("Venom", Movie.MovieTypes.REGULAR);
        Rental rental = new Rental(movie, 1);
        customer.addRental(rental);
        String result = customer.statement();

        double expectedAmount = 2.0;
        String expected = "Amount owed is " + expectedAmount;
        assertTrue(result.contains(expected));
      }

      @Test
      void testLongTermRegularRentalAmountCalculation() {
        Customer customer = new Customer("John Doe");
        Movie movie = new Movie("Venom", Movie.MovieTypes.REGULAR);
        Rental rental = new Rental(movie, 7);
        customer.addRental(rental);
        String result = customer.statement();

        double expectedAmount = 9.5;
        String expected = "Amount owed is " + expectedAmount;
        assertTrue(result.contains(expected));
      }
}
