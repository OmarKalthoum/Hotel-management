import java.text.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class HotelLogic {

    private String userName, passWord;
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
                                "[3] View bookings\n" +
                                "[4] View booking history\n" +
                                "[5] Back to the main menu\n\n" +
                                "Your choice: ");

                        while (!scan.hasNextInt()) {
                            scan.next();
                        }

                        choice = scan.nextInt();
                        scan.nextLine();
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
                                viewBookingHistoryForUser(owner, false);
                                break;
                            }
                            case 4: {
                                viewBookingHistoryForUser(owner, true);
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
                                checkIn(owner);
                                break;
                            }
                            case 2: {
                                checkOut(owner);
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

                    //viewAvailableRoomDate();
                    break;
                }
                case 4: {
                    while (choice != -4) {

                        System.out.print("\n" +
                                "[1] View customer information\n" +
                                "[2] Edit customer information\n" +
                                "[3] Back to the main menu\n\n" +
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
                                viewAvailableRoomByEmployee();
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
                                caneclBooking();
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

        LinkedList<Integer> list;
        Date checkoutDate;
        Date checkinDate;
        String date;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Enter check in date and try parse, if bad input return to previous menu
        System.out.println("Enter check-in date (Format: yyyy-mm-dd) or 0 to abort:");
        date = scan.nextLine();

        if(date.equalsIgnoreCase("0")){
            return;
        }

        try {
            checkinDate = dateFormat.parse(date);
        } catch (ParseException e) {
            //e.printStackTrace();
            System.err.println("Date input incorrect");
            return;
        }

        // Enter check out date and try parse, if bad input return to previous menu
        System.out.println("Enter checkout date (Format: yyyy-mm-dd) or 0 to abort:");
        date = scan.nextLine();

        if(date.equalsIgnoreCase("0")){
            return;
        }

        try {
            checkoutDate = dateFormat.parse(date);
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.println("Date Input incorrect");
            return;
        }

            // Check if check out date is before check in date or date not entered, return to previous menu if dates are bad
            try {
                if (checkinDate.after(checkoutDate)) {
                    System.err.println("You have entered a check out date that is before check in- Please try again");
                    return;
                }
            } catch (NullPointerException e) {
                System.err.println("Date was not entered");
                return;
            }

            // List available rooms, input from user, check input against booked rooms
            list = viewAvailableRoomDate(checkinDate, checkoutDate, true, -1);
            int roomNumber = -1;
            while (true) {
                System.out.print("Enter RoomNumbers: ");
                roomNumber = scan.nextInt();
                scan.nextLine();

                if (list != null && !list.contains(roomNumber)) {
                    break;
                } else {
                    System.out.println("Room not available for the given Dates");
                }
            }

            // evaluate days between check in and check out
            int nbrOfDays = (int) ((checkoutDate.getTime() - checkinDate.getTime()) / (1000 * 60 * 60 * 24));

            // find room for current booking
            Room temp = null;
            for (Room r : rooms) {
                if (r.getRommNumber() == roomNumber) {
                    temp = r;
                }
            }

            // calculate totalprice
            double price = 0;
            if (temp != null) {
                price = temp.getPricePerNight() * nbrOfDays;
            }

        int lastBookId = 0;
        if (!books.isEmpty()) {
            lastBookId = books.getLast().getBookId();
        }

        int bookId =(lastBookId+1);

            // Print confirmation info
            System.out.println("\n\t***Confirmation***");
            System.out.println("Your booking id is: " + bookId);
            System.out.println("Thr room that you chose has the number: " + temp.getRommNumber());
            System.out.println("Your check in will be at: " + checkinDate);
            System.out.println("Your check out will be at: " + checkoutDate);
            System.out.printf("The room that you chose costs per day %.2f", temp.getPricePerNight());
            System.out.printf(" and it costs for the whole period %.2f", price);
            System.out.print("\nAll information are correct (Y/N)? ");
            String choice = scan.nextLine();


            // check input for confirmation and create new booking, print in logg and add booking to customer list of bookings
            if (choice.equalsIgnoreCase("y")) {
                Booking newBooking = new Booking(checkinDate, checkoutDate, temp.getRommNumber(), lastBookId);
                newBooking.setTotalPrice(price);
                owner.addCustomerBookings(newBooking.getBookId());
                books.add(newBooking);

                new ReadWrite().write(newBooking.getBookId(), checkinDate, checkoutDate, temp.getRommNumber(), false);
                System.out.println("Thank you for choosing our hotel!");
            }
        }

    private void editBooking(Customer owner) {
        Date CheckDate = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date;
        int bookId;
        int choice = 0;
        Booking booking = null;

        System.out.println("Enter booking id:");
        bookId = scan.nextInt();

        // hitta bokning via id i listan
        for (Booking book : books) {
            if (book.getBookId() == bookId) booking = book;
        }

        // Om bokningen inte finns - return från metod
        if(booking == null){
            System.err.println("Booking ID is not found in database");
            return;
        }

        while (choice != -1) {
            System.out.print("\n" +
                    "[1] Check in date\n" +
                    "[2] Check out date\n" +
                    "[3] Change Entire booking\n" +
                    "[4] Back to menu \n" +
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
                    System.out.println("Current check in date: " + booking.getCheckinDate());
                    scan.nextLine();
                    System.out.println("Enter new check in date:");
                    date = scan.nextLine();

                    try {
                        CheckDate = dateFormat.parse(date);
                    } catch (ParseException e) {
                        System.err.println("\nThats not a valid date\n\n");
                        //e.printStackTrace();
                    }finally {
                        LinkedList<Integer> list = viewAvailableRoomDate(CheckDate, booking.getCheckoutDate(), false, booking.getBookId());
                            if(list !=null && !list.contains(booking.getRoomNbr())){
                                booking.setCheckinDate(CheckDate);
                                new ReadWrite().write(bookId, CheckDate, booking.getCheckoutDate(), booking.getRoomNbr(), true);
                            }else{
                                System.out.println("This room is not available for this date");
                                viewAvailableRoomDate(CheckDate, booking.getCheckoutDate(), true, booking.getBookId());
                            }
                    }
                    break;
                }

                case 2: {
                    System.out.println("Current check out date: " + booking.getCheckoutDate());
                    scan.nextLine();
                    System.out.println("Enter new check out date:");
                    date = scan.nextLine();
                    try {
                        CheckDate = dateFormat.parse(date);
                    } catch (ParseException e) {
                        System.err.println("Thats not a valid date");
                        //e.printStackTrace();
                    }finally{
                        LinkedList<Integer> list = viewAvailableRoomDate(booking.getCheckinDate(),CheckDate , false, bookId);
                        if(list !=null && !list.contains(booking.getRoomNbr())){
                            booking.setCheckinDate(CheckDate);
                            new ReadWrite().write(bookId, CheckDate, booking.getCheckoutDate(), booking.getRoomNbr(), true);
                        }else{
                            System.out.println("This room is not available for this date");
                            viewAvailableRoomDate(booking.getCheckinDate(),CheckDate , true, bookId);
                        }
                    }
                    break;
                }

                case 3:
                    scan.nextLine();

                    addNewBooking(owner);

                    try {
                        for (Booking b : books) {
                            if (b.getBookId() == bookId) {
                                books.remove(b);
                                System.out.println("Old booking with ID: " + bookId + " is removed.");
                                System.out.println("Please use your new booking ID for future reference");
                                break;
                            }
                        }
                    }catch(ConcurrentModificationException e){
                        System.err.println("Error");
                        continue;
                    }

                    break;

                case 4: {
                    choice = -1;
                    break;
                }
            }
        }
    }

    private void viewBookings() {
        if (books.size() > 0) {
            System.out.println("\tListing all the registered bookings at Hotel California\n");
            System.out.println("Index\t\tBookID\t\tRoomNumber\t\t\tCheck-in\t\t\t\t\t\t\t\tCheckout\n");
        }

        for (int i = 0; i < books.size(); i++) {
            System.out.print((i + 1) + "\t\t\t");
            System.out.print(books.get(i).getBookId() + "\t\t\t");
            System.out.print(books.get(i).getRoomNbr() + "\t\t\t\t\t");
            System.out.print(books.get(i).getCheckinDate() + "\t\t\t");
            System.out.print(books.get(i).getCheckoutDate() + "\t\t");
            System.out.println();

        }
            /*
            Så här kan man kalla på checkin och skriva ut
            b.setActualCheckIn();
            System.out.println(b.getActualCheckIn());
            */
    }

    private void caneclBooking() {
        viewBookings();
        if (books.size() > 0) {
            System.out.print("\nChoose the booking that you want to delete or just 0 to abort: ");
            int choice = scan.nextInt();
            if (choice == 0) {
                return;
            } else if (choice < books.size() || choice == books.size()) {
                books.remove(choice - 1);
            } else {
                System.out.println("Something went wrong, please try later!");
            }
        } else {
            System.out.println("There are none bookings to cancel!");
        }


    }

    private void viewBookingHistoryForUser(Customer user, boolean allHistory){

        LinkedList<Integer> customerBookings = user.getCustomerBookings();
        Date date = new Date(System.currentTimeMillis());

        for(Booking b: books){
            if(customerBookings.contains(b.getBookId())){
                    if(allHistory) {
                        viewBookingById(b.getBookId());
                    }else{
                        if(b.getCheckinDate().after(date)){
                            viewBookingById(b.getBookId());
                        }
                    }
                }
            }
        }

    private void viewBookingById(int bookingId){

        boolean noBookingFound = true;

        for(Booking b: books){
            if(b.getBookId() == bookingId){
                System.out.println("\nBooking ID: " + bookingId);
                System.out.println("Check in: " + b.getCheckinDate());
                System.out.println("Check Out: " + b.getCheckoutDate());
                System.out.println("Room Number: " + b.getRoomNbr());
                System.out.printf("Total Price: %.2f\n", b.getTotalPrice());
                noBookingFound = false;
            }
        }

        if(noBookingFound){
            System.out.println("\n No Booking Found with bookingId " + bookingId);
        }

    }

    //Room methods

    private void addNewRoom() {

        boolean hasBalcony = false;
        int roomNumber = rooms.size() + 1;
        System.out.println("\nAdding a new Room: ");
        System.out.println("\nThe room number is gonna be : " + roomNumber);

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
        System.out.print("How much does the room cost per night? ");

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
        scan.nextLine();
        System.out.println("\n\t***Confirmation***");
        System.out.println("The room number is: " + roomNumber);
        System.out.println("The room has " + bedsQuantity + " beds");
        if (hasBalcony) {
            System.out.println("And has a balcony");
        } else {
            System.out.println("And has not a balcony");

        }

        System.out.println("The room costs per night: " + cost);
        System.out.print("\nAll information are correct (Y/N)? ");
        String choice = scan.nextLine();

        if (choice.equalsIgnoreCase("y")) {
            rooms.add(new Room(roomNumber - 1, bedsQuantity, hasBalcony, cost));
            System.out.println("A new room with the number " + roomNumber + " has now been added to the hotel");
        } else {
            System.out.println("Please try again!");
        }


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
                    (i + 1) + "\t\t" +
                            (temp.getRommNumber() + 1 + "\t\t" +
                                    rooms.get(i).getNumberOfBeds() + "\t\t" +
                                    df.format(rooms.get(i).getPricePerNight()) + "\t\t" +
                                    rooms.get(i).isHasBalcony()));
        }
        if (counter == 1) {
            System.out.println("There are no rooms to view!");
        }
    }

    private void viewAvailableRoomByEmployee() {
        Date checkoutDate = null;
        Date checkinDate = null;

        scan.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("Enter check-in date (Format: yyyy-mm-dd):");
        String date = scan.nextLine();
        try {
            checkinDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Enter check-out date (Format: yyyy-mm-dd):");
        date = scan.nextLine();
        try {
            checkoutDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        viewAvailableRoomDate(checkinDate, checkoutDate, false, -1);

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

        System.out.println("\n\t***Confirmation***");
        System.out.println("Your your full name is: " + name);
        System.out.println("Your social security-number is: " + ssn);
        System.out.println("Your phone-number is: " + phoneNumber);
        System.out.println("Your address is: " + address);
        System.out.println("Your username is: " + userName);
        System.out.println("Your password is: " + password);
        System.out.print("\nAll information are correct (Y/N)? ");
        String choice = scan.nextLine();

        if (choice.equalsIgnoreCase("y")) {
            Customer customer = new Customer(ssn, name, address, phoneNumber, userName, password);
            users.add(customer);
            System.out.println("\n**Customer-account created**\nThank you for using out hotel!");
            System.out.println("To login in your account, please use your username and password");
        } else {
            System.out.println("Please try again!");
        }

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
        boolean counter = false;
        for (Person customer : users) {

            if (customer.getClass().equals(Customer.class)) {
                counter = true;
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
        if (!counter) {
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

        System.out.println("\nName: " + owner.getName());
        System.out.println("SSN: " + owner.getSsn());
        System.out.println("Phone-number: " + owner.getContactNBR());
        System.out.println("Address: " + owner.getAddress());
        System.out.println("Username: " + owner.getUserName());
        System.out.println("Password: " + owner.getPassword());
        System.out.println();

    }

    private void checkIn(Customer owner) {
        boolean count = false;
        int bookingID = 0;
        System.out.print("Enter booking-id: ");
        try {
            bookingID = scan.nextInt();
        } catch (Exception e) {
            System.out.println("\nWrong input");
            count = true;
            scan.next();
        }

        for (Booking b : books) {
            if (owner.getCustomerBookings().contains(bookingID) && b.getBookId() == bookingID) {
                if (b.getActualCheckIn() == null) {
                    b.setActualCheckIn();
                    System.out.println("Success! Check-in registered at: " + b.getActualCheckIn());
                    count = true;
                    break;
                } else {
                    System.out.println("You can not check-in more than one time!");
                }

            }

        }
        if (!count) {
            System.out.println("The booking-id couldn't find");
        }
    }

    private void checkOut(Customer owner) {
        boolean count = false;
        int bookingID = 0;
        System.out.print("Enter booking-id: ");
        try {
            bookingID = scan.nextInt();
        } catch (Exception e) {
            System.out.print("\nWrong input!\n");
            count = true;
            scan.next();
        }

        for (Booking b : books) {
            if (owner.getCustomerBookings().contains(bookingID) && b.getBookId() == bookingID) {
                if (b.getActualCheckIn() != null) {
                    b.setActualCheckOut();
                    System.out.println("Success! Checkout registered at: " + b.getActualCheckOut());
                    count = true;
                    break;
                } else {
                    System.out.println("\nUnable to check-out");
                    System.out.println("Probably because you did not check-in yet\nPlease contact the customer service for more information!");
                    count = true;
                    break;
                }

            }
        }
        if (!count) {
            System.out.println("The booking-id couldn't find");
        }
    }

    //Other methods

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

    private LinkedList<Integer> viewAvailableRoomDate(Date tempStart, Date tempEnd, boolean print, int bookId) {

        LinkedList<Integer> roomNbrs = new LinkedList<>();

        try {
            for (Booking b : books) {
                    if((tempStart.after(b.getCheckinDate()) && tempStart.before(b.getCheckoutDate())) ||
                            (tempEnd.after(b.getCheckinDate()) && tempEnd.before(b.getCheckoutDate())) ||
                            (tempStart.before(b.getCheckinDate()) && tempEnd.after(b.getCheckoutDate()))){
                    if(b.getBookId() != bookId) {
                        roomNbrs.add(b.getRoomNbr());
                    }
                }
            }
        }catch(NullPointerException e){
            return null;
        }

        Room temp;
        boolean counter = false;
        DecimalFormat df = new DecimalFormat("#.##");
        for (int i = 0; i < rooms.size(); i++) {
            temp = rooms.get(i);

            if (!roomNbrs.contains(temp.getRommNumber())) {
                if (!counter && print) {
                    System.out.println("Listing all registered available rooms at Hotel California\n");
                    System.out.println("Listing all registered rooms at Hotel California\n");
                    System.out.println("Room\tBeds\tPrice/Night\tBalcony\n");
                    counter = true;
                }

                if (print) {
                    System.out.println(
                            temp.getRommNumber() + "\t\t" +
                                    rooms.get(i).getNumberOfBeds() + "\t\t" +
                                    df.format(rooms.get(i).getPricePerNight()) + "\t\t" +
                                    rooms.get(i).isHasBalcony());
                }
            }
        }
        if (!counter && print) {
            System.out.println("There are nona available rooms at Hotel California!");
            return null;
        }
        return roomNbrs;
    }

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
        for (int i = 1; i < 11; i++) {
            ppn = 299 + (399) * rand.nextDouble();
            Room room = new Room(i, rand.nextInt(4) + 1, rand.nextBoolean(), ppn);
            rooms.add(room);
        }

        save();

    }



}




