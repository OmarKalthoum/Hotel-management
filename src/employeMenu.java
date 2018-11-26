import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class employeMenu extends HCmenu {
    private LinkedList<Person> users = new LinkedList<>();

    public employeMenu(Scanner scan, Customer user, List bookings, List rooms, List users, HotelLogic owner) {
        super(scan, user, bookings, rooms);
        this.users = (LinkedList<Person>) users;
    }

    public void mainEmployeMenu(){}

    protected void addRoom(){}
    protected void removeRoom(){}
    protected void viewRooms(){}
    protected void editRoomInfo(){}
    protected void addCustomer(){


    }
    protected void removeCustomer(){}
    protected void viewAllCustomers(){}
    protected void viewUnoccupiedRooms(){}
    protected void searchForBooking(){}

}
