import java.util.Enumeration;

public class TextStatement extends Statement {

    @Override
    public String value(Customer aCustomer) {

        Enumeration rentals = aCustomer.getRentals();
        String result = headerString(aCustomer); // linha EXTRAÍDA

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += eachRentalString(each); // linha EXTRAÍDA
        }

        result += footerString(aCustomer); // linha EXTRAÍDA

        return result;
    }

    private String headerString(Customer aCustomer) {
        return "Rental Record for " + aCustomer.getName() + "\n";
    }

    private String eachRentalString(Rental each) {
        return "\t" + each.getMovie().getTitle() + "\t" +
                each.getCharge() + "\n";
    }

    private String footerString(Customer aCustomer) {
        return "Amount owed is " + aCustomer.getTotalCharge() + "\n" +
                "You earned " + aCustomer.getTotalFrequentRenterPoints() +
                " frequent renter points";
    }
}
