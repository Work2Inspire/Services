package za.co.protogen;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaServer
public class carApplication {
    public static void main(String[] args) {
        SpringApplication.run(carApplication.class,args);
    }
}



//class OldApplication {
//    public static void main(String[] args) {
//        CarService carService = new CarServiceImpl();
//        Scanner scanner = new Scanner(System.in);
//
//        //Add this new car
//        System.out.println("Add car--------------------");
//        Car newCar = new Car();
//        newCar.setMake("Moro");
//        newCar.setModel("BMW");
//        newCar.setYear(2021);
//        newCar.setColor("White");
//        newCar.setEngine("1.8L");
//        newCar.setTransmission("Automatic");
//        newCar.setFuelType("Gasoline");
//        newCar.setMileage(10000);
//        newCar.setVin("HSP123");
//        newCar.setPrice(25000);
//        newCar.setOwnerId(123);
//        newCar.setFeatures(new ArrayList<>());
//        carService.addCar(newCar);
//
//
//        System.out.println(Constant.cars);
//        System.out.println("Car has been added successfully");
//        System.out.println("There is now " + Constant.cars.size() + " cars\n");
//
//        //Remove a car
//        System.out.println("Search then remove a car-----------------------");
//        carService.removeCar(carService.getCarById("ABC123"));
//        System.out.println("Car has been added successfully");
//        System.out.println("There is now " + Constant.cars.size() + " cars in service\n");
//
//        //get all cars
//        System.out.println("get all cars----------------------------");
//        System.out.println(carService.getAllCars());
//        System.out.println("All cars printed\n");
//
//        //get cars by make
//        System.out.println("get cars by make------------------------");
//        System.out.println(carService.getCarsByMake("BMW"));
//        System.out.println(carService.getCarsByMake("BMW").size() + " cars retrieved by make\n");
//
//        //get cars by year
//        System.out.println("get cars by year---------------------");
//        System.out.println(carService.getCarsByYear(2021));
//        System.out.println(carService.getCarsByYear(2021).size() + " cars retrieved by year\n");
//
//        //get cars by color
//        System.out.println("get cars by color--------------------");
//        System.out.println(carService.getCarsByColor("Red"));
//        System.out.println(carService.getCarsByColor("Red").size() + " Cars retrieved by year\n");
//
//        //Update Car------------------------------------------------------
//        System.out.println("update car--------------------");
//
//
//        //Enter car vin then retrieve Car from List
//        System.out.println("Enter vin of car to update");
//        String ansVin = scanner.nextLine();
//        Car carToUpdate = carService.getCarById(ansVin); //Retrieve Car to Update
//
//        List<String> listofChoices = new ArrayList<>(); // List choices the user can Update as string
//
//        String strChoices = "a.Vin: " + carToUpdate.getVin() + "\n" //users choices in string
//                + "b.OwnerID: " + carToUpdate.getOwnerId() + "\n"
//                + "c.Mileage: " + carToUpdate.getMileage() + "\n"
//                + "d.Year: " + carToUpdate.getYear() + "\n"
//                + "e.Make: " + carToUpdate.getMake() + "\n"
//                + "f.Model: " + carToUpdate.getModel() + "\n"
//                + "g.Color: " + carToUpdate.getColor() + "\n"
//                + "h.Engine: " + carToUpdate.getEngine() + "\n"
//                + "i.Fueltype: " + carToUpdate.getFuelType() + "\n"
//                + "j.Transmission: " + carToUpdate.getTransmission() + "\n"
//                + "k.Features: " + carToUpdate.getFeatures();
//
//        listofChoices = List.of(strChoices.split("\n")); //split user update choices and places in List
//
//        for (int i = 0; i < listofChoices.size(); i++) { //Display User update choices
//            System.out.println(listofChoices.get(i));
//        }
//        System.out.println("Using the letters,What do you want to update? (case-sensitive)");
//
//        String ansUpdateWhat = ""; //stores what user wants to update
//        String ansUpdateTo = ""; //stores what user wants to update value to
//
//        boolean GoodInput = false;
//        while (!GoodInput) { //repeat until user inputs correctly
//            ansUpdateWhat = scanner.nextLine();
//            if (ansUpdateWhat.length() == 1 && ansUpdateWhat.charAt(0) >= 'a' && ansUpdateWhat.charAt(0) <= 'k') {
//                GoodInput = true;
//                System.out.println("Update to what?");
//                ansUpdateTo = scanner.nextLine();
//            }
//        }
//        carService.updateCar(carToUpdate, ansUpdateWhat, ansUpdateTo);
//
//        System.out.println(carToUpdate);
//        System.out.println("Car updated successfully\n");
//
//
//        //Calculate Avg Mileage
//        System.out.println("Avg Mileage-------------------------");
//        System.out.println("Avg Mileage is "+carService.calculateAverageMileage()+"\n");
//
//        //Cheapest Car
//        System.out.println("Cheapest car--------------------------");
//        System.out.println("Cheapest car is: \n"+carService.findCheapestCar()+"\n");
//
//        //Most Expensive Car
//        System.out.println("Most Expensive car--------------------------");
//        System.out.println("Expensive car is: \n"+carService.findMostExpensiveCar()+"\n");
//
//        //Newest car
//        System.out.println("Most Newest car--------------------------");
//        System.out.println("Newest car is: \n"+carService.findNewestCar()+"\n");
//
//        //Oldest car
//        System.out.println("Most Oldest car--------------------------");
//        System.out.println("Oldest car is: \n"+carService.findOldestCar()+"\n");
//
//        //Search cars
//        System.out.println("Search Cars--------------------------");
//        System.out.println("Enter any Criteria--------------------------");
//        String ansSearchCriteria = scanner.nextLine();
//        System.out.println("Returned: \n"+carService.searchCars(ansSearchCriteria)+"\n");
//
//    }
//}
