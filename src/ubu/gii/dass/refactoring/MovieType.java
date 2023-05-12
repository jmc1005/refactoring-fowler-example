package ubu.gii.dass.refactoring;

/**
 * Clase MovieType
 * @author jmc1005@alu.ubu.es
 *
 */
public abstract class MovieType {

	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	
	public MovieType() {
		
	}
	
	public abstract int getTypeCode();
	
	public abstract double getCharge(Rental rental);
	
}
