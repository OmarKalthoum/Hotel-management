public class Room {

    private int rommNumber;
    private int numberOfBeds;
    private boolean hasBalcony;
    private double pricePerNight;
    private boolean isBooked;

    public Room(int rommNumber, int numberOfBeds, boolean hasBalcony, double pricePerNight, boolean isBooked) {
        this.rommNumber = rommNumber;
        this.numberOfBeds = numberOfBeds;
        this.hasBalcony = hasBalcony;
        this.pricePerNight = pricePerNight;
        this.isBooked = isBooked;
    }


}
