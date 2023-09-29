package writeside.event;

public class AddRoomEvent extends Event{

    private int numberOfPeople;
    private String roomNumber;

    public AddRoomEvent(int numberOfPeople, String roomNumber) {
        this.numberOfPeople = numberOfPeople;
        this.roomNumber = roomNumber;
    }

    public AddRoomEvent() {}

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
