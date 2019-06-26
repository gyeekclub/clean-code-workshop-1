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
                    new Movie(null, 0);
                },
                "Do not allow null parameters to stay unpunished."
        );
    }

    @Test
    public void nullConstructorTestForRental() {
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Rental(null, 0);
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

    @Test
    public void illegalParameterTestForMovieConstructor() {
        assertThrows(
            IllegalArgumentException.class,
            () -> {
                Movie invalidMovie = new Movie("Nope", 80); // 80 is invalid
            },
            "No not allow invalid parameters to happen."
        );
    }

    @Test
    public void illegalParameterTestForMovieForPriceCodeSetter() {
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Movie validMovie = new Movie("Nope", 1); // 1 is valid
                    validMovie.setPriceCode(80); //80 is invalid
                },
                "No not allow invalid parameters to happen."
        );
    }
}
