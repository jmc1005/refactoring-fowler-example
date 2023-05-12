package ubu.gii.dass.refactoring;

public class NewRelease extends MovieType {

	@Override
	public double getCharge(Rental rental) {
		return rental.getDaysRented() * 3.0;
	}

}
