import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedList;


public class ReadWrite {


    public void write(int bookId, Date checkinDate, Date checkoutDate, int roomNbr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //Chooses file
            PrintWriter pw = new PrintWriter(new FileWriter("Booking_LOGG.txt", true));
            //Print information to txt file
            pw.println("---------------------------------------------------------------------------");
            pw.println("|Booking Id: " + bookId + "|Check In: " + dateFormat.format(checkinDate) + "|Check Out: " + dateFormat.format(checkoutDate) + "|Room Number: " + roomNbr + "|");
            pw.println("---------------------------------------------------------------------------");
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