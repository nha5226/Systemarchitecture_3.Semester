package writeside.application;

import java.time.LocalDate;

public interface CommandInterface {
    
    public boolean addBooking(LocalDate fromDate, LocalDate toDate, String roomnumber, String firstName, String lastName, int numberOfPeople);

    public boolean cancelBooking(long bookingID);

    public boolean createRoom(String roomNumber, int capacity);

    public boolean deleteRoom(String roomNumber);
}
