package za.co.protogen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableEurekaServer
public class resApplication {
    public static void main(String[] args) {
        SpringApplication.run(resApplication.class,args);
    }
}


//public class Application {
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("System running--------------\n");
//        String ansOpWhile="";
//        while (ansOpWhile!="f"){
//
//            System.out.println("Please select what to run (case sensitive)");
//            System.out.println("a. Add Reservation\n" +
//                    "b. Remove Reservation\n" +
//                    "c.Get all Reservations\n" +
//                    "d.Update Reservation byId\n" +
//                    "e.Search for a Reservation\n" +
//                    "f.exit");
//            String ansOption=scanner.nextLine();
//            ansOpWhile=ansOption;
//
//            switch (ansOption){
//                case "a":
//                    Add_Res.main(args);
//                    break;
//                case "b":
//                    Remove_Res.main(args);
//                    break;
//                case "c":
//                    GetAll_Reservations.main(args);
//                    break;
//                case "d":
//                    Update_Res.main(args);
//                    break;
//                case "e":
//                    Search_Res.main(args);
//                    break;
//                case "f":
//                    System.exit(0);
//                    break;
//            }
//        }
//    }
//}
//
//class Add_Res {
//    public static void main(String[] args) {
//        ReservationService resService = new ReservationServiceImpl();
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Add reservation--------------------");
//        //Add this new newRes
//        Reservation newRes = new Reservation();
//        newRes.setId(1L);
//        newRes.setUserId(1L);
//        newRes.setCarId(1L);
//        newRes.setFromDate(LocalDate.of(2023, 6, 10));
//        newRes.setToDate(LocalDate.of(2023, 6, 15));
//        newRes.setPickUpLocation("New York");
//        newRes.setDropoffLocation("Los Angeles");
//        resService.addReservation(newRes);
//
//        System.out.println(Constant.reservations);
//        System.out.println("Reservation has been added successfully");
//        System.out.println("There is now "+Constant.reservations.size()+" reservations\n");
//    }
//}
//
//class Remove_Res {
//    public static void main(String[] args) {
//        ReservationService resService = new ReservationServiceImpl();
//        Scanner scanner = new Scanner(System.in);
//
//        //Remove a Reservation
//        System.out.println("Search then remove a car-----------------------");
//        resService.removeReservation(resService.getReservationById(1L));
//        System.out.println("Reservation has been added successfully");
//        System.out.println("There is now "+Constant.reservations.size()+" reservation\n");
//
//    }
//}
//
//class GetAll_Reservations {
//    public static void main(String[] args) {
//        ReservationService resService = new ReservationServiceImpl();
//        Scanner scanner = new Scanner(System.in);
//
//        //get all Reservation
//        System.out.println("get all cars----------------------------");
//        System.out.println(resService.getAllReservations());
//        System.out.println("All reservations printed\n");
//
//    }
//}
//
//class Update_Res {
//    public static void main(String[] args) {
//        ReservationService resService = new ReservationServiceImpl();
//        Scanner scanner = new Scanner(System.in);
//
//        //update reservations
//        System.out.println("update Reservation--------------------");
//
//        //Enter reservation ID then retrieve reservation from List
//       ----------- System.out.println("Enter Reservation ID to update");
//        String ansReservation= scanner.nextLine();
//        Reservation ResToUpdate=resService.getReservationById(Long.parseLong(ansReservation)); //Retrieve Reservation to Update
//
//        List<String> listofChoices =new ArrayList<>(); // List choices to Update, as string
//
//        String strChoices = "a.Id: " + ResToUpdate.getId() + "\n" //users choices in string
//                + "b.ReservationId: " + ResToUpdate.getUserId() + "\n"
//                + "c.CarId: " + ResToUpdate.getCarId() + "\n"
//                + "d.From Date: " + ResToUpdate.getFromDate() + "\n"
//                + "e.To Date: " + ResToUpdate.getToDate() + "\n"
//                + "f.DropoffLocation: " + ResToUpdate.getDropoffLocation() + "\n"
//                + "g.PickUpLocation: " + ResToUpdate.getPickUpLocation() + "\n";
//
//        listofChoices= List.of(strChoices.split("\n")); //split user update choices and places in List
//
//        for (Integer i = 0; i < listofChoices.size() ; i++) { //Display User update choices
//            System.out.println(listofChoices.get(i));
//        }
//        System.out.println("Using the letters,What do you want to update? (case-sensitive)");
//        String ansUpdate=""; //stores what user wants to update
//        String ansUpdateTo=""; //stores what user wants to update value to
//
//        Boolean GoodInput=false;
//        while (!GoodInput) { //repeat until user inputs correctly
//            ansUpdate = scanner.nextLine();
//            if (ansUpdate.length() == 1 && ansUpdate.charAt(0) >= 'a' && ansUpdate.charAt(0) <= 'k') {
//                GoodInput = true;
//                System.out.println("Update to what?");
//                ansUpdateTo = scanner.nextLine();
//            }
//            else{
//                System.out.println("Try Again");
//            }
//        }
//        resService.updateReservation(ResToUpdate,ansUpdate,ansUpdateTo);
//
//        System.out.println(ResToUpdate);
//        System.out.println("Reservation updated successfully\n");
//    }
//}
//
//class Search_Res {
//    public static void main(String[] args) {
//        ReservationService resService = new ReservationServiceImpl();
//        Scanner scanner = new Scanner(System.in);
//        //Search cars
//        System.out.println("Search for Reservation--------------------------");
//        System.out.println("Enter any Criteria--------------------------");
//        String ansSearchCriteria = scanner.nextLine();
//        System.out.println("Returned: \n"+resService.searchReservations(ansSearchCriteria)+"\n");
//    }
//}