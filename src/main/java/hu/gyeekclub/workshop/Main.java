package hu.gyeekclub.workshop;

public class Main {

	public static void main(String[] args) {
		// create movies
		Movie movie1 = new Movie("Horrora akadva", Movie.REGULAR);
		Movie movie2 = new Movie("Halálos iramban", Movie.NEW_RELEASE);
		Movie movie3 = new Movie("Egyszer volt, hol nem volt", Movie.CHILDRENS);

		// create rentals
		Rental rental1 = new Rental(movie1, 4);
		Rental rental2 = new Rental(movie2, 5);
		Rental rental3 = new Rental(movie3, 10);

		// create customer
		Customer customer1 = new Customer("Teszt Elek");
		Customer customer2 = new Customer("Kis Virág");
		Customer customer3 = new Customer("Nagy Etelka");


		// add rentals to customers
		customer1.addRental(rental1);
		customer1.addRental(rental2);
		customer1.addRental(rental3);

		customer2.addRental(rental3);

		customer3.addRental(rental2);
		customer3.addRental(rental2);
		customer3.addRental(rental1);

		// print results
		String result;

		result = customer1.toString();
		System.out.println(result);

		result = customer2.toString();
		System.out.println(result);

		result = customer3.toString();
		System.out.println(result);
	}
}
