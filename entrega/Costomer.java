import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    // Agora delega para TextStatement
    public String statement() {
        return new TextStatement().value(this);
    }

    // Agora delega para HtmlStatement
    public String htmlStatement() {
        return new HtmlStatement().value(this);
    }

    // Agora public – usado por TextStatement e HtmlStatement
    public Enumeration getRentals() {
        return _rentals.elements();
    }

    // Agora public – usado por TextStatement e HtmlStatement
    public double getTotalCharge() {
        double result = 0;

        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }

        return result;
    }

    // Agora public – usado por TextStatement e HtmlStatement
    public int getTotalFrequentRenterPoints() {
        int result = 0;

        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }

        return result;
    }
}
