package at.fhv.lab1reference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import readside.Controller.Controller;

@SpringBootApplication
@Configuration
@ComponentScan("readside")
public class ReadSide {

    public static void main(String[] args) {
        SpringApplication.run(ReadSide.class, args);
        Controller c = new Controller();
        System.err.println("---------------------------------------------- APPLICATION START ----------------------------------------------");
        System.out.println("For all Bookings in a Timeperiod pls enter \"getbookings [FromDate] [ToDate]\" seperated by a space DateFormat must be \"dd-MM-yyyy\"");
        System.out.println("For all free Rooms in a Timeperiod pls enter \"getfreerooms [FromDate] [ToDate] [Capacity]\" seperated by a space DateFormat must be \"dd-MM-yyyy\"");
        c.commandLine();
    }
}