import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class HotelLogic {

    private String userName, passWord;
    private Scanner scan;
    protected LinkedList<Person> users = new LinkedList<>();
    protected LinkedList<Booking> books = new LinkedList<>();
    protected LinkedList<Room> rooms = new LinkedList<>();

    public HotelLogic(Scanner scan) {
        this.scan = scan;
        createTestInfo();
    }

    // Login user and check for user type
    protected void loginUser() throws Exception {
        System.out.print("UserName: ");
        userName = scan.nextLine();
        System.out.print("PassWord: ");
        passWord = scan.nextLine();

            for (Person user : users) {
                if (user.getUserName().equals(userName) && user.getPassword().equals(passWord)) {
                    if (user.getClass().equals(Employee.class)) {
                        employeeMenu();
                        break;
                    } else if (user.getClass().equals(Customer.class)) {
                        Customer owner = (Customer) user;
                        customerMenu(owner);
                        break;
                    }
                }else {
                    System.out.println("Login Failed\n");
                }
            }
        }

    // customer & employee menu
    protected void customerMenu(Customer owner) {
        int choice = 0;
        while (choice != -1) {

            System.out.print("[1] Booking options \n" +
                    "[2] Check in / Check out\n" +
                    "[3] View available rooms\n" +
                    "[4] Customer information\n" +
                    "[5] Exit customer mode\n\n" +
                    "Your choice: ");

            while (!scan.hasNextInt()) {
                scan.next();
            }

            choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    while (choice != -2) {

                        System.out.print("\n" +
                                "[1] New booking\n" +
                                "[2] Edit booking\n" +
                                "[3] Print booking\n" +
                                "[4] Print booking history\n" +
                                "[5] Back to the main menu\n\n" +
                                "Your choice: ");

                        while (!scan.hasNextInt()) {
                            scan.next();
                        }

                        choice = scan.nextInt();
                        switch (choice) {
                            case 1: {
                                break;
                            }
                            case 2: {
                                break;
                            }
                            case 3: {
                                break;
                            }
                            case 4: {
                                break;
                            }
                            case 5: {
                                choice = -2;
                                break;
                            }
                            default: {
                                break;
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    while (choice != -3) {

                        System.out.print("\n" +
                                "[1] Check in\n" +
                                "[2] Check out\n" +
                                "[3] Back to the main menu\n\n" +
                                "Your choice:  ");
                        choice = scan.nextInt();

                        switch (choice) {
                            case 1: {
                                break;
                            }
                            case 2: {
                                break;
                            }
                            case 3: {
                                choice = -3;
                                break;
                            }
                            default: {
                                break;
                            }
                        }
                    }
                    break;
                }
                case 3: {

                    break;
                }
                case 4: {
                    while (choice != -4) {

                        System.out.print("\n" +
                                "[1] View customer information\n" +
                                "[2] Edit customer information\n" +
                                "[3] View current booking\n" +
                                "[4] View booking history\n" +
                                "[5] Back to the main menu\n\n" +
                                "Your choice: ");
                        choice = scan.nextInt();
                        switch (choice) {
                            case 1: {
                                break;
                            }
                            case 2: {
                                break;
                            }
                            case 3: {
                                break;
                            }
                            case 4: {
                                break;
                            }
                            case 5: {
                                choice = -4;
                                break;
                            }
                            default: {
                                break;
                            }
                        }
                    }
                    break;
                }
                case 5: {
                    choice = -1;
                    break;
                }
                default: {
                    break;
                }
            }
        }

    }

    protected void employeeMenu() {
        int choice = 0;
        while (choice != -1) {

            System.out.print("" +
                    "[1] Room options \n" +
                    "[2] User options\n" +
                    "[3] Bookings\n" +
                    "[4] Customer menu administration\n" +
                    "[5] Exit employee mode\n\n" +
                    "Your choice: ");
            choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    while (choice != -2) {

                        System.out.print("\n[1] Add a room\n" +
                                "[2] Remove a room\n" +
                                "[3] View all rooms\n" +
                                "[4] View all available rooms\n" +
                                "[5] Edit room info\n" +
                                "[6] Back to the main menu\n\n" +
                                "Your choice: ");
                        choice = scan.nextInt();
                        switch (choice) {
                            case 1: {
                                break;
                            }
                            case 2: {
                                break;
                            }
                            case 3: {
                                viewAllRooms();
                                break;
                            }
                            case 4: {
                                break;
                            }
                            case 5: {
                                break;
                            }
                            case 6: {
                                choice = -2;
                                break;
                            }
                            default: {
                                break;
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    while (choice != -3) {

                        System.out.print("\n" +
                                "[1] Add customer\n" +
                                "[2] Remove customer\n" +
                                "[3] Edit customer's information\n" +
                                "[4] View all customers\n" +
                                "[5] Back to the main menu\n\n" +
                                "Your choice:  ");
                        choice = scan.nextInt();

                        switch (choice) {
                            case 1: {
                                addNewCustomer();
                                break;
                            }
                            case 2: {
                                break;
                            }
                            case 3: {
                                break;
                            }
                            case 4: {
                                viewAllCustomers();
                                break;
                            }
                            case 5: {
                                choice = -3;
                                break;
                            }
                            default: {
                                break;
                            }
                        }
                    }
                    break;
                }
                case 3: {
                    while (choice != -4) {

                        System.out.print("\n" +
                                "[1] Search for a specific booking\n" +
                                "[2] Cancel a booking\n" +
                                "[3] Back to the main menu\n\n" +
                                "Your choice: ");
                        choice = scan.nextInt();
                        switch (choice) {
                            case 1: {
                                break;
                            }
                            case 2: {
                                break;
                            }
                            case 3: {
                                choice = -4;
                                break;
                            }
                            default: {
                                break;
                            }
                        }
                        break;
                    }
                }
                case 4: {
                    break;
                }
                case 5: {
                    choice = -1;
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    private void viewAllRooms(){

        System.out.println("Listing all registered rooms at Hotel California\n\n");
        System.out.println("Room\tBeds\tPrice/Night\tBalcony\n\n");
        DecimalFormat df = new DecimalFormat("#.##");
        double ppn;

        for (Room r : rooms){
            System.out.println(
                    r.getRommNumber() + "\t\t" +
                            r.getNumberOfBeds() + "\t\t" +
                            df.format(r.getPricePerNight()) + "\t\t" +
                            r.isHasBalcony());
        }

    }

    private void addNewCustomer() {
        scan.nextLine();
        System.out.println("Enter your full name : ");
        String name = scan.nextLine();
        System.out.println("Enter your social security-number :");
        String ssn = scan.nextLine();
        System.out.println("Enter your phone-number : ");
        String phoneNumber = scan.nextLine();
        System.out.println("Enter your address : ");
        String address = scan.nextLine();
        System.out.println("Enter your username : ");
        String userName = scan.nextLine();
        System.out.println("Enter your password : ");
        String password = scan.nextLine();
        Customer customer = new Customer(ssn, name, address, phoneNumber, userName, password);
        users.add(customer);
        System.out.println("Customer-account created! ");
        System.out.println();

    }

    private void viewAllCustomers() {
        System.out.println("Registered customers : ");
        for (Person p : users) {
            if (p.getClass().equals(Customer.class)) {
                System.out.println(p.getName());
            }
        }


    }

    private void createTestInfo() {
        /* create a bunch of users, employees, rooms & stuff in
            order to check functionality that edits data*/

        Employee emp1 = new Employee("0000", "xxx", "xxx"
                , "xxx", "xxx"
                , "xxx", 1, "xxx");

        users.add(emp1);

        Customer cust1 = new Customer("0000", "yyy", "xxx"
                , "xxx", "yyy"
                , "yyy");
        users.add(cust1);


        double ppn;
        Random rand = new Random();
        for(int i = 0; i<10;i++) {
            ppn = 299 + (399) * rand.nextDouble();
            Room room = new Room(rand.nextInt(4)+1, rand.nextBoolean(),ppn);
            rooms.add(room);
        }

    }

}

