package readside.rest;

import eventside.EventRepository;
import readside.readStore.ProjectionInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import writeside.event.Event;


@RestController
public class EventRestReadController {
    
    @Autowired
    private ProjectionInterface projectionInterface;

    @PostMapping(value = "/event/addEvent", consumes = "application/json", produces = "application/json")
    public boolean addEvent(@RequestBody Event event) {
        
        projectionInterface.addBooking(event);
        System.out.println("Event received: " + event);
        return true;
    }

    @PostMapping(value = "/event/cancelEvent", consumes = "application/json", produces = "application/json")
    public boolean cancelEvent(@RequestBody Event event) {
       
        projectionInterface.cancelBooking(event);
        System.out.println("Event received: " + event);
        return true;
    }

    @PostMapping(value = "/event/addRoomEvent", consumes = "application/json", produces = "application/json")
    public boolean addRoomEvent(@RequestBody Event event) {

        projectionInterface.addRoom(event);
        System.out.println("Event received: " + event);
        return true;
    }

    @PostMapping(value = "/event/deleteRoomEvent", consumes = "application/json", produces = "application/json")
    public boolean deleteRoomEvent(@RequestBody Event event) {

        projectionInterface.deleteRoom(event);
        System.out.println("Event received: " + event);
        return true;
    }




}






