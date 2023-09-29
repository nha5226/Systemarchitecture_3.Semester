package readside.readStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import readside.ServiceLocator;
import readside.dto.BookingDTO;
import readside.dto.RoomDTO;
import writeside.event.*;

import java.beans.JavaBean;

@Component
public class Projection implements ProjectionInterface{


    private StorageRepository storageRepository = ServiceLocator.getStorageRepository();

    @Override
    public void addBooking(Event event) {
        //Cast to Booking
        event = (BookingCreatedEvent) event;

        BookingDTO bookingDTO = new BookingDTO();

        bookingDTO.setBookingID(((BookingCreatedEvent) event).getBookingID());
        bookingDTO.setFrom(((BookingCreatedEvent) event).getBookingFrom().toString());
        bookingDTO.setTo(((BookingCreatedEvent) event).getBookingTo().toString());
        bookingDTO.setFirstName(((BookingCreatedEvent) event).getFirstName());
        bookingDTO.setLastName(((BookingCreatedEvent) event).getLastName());
        bookingDTO.setRoomNumber(((BookingCreatedEvent) event).getRoomNumber());

        storageRepository.addBooking(bookingDTO);
    }

    @Override
    public void cancelBooking(Event event) {
        //cast
        Long bookingID = ((BookingCanceledEvent) event).getBookingID();
        storageRepository.cancelBooking(bookingID);
    }

    @Override
    public void addRoom(Event event) {
        event = (AddRoomEvent) event;
        RoomDTO roomDTO = new RoomDTO(((AddRoomEvent) event).getRoomNumber(), ((AddRoomEvent) event).getNumberOfPeople());
        storageRepository.addRoom(roomDTO);
    }

    @Override
    public void deleteRoom(Event event) {
        event = (DeleteRoomEvent) event;
        storageRepository.deleteRoom(((DeleteRoomEvent) event).getRoomNumber());
    }

}
