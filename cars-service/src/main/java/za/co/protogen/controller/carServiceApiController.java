package za.co.protogen.controller;

//import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import za.co.protogen.core.CarService;
import za.co.protogen.core.impl.CarServiceImpl;
import za.co.protogen.domain.Car;
import za.co.protogen.utility.Constant;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/ctrl/")

public class carServiceApiController {
    CarService carService = new CarServiceImpl();

    @RequestMapping("/add_car")
    public String Add_Car() {
        Car newCar = new Car();
        newCar.setMake("Moro");
        newCar.setModel("BMW");
        newCar.setYear(2021);
        newCar.setColor("White");
        newCar.setEngine("1.8L");
        newCar.setTransmission("Automatic");
        newCar.setFuelType("Gasoline");
        newCar.setMileage(10000);
        newCar.setVin("HSP123");
        newCar.setPrice(25000);
        newCar.setOwnerId(123);
        newCar.setFeatures(new ArrayList<>());

        return carService.addCar(newCar);
    }

    @RequestMapping("/remove_car")
    public String Remove_Car(@RequestParam(defaultValue = "NoID") String vin) {
        return carService.removeCar(carService.getCarById(vin));
        //requires cars id: http://localhost:9102/api/ctrl/remove_car?vin=yourvalue.
    }

    @GetMapping("/getCar_id")
    public String getBy_id(@RequestParam(defaultValue = "NoID") String vin) {
        Car foundCar = carService.getCarById(vin);
        if (foundCar==null)
        {
            return "Error: No car found";
        }
        return carService.getCarById(vin).toString();
        //requires cars id: http://localhost:9102/api/ctrl/getCar_id?vin=yourvalue.
    }

    @GetMapping("/getAllCars")
    public List<Car> getAll_Cars() {
        return carService.getAllCars();
        //requires cars id: http://localhost:9102/api/ctrl/getAllCars
    }

    @GetMapping("/getCar_make")
    public List<Car> carBy_Make(@RequestParam(defaultValue = "NoMake") String make) {
        return carService.getCarsByMake(make);
        //requires cars id: http://localhost:9102/api/ctrl/getCar_make?make=yourvalue.
    }


    @GetMapping("/getCar_year")
    public List<Car> carBy_year(@RequestParam(defaultValue = "NoYear") int year) {
        return carService.getCarsByYear(year);
        //requires cars id: http://localhost:9102/api/ctrl/getCar_year?year=yourvalue.
    }

    @RequestMapping("/update/{vin}/{sWhat}/{sTo}")
    public String updateCar(@PathVariable String vin, @PathVariable String sWhat, @PathVariable String sTo) {
        Car carToUpdate=carService.getCarById(vin);
        if (!(sWhat.length() == 1 && sWhat.charAt(0) >= 'a' && sWhat.charAt(0) <= 'k')) {
            return "Error: incorrect option input";
        }
    //"sWhat" Options
    // a.Vin
    // b.OwnerID
    // c.Mileage
    // d.Year
    // e.Make
    // f.Model
    // g.Color
    // h.Engine
    // i.Fueltype
    // j.Transmission
    // k.Features

        return carService.updateCar(carToUpdate,sWhat,sTo);
    }

    @GetMapping("/avg_mileage")
    public double calcAvgMileage() {
        return carService.calculateAverageMileage();
        //requires cars id: http://localhost:9102/api/ctrl/avg_mileage
    }

    @GetMapping("/find_cheapest")
    public Car car_Cheapest() {
        return carService.findCheapestCar();
        //requires cars id: http://localhost:9102/api/ctrl/find_cheapest
    }

    @GetMapping("/find_Expensive")
    public Car car_Expensive() {
        return carService.findMostExpensiveCar();
        //requires cars id: http://localhost:9102/api/ctrl/find_Expensive
    }

    @GetMapping("/find_Newest")
    public Car car_Newest() {
        return carService.findNewestCar();
        //requires cars id: http://localhost:9102/api/ctrl/find_Newest
    }

    @GetMapping("/find_Oldest")
    public Car car_Oldest() {
        return carService.findOldestCar();
        //requires cars id: http://localhost:9102/api/ctrl/find_Oldest
    }

    @GetMapping("/search/{criteria}")
    public List<Car> carSearch(@PathVariable String criteria) {
        return carService.searchCars(criteria);
        //requires cars id: http://localhost:9102/api/ctrl/search/{criteria)
    }

    public interface CarController{
        @RequestMapping("/greetings")
        String greeting();
        //requires cars id: http://localhost:9102/api/ctrl/greetings
    }

}
