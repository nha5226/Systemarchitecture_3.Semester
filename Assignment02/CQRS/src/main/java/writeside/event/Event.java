package writeside.event;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.UUID;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AddRoomEvent.class, name = "addRoomEvent"),
        @JsonSubTypes.Type(value = BookingCreatedEvent.class, name = "bookingCreatedEvent"),
        @JsonSubTypes.Type(value = BookingCanceledEvent.class, name = "bookingCanceledEvent"),
        @JsonSubTypes.Type(value = DeleteRoomEvent.class, name = "deleteRoomEvent"),
})
public abstract class Event {

    private long timeStamp = System.currentTimeMillis();
    private UUID eventID = UUID.randomUUID();


    public Event() {}

    public long getTimeStamp() {
        return timeStamp;
    }

    public UUID getEventID() {
        return eventID;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setEventID(UUID eventID) {
        this.eventID = eventID;
    }
}
