package writeside.application;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;

import writeside.ServiceLocator;

public class Controller {

    // Consolen eingabe
    private boolean isRunning = true;

    //@Autowired
    CommandInterface commandInterface = ServiceLocator.commandInterface();

    public void commandoline() {

        while (isRunning) {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            try {
				String line = br.readLine();
				
                String[] commandArray = line.split(" ");

                String command = commandArray[0];
                String parameter1 = ""; //bookingNumber for Cancel or fromDate for booking
                String parameter2 = ""; //toDate for booking
                String parameter3 = ""; //roomNumber for booking
                String parameter4 = ""; //FirstName
                String parameter5 = ""; //lastName
                String parameter6 = ""; //Number of People


                //Dirty
                if(commandArray.length > 1) {
                    parameter1 = commandArray[1];
                    if(commandArray.length > 2) {
                        parameter2 = commandArray[2];
                        if(commandArray.length > 3) {
                            parameter3 = commandArray [3];
                            if(commandArray.length > 4) {
                                parameter4 = commandArray[4];
                                if(commandArray.length > 5) {
                                    parameter5 = commandArray[5];
                                    if(commandArray.length > 6) {
                                        parameter6 = commandArray[6];
                                    }
                                }
                            }
                        }
                    }
                }

                if(command.length() > 0) {
                    if(command.toLowerCase().equals("exit")) {
                        isRunning = false;
                        System.out.println("Exit System");
                        System.exit(0);
                    }
                    if(parameter1.length() > 0) {
                        if(command.toLowerCase().equals("cancelbooking")) {
                            try {
                                commandInterface.cancelBooking(Long.parseLong(parameter1));
                            }
                            catch (NumberFormatException ex){
                                System.err.println("Please enter a valid bookingnumber");
                            }
                        }
                        if(command.toLowerCase().equals("deleteroom")) {
                            commandInterface.deleteRoom(parameter1);
                        }
                        if(parameter2.length() > 0) {
                            if(command.toLowerCase().equals("addroom")) {
                                commandInterface.createRoom(parameter1, Integer.parseInt(parameter2));
                            }
                        }


                        if(parameter2.length() > 0 && parameter3.length() > 0 && parameter4.length() > 0 && parameter5.length() > 0 && parameter6.length() > 0) {
                            if(command.toLowerCase().equals("bookroom")) {
                                //TODO Check Parse

                                LocalDate from;
                                LocalDate to;
                                try {
                                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                                    from  = LocalDate.parse(parameter2, dateFormatter);
                                    to = LocalDate.parse(parameter1, dateFormatter);

                                    if(to.isAfter(from)) {
                                       System.out.println("From Date must be After To Date");
                                    } else {

                                        commandInterface.addBooking(to, from,
                                                parameter3, parameter4, parameter5, Integer.parseInt(parameter6));
                                    }

                                } catch (Exception e) {
                                    System.out.println("Please use valid Date format");
                                }



                            }
                        }
                    }
                }				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


        }

    }

}
