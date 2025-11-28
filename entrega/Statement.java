package refactoring.solution;

public abstract class Statement {

    public String value(Customer aCustomer) {
        String result = headerString(aCustomer);

        for (Rental each : aCustomer.getRentals()) {
            result += eachRentalString(each);
        }

        result += footerString(aCustomer);
        return result;
    }

    protected abstract String headerString(Customer aCustomer);

    protected abstract String eachRentalString(Rental aRental);

    protected abstract String footerString(Customer aCustomer);
}
