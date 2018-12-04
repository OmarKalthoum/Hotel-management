import java.io.Serializable;

public class Room implements Serializable {

    private int roomNumber;
    private int numberOfBeds;
    private boolean hasBalcony;
    private double pricePerNight;
    private boolean isBooked;


    public Room(int roomNumber, int numberOfBeds, boolean hasBalcony, double pricePerNight) {
        this.setRommNumber(roomNumber);
        this.setNumberOfBeds(numberOfBeds);
        this.setHasBalcony(hasBalcony);
        this.setPricePerNight(pricePerNight);
        this.setBooked(isBooked);
    }


    protected int getRommNumber() {
        return roomNumber;
    }

    protected void setRommNumber(int rommNumber) {
        this.roomNumber = rommNumber;
    }

    protected int getNumberOfBeds() {
        return numberOfBeds;
    }

    protected void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    protected boolean isHasBalcony() {
        return hasBalcony;
    }

    protected void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    protected double getPricePerNight() {
        return pricePerNight;
    }

    protected void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    protected boolean isBooked() {
        return isBooked;
    }

    protected void setBooked(boolean booked) {
        isBooked = booked;
    }

}
