package eventside.publisher;


import writeside.event.Event;

public interface Publisher {

    public Boolean publishAddEvent(Event event);

    public Boolean publishCancelEvent(Event event);

    public Boolean publishAddRoomEvent(Event event);

    public Boolean publishDeleteRoomEvent(Event event);

}
