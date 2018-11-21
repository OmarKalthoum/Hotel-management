import java.util.ArrayList;

public class HotelLogic {


    public Customer getCustomer(String ssn) {

        return new Customer("", "", "", "", "");
    }

    public ArrayList<Customer> getCustomers() {
        return new ArrayList<>();
    }

    public Room getRoom(int rommNbr) {

        return new Room(0, 0, false, 0, false);
    }

    public ArrayList<Room> getRooms() {

        return new ArrayList<Room>();
    }

    public ArrayList<Room> getAvailableRooms() {

        return new ArrayList<Room>();
    }

    public boolean addCustomer(Customer customer) {

        return false;
    }

    public boolean addRoom(Room room) {

        return false;
    }

    public boolean chechInCustomer(String ssn, Booking booking) {

        return false;
    }

    public boolean chechoutCustomer(String ssn, int bookingNbr) {

        return false;
    }

    public boolean editBooking(String ssn, Booking booking) {

        return false;
    }


}
