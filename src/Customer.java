import java.util.LinkedList;

public class Customer extends Person{

    public Customer(String ssn, String name, String address, String telephonNumber, String userName, String password) {
        super(ssn, name, address, telephonNumber, userName, password);
    }

<<<<<<< HEAD
    private LinkedList<Booking> customerBookings = new LinkedList<>();

    protected LinkedList<Booking> getCustomerBookings() {
        return customerBookings;
=======
    public String getSsn() {
        return ssn;
    }

    public String getName() {
        return name;
>>>>>>> master
    }

    protected void addCustomerBookings(Booking booking) {
        customerBookings.add(booking);
    }

<<<<<<< HEAD
=======
    @Override
    public String toString(){
        return "Name: " + name + "\nSocial security number: " + ssn + "\nAddress: " + address + "\nPhone Number: " + telephonNumber + "\n\n";
    }
>>>>>>> master
}
