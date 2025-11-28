import java.util.Enumeration;

public abstract class Statement {
    public String value(Customer aCustomer) {
        Enumeration<Rental> rentals = aCustomer.getRentals();
        String result = header(aCustomer);
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += line(each);
        }
        result += footer(aCustomer);
        return result;
    }

    protected abstract String header(Customer aCustomer);
    protected abstract String line(Rental aRental);
    protected abstract String footer(Customer aCustomer);
}
