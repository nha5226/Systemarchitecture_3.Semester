package readside.readStore;


import writeside.event.Event;

public interface ProjectionInterface {
 
    public void addBooking(Event event);

    public void cancelBooking(Event event);

    public void addRoom(Event event);

    public void deleteRoom(Event event);

}
