package writeside.event;

public class BookingCanceledEvent extends Event{

    private long bookingID;

    public BookingCanceledEvent(long bookingID) {
        this.bookingID = bookingID;
    }

    public BookingCanceledEvent() {}

    public long getBookingID() {
        return bookingID;
    }

    public void setBookingID(long bookingID) {
        this.bookingID = bookingID;
    }
}