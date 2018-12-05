import java.text.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class HotelLogic {

    private String userName, passWord;
    private Date checkinDate, checkoutDate;
    private Scanner scan;
    private LinkedList<Person> users = new LinkedList<>();
    private LinkedList<Booking> books = new LinkedList<>();
    private LinkedList<Room> rooms = new LinkedList<>();

    public HotelLogic(Scanner scan) {
        this.scan = scan;
        load();
        //createTestInfo();
    }

    // Login user and check for user type
    protected void loginUser() {

        System.out.print("UserName: ");
        userName = scan.nextLine();
        System.out.print("PassWord: ");
        passWord = scan.nextLine();
        int checkLogIn = 1;
        for (Person user : users) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(passWord)) {
                checkLogIn++;
                if (user.getClass().equals(Employee.class)) {
                    employeeMenu();
                    break;
                } else if (user.getClass().equals(Customer.class)) {
                    Customer owner = (Customer) user;
                    customerMenu(owner);
                    break;
                }
            }
        }
        if (checkLogIn == 1) {
            System.out.println("Login Failed\nPlease try again");

        }
    }

    // Customer & employee menu

    private void customerMenu(Customer owner) {
        int choice = 0;
        while (choice != -1) {

            System.out.print("\n[1] Booking options \n" +
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
                                "[3] View booking\n" +
                                "[4] View booking history\n" +
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
                                editBooking(owner);
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
                    viewAvailableRoomDate();
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
                        scan.nextLine();
                        switch (choice) {
                            case 1: {
                                viewCurrentCustomer(owner);
                                break;
                            }
                            case 2: {
                                editCustomerByCustomer(owner);
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

    private void employeeMenu() {
        int choice = 0;
        while (choice != -1) {

            System.out.print("\n" +
                    "[1] Room options \n" +
                    "[2] Customer options\n" +
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
                                removeCustomer();
                                break;
                            }
                            case 3: {
                                editCustomer();
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
                                viewBookings();
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


    //Booking methods

    private void addNewBooking(Customer owner) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date;
        //Error handling date = ""
        scan.nextLine();
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
        //System.out.println("Enter price:");
        int nbrOfDays = (int) ((checkoutDate.getTime() - checkinDate.getTime()) / (1000*60*60*24));

        Room temp = null;
        for(Room r: rooms){
            if(r.getRommNumber() == roomNbr){
                temp = r;
            }
        }

        double price = 0;
        if(temp != null) {
            price = temp.getPricePerNight() * nbrOfDays;
        }

        //double price = scan.nextDouble();
        Booking newBooking = new Booking(checkinDate, checkoutDate, roomNbr);
        newBooking.setTotalPrice(price);
        owner.addCustomerBookings(newBooking.getBookId());
        books.add(newBooking);
        ReadWrite rw = new ReadWrite();
        rw.write(newBooking.getBookId(), checkinDate, checkoutDate, roomNbr);

        /*
        Denna ska in i view bookin, price per night är auto.
        Print kan användas för att visa kund pris per natt och totalpris för bokning och bekräftelse

        System.out.printf("%.2f", newBooking.getTotalPrice());
        System.out.println();
        System.out.printf("%.2f", temp.getPricePerNight());
*/
    }

    private void editBooking(Customer owner) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date;
        int bookId;
        int choice = 0;
        int price;
        int roomNbr;
        System.out.println("Enter booking id:");
        bookId = scan.nextInt();
        while(choice != -1) {
            System.out.print("\n" +
                    "[1] Check in date\n" +
                    "[2] Check out date\n" +
                    "[3] Total price\n" +
                    "[4] Status \n" +
                    "[5] Room number \n" +
                    "[6] Back to menu \n" +
                    "Your choice: ");
            try {
            choice = scan.nextInt();
            } catch (Exception e) {
            System.out.println("Please choose a number from the menu");
            scan.next();
            continue;
            }
            switch(choice) {
                case 1: {
                    //Error handling date = ""
                    scan.nextLine();
                    System.out.println("Enter new check in date:");
                    date = scan.nextLine();
                    try {
                        checkinDate = dateFormat.parse(date);
                    } catch(ParseException e) {
                        e.printStackTrace();
                    }
                    books.get(bookId).setCheckinDate(checkinDate);
                    break;
                }
                case 2: {
                    //Error handling date = ""
                    date = scan.nextLine();
                    System.out.println("Enter new check out date:");
                    date = scan.nextLine();
                    try {
                        checkoutDate = dateFormat.parse(date);
                    } catch(ParseException e) {
                        e.printStackTrace();
                    }
                    books.get(bookId).setCheckoutDate(checkoutDate);
                    break;
                }
                case 3: {
                    System.out.println("Enter total price:");
                    price = scan.nextInt();
                    books.get(bookId).setTotalPrice(price);
                    break;
                }
                case 4: {
                    if(books.get(bookId).isCanceled() == true) {
                        books.get(bookId).setCanceled(false);
                    } else {
                        books.get(bookId).setCanceled(true);
                    }
                    System.out.println("Changed status!");
                    break;
                }
                case 5: {
                    System.out.println("Enter new room number:");
                    roomNbr = scan.nextInt();
                    books.get(bookId).setRoomNbr(roomNbr);
                    break;
                }
                case 6: {
                    choice = -1;
                    break;
                }
            }
        }
    }

    private void viewBookings(){


        if(!books.isEmpty()){
        for(Booking b: books) {
            System.out.println(b.getBookId());
            System.out.println(b.getRoomNbr());
            System.out.println(b.getCheckinDate());
            System.out.println(b.getCheckoutDate());
        }
        }
    }

        //Room methods

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
        rooms.add(new Room(roomNumber - 1, bedsQuantity, hasBalcony, cost));
        System.out.println("A new room with the number " + roomNumber + " has now been added to the hotel");

    }

    private void removeRoom() {
        while (true) {
            if (rooms.size() > 0) {
                viewAllRooms();
                int roomNumber;

                System.out.print("\nWrite the room index that you would like to delete or 0 to abort: ");
                try {
                    roomNumber = scan.nextInt();
                } catch (Exception e) {
                    System.out.println("Please choose an available room number!");
                    scan.next();
                    continue;
                }
                if (roomNumber > rooms.size() || roomNumber < 0) {
                    System.out.println("Please choose an available room number!");
                } else if (roomNumber == 0) {
                    break;
                } else {
                    rooms.remove(rooms.get(roomNumber - 1));
                    System.out.println("The room with the number: " + roomNumber + " has been removed");
                    break;
                }

            } else if (rooms.size() == 0) {
                System.out.println("There are no room left in the hotel to delete!");
                break;
            }
        }
    }

    private void viewAllRooms() {
        Room temp;
        DecimalFormat df = new DecimalFormat("#.##");
        int counter = 1;
        for (int i = 0; i < rooms.size(); i++) {
            if (counter == 1) {
                System.out.println("Listing all registered rooms at Hotel California\n");
                System.out.println("Index:\tRoom\tBeds\tPrice/Night\tBalcony\n");
                counter++;
            }
            temp = rooms.get(i);
            System.out.println(
                    (i+1) + "\t\t" +
                            (temp.getRommNumber() + 1 + "\t\t" +
                            rooms.get(i).getNumberOfBeds() + "\t\t" +
                            df.format(rooms.get(i).getPricePerNight()) + "\t\t" +
                            rooms.get(i).isHasBalcony()));
        }
        if (counter == 1) {
            System.out.println("There are no rooms to view!");
        }
    }

    private void viewJustAvailableRooms() {
        int counter = 1;

        for (int i = 0; i < rooms.size(); i++) {
            if (!rooms.get(i).isBooked()) {
                if (counter == 1) {
                    System.out.println("Listing all available rooms at Hotel California\n");
                    System.out.println("Room\tBeds\tPrice/Night\tBalcony\n");
                    counter++;
                }
                DecimalFormat df = new DecimalFormat("#.##");
                System.out.println(
                        i + 1 + "\t\t" +
                                rooms.get(i).getNumberOfBeds() + "\t\t" +
                                df.format(rooms.get(i).getPricePerNight()) + "\t\t" +
                                rooms.get(i).isHasBalcony());
            }
        }
        if (counter == 1) {
            System.out.println("There are nona available rooms at Hotel California!");
        }
    }

    private void editRoom() {

        while (true) {
            if (rooms.size() > 0) {
                viewAllRooms();
                int roomNumber;

                System.out.print("Write the number of the room that you want to edit or 0 to abort: ");
                try {
                    roomNumber = scan.nextInt();
                    scan.nextLine();
                } catch (Exception e) {
                    System.out.println("Please choose an available room number!");
                    scan.next();
                    continue;
                }
                if (roomNumber > rooms.size() || roomNumber < 0) {
                    System.out.println("Please choose an available room number!");
                } else if (roomNumber == 0) {
                    break;
                } else {
                    System.out.println("You are editing the room number " + roomNumber);
                    System.out.print("Enter the number of beds: ");
                    while (true) {
                        try {
                            rooms.get(roomNumber - 1).setNumberOfBeds(scan.nextInt());
                            break;
                        } catch (Exception e) {
                            System.out.print("Please write only the number of beds: ");
                            scan.next();
                        }
                    }
                    scan.nextLine();
                    System.out.print("Has the room a balcony: (Y/N): ");
                    if (scan.nextLine().equalsIgnoreCase("y")) {
                        rooms.get(roomNumber - 1).setHasBalcony(true);
                    }
                    System.out.print("How much costs the room per night? ");
                    while (true) {
                        try {
                            rooms.get(roomNumber - 1).setPricePerNight(scan.nextDouble());
                            break;
                        } catch (Exception e) {
                            System.out.print("Please write only the cost of the room per night: ");
                            scan.next();
                        }
                    }
                    scan.nextLine();
                    break;
                }
            } else if (rooms.size() == 0) {
                System.out.println("There are no room to edit!");
                break;
            }

        }

    }

    //Customer methods

    private void addNewCustomer() {
        scan.nextLine();
        System.out.print("Enter your full name: ");
        String name = scan.nextLine();
        System.out.print("Enter your social security-number: ");
        String ssn = scan.nextLine();
        System.out.print("Enter your phone-number: ");
        String phoneNumber = scan.nextLine();
        System.out.print("Enter your address: ");
        String address = scan.nextLine();
        System.out.print("Enter your username: ");
        String userName = scan.nextLine();
        System.out.print("Enter your password: ");
        String password = scan.nextLine();
        Customer customer = new Customer(ssn, name, address, phoneNumber, userName, password);
        users.add(customer);
        System.out.println("Customer-account created! ");
        System.out.println();

    }

    private void viewAllCustomers() {
        int counter = 1;

        for (Person p : users) {
            if (p.getClass().equals(Customer.class)) {
                if (counter == 1) {
                    System.out.println("Registered customers:\n");
                }
                System.out.println("Customer [" + counter + "]");
                System.out.println("Name: " + p.getName());
                System.out.println("SSN: " + p.getSsn());
                System.out.println("Phone-number: " + p.getContactNBR());
                System.out.println("Address: " + p.getAddress());
                System.out.println("Username: " + p.getUserName());
                System.out.println();
                counter++;
            }

        }
        if (counter != 1) {
            System.out.println("-------------------------------------------------------");
        }
        if (counter == 1) {
            System.out.println("There are none registered customer to view");
        }

    }

    private void removeCustomer() {
        int counter = 1;
        for (Person customer : users) {

            if (customer.getClass().equals(Customer.class)) {
                counter++;
                viewAllCustomers();
                int removeCustomer;
                System.out.print("Choose the customer number that you want to delete or 0 to abort: ");
                try {
                    removeCustomer = scan.nextInt();
                } catch (Exception e) {
                    System.out.println("Please choose an available customer number!");
                    scan.next();
                    continue;
                }
                if (removeCustomer > users.size() || removeCustomer < 0) {
                    System.out.println("Please choose an available customer number!");
                } else if (removeCustomer == 0) {
                    break;
                } else {
                    System.out.println("The customer " + users.get(removeCustomer).getName() + " has been deleted!");
                    users.remove(users.get(removeCustomer));
                    break;
                }
            }
        }
        if (counter == 1) {
            System.out.println("There are none registered customer to delete!");

        }
    }

    private void editCustomer() {
        for (Person customer : users) {

            if (customer.getClass().equals(Customer.class)) {
                viewAllCustomers();
                int customerNumber;

                System.out.print("Write the number of the customer that you want to edit or 0 to abort: ");
                try {
                    customerNumber = scan.nextInt();
                    scan.nextLine();
                } catch (Exception e) {
                    System.out.println("Please choose an available customer number!");
                    scan.next();
                    continue;
                }
                if (customerNumber > users.size() - 1 || customerNumber < 0) {
                    System.out.println("Please choose an available customer number!");
                } else if (customerNumber == 0) {
                    break;
                } else {
                    System.out.println("You are editing the customer number " + customerNumber);
                    System.out.print("Enter your full name or 0 to go the next step: ");
                    String name = scan.nextLine();
                    if (!name.equalsIgnoreCase("0")) {
                        users.get(customerNumber).setName(name);
                    }

                    System.out.print("Enter your social security-number or 0 to go the next step: ");
                    String ssn = scan.nextLine();
                    if (!ssn.equalsIgnoreCase("0")) {
                        users.get(customerNumber).setSsn(ssn);
                    }

                    System.out.print("Enter your phone-number or 0 to go the next step: ");
                    String number = scan.nextLine();
                    if (!number.equalsIgnoreCase("0")) {
                        users.get(customerNumber).setContactNBR(number);
                    }

                    System.out.print("Enter your address or 0 to go the next step: ");
                    String address = scan.nextLine();
                    if (!address.equalsIgnoreCase("0")) {
                        users.get(customerNumber).setAddress(address);
                    }

                    System.out.print("Enter your username or 0 to go the next step: ");
                    String userName = scan.nextLine();
                    if (!userName.equalsIgnoreCase("0")) {
                        users.get(customerNumber).setUserName(userName);
                    }

                    System.out.print("Enter your password or 0 to go the next step: ");
                    String password = scan.nextLine();
                    if (!password.equalsIgnoreCase("0")) {
                        users.get(customerNumber).setPassword(password);
                    }
                    System.out.println("\nCustomer's information are now updated");
                    break;
                }
            } else {
                System.out.println("There are none registered customer to edit! ");
            }
        }

    }

    private void editCustomerByCustomer(Customer owner) {

        //Not allowed to change the ssn
        System.out.print("Enter your full name or 0 to go the next step: ");
        String name = scan.nextLine();
        if (!name.equalsIgnoreCase("0")) {
            owner.setName(name);
        }

        System.out.print("Enter your phone-number or 0 to go the next step: ");
        String number = scan.nextLine();
        if (!number.equalsIgnoreCase("0")) {
            owner.setContactNBR(number);
        }

        System.out.print("Enter your address or 0 to go the next step: ");
        String address = scan.nextLine();
        if (!address.equalsIgnoreCase("0")) {
            owner.setAddress(address);
        }
        System.out.print("Enter your username or 0 to go the next step: ");
        String userName = scan.nextLine();
        if (!userName.equalsIgnoreCase("0")) {
            owner.setUserName(userName);
        }

        System.out.print("Enter your password or 0 to go the next step: ");
        String password = scan.nextLine();
        if (!password.equalsIgnoreCase("0")) {
            owner.setPassword(password);
        }
        System.out.println("\nYour information are now updated");
    }

    private void viewCurrentCustomer(Customer owner) {

        System.out.println("Name: " + owner.getName());
        System.out.println("SSN: " + owner.getSsn());
        System.out.println("Phone-number: " + owner.getContactNBR());
        System.out.println("Address: " + owner.getAddress());
        System.out.println("Username: " + owner.getUserName());
        System.out.println("Password: " + owner.getPassword());
        System.out.println();

    }

    //Other methods

    private void createTestInfo() {
        /* create a bunch of users, employees, rooms & stuff in
            order to check functionality that edits data*/

        Employee emp1 = new Employee("999999-9999", "MyHomieThaEmployee", "EmployeTown @ da EmployeHouse 99"
                , "077-7777777", "xxx"
                , "xxx", 1, "Top Dawgh");

        users.add(emp1);

        Customer cust1 = new Customer("121212-1212", "Goldmember James", "who gives a ***"
                , "070-121212121", "yyy"
                , "yyy");
        users.add(cust1);

        Customer cust2 = new Customer("999999-9999", "Hans Eklund", "tjenagatan 1827 198287 Härnösand"
                , "0777-777777", "Kajsasasa"
                , "yyy");
        users.add(cust2);


        double ppn;
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            ppn = 299 + (399) * rand.nextDouble();
            Room room = new Room(i, rand.nextInt(4) + 1, rand.nextBoolean(), ppn);
            rooms.add(room);
        }

        save();

    }

    private void load() {
        ReadWrite rw = new ReadWrite();
        users = rw.readUsers();
        books = rw.readBookings();
        rooms = rw.readRooms();
    }

    protected void save() {
        ReadWrite rw = new ReadWrite();
        rw.saveUsers(users);
        rw.saveBookings(books);
        rw.saveRooms(rooms);
    }

    // det som saknas är att välja rum för bokning, alternativt hur många rum som ska bokas
    private void viewAvailableRoomDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Datum för Kundens önskemål om ledigt rum, hårdkodat just nu,
            // ska vara input
            Date tempStart = dateFormat.parse("2020-12-19");
            Date tempEnd = dateFormat.parse("2020-12-23");

        LinkedList<Integer> roomNbr = new LinkedList<>();

        for(Booking b:books){

            if(!(tempStart.after(b.getCheckinDate()) && (tempEnd.after(b.getCheckinDate())) ||
                    (tempStart.before(b.getCheckoutDate()) && tempEnd.after(b.getCheckoutDate())) ||
                    (tempStart.before(b.getCheckinDate()) && tempEnd.after(b.getCheckoutDate())))){
                roomNbr.add(b.getRoomNbr());
            }
        }

        Room temp;
        int test;
        for(int i = 0; i<rooms.size(); i++){
            temp = rooms.get(i);
            test = temp.getRommNumber();
            // Skriver ut rumsnummer om rum ej är bokat (dvs tillgängliga rum)
            // här krävs lite snyggare print om rums info,
            if(!roomNbr.contains(test)){
                System.out.println(test);
            }
        }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}


