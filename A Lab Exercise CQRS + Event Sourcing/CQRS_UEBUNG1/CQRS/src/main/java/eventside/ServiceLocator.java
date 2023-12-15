package eventside;

import eventside.publisher.EventPublishToRead;
import eventside.publisher.Publisher;

public class ServiceLocator {

    private static Publisher publisher;
    private static EventRepository eventRepository;

    public static Publisher getPublisher() {
        if(publisher == null) {
            publisher = new EventPublishToRead();
        }
        return publisher;
    }

    public static EventRepository getEventRepository() {
        if(eventRepository == null) {
            eventRepository = new EventRepository();
        }
        return eventRepository;
    }


}
