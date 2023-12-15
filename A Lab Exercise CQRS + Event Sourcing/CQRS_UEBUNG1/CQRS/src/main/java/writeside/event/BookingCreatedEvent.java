package writeside.event;

import java.time.LocalDate;

public class BookingCreatedEvent extends Event{

    private long bookingID;
    private String roomNumber;

    private LocalDate bookingFrom;
    private LocalDate bookingTo;

    private String firstName;
    private String lastName;

    private int numberOfPersons;

    public BookingCreatedEvent(long bookingId, String roomNumber,
                               LocalDate bookingFrom, LocalDate bookingTo,
                               String firstName, String lastName,
                               int numberOfPersons) {
        this.bookingID = bookingId;
        this.roomNumber = roomNumber;
        this.bookingFrom = bookingFrom;
        this.bookingTo = bookingTo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberOfPersons = numberOfPersons;
    }

    public BookingCreatedEvent() {}

    public long getBookingID() {
        return bookingID;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public LocalDate getBookingFrom() {
        return bookingFrom;
    }

    public LocalDate getBookingTo() {
        return bookingTo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setBookingID(long bookingID) {
        this.bookingID = bookingID;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setBookingFrom(LocalDate bookingFrom) {
        this.bookingFrom = bookingFrom;
    }

    public void setBookingTo(LocalDate bookingTo) {
        this.bookingTo = bookingTo;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }
}
