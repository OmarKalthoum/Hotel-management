import java.util.LinkedList;
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
                    } else if (userName.equals("ROOTADMINUSER") && passWord.equals("habibi")) {

                        employeeMenu();
                    } else {
                        //something terribly worng
                        throw new Exception("something went terribly wrong in menu loginUser()");
                    }
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

            while(!scan.hasNextInt()){
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

                        while(!scan.hasNextInt()){
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
                            case 4:{
                                break;
                            }
                            case 5:{
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
                                "[3] edit customer's information\n" +
                                "[4] View all customers\n" +
                                "[5] Back to the main menu\n\n" +
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
                                break;
                            }
                            case 4: {
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

    private void createTestInfo() {
        /* create a bunch of users, employees, rooms & stuff in
            order to check functionality that edits data*/

        Employee emp1 = new Employee("0000", "xxx", "xxx"
                , "xxx", "xxx"
                , "xxx", 1, "xxx");

        users.add(emp1);



        }

    }

