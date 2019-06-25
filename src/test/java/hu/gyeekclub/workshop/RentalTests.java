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

}
