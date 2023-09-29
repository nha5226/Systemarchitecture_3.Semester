package writeside.application.impl;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import ch.qos.logback.core.net.SyslogOutputStream;
import writeside.EventPublisher;
import writeside.ServiceLocator;
import writeside.application.CommandInterface;
import writeside.domain.Booking;
import writeside.domain.Room;
import writeside.domain.repository.Repositroy;
import writeside.event.*;


public class Command implements CommandInterface{

    //@Autowired
    private Repositroy repositroy = ServiceLocator.repositroy();
    private EventPublisher eventPublisher = new EventPublisher();

    private static long number = 100;

    @Override
    public boolean cancelBooking(long bookingID) {
        //validate Command
        boolean validCommand = repositroy.cancelBooking(bookingID);

        if(validCommand) {
            //Create Event
            System.out.println("Valid Command Create Event :" );
            Event event = new BookingCanceledEvent(bookingID);
            eventPublisher.publishCancelEvent(event);
          return true;
        }
        System.err.println("Command not Valid :");
        return false;
    }

    @Override
    public boolean createRoom(String roomNumber, int capacity) {
        Room room = new Room(roomNumber, capacity);

        //validate Command
        boolean validCommand = repositroy.addRoom(room);

        if(validCommand) {
            //create Event
            System.out.println("Valid Command Create Event : Add Room with Room-Number: " + roomNumber);
            Event event = new AddRoomEvent(room.getCapacity(), room.getRoomNumber());
            eventPublisher.publishAddRoomEvent(event);
            return true;
        }
        System.err.println("There is already a Room with this Room-number");
        return false;
    }

    @Override
    public boolean deleteRoom(String roomNumber) {

        boolean validCommand = repositroy.deleteRoom(roomNumber);


        if(validCommand) {
            //create Event
            System.out.println("Valid Command Create Event : Delete Room with Room-Number: " + roomNumber);
            Event event = new DeleteRoomEvent(roomNumber);
            eventPublisher.publishDeleteRoomEvent(event);
            return true;
        }
        System.err.println("Cannot delete a Room witch does not exist.");
        return false;
    }

    @Override
    public boolean addBooking(LocalDate fromDate, LocalDate toDate, String roomnumber, String firstName, String lastName, int numberOfPeople) {

        Booking booking =  new Booking();
        booking.setBookingID(number++);
        booking.setBookingFrom(fromDate);
        booking.setBookingTo(toDate);
        booking.setRoomNumber(roomnumber);
        booking.setFirstName(firstName);
        booking.setLastName(lastName);
        booking.setNumberOfPersons(numberOfPeople);

        //validate Command
        boolean validCommand = repositroy.addBooking(booking);

        if(validCommand) {
            //Create Command
            System.out.println("Valid Command Create Event : Create Booking with Booking-number: " + (number-1));
            Event event = new BookingCreatedEvent(booking.getBookingID(), roomnumber, fromDate, toDate, firstName, lastName, numberOfPeople);
            eventPublisher.publishAddEvent(event);
            return true;
        }
        System.err.println("Cannot create Booking");
        number--;
        return false;
    }
}
