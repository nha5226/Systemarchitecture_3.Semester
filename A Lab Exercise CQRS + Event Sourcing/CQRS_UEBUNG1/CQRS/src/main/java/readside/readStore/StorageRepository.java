package readside.readStore;

import java.time.LocalDate;
import java.util.List;

import readside.dto.BookingDTO;
import readside.dto.RoomDTO;

public interface StorageRepository {



    public void addBooking(BookingDTO b);

    public void cancelBooking(long bookingId);
    
    public List<BookingDTO> getBookings(LocalDate from, LocalDate to);

    public List<RoomDTO> getFreeRooms(LocalDate from, LocalDate to, int capacity);

    public void addRoom(RoomDTO roomDTO);

    public void deleteRoom(String roomNumber);



}
