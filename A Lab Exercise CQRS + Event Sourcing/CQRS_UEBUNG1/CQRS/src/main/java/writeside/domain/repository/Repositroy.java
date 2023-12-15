package writeside.domain.repository;

import java.util.List;

import writeside.domain.Booking;
import writeside.domain.Room;

public interface Repositroy {
    
    public boolean addBooking(Booking booking);

    public boolean cancelBooking(long bookingID);

    public List<Booking> getAllBooking();

    public List<Room> getAllRooms();

    public boolean addRoom(Room room);

    public boolean deleteRoom(String roomNumber);
}
