import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable {

    private final int bookId;
    private Date checkinDate;
    private Date checkoutDate;
    private double totalPrice;
    private boolean isCanceled = false;
    private int roomNbr;
    private Date actualCheckOut;
    private Date actualCheckIn;


    public Booking(Date checkinDate, Date checkoutDate, int roomNbr,int bookId){
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.roomNbr = roomNbr;
        this.bookId = bookId;
    }

    public int getRoomNbr() {
        return roomNbr;
    }

    public void setRoomNbr(int roomNbr) {
        this.roomNbr = roomNbr;
    }

    protected int getBookId() {
        return bookId;
    }

    protected Date getCheckinDate() {
        return checkinDate;
    }

    protected void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    protected Date getCheckoutDate() {
        return checkoutDate;
    }

    protected void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    protected double getTotalPrice() {
        return totalPrice;
    }

    protected void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    protected boolean isCanceled() {
        return isCanceled;
    }

    protected void setCanceled() {
        isCanceled = true;
    }

    public Date getActualCheckOut() {
        return actualCheckOut;
    }

    public void setActualCheckOut() {
        this.actualCheckOut  = new Date();
        this.actualCheckOut.setTime(System.currentTimeMillis());
    }

    public Date getActualCheckIn() {
        return actualCheckIn;
    }

    public void setActualCheckIn() {
        this.actualCheckIn = new Date();
        this.actualCheckIn.setTime(System.currentTimeMillis());
    }
}
