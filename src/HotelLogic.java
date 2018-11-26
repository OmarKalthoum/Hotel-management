import java.util.LinkedList;
import java.util.Scanner;

public class HotelLogic {

    private String userName, passWord;
    private Scanner scan;
    protected LinkedList<Person> users = new LinkedList<>();
    protected LinkedList<Booking> books = new LinkedList<>();
    protected LinkedList<Room> rooms = new LinkedList<>();

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
                    Customer owner = (Customer) user;
                    customerMenu(owner);
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
    protected void customerMenu(Customer owner){
        HCmenu customer = new HCmenu(scan, owner, books, rooms);
        customer.customerMenu();
    }
    protected void employeeMenu(){
        //direct user to employeemenu class
    }

    // Method to generate random users & rooms for testing menus & logic
    private void createTestInfo() {
        /* create a bunch of users, employees, rooms & stuff in
            order to check functionality that edits data
         */
    }
}
