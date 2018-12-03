import java.text.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class HotelLogic {

    private String userName, passWord;
    private Date checkinDate, checkoutDate;
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
            } else {
                System.out.println("Login Failed\n");
            }
        }
    }

    // Customer & employee menu
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
                                addNewBooking(owner);
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

            System.out.print("\n" +
                    "[1] Room options \n" +
                    "[2] User options\n" +
                    "[3] Bookings\n" +
                    "[4] Customer menu administration\n" +
                    "[5] Exit employee mode\n\n" +
                    "Your choice: ");
            try {
                choice = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Please choose a number from the menu");
                scan.next();
                continue;
            }
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
                        try {
                            choice = scan.nextInt();
                        } catch (Exception e) {
                            System.out.println("Please choose a number from the menu");
                            scan.next();
                            continue;
                        }

                        switch (choice) {
                            case 1: {
                                addNewRoom();
                                break;
                            }
                            case 2: {
                                removeRoom();
                                break;
                            }
                            case 3: {
                                viewAllRooms();
                                break;
                            }
                            case 4: {
                                viewJustAvailableRooms();
                                break;
                            }
                            case 5: {
                                editRoom();
                                break;
                            }
                            case 6: {
                                choice = -2;
                                break;
                            }
                            default: {
                                System.out.println("Please choose a number from the menu");
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
                        try {
                            choice = scan.nextInt();
                        } catch (Exception e) {
                            System.out.println("Please choose a number from the menu");
                            scan.next();
                            continue;
                        }

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
                        try {
                            choice = scan.nextInt();
                        } catch (Exception e) {
                            System.out.println("Please choose a number from the menu");
                            scan.next();
                            continue;
                        }
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

    private void addNewBooking(Customer owner) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date;
        //Error handling date = ""
        date = scan.nextLine();
        System.out.println("Enter checkin date (Format: yyyy-mm-dd):");
        date = scan.nextLine();
        try {
            checkinDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Enter checkout date (Format: yyyy-mm-dd):");
        date = scan.nextLine();
        try {
            checkoutDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Enter room number:");
        int roomNbr = scan.nextInt();
        System.out.println("Enter price:");
        double price = scan.nextDouble();
        Booking newBooking = new Booking(checkinDate, checkoutDate, roomNbr);
        newBooking.setTotalPrice(price);
        owner.addCustomerBookings(newBooking.getBookId());
        books.add(newBooking);
        ReadWrite rw = new ReadWrite();
        rw.write(newBooking.getBookId(), checkinDate, checkoutDate, roomNbr);
    }

    private void addNewRoom() {

        boolean hasBalcony = false;
        int roomNumber = rooms.size() + 1;
        System.out.println("\nAdding a new Room: ");
        System.out.println("The room number is gonna be : " + roomNumber);

        System.out.print("Enter the number of beds: ");
        int bedsQuantity = 0;
        while (true) {
            try {
                bedsQuantity = scan.nextInt();
                break;
            } catch (Exception e) {
                System.out.print("Please write only the number of beds: ");
                scan.next();
            }
        }
        scan.nextLine();
        System.out.print("Has the room a balcony: (Y/N): ");
        if (scan.nextLine().equalsIgnoreCase("y")) {
            hasBalcony = true;
        }
        System.out.print("How much costs the room per night? ");

        double cost = 0;
        while (true) {
            try {
                cost = scan.nextDouble();
                break;
            } catch (Exception e) {
                System.out.print("Please write only the cost of the room per night: ");
                scan.next();
            }
        }
        rooms.add(new Room(roomNumber, bedsQuantity, hasBalcony, cost));
        System.out.println("A new room with the number " + roomNumber + " has now been added to the hotel");

    }

    private void viewAllRooms() {

        System.out.println("Listing all registered rooms at Hotel California\n\n");
        System.out.println("Room\tBeds\tPrice/Night\tBalcony\n\n");
        DecimalFormat df = new DecimalFormat("#.##");
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println(
                    (i + 1 + "\t\t" +
                            rooms.get(i).getNumberOfBeds() + "\t\t" +
                            df.format(rooms.get(i).getPricePerNight()) + "\t\t" +
                            rooms.get(i).isHasBalcony()));
        }
    }

    private void viewJustAvailableRooms() {
        System.out.println("Listing all available rooms at Hotel California\n");
        System.out.println("Room\tBeds\tPrice/Night\tBalcony\n\n");
        for (int i = 0; i < rooms.size(); i++) {
            if (!rooms.get(i).isBooked()) {
                DecimalFormat df = new DecimalFormat("#.##");
                System.out.println(
                        i + 1 + "\t\t" +
                                rooms.get(i).getNumberOfBeds() + "\t\t" +
                                df.format(rooms.get(i).getPricePerNight()) + "\t\t" +
                                rooms.get(i).isHasBalcony());
            }
        }
    }

    private void editRoom() {

        while (true) {
            viewAllRooms();
            int roomNumber;

            System.out.print("Write the number of the room that you want to edit: ");
            try {
                roomNumber = scan.nextInt() - 1;
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("Please choose an available room number!");
                scan.next();
                continue;
            }
            if (roomNumber > rooms.size() || roomNumber <= 0) {
                System.out.println("Please choose an available room number!");
            } else {
                System.out.println("You are editing the room number " + roomNumber + 1);
                System.out.print("Enter the number of beds: ");
                while (true) {
                    try {
                        rooms.get(roomNumber).setNumberOfBeds(scan.nextInt());
                        break;
                    } catch (Exception e) {
                        System.out.print("Please write only the number of beds: ");
                        scan.next();
                    }
                }
                scan.nextLine();
                System.out.print("Has the room a balcony: (Y/N): ");
                if (scan.nextLine().equalsIgnoreCase("y")) {
                    rooms.get(roomNumber).setHasBalcony(true);
                }
                System.out.print("How much costs the room per night? ");
                while (true) {
                    try {
                        rooms.get(roomNumber).setPricePerNight(scan.nextInt());
                        break;
                    } catch (Exception e) {
                        System.out.print("Please write only the cost of the room per night: ");
                        scan.next();
                    }
                }
                scan.nextLine();
                break;
            }
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
        for (int i = 0; i < 10; i++) {
            ppn = 299 + (399) * rand.nextDouble();
            Room room = new Room(i, rand.nextInt(4) + 1, rand.nextBoolean(), ppn);
            rooms.add(room);
        }

    }

    private void removeRoom(){
        int RoomNumber;
        System.out.println("Enter Roomnumber and press Enter. (This room will be removed from record)\n" +
                "select 0 to abort.\n");

        while(!scan.hasNextInt()){
            scan.next();
        }
        RoomNumber = scan.nextInt();

        if (RoomNumber == 0){
            return;
        }

        for (Room r : rooms){
            if (r.getRommNumber() == RoomNumber){
                    rooms.remove(r);
                System.out.println("Room Number " + RoomNumber + " has been removed");
                return;
            }
        }
    }
}

