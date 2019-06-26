package hu.gyeekclub.workshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

// these tests test for code security: how much code allows itself to be misused
// As a wise man once said: thou shalt make thine code resilient to tardiness!
public class SecurityTests {

    @Test
    public void nullConstructorTestForCustomer() {
        assertThrows(
            IllegalArgumentException.class,
            () -> {
                new Customer(null);
            },
            "Do not allow null parameters to stay unpunished."
        );
    }

    @Test
    public void nullConstructorTestForMovie() {
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new RegularMovie(null);
                },
                "Do not allow null parameters to stay unpunished."
        );
    }

    @Test
    public void nullConstructorTestForRental() {
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Rental(null, 5);
                },
                "Do not allow null parameters to stay unpunished."
        );
    }

    @Test
    public void nullParameterTestForCustomerAddRental() {
        assertThrows(
            IllegalArgumentException.class,
            () -> {
                new Customer("Test").addRental(null);
            },
            "No not allow null parameters to stay unpunished."
        );
    }
}
