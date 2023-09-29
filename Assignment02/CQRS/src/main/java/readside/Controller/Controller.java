package readside.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import readside.ServiceLocator;
import readside.dto.BookingDTO;
import readside.dto.RoomDTO;
import readside.readStore.StorageRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Controller {

    private boolean isRunning = true;

    @Autowired
    private StorageRepository storageRepository = ServiceLocator.getStorageRepository();

    public void commandLine() {

        while (isRunning) {
            try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


            String line = null;

                line = br.readLine();

            String[] commandArray = line.split(" ");

            if (commandArray.length == 1) {
                if (commandArray[1].toLowerCase().equals("exit")) {
                    System.err.println("Exit System");
                    System.exit(0);
                }
            }


            if (commandArray.length == 3) {
                String command = commandArray[0];
                String parameter1 = commandArray[1];
                String parameter2 = commandArray[2];

                if (command.toLowerCase().equals("getbookings")) {

                    try {
                        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        LocalDate bookingFrom = LocalDate.parse(parameter1, dateFormatter);
                        LocalDate bookingTo= LocalDate.parse(parameter2, dateFormatter);
                        List<BookingDTO> bookingDTOs = storageRepository.getBookings(bookingFrom, bookingTo);

                        for (BookingDTO b : bookingDTOs) {
                            System.out.println("Booking : " + b.getBookingID() + " Room-Number: " + b.getRoomNumber() + " Booked From: " + b.getFrom() + " Booked To: " + b.getTo() + " Name: " + b.getFirstName() + " " + b.getLastName());
                        }

                    } catch (Exception e) {
                        System.out.println("Please use valid Date format");
                    }



                }
            }

            if (commandArray.length == 4) {
                String command = commandArray[0];
                String parameter1 = commandArray[1];
                String parameter2 = commandArray[2];
                String parameter3 = commandArray[3];

                if (command.toLowerCase().equals("getfreerooms")) {
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate bookingTo = LocalDate.parse(parameter1,dateFormatter);
                    LocalDate bookingFrom = LocalDate.parse(parameter2,dateFormatter);

                    List<RoomDTO> roomDTOs = storageRepository.getFreeRooms(bookingFrom, bookingTo, Integer.parseInt(parameter3));

                    for (RoomDTO r : roomDTOs) {
                        System.out.println("Room: " + r.getRoomNumber() + " Capacity: " + r.getCapacity());
                    }
                }
            }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
