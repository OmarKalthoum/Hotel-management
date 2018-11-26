import java.util.LinkedList;

public class Customer extends Person{

    public Customer(String ssn, String name, String address, String telephonNumber, String userName, String password) {
        super(ssn, name, address, telephonNumber, userName, password);
    }

    private LinkedList<Booking> customerBookings = new LinkedList<>();

    protected LinkedList<Booking> getCustomerBookings() {
        return customerBookings;
    }

    protected void addCustomerBookings(Booking booking) {
        customerBookings.add(booking);
    }

}
