import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable {

    private final int bookId = 0;
    private Date checkinDate;
    private Date checkoutDate;
    private double totalPrice;
    private boolean isCanceled;
    private int roomNbr;


    public Booking(Date checkinDate, Date checkoutDate, int roomNbr){
        this.setCheckinDate(checkinDate);
        this.setCheckoutDate(checkoutDate);
        this.roomNbr = roomNbr;

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
