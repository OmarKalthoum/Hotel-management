import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ReadWrite {

        public void read () {

        }

        public void write (int bookId, Date checkinDate, Date checkoutDate, int roomNbr){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                //Choose file
                PrintWriter pw = new PrintWriter(new FileWriter("Booking_LOGG.txt", true));
                //Print out information to file
                pw.println("---------------------------------------------------------------------------");
                pw.println("|Booking Id: " + bookId + "|Check In: " + dateFormat.format(checkinDate) + "|Check Out: " + dateFormat.format(checkoutDate) + "|Room Number: " + roomNbr + "|");
                pw.println("---------------------------------------------------------------------------");
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }