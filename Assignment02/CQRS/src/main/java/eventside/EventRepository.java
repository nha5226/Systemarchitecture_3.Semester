package eventside;


import eventside.publisher.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import writeside.event.*;

import java.util.ArrayList;
import java.util.List;


public class EventRepository {


    private Publisher publisher = ServiceLocator.getPublisher();

    private List<Event> events = new ArrayList<>();

    public void processEvent(Event event) {
        events.add(event);

        System.out.println(event.getClass().getName());

        if(event instanceof BookingCreatedEvent) {
            System.out.println("BookingCreatedEvent");
            publisher.publishAddEvent(event);
        }
        if(event instanceof BookingCanceledEvent) {
            System.out.println("BookingCanceldEvent");
            publisher.publishCancelEvent(event);

        }
        if(event instanceof AddRoomEvent) {
            System.out.println("AddRoomEvent");
            publisher.publishAddRoomEvent(event);
        }

        if(event instanceof DeleteRoomEvent) {
            System.out.println("DeleteRoomEvent");
            publisher.publishDeleteRoomEvent(event);
        }
    }
}
