package ubu.gii.dass.refactoring;

/**
* Tema  Refactorizaciones 
*
* Ejemplo de aplicaci�n de refactorizaciones. Actualizado para colecciones gen�ricas de java 1.5
*
* @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
* @version 1.1
* @see java.io.File
*
*/
import java.util.*;

public class Customer {
	private String _name;
	private List<Rental> _rentals;

	public Customer(String name) {
		_name = name;
		_rentals = new ArrayList<Rental>();

	};

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String getName() {
		return _name;
	};

	public StringBuilder getStatement(boolean isHtmlStatement) {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		StringBuilder sb = new StringBuilder();
		if(isHtmlStatement)
			sb.append("<h1>");	
		sb.append("Rental Record for " + getName() + "\n");
		if(isHtmlStatement)
			sb.append("</h1><p>");
		while (rentals.hasNext()) {
			double thisAmount = 0;
			Rental rental = rentals.next();
			thisAmount = rental.get_movie().getCharge(rental);

			frequentRenterPoints += rental.get_movie()._movieType.getFrecuentRenterPoint(rental);
			// show figures for this rental
			sb.append("\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n");
			totalAmount += thisAmount;
		}
		// add footer lines
		sb.append("Amount owed is " + totalAmount + "\n");
		sb.append("You earned " + frequentRenterPoints + " frequent renter points");
		if(isHtmlStatement)
			sb.append("</p>");
		
		return sb;
	}
	
	public String statement() {
		return getStatement(false).toString();
	}
	
	public String htmlStatement() {		
		return getStatement(true).toString().replace("\n", "<br/>").replace("\t", "&nbsp");
	}
}
