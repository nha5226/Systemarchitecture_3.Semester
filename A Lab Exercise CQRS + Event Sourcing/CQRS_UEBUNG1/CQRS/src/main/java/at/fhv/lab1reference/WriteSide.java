package at.fhv.lab1reference;

import eventside.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import writeside.EventPublisher;
import writeside.ServiceLocator;
import writeside.application.CommandInterface;
import writeside.application.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@Configuration
@ComponentScan("writeside")
public class WriteSide {

    @Autowired
    private EventPublisher publisher;

    private CommandInterface commandInterface = ServiceLocator.commandInterface();

    public static void main(String[] args) {
        SpringApplication.run(WriteSide.class, args);
        Controller c = new Controller();
        System.err.println("---------------------------------------------- APPLICATION START ----------------------------------------------");
        System.out.println("For Booking a Room pls enter \"bookroom [FromDate] [ToDate] [RoomNumber] [Firstname] [Lastname] [Number of People]\" seperated by a space DateFormat must be \"dd-MM-yyyy\"");
        System.out.println("For Canceling a Room pls enter \"cancelbooking [Bookingnumber]\" seperated by a space");
        System.out.println("For creating a Room pls enter \"addroom [roomnumber] [capacity]\" seperated by a space");
        System.out.println("For deleting a Room pls enter \"deleteroom [roomnumber]\" seperated by a space");

        CommandInterface com = ServiceLocator.commandInterface();
        com.createRoom("1", 1);
        com.createRoom("2", 2);
        com.createRoom("3", 2);
        com.createRoom("4", 2);
        com.createRoom("5", 2);
        com.createRoom("6", 2);

        com.deleteRoom("6");

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        com.addBooking(LocalDate.parse("14-11-2021",dateFormatter), LocalDate.parse("20-11-2021",dateFormatter), "1", "Max","Muster", 1);



        c.commandoline();
    }

    /*
    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            Event event = new Event();
            event.setContent("This is the content!");
            event.setCustomer("Customer1");
            event.setTimestamp(System.currentTimeMillis());
            System.out.println("Result: " + publisher.publishEvent(event));
        };
    }*/
}
