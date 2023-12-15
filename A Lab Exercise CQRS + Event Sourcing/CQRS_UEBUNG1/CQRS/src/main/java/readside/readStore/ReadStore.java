package readside.readStore;

import java.util.ArrayList;

import eventside.domain.Event;
import readside.dto.BookingDTO;

import java.util.*;

public class ReadStore {

    private List<Event> events = new ArrayList<>();
    private HashMap<Long, BookingDTO> bookingHashMap = new HashMap<>();


    //private List<BookingDTO> bookingDTOs = new ArrayList<>();

    public void processEvent(Event event) {
        events.add(event);
    }

    public void addBookingDTOToStore(BookingDTO bookingDTO) {
        bookingHashMap.put(bookingDTO.getBookingID(), bookingDTO);
    }

    public void cancelBookingDTO(Long bookingID) {
        bookingHashMap.remove(bookingID);
    }









}
