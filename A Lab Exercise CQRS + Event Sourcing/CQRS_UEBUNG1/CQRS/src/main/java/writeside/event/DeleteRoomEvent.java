package writeside.event;

public class DeleteRoomEvent extends Event {

    private String roomNumber;

    public DeleteRoomEvent(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public DeleteRoomEvent() {}

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
