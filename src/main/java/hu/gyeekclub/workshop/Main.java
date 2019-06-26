package hu.gyeekclub.workshop;

public class Main {

	public static void main(String[] args) {
		Movie[] movies = {
			new RegularMovie("Horrora akadva"),
			new NewReleaseMovie("Halálos iramban"),
			new ChildrensMovie("Egyszer volt, hol nem volt"),
		};

		Rental[] rentals = {
			new Rental(movies[0], 4),
			new Rental(movies[1], 5),
			new Rental(movies[2], 10),
		};

		Customer[] customers = {
			new Customer("Teszt Elek"),
			new Customer("Kis Virág"),
			new Customer("Nagy Etelka"),
		};

		customers[0].addRental(rentals[0]);
		customers[0].addRental(rentals[1]);
		customers[0].addRental(rentals[2]);

		customers[1].addRental(rentals[2]);

		customers[2].addRental(rentals[1]);
		customers[2].addRental(rentals[1]);
		customers[2].addRental(rentals[0]);

		System.out.println(customers[0].statement());
		System.out.println(customers[1].statement());
		System.out.println(customers[2].statement());
	}
}
