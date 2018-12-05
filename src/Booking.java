import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable {

    private final int bookId;
    private Date checkinDate;
    private Date checkoutDate;
    private double totalPrice;
    private boolean isCanceled;
    private int roomNbr;
    private static int counter = 0;

    public Booking(Date checkinDate, Date checkoutDate, int roomNbr){
        this.setCheckinDate(checkinDate);
        this.setCheckoutDate(checkoutDate);
        this.roomNbr = roomNbr;
        bookId = counter++;
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

    protected void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

}
