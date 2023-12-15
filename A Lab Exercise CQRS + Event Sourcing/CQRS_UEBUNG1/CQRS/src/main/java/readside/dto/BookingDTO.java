package readside.dto;

public class BookingDTO {
    
    private long bookingID;
    private String firstName;
    private String lastName;
    private String roomNumber;
    private String from;
    private String to;
    private String numberOfPersons;
    
    public long getBookingID() {
        return bookingID;
    }
    public void setBookingID(long bookingID) {
        this.bookingID = bookingID;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public String getNumberOfPersons() {
        return numberOfPersons;
    }
    public void setNumberOfPersons(String numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }
}
