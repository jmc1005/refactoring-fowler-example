package ubu.gii.dass.refactoring;

public class Regular extends MovieType{

	@Override
	public int getTypeCode() {
		return MovieType.REGULAR;
	}

	@Override
	public double getCharge(Rental rental) {
		return 0;
	}

}
