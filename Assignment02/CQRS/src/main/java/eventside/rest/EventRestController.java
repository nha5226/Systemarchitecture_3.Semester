package eventside.rest;

import eventside.EventRepository;
import eventside.ServiceLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import writeside.event.AddRoomEvent;
import writeside.event.BookingCreatedEvent;
import writeside.event.Event;

@RestController
public class EventRestController {


    private EventRepository repository = ServiceLocator.getEventRepository();

    @PostMapping(value = "/event/addEvent", consumes = "application/json", produces = "application/json")
    public boolean addEvent(@RequestBody Event event) {
        // TODO: process event in repository
        repository.processEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }

    @PostMapping(value = "/event/cancelEvent", consumes = "application/json", produces = "application/json")
    public boolean cancelEvent(@RequestBody Event event) {
        // TODO: process event in repository
        repository.processEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }

    @PostMapping(value = "/event/addRoomEvent", consumes = "application/json", produces = "application/json")
    public boolean addRoomEvent(@RequestBody Event event) {
        // TODO: process event in repository
        repository.processEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }


    @PostMapping(value = "/event/deleteRoomEvent", consumes = "application/json", produces = "application/json")
    public boolean deleteRoomEvent(@RequestBody Event event) {
        // TODO: process event in repository
        repository.processEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }



}