public class Room {

    private int roomNumber;
    private int numberOfBeds;
    private boolean hasBalcony;
    private double pricePerNight;
    private boolean isBooked;
    private static int counter = 1;


    public Room(int numberOfBeds, boolean hasBalcony, double pricePerNight) {
        this.setNumberOfBeds(numberOfBeds);
        this.setHasBalcony(hasBalcony);
        this.setPricePerNight(pricePerNight);
        this.setBooked(isBooked);
        roomNumber = counter;
        counter++;
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
