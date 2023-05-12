package ubu.gii.dass.refactoring;

/**
 * Clase MovieType
 * 
 * @author jmc1005@alu.ubu.es
 *
 */
public abstract class MovieType {

	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	public MovieType() {
		super();
	}

	public abstract double getCharge(Rental rental);

	int getFrecuentRenterPoint(Rental rental) {
		int result = 1;
		// add bonus for a two day new release rental
		if ((rental.get_movie().getPriceCode() == MovieType.NEW_RELEASE) && rental.getDaysRented() > 1)
			result++;
		return result;
	}
	
}
