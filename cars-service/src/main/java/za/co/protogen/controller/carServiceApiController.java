package za.co.protogen.controller;

//import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.openfeign.FeignClient;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import za.co.protogen.core.CarService;
import za.co.protogen.core.impl.CarServiceImpl;
import za.co.protogen.persistence.Car;
import za.co.protogen.persistence.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/ctrl/")
public class carServiceApiController {

    private final CarServiceImpl carService;
    @Autowired
    public carServiceApiController( CarServiceImpl carServiceImp){
        this.carService=carServiceImp;
    }

    @RequestMapping("/add_car/{vin}")
    public String Add_Car(@PathVariable String vin) {
        Car newCar = new Car();
        newCar.setMake("Moro");
        newCar.setModel("BMW");
        newCar.setYear(2021);
        newCar.setColor("White");
        newCar.setEngine("1.8L");
        newCar.setTransmission("Automatic");
        newCar.setFuelType("Gasoline");
        newCar.setMileage(10000);
        newCar.setVin(vin);
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
    public String getAll_Cars() {
        return carService.getAllCars().toString();
        //requires cars id: http://localhost:9102/api/ctrl/getAllCars
    }

    @GetMapping("/getCar_make")
    public String carBy_Make(@RequestParam(defaultValue = "NoMake") String make) {
        return carService.getCarsByMake(make).toString();
        //requires cars id: http://localhost:9102/api/ctrl/getCar_make?make=yourvalue.
    }


    @GetMapping("/getCar_year")
    public String carBy_year(@RequestParam(defaultValue = "NoYear") int year) {
        return carService.getCarsByYear(year).toString();
        //requires cars id: http://localhost:9102/api/ctrl/getCar_year?year=yourvalue.
    }

    @GetMapping("/getCar_color")
    public String carBy_color(@RequestParam(defaultValue = "NoYear") String color) {
        return carService.getCarsByColor(color).toString();
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
    public String car_Cheapest() {
        return carService.findCheapestCar().toString();
        //requires cars id: http://localhost:9102/api/ctrl/find_cheapest
    }

    @GetMapping("/find_Expensive")
    public String car_Expensive() {
        return carService.findMostExpensiveCar().toString();
        //requires cars id: http://localhost:9102/api/ctrl/find_Expensive
    }

    @GetMapping("/find_Newest")
    public String car_Newest() {
        return carService.findNewestCar().toString();
        //requires cars id: http://localhost:9102/api/ctrl/find_Newest
    }

    @GetMapping("/find_Oldest")
    public String car_Oldest() {
        return carService.findOldestCar().toString();
        //requires cars id: http://localhost:9102/api/ctrl/find_Oldest
    }

    @GetMapping("/search/{criteria}")
    public String carSearch(@PathVariable String criteria) {
        return carService.searchCars(criteria).toString();
        //requires cars id: http://localhost:9102/api/ctrl/search/{criteria)
    }

}
