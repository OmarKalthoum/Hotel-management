import java.util.Date;

public class Booking {

    private int bookId;
    private Date checkinDate;
    private Date checkoutDate;
    private double totalPrice;
    private boolean isCanceled;

    public Booking(Date checkinDate, Date checkoutDate, double totalPrice){
        this.setCheckinDate(checkinDate);
        this.setCheckoutDate(checkoutDate);
        this.setTotalPrice(totalPrice);
    }

    protected int getBookId() {
        return bookId;
    }

    protected void setBookId(int bookId) {
        this.bookId = bookId;
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
