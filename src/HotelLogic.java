import java.text.*;
import java.util.*;
import java.text.SimpleDateFormat;

class HotelLogic {

    private Scanner scan;
    private LinkedList<Person> users = new LinkedList<>();
    private LinkedList<Booking> books = new LinkedList<>();
    private LinkedList<Room> rooms = new LinkedList<>();

    public HotelLogic() {
        this.scan = new Scanner(System.in);
        load();
        //createTestInfo();
    }

    // Login user and check for user type

    protected void loginUser() {

        System.out.print("UserName: ");
        String userName = scan.nextLine();
        System.out.print("PassWord: ");
        String passWord = scan.nextLine();
        int checkLogIn = 1;
        for (Person user : users) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(passWord)) {
                checkLogIn++;
                if (user.getClass().equals(Employee.class)) {
                    Employee emp = (Employee) user;
                    employeeMenu(emp);
                    break;
                } else if (user.getClass().equals(Customer.class)) {
                    Customer owner = (Customer) user;
                    customerMenu(owner);
                    break;
                }
            }
        }
        if (checkLogIn == 1) {
            System.out.println("\n\nLogin Failed\nPlease try again");

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
                    "[5] Exit customer mode(Save changes)\n\n" +
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

                        System.out.print("\n" +
                                "[1] New booking\n" +
                                "[2] Edit booking\n" +
                                "[3] View bookings\n" +
                                "[4] View booking history\n" +
                                "[5] Print Booking Information\n" +
                                "[6] Back to the main menu\n\n" +
                                "Your choice: ");
                        try {
                            choice = scan.nextInt();
                            scan.nextLine();
                        } catch (Exception e) {
                            System.out.println("Please choose a number from the menu");
                            scan.next();
                            continue;
                        }
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
                                System.out.print("Enter Booking ID: ");
                                int bookId = -1;
                                try {
                                    bookId = scan.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("Input not acceptable");
                                } finally {
                                    if (owner.getCustomerBookings().contains(bookId)) {
                                        viewBookingById(bookId, true, owner);
                                    } else {
                                        System.out.println("None booking is registered in your name with booking id: " + bookId);
                                    }
                                }

                                break;
                            }
                            case 6: {
                                choice = -2;
                                break;
                            }
                            default: {
                                System.out.println("Please choose a number from the menu! ");
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
                        try {
                            choice = scan.nextInt();
                            scan.nextLine();
                        } catch (Exception e) {
                            System.out.println("Please choose a number from the menu!");
                            scan.next();
                            continue;
                        }

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
                                System.out.println("Please choose a number from the menu ");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 3: {
                    viewAvailableRoomByUser();
                    break;
                }
                case 4: {
                    while (choice != -4) {

                        System.out.print("\n" +
                                "[1] View customer information\n" +
                                "[2] Edit customer information\n" +
                                "[3] Back to the main menu\n\n" +
                                "Your choice: ");
                        try {
                            choice = scan.nextInt();
                            scan.nextLine();
                        } catch (Exception e) {
                            System.out.println("Please choose a number from the menu ");
                            scan.next();
                            continue;
                        }
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
                                System.out.println("Please choose a number from the menu ");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 5: {
                    scan.nextLine();
                    save();
                    System.out.println("Your changes are now saved");
                    choice = -1;
                    break;
                }
                default: {
                    System.out.println("Please choose a number from the menu ");
                    break;
                }
            }
        }

    }

    private void employeeMenu(Employee user) {
        int choice = 0;
        while (choice != -1) {

            System.out.print("\n" +
                    "[1] Room options \n" +
                    "[2] Customer options\n" +
                    "[3] Bookings\n" +
                    "[4] Customer menu administration\n" +
                    "[5] Exit employee mode(Save changes)\n\n" +
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
                                viewAvailableRoomByUser();
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
                                System.out.println("Please choose a number from the menu");
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
                                "[3] View All Bookings (Not historic include)\n" +
                                "[4] Back to the main menu\n\n" +
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
                                System.out.print("Enter Booking ID: ");
                                int bookId = -1;
                                try {
                                    bookId = scan.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("Input not a number\n");
                                } finally {
                                    scan.nextLine();
                                    viewBookingById(bookId, false, user);
                                }
                                break;
                            }
                            case 2: {
                                cancelBooking();
                                break;
                            }
                            case 3: {
                                viewAllBookingsFromToday(user);
                                break;
                            }
                            case 4: {
                                choice = -4;
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
                case 4: {
                    Customer cust = (Customer) findCustomer();
                    if (cust != null) {
                        customerMenu(cust);
                    }
                    break;
                }
                case 5: {
                    scan.nextLine();
                    save();
                    System.out.println("Your changes are now saved");
                    choice = -1;
                    break;
                }
                default: {
                    System.out.println("Please choose a number from the menu ");
                    break;
                }
            }
        }
    }


    //Booking methods

    private void addNewBooking(Customer owner) {

        LinkedList<Integer> list;
        LinkedList<Integer> totalRooms = new LinkedList<Integer>();
        Date checkoutDate;
        Date checkinDate;
        String date;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        boolean checkDate;

        do {
            checkDate = false;
            // Enter check in date and try parse, if bad input return to previous menu
            System.out.print("Enter check-in date (Format: yyyy-mm-dd) or 0 to abort: ");
            date = scan.nextLine();

            if (date.equalsIgnoreCase("0")) {
                return;
            }

            try {
                checkinDate = dateFormat.parse(date);
            } catch (ParseException e) {
                System.out.println("\nDate input incorrect");
                System.out.println();
                return;
            }

            if (!checkinDate.after(new Date(System.currentTimeMillis()))) {
                System.out.println("Check in date cannot be before today");
                System.out.println();
                checkDate = true;
            }
        } while (checkDate);


        do {
            checkDate = false;
            // Enter check out date and try parse, if bad input return to previous menu
            System.out.print("Enter check-out date (Format: yyyy-mm-dd) or 0 to abort: ");
            date = scan.nextLine();

            if (date.equalsIgnoreCase("0")) {
                return;
            }

            try {
                checkoutDate = dateFormat.parse(date);
            } catch (ParseException e) {
                System.out.println("\nDate Input incorrect");
                System.out.println();
                return;
            }


            // Check if check out date is before check in date or date not entered, return to previous menu if dates are bad
            try {
                if (checkoutDate.before(checkinDate)) {
                    System.out.println("You have entered a check out date that is before check in- Please try again\n");
                    System.out.println();
                    checkDate = true;
                } else if (checkinDate.equals(checkoutDate)) {
                    System.out.println("Check Out has to be at least the day after check In\n");
                    checkDate = true;
                } else if (checkoutDate.before(new Date(System.currentTimeMillis()))) {
                    System.out.println("Check out has to be at least tomorrow\n");
                    System.out.println();
                    checkDate = true;
                }
            } catch (NullPointerException e) {
                System.out.println("Date was not entered\n");
                checkDate = true;
            }
        } while (checkDate);

        // List available rooms, input from user, check input against booked rooms
        list = viewAvailableRoomDate(checkinDate, checkoutDate, true, -1);
        int roomNumber;
        while (true) {
            System.out.print("\nEnter RoomNumbers or 0 to abort: ");
            try {
                roomNumber = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entered roomnumber not a number, please try again\n");
                scan.next();
                return;
            }

            if (roomNumber == 0) {
                return;
            }

            if (list != null && !list.contains(roomNumber) && roomNumber > 0) {
                System.out.println("Room with number: " + roomNumber + " has been added to your booking!");
                totalRooms.add(roomNumber);
                System.out.println("\nAdd more rooms to booking (Y/N)?");
                if(scan.nextLine().equalsIgnoreCase("y")){
                    continue;
                }
                break;
            } else {
                System.out.println("Room not available for the given Dates");
            }
        }

        // evaluate days between check in and check out
        int nbrOfDays = (int) ((checkoutDate.getTime() - checkinDate.getTime()) / (1000 * 60 * 60 * 24));

        // find room for current booking
        LinkedList<Room> temp = new LinkedList<Room>();
        for(int number : totalRooms) {
           for (Room r : rooms) {
               if (r.getRommNumber() == number) {
                   temp.add(r);
               }
           }
       }

        // calculate totalprice
        double price = 0;
        for(Room r : temp) {
            if (r != null) {
                price = price + (r.getPricePerNight() * nbrOfDays);
            } else {
                return;
            }
        }

        // calculate price per day
        double priceday = 0;
        for(Room r : temp){
            if(r != null){
                priceday = priceday + r.getPricePerNight();
            }else {
                return;
            }
        }

        int lastBookId = 0;
        if (!books.isEmpty()) {
            lastBookId = books.getLast().getBookId();
        }

        int bookId = (lastBookId + 1);

        // Print confirmation info
        System.out.println("\n\t***Confirmation***");
        System.out.println("Your booking id is: " + bookId);
        System.out.println("The room's that you chose has the number: " + totalRooms);
        System.out.println("Your check in will be at: " + checkinDate);
        System.out.println("Your check out will be at: " + checkoutDate);
        System.out.printf("The room that you chose costs per day %.2f", priceday);
        System.out.printf(" and it costs for the whole period %.2f", price);
        System.out.print("\nAll information are correct (Y/N)? ");
        String choice = scan.nextLine();


        // check input for confirmation and create new booking, print in logg and add booking to customer list of bookings
        /**if (choice.equalsIgnoreCase("y")) {
            Booking newBooking = new Booking(checkinDate, checkoutDate, temp.getRommNumber(), lastBookId);
            newBooking.setTotalPrice(price);
            owner.addCustomerBookings(newBooking.getBookId());
            books.add(newBooking);
            new ReadWrite().write(newBooking.getBookId(), checkinDate, checkoutDate, temp.getRommNumber(), false);
            System.out.print("Would you like us to print this information? Y/N ? ");
            if (scan.nextLine().equalsIgnoreCase("y")) {
                viewBookingById(bookId, true, owner);
            }

            System.out.println("Thank you for choosing our hotel!");
        }**/
    }

    private void editBooking(Customer owner) {
        Date CheckDate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date;
        int bookId;
        int choice = 0;
        Booking booking = null;

        System.out.print("Enter booking id: ");
        bookId = scan.nextInt();

        // Find booking with id from list.
        for (Booking book : books) {
            if (book.getBookId() == bookId && owner.getCustomerBookings().contains(bookId)) {
                booking = book;
            }
        }

        // If booking not exist - return from method.
        if (booking == null) {
            System.out.println("\nBooking ID is not found in database");
            return;
        }
        System.out.println("***Booking Information***");
        viewBookingById(bookId, false, owner);

        while (choice != -1) {
            System.out.print("\n\n" +
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
                    System.out.print("Enter new check in date: ");
                    date = scan.nextLine();

                    try {
                        CheckDate = dateFormat.parse(date);
                    } catch (ParseException e) {
                        System.out.println("\nThat's not a valid date\n\n");
                        return;
                    }
                        LinkedList<Integer> list = viewAvailableRoomDate(CheckDate, booking.getCheckoutDate(), false, booking.getBookId());
                        if (list != null && !list.contains(booking.getRoomNbr())) {
                            if (!checkDates(CheckDate, booking.getCheckoutDate())) {
                                System.out.println();
                                System.out.println("Choice of Date not possible ");
                                System.out.println();
                                return;
                            }
                            booking.setCheckinDate(CheckDate);
                            updateTotalpriceBooking(booking);
                            viewBookingById(bookId, false, owner);
                            new ReadWrite().write(bookId, CheckDate, booking.getCheckoutDate(), booking.getRoomNbr(), true);
                        } else {
                            System.out.println("This room is not available for this date");
                            viewAvailableRoomDate(CheckDate, booking.getCheckoutDate(), true, booking.getBookId());
                        }

                    break;
                }

                case 2: {
                    System.out.println("Current check out date: " + booking.getCheckoutDate());
                    scan.nextLine();
                    System.out.print("Enter new check out date: ");
                    date = scan.nextLine();
                    try {
                        CheckDate = dateFormat.parse(date);
                    } catch (ParseException e) {
                        System.out.println("That's not a valid date");
                        return;
                    }
                        LinkedList<Integer> list = viewAvailableRoomDate(booking.getCheckinDate(), CheckDate, false, bookId);
                        if (list != null && !list.contains(booking.getRoomNbr())) {
                            if (!checkDates(booking.getCheckinDate(), CheckDate)) {
                                System.out.println();
                                System.out.println("Choice of Date not possible");
                                System.out.println();
                                return;
                            }

                            booking.setCheckoutDate(CheckDate);
                            updateTotalpriceBooking(booking);
                            viewBookingById(bookId, false, owner);
                            new ReadWrite().write(bookId, CheckDate, booking.getCheckoutDate(), booking.getRoomNbr(), true);
                        } else {
                            System.out.println("This room is not available for this date");
                            viewAvailableRoomDate(booking.getCheckinDate(), CheckDate, true, bookId);
                        }
                    }
                    break;


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
                    } catch (ConcurrentModificationException e) {
                        System.out.println("Error");
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
            System.out.println("BookID\t\tRoomNumber\t\t\tCheck-in\t\t\t\t\t\t\t\tCheckout\n");
        }

        for (int i = 0; i < books.size(); i++) {
            System.out.print(books.get(i).getBookId() + "\t\t\t");
            System.out.print(books.get(i).getRoomNbr() + "\t\t\t\t\t");
            if (books.get(i).getActualCheckIn() != null) {
                System.out.print(books.get(i).getActualCheckIn() + "\t\t\t");
            } else {
                System.out.print(books.get(i).getCheckinDate() + "\t\t\t");
            }
            if (books.get(i).getActualCheckOut() != null) {
                System.out.print(books.get(i).getActualCheckOut() + "\t\t");
            } else {
                System.out.print(books.get(i).getCheckoutDate() + "\t\t");
            }
            System.out.println();

        }
            /*
            Så här kan man kalla på checkin och skriva ut
            b.setActualCheckIn();
            System.out.println(b.getActualCheckIn());
            */
    }

    private void cancelBooking() {
        viewBookings();
        if (books.size() > 0) {
            try {
                System.out.print("\nChoose the booking that you want to delete or just 0 to abort: ");
                int choice = scan.nextInt();
                if (choice == 0) {
                    return;
                } else if (choice > books.getLast().getBookId()) {
                    System.out.println("Booking ID out of range");
                }

                for (Booking b : books) {
                    if (b.getBookId() == choice) {
                        books.remove(b);
                        System.out.println("Booking Removed");
                    }

                }

            } catch (ConcurrentModificationException e) {
                System.out.println();

            } catch (InputMismatchException e) {
                System.out.println("Wrong input");
                scan.nextLine();
            }

        } else {
            System.out.println("There are no bookings to show");
        }
    }

    private void viewBookingHistoryForUser(Customer user, boolean allHistory) {

        LinkedList<Integer> customerBookings = user.getCustomerBookings();
        Date date = new Date(System.currentTimeMillis());

        for (Booking b : books) {
            if (customerBookings.contains(b.getBookId())) {
                if (allHistory) {
                    viewBookingById(b.getBookId(), false, user);
                } else {
                    if (b.getCheckinDate().after(date)) {
                        viewBookingById(b.getBookId(), false, user);
                    }
                }
            }
        }
    }

    private void viewBookingById(int bookingId, boolean print, Person user) {

        if (bookingId == -1) {
            return;
        }

        boolean noBookingFound = true;

        for (Booking b : books) {
            if (b.getBookId() == bookingId) {

                System.out.println("\nBooking ID: " + bookingId);
                System.out.println("Check in: " + b.getCheckinDate());
                System.out.println("Check Out: " + b.getCheckoutDate());
                if (b.getActualCheckIn() != null && b.getCheckoutDate() != null) {
                    System.out.println("Actual Check-in date: " + b.getActualCheckIn());
                    System.out.println("Actual Check-out date: " + b.getActualCheckOut());
                } else {
                    System.out.println("No actual Check In/Out is registered!");
                }
                System.out.println("Room Number: " + b.getRoomNbr());
                System.out.printf("Total Price: %.2f\n", b.getTotalPrice());
                noBookingFound = false;

                if (print) {
                    new ReadWrite().printBooking(b, (Customer) user);
                }
            }
        }

        if (noBookingFound) {
            System.out.println("No Booking Found with bookingId: " + bookingId);
        }
    }

    private void viewAllBookingsFromToday(Person user) {
        Date date = new Date(System.currentTimeMillis());

        for (Booking b : books) {
            if (b.getCheckinDate().after(date)) {
                viewBookingById(b.getBookId(), false, user);
            }
        }
    }

    private void checkIn(Customer owner) {
        boolean count = false;
        int bookingID = 0;
        System.out.print("Enter booking-id: ");
        try {
            bookingID = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("\nWrong input");
            count = true;
            scan.next();
        }

        for (Booking b : books) {
            if (owner.getCustomerBookings().contains(bookingID) && b.getBookId() == bookingID) {
                if (b.getActualCheckIn() == null) {
                    b.setActualCheckIn();
                    System.out.println("\nSuccess! Check-in registered at: " + b.getActualCheckIn());
                    count = true;
                    break;
                } else {
                    System.out.println("\nYou can not check-in more than one time!");
                    return;
                }
            }
        }
        if (!count) {
            System.out.println("\nThe booking-id couldn't find!");
        }
    }

    private void checkOut(Customer owner) {
        boolean count = false;
        int bookingID = 0;
        System.out.print("Enter booking-id: ");
        try {
            bookingID = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.print("\nWrong input!\n");
            count = true;
            scan.next();
        }

        for (Booking b : books) {
            if (owner.getCustomerBookings().contains(bookingID) && b.getBookId() == bookingID) {
                if (b.getActualCheckIn() != null && b.getActualCheckOut() == null) {
                    b.setActualCheckOut();
                    System.out.println("\nSuccess! Checkout registered at: " + b.getActualCheckOut());
                    count = true;
                    break;
                } else if (b.getActualCheckIn() == null) {
                    System.out.println("\nYou have not checked in yet!\nplease try after you have check in!");
                    count = true;
                    break;
                } else if (b.getActualCheckOut() != null) {
                    System.out.println("\nYou can not check-out more than one time!");
                    count = true;
                    break;
                } else {
                    System.out.println("\nSomething went wrong\nUnable to check-out");
                    count = true;
                    break;
                }
            }
        }
        if (!count) {
            System.out.println("The booking-id couldn't find");
        }
    }


    //Room methods

    private void addNewRoom() {

        boolean hasBalcony = false;
        int roomNumber = rooms.size() + 1;
        System.out.println("\nAdding a new Room: ");
        System.out.println("\nThe room number is gonna be : " + roomNumber);

        System.out.print("Enter the number of beds: ");
        int bedsQuantity;
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

        double cost;
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
            rooms.add(new Room(roomNumber, bedsQuantity, hasBalcony, cost));
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
                            (temp.getRommNumber() + "\t\t" +
                                    rooms.get(i).getNumberOfBeds() + "\t\t" +
                                    df.format(rooms.get(i).getPricePerNight()) + "\t\t" +
                                    rooms.get(i).isHasBalcony()));
        }
        if (counter == 1) {
            System.out.println("There are no rooms to view!");
        }
    }

    private void viewAvailableRoomByUser() {
        Date checkoutDate = null;
        Date checkinDate = null;

        Date currentDate = new Date();

        scan.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        System.out.print("Enter check-in date (Format: yyyy-mm-dd): ");
        String date = scan.nextLine();
        try {
            checkinDate = dateFormat.parse(date);
            if (checkinDate.before(currentDate)) {
                System.out.println("Can not choose a date in the past!");
                return;
            }
        } catch (ParseException e) {
            System.out.println("Wrong Input!");
            return;
        }
        System.out.print("Enter check-out date (Format: yyyy-mm-dd): ");
        date = scan.nextLine();
        try {
            checkoutDate = dateFormat.parse(date);
            if (checkoutDate.before(checkinDate)) {
                System.out.println("Can not choose a date before the check-in date! ");
                return;
            } else if (checkoutDate.equals(checkinDate)) {
                System.out.println("\nThe difference between check-in/out must at least be one night\nPlease try again!");
                return;
            }
        } catch (ParseException e) {
            System.out.println("Wrong Input!");
            return;
        }
        viewAvailableRoomDate(checkinDate, checkoutDate, true, 0);

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

    private LinkedList<Integer> viewAvailableRoomDate(Date tempStart, Date tempEnd, boolean print, int bookId) {

        LinkedList<Integer> roomNbrs = new LinkedList<>();

        try {
            for (Booking b : books) {
                if ((tempStart.after(b.getCheckinDate()) && tempStart.before(b.getCheckoutDate())) ||
                        (tempEnd.after(b.getCheckinDate()) && tempEnd.before(b.getCheckoutDate())) ||
                        (tempStart.before(b.getCheckinDate()) && tempEnd.after(b.getCheckoutDate())) ||
                        (tempStart.equals(b.getCheckinDate()) && tempEnd.equals(b.getCheckoutDate()))) {
                    if (b.getBookId() != bookId) {
                        roomNbrs.add(b.getRoomNbr());
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Error getting booknumbers");
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


    //Customer methods

    private void addNewCustomer() {
        scan.nextLine();
        System.out.print("Enter your full name: ");
        String name = scan.nextLine();
        String ssn = "";
        boolean run = false;
        while (!run) {
            System.out.print("Enter your 10 digits social security-number(xxxxxx-xxxx): ");
            ssn = scan.nextLine();
            if (ssn.equalsIgnoreCase("0")) {
                return;
            }
            if (!ssn.matches("\\d{6}-\\d{4}")) {
                System.out.println("\nPlease write your social security-number in this format\nxxxxxx-xxxx\n");
                continue;
            }
            for (Person p : users) {
                if (p.getClass().equals(Customer.class)) {
                    if (p.getSsn().equals(ssn)) {
                        System.out.println("\nThe social security-number is already used. Please try another one or 0 to abort!\n");
                        run = false;
                        break;
                    } else {
                        run = true;
                    }
                }
            }
        }
        System.out.print("Enter your phone-number: ");
        String phoneNumber = scan.nextLine();
        System.out.print("Enter your address: ");
        String address = scan.nextLine();

        String userName = "";
        run = false;
        while (!run) {
            System.out.print("Enter your username: ");
            userName = scan.nextLine();
            for (Person p : users) {
                if (p.getClass().equals(Customer.class)) {
                    if (p.getUserName().equals(userName)) {
                        System.out.println("The username is already used. Please try another one or 0 to abort!");
                        run = false;
                        break;
                    } else if (userName.equalsIgnoreCase("0")) {
                        return;
                    } else if (userName.equals("")) {

                    } else {
                        run = true;
                    }
                }
            }
        }

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
            System.out.println("\n\n**Customer-account created**\nThank you for using out hotel!");
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
        boolean run = false;
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
                    while (!run) {
                        System.out.print("Enter your social security-number (xxxxxx-xxxx) or 0 to go the next step: ");
                        String ssn = scan.nextLine();
                        int check = 0;

                        if (ssn.equalsIgnoreCase("0")) {
                            //run = true;
                            break;
                        } else {
                            for (Person p : users) {
                                if (p.getSsn().equalsIgnoreCase(ssn)) {
                                    check = 1;
                                }
                            }
                            switch (check) {
                                case 1:
                                    check = 1;
                                    System.out.println("Entered security-number allready used!");
                                    run = false;
                                    break;
                                case 2:
                                    check = 0;
                                    run = true;
                                    break;
                            }
                            if (ssn.matches("\\d{6}-\\d{4}")) {
                                users.get(customerNumber).setSsn(ssn);
                            }
                        }
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
        } else{
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

    private Customer findCustomer() {

        scan.nextLine();
        System.out.print("Enter SSN, TelephoneNumber or UserName: ");
        String SearchParam = scan.nextLine();

        for (Person p : users) {
            if ((p.getSsn().equalsIgnoreCase(SearchParam)) ||
                    (p.getContactNBR().equals(SearchParam)) ||
                    (p.getUserName().equals(SearchParam))) {

                if (p.getClass().equals(Customer.class)) {
                    viewCurrentCustomer((Customer) p);
                } else {
                    break;
                }
                System.out.print("Customer found, Correct Y/N? ");

                if ((scan.nextLine()).equalsIgnoreCase("y")) {
                    return (Customer) p;
                } else {
                    return null;
                }

            }
        }

        System.out.println("Could not find any users with this information");

        return null;
    }

    private void updateTotalpriceBooking(Booking booking) {
        int nbrOfDays = (int) ((booking.getCheckoutDate().getTime() - booking.getCheckinDate().getTime()) / (1000 * 60 * 60 * 24));

        for (Room r : rooms) {
            if (r.getRommNumber() == booking.getRoomNbr()) {
                booking.setTotalPrice((r.getPricePerNight() * nbrOfDays));
            }
        }
        System.out.println("\n***Booking Updated***\n");

    }

    private boolean checkDates(Date checkIn, Date checkOut) {

        if (checkOut.before(checkIn) ||
                checkOut.equals(checkIn) ||
                checkIn.before(new Date(System.currentTimeMillis())) ||
                checkOut.before(new Date(System.currentTimeMillis()))) {
            return false;
        } else {
            return true;
        }
    }

}




