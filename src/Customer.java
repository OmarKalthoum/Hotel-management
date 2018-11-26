import java.util.LinkedList;

public class Customer extends Person{

    public Customer(String ssn, String name, String address, String telephonNumber, String userName, String password) {
        super(ssn, name, address, telephonNumber, userName, password);
    }

    private LinkedList<Integer> customerBookings = new LinkedList<>();

    protected LinkedList<Integer> getCustomerBookings() {
        return customerBookings;

    }

    protected void addCustomerBookings(int bookingId) {
        customerBookings.add(bookingId);
    }

}
