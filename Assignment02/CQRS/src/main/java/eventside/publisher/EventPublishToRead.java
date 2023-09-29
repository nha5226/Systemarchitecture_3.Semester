package eventside.publisher;



import javax.annotation.ManagedBean;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import writeside.event.Event;

@ManagedBean
public class EventPublishToRead implements Publisher{
    
    private final WebClient localApiClient = WebClient.create("http://localhost:8082");

    public EventPublishToRead() {
    }

    public Boolean publishAddEvent(Event event) {
        System.out.println(event);
        return localApiClient
                .post()
                .uri("/event/addEvent")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event),Event.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    public Boolean publishCancelEvent(Event event) {
        System.out.println(event);
        return localApiClient
                .post()
                .uri("/event/cancelEvent")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event),Event.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    @Override
    public Boolean publishAddRoomEvent(Event event) {
        System.out.println(event);
        return localApiClient
                .post()
                .uri("/event/addRoomEvent")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event),Event.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    @Override
    public Boolean publishDeleteRoomEvent(Event event) {
        System.out.println(event);
        return localApiClient
                .post()
                .uri("/event/deleteRoomEvent")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event),Event.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
}
