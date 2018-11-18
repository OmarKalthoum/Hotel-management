import java.util.ArrayList;
import java.util.Date;

public class Booking {

    private int bookingId;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalPrice;

    //Constructur does not seem well! Check it later
    public Booking(int bookingId, Date checkInDate, ArrayList<Room> rooms){
        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
        //ArrayList(Room)??
    }

}
