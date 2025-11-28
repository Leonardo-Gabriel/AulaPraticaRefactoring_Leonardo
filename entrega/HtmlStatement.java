import java.util.Enumeration;

public class HtmlStatement extends Statement {

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
        return "<H1>Rentals for <EM>" + aCustomer.getName() +
                "</EM></H1><P>\n";
    }

    private String eachRentalString(Rental each) {
        return each.getMovie().getTitle() + ": " +
                each.getCharge() + "<BR>\n";
    }

    private String footerString(Customer aCustomer) {
        return "<P>You owe <EM>" + aCustomer.getTotalCharge() +
                "</EM><P>\n" +
                "On this rental you earned <EM>" +
                aCustomer.getTotalFrequentRenterPoints() +
                "</EM> frequent renter points<P>";
    }
}
