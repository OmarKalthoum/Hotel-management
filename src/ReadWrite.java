import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedList;


public class ReadWrite {


    public void write(int bookId, Date checkinDate, Date checkoutDate, int roomNbr, boolean update) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //Chooses file
            PrintWriter pw = new PrintWriter(new FileWriter("Booking_LOGG.txt", true));
            //Print information to text file
            pw.println("---------------------------------------------------------------------------");
            if(update){
                pw.println("\t***** Updated By Customer *****");
            }
            pw.println("|Booking Id: " + bookId + "|Check In: " + dateFormat.format(checkinDate) + "|Check Out: " + dateFormat.format(checkoutDate) + "|Room Number: " + roomNbr + "|");
            pw.println("---------------------------------------------------------------------------");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printBooking(Booking booking, Customer user){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String filename = "BookingId-" + (booking.getBookId() + "-" + String.valueOf(user.getName())) + ".txt";

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(filename, true));

            pw.println("----------------------------------------------------------------------");
            pw.println("*** *** *** Your Booking Information from Hotel Califormia *** *** ***");
            pw.println("----------------------------------------------------------------------");
            pw.println(" Beloved Customer, we are very pleased that you have choosen our hotel");
            pw.println(" You will find all details about your booking below");
            pw.println(" See you soon and we hope you will enjoy staying with us");
            pw.println("\n Booking ID: " + booking.getBookId());
            pw.println(" Check in Date: " + dateFormat.format(booking.getCheckinDate()));
            pw.println(" Check Out Date: " + dateFormat.format(booking.getCheckoutDate()));
            pw.println(" Room Number: " + booking.getRoomNbr());
            pw.println(" Price in Total:  " + booking.getTotalPrice() + "\n");
            pw.println("   --- --- --- --- --- Your Personal Information --- --- --- --- ---");
            pw.println(" Mr/Mrs: " + user.getName());
            pw.println(" Adress: " + user.getAddress());
            pw.println(" TFN: " + user.getContactNBR());
            pw.println(" Personal ID: " + user.getSsn());
            pw.println("\n --------------------------------------------------------------------");
            pw.println("\n             *** *** *** Hotel Disclaimer *** *** ***");
            pw.println(" We are very glad that you have chosen Hotel California");
            pw.println(" Due to musical refrences we can not quarantee that checking out from ");
            pw.println(" hotel will result in you leaving the hotel. ");
            pw.println(" If you do not check out we will arrange that for you free of charge");
            pw.println(" If you have any questions you can contact us at 555-Eagles-RIP-OFF");
            pw.println(" Have nice day!");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private LinkedList read(File file) {
        if (file.exists()) {
            try {
                file.createNewFile();
                FileInputStream fin = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fin);
                LinkedList list = (LinkedList) ois.readObject();

                return list;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private void writelist(LinkedList list, File file) {

        try {
            file.createNewFile();
            FileOutputStream fout = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(list);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void saveUsers(LinkedList<Person> users) {
        File file = new File("users.txt");
        writelist(users, file);
    }

    protected void saveRooms(LinkedList<Room> rooms) {
        File file = new File("rooms.txt");
        writelist(rooms, file);
    }

    protected void saveBookings(LinkedList<Booking> bookings) {
        File file = new File("bookings.txt");
        writelist(bookings, file);
    }

    protected LinkedList readUsers() {
        File file = new File("users.txt");
        LinkedList list = read(file);

        return list;
    }

    protected LinkedList readRooms() {
        File file = new File("rooms.txt");
        LinkedList list = read(file);

        return list;
    }

    protected LinkedList readBookings() {
        File file = new File("bookings.txt");
        LinkedList list = read(file);

        return list;
    }
}