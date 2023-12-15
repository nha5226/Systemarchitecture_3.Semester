package writeside.domain.repository;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import writeside.EventPublisher;
import writeside.domain.Booking;
import writeside.domain.Room;
import writeside.event.BookingCanceledEvent;
import writeside.event.BookingCreatedEvent;
import writeside.event.Event;

public class RepositoryStore implements Repositroy {

    List<Booking> list = new LinkedList<>();
    List<Room> listOfRooms = new LinkedList<>();

    EventPublisher eventPublisher = new EventPublisher();

    @Override
    public boolean addBooking(Booking booking) {

        boolean roomExist = false;
        //Check if Room exist
        for(Room r : listOfRooms) {
            if(r.getRoomNumber().equals(booking.getRoomNumber())) {
                //Room exist
                roomExist = true;
                break;
            }
        }

        if(!roomExist) {
            System.err.println("Room does not Exist");
            return false;
        }

        List<Booking> listOfBookingWithRoomNumber = getAllBookingWithRoomNumber(booking.getRoomNumber());

        for(Booking b : listOfBookingWithRoomNumber) {
            if(b.getBookingFrom().isBefore(booking.getBookingFrom()) && b.getBookingTo().isAfter(booking.getBookingFrom())) {
                System.out.println("An other Booking is in this Time period");
                return false;
            }
            if(b.getBookingFrom().isAfter(booking.getBookingFrom()) && b.getBookingTo().isBefore(booking.getBookingTo())) {
                System.out.println("An other Booking is in this Time period");
                return false;
            }
            if(b.getBookingFrom().isBefore(booking.getBookingTo()) && b.getBookingTo().isAfter(booking.getBookingTo())) {
                System.out.println("An other Booking is in this Time period");
                return false;
            }
            if(b.getBookingFrom().isBefore(booking.getBookingFrom()) && b.getBookingTo().isAfter(booking.getBookingTo())) {
                System.out.println("An other Booking is in this Time period");
                return false;
            }
        }
        list.add(booking);
        return true;
    }

    private List<Booking> getAllBookingWithRoomNumber(String roomNumber) {
        List<Booking> bookings = new LinkedList<>();

        for(Booking b : list) {
            if(b.getRoomNumber().equals(roomNumber)) {
                bookings.add(b);
            }
        }
        return bookings;
    }

    @Override
    public boolean cancelBooking(long bookingID) {
        
        Iterator itr = list.iterator();
        
        while(itr.hasNext()) {
            Booking b = (Booking) itr.next();
            
            if(b.getBookingID() == bookingID) {
                itr.remove();
                System.out.println("Deleted Booking with bookingID " + bookingID);
                return true;
            } 
        }
        return false;
    }

    @Override
    public List<Booking> getAllBooking() {
        return list;
    }

    @Override
    public List<Room> getAllRooms() {
        return listOfRooms;
    }

    @Override
    public boolean addRoom(Room room) {

        for(Room r : listOfRooms) {
            if(r.getRoomNumber().equals(room.getRoomNumber())) {
                return false;
            }
        }
        listOfRooms.add(room);
        return true;
    }

    @Override
    public boolean deleteRoom(String roomNumber) {
        Iterator itr = listOfRooms.iterator();

        while(itr.hasNext()) {

            if(roomNumber.equals(((Room)itr.next()).getRoomNumber())) {
                itr.remove();
                break;
            }
        }
        return true;
    }
}
