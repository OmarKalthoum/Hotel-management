import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HCmenu {
    Scanner scan;
    Customer owner;
    private LinkedList<Booking> books = new LinkedList<>();
    private LinkedList<Room> rooms = new LinkedList<>();

    public HCmenu(Scanner scan, Customer user, List bookings, List rooms){
        this.scan = scan;
        this.owner = user;
        this.books = (LinkedList<Booking>) bookings;
        this.rooms = (LinkedList<Room>) rooms;
    }

    public void customerMenu(){}

    public Booking newBooking(){
        Booking book = new Booking();

        /*
        Ask user for information in order to create a booking
        */

        return book;
    }
    public void checkIn(int bookingId){}
    public void checkOut(int bookingID){}
    public void viewCustInfo(){}
    public void viewCurrentBookings(){}
    public void viewBookingHistory(){}
    public void editBooking(){}
    public void editCustomerInformation(){}
    public void viewAvailableRooms(){}

}
