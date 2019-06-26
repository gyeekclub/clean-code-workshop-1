package hu.gyeekclub.workshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalTests {

	@Test
    public void testZeroAmountCalculation() {
        Customer customer = new Customer("Judy Jusper");
        String result = customer.printBill();

        double expectedAmount = 0;
        String expected = "Amount owed is " + expectedAmount;
        assertTrue(result.contains(expected));
    }

	
    @Test
    public void testChildrenRentalAmountCalculation() {
        Movie movie = new Movie("Winnie the Pooh", Movie.CHILDRENS);
        Rental rental = new Rental(movie, 3);
        Customer customer = new Customer("Judy Jusper");
        customer.addRental(rental);
        String result = customer.printBill();

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
        String result = customer.printBill();

        double expectedAmount = 6.0;
        String expected = "Amount owed is " + expectedAmount;
        assertTrue(result.contains(expected));
    }

    @Test
    public void testOneDayNewReleaseRentalAmountCalculation() {
        Movie movie = new Movie("John Wick: Chapter 3 - Parabellum", Movie.NEW_RELEASE);
        Rental rental = new Rental(movie, 1);
        Customer customer = new Customer("John Doe");
        customer.addRental(rental);

        String result = customer.printBill();

        double expectedAmount = 3.0;
        String expectedAmountText = "Amount owed is " + expectedAmount;
        assertTrue(result.contains(expectedAmountText));

        int expectedFrequentRenterPoints = 1;
        String expectedFrequentRenterPointsText = "You earned " + expectedFrequentRenterPoints + " frequent renter points";
        assertTrue(result.contains(expectedFrequentRenterPointsText));
    }

    @Test
    public void testTwoDaysNewReleaseRentalAmountCalculation() {
        Movie movie = new Movie("John Wick: Chapter 3 - Parabellum", Movie.NEW_RELEASE);
        Rental rental = new Rental(movie, 2);
        Customer customer = new Customer("John Doe");
        customer.addRental(rental);

        String result = customer.printBill();

        double expectedAmount = 6.0;
        String expectedAmountText = "Amount owed is " + expectedAmount;
        assertTrue(result.contains(expectedAmountText));

        int expectedFrequentRenterPoints = 2;
        String expectedFrequentRenterPointsText = "You earned " + expectedFrequentRenterPoints + " frequent renter points";
        assertTrue(result.contains(expectedFrequentRenterPointsText));
    }
    
    @Test
    public void testMoreThan2DaysNewReleaseAmounts() {
    	String result = createNewReleaseMoreThan2DaysReservation();
        String expectedAmountText = "Amount owed is 18.0";
        assertTrue(result.contains(expectedAmountText));
    }
    
    @Test
    public void testMoreThan2DaysNewReleaseFrequentRentalPoints() {
    	String result = createNewReleaseMoreThan2DaysReservation();
        String expectedFrequentRenterPointsText = "You earned 2 frequent renter points";
        
        assertTrue(result.contains(expectedFrequentRenterPointsText));
    }

    @Test
    void testRegularRentalAmountCalculation() {
        Customer customer = new Customer("John Doe");
        Movie movie = new Movie("Venom", Movie.REGULAR);
        Rental rental = new Rental(movie, 1);
        customer.addRental(rental);
        String result = customer.printBill();

        double expectedAmount = 2.0;
        String expected = "Amount owed is " + expectedAmount;
        assertTrue(result.contains(expected));
      }

      @Test
      void testLongTermRegularRentalAmountCalculation() {
        Customer customer = new Customer("John Doe");
        Movie movie = new Movie("Venom", Movie.REGULAR);
        Rental rental = new Rental(movie, 7);
        customer.addRental(rental);
        String result = customer.printBill();

        double expectedAmount = 9.5;
        String expected = "Amount owed is " + expectedAmount;
        assertTrue(result.contains(expected));
      }
      
      @Test
      void testMultipleRentalAmountCalculation() {
        Customer customer = new Customer("John Doe");
        Movie movie = new Movie("Venom", Movie.REGULAR);
        Rental rental = new Rental(movie, 7);
        customer.addRental(rental);
        customer.addRental(new Rental(movie, 7));
        String result = customer.printBill();

        double expectedAmount = 19.0;
        String expected = "Amount owed is " + expectedAmount;
        assertTrue(result.contains(expected));
      }
      
      private String createNewReleaseMoreThan2DaysReservation() {
  		Movie movie = new Movie("John Wick: Chapter 3 - Parabellum", Movie.NEW_RELEASE);
          Rental rental = new Rental(movie, 6);
          Customer customer = new Customer("John Doe");
          customer.addRental(rental);
          String result = customer.printBill();
  		return result;
  	}
}
