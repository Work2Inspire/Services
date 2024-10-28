package za.co.protogen;
import za.co.protogen.core.ReservationService;
import za.co.protogen.core.impl.ReservationServiceImpl;
import za.co.protogen.domain.Reservation;
import za.co.protogen.utility.Constant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ReservationService resService = new ReservationServiceImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add reservation--------------------");
        //Add this new newRes
        Reservation newRes = new Reservation();
        newRes.setId(1L);
        newRes.setUserId(1L);
        newRes.setCarId(1L);
        newRes.setFromDate(LocalDate.of(2023, 6, 10));
        newRes.setToDate(LocalDate.of(2023, 6, 15));
        newRes.setPickUpLocation("New York");
        newRes.setDropoffLocation("Los Angeles");
        resService.addReservation(newRes);

        System.out.println(Constant.reservations);
        System.out.println("Reservation has been added successfully");
        System.out.println("There is now "+Constant.reservations.size()+" reservations\n");

        //Remove a Reservation
        System.out.println("Search then remove a car-----------------------");
        resService.removeReservation(resService.getReservationById(1L));
        System.out.println("Reservation has been added successfully");
        System.out.println("There is now "+Constant.reservations.size()+" reservation\n");

        //get all Reservation
        System.out.println("get all cars----------------------------");
        System.out.println(resService.getAllReservations());
        System.out.println("All reservations printed\n");

        //Search Reservation


        //update reservations
        System.out.println("update car--------------------");

        //Enter reservation ID then retrieve reservation from List
        System.out.println("Enter reservation ID of the reservation to update");
        String ansReservation= scanner.nextLine();
        Reservation ResToUpdate=resService.getReservationById(Long.parseLong(ansReservation)); //Retrieve Reservation to Update

        List<String> listofChoices =new ArrayList<>(); // List choices to Update, as string

        String strChoices = "a.Id: " + ResToUpdate.getId() + "\n" //users choices in string
                + "b.UserId: " + ResToUpdate.getUserId() + "\n"
                + "e.Car Id: " + ResToUpdate.getCarId() + "\n"
                + "c.From Date: " + ResToUpdate.getFromDate() + "\n"
                + "d.To Date: " + ResToUpdate.getToDate() + "\n"
                + "f.DropoffLocation: " + ResToUpdate.getDropoffLocation() + "\n"
                + "g.PickUpLocation: " + ResToUpdate.getPickUpLocation() + "\n";

        listofChoices= List.of(strChoices.split("\n")); //split user update choices and places in List

        for (int i = 0; i < listofChoices.size() ; i++) { //Display User update choices
            System.out.println(listofChoices.get(i));
        }
        System.out.println("Using the letters,What do you want to update? (case-sensitive)");

        String ansUpdate=""; //stores what user wants to update
        String ansUpdateTo=""; //stores what user wants to update value to

        boolean GoodInput=false;
        while (!GoodInput) { //repeat until user inputs correctly
            ansUpdate = scanner.nextLine();
            if (ansUpdate.length() == 1 && ansUpdate.charAt(0) >= 'a' && ansUpdate.charAt(0) <= 'k') {
                GoodInput = true;
                System.out.println("Update to what?");
                ansUpdateTo = scanner.nextLine();
            }
        }
        resService.updateReservation(ResToUpdate,ansUpdate,ansUpdateTo);

        System.out.println(ResToUpdate);
        System.out.println("Reservation updated successfully\n");

        //Search cars
        System.out.println("Search for Reservation--------------------------");
        System.out.println("Enter any Criteria--------------------------");
        String ansSearchCriteria = scanner.nextLine();
        System.out.println("Returned: \n"+resService.searchReservations(ansSearchCriteria)+"\n");

    }
}
