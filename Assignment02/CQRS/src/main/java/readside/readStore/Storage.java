package readside.readStore;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;
import readside.dto.BookingDTO;
import readside.dto.RoomDTO;


public class Storage implements StorageRepository{

    private List<BookingDTO> bookingDTOs = new LinkedList<>();
    private List<RoomDTO> roomDTOs = new LinkedList<>();


    @Override
    public void addBooking(BookingDTO b) {
        bookingDTOs.add(b);
    }

    @Override
    public void cancelBooking(long bookingId) {

        Iterator itr = bookingDTOs.iterator();

        while(itr.hasNext()){
            if(((BookingDTO)itr.next()).getBookingID() == bookingId) {
                itr.remove();
            }
        }
    }

    @Override
    public List<BookingDTO> getBookings(LocalDate from, LocalDate to) {
        List<BookingDTO> bookings = new LinkedList<>();

        for(BookingDTO b : bookingDTOs){
            LocalDate fromB = LocalDate.parse(b.getFrom());
            LocalDate toB = LocalDate.parse(b.getTo());

            if((fromB.equals(from) || fromB.isAfter(from)) && toB.equals(to) || toB.isBefore(to)) {
                bookings.add(b);
            }
        }

        return bookings;
    }

    @Override
    public List<RoomDTO> getFreeRooms(LocalDate from, LocalDate to, int capacity) {
        List<RoomDTO> rooms = new LinkedList<>();

        //all rooms with this capacity
        for(RoomDTO r : roomDTOs) {
            if(r.getCapacity() == capacity) {
                rooms.add(r);
            }
        }
        //search for bookings in this time period
        List<BookingDTO> bookingsInThisPeriod = getBookings(from, to);
        List<RoomDTO> roomsWitchAreBooked = new LinkedList<>();
        for(RoomDTO r : rooms) {
            for(BookingDTO b : bookingsInThisPeriod) {

                if(b.getRoomNumber().equals(r.getRoomNumber())) {
                    roomsWitchAreBooked.add(r);
                }
            }
        }
        for(RoomDTO r : roomsWitchAreBooked) {
            rooms.remove(r);
        }




        return rooms;
    }

    @Override
    public void addRoom(RoomDTO roomDTO) {
        roomDTOs.add(roomDTO);
    }

    @Override
    public void deleteRoom(String roomNumber) {
        Iterator<RoomDTO> itr = roomDTOs.iterator();

        while(itr.hasNext()) {
            if(itr.next().getRoomNumber().equals(roomNumber)){
                itr.remove();
            }
        }
    }
}
