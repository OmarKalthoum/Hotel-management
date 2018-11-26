import java.util.LinkedList;
import java.util.Scanner;

public class HotelLogic {

<<<<<<< HEAD
    private String userName, passWord;
    private Scanner scan;
    private LinkedList<Person> users = new LinkedList<>();

    public HotelLogic(Scanner scan){
        this.scan = scan;
    }

    // Login user and check for user type
    protected void loginUser() throws Exception {
        System.out.println("UserName: ");
        userName = scan.nextLine();
        System.out.println("PassWord: ");
        passWord = scan.nextLine();

        for (Person user:users) {
            if(user.getUserName().equals(userName) && user.getPassword().equals(passWord)){
                if(user.getClass().equals(Employee.class)){
                    employeeMenu();
                    break;
                }else if(user.getClass().equals(Customer.class)){
                    customerMenu();
                    break;
                }else if(userName.equals("ROOTADMINUSER") && passWord.equals("habibi")){
                    createTestInfo();
                    loginUser();
                }else{
                    //something terribly worng
                    throw new Exception("something went terribly wrong in menu loginUser()");
                }
            }
        }
    }

    // customer & employee menu
    protected void customerMenu(){
        // direct user to basic menu class
    }
    protected void employeeMenu(){
        //direct user to employeemenu class
    }

    // Method to generate random users & rooms for testing menus & logic
    private void createTestInfo(){
        /* create a bunch of users, employees, rooms & stuff in
            order to check functionality that edits data
         */
=======

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
>>>>>>> master
    }


}
