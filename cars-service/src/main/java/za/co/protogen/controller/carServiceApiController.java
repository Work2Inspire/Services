package za.co.protogen.controller;

//import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.protogen.core.domain.models.impl.CarServiceImpl;
import za.co.protogen.persistence.models.Car;

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
    public ResponseEntity<String> Add_Car(@PathVariable String vin) {
        return carService.addCar(vin);
    }

    @RequestMapping("/remove_car")
    public ResponseEntity<String> Remove_Car(@RequestParam(defaultValue = "NoID") String vin) {
        return carService.removeCar(carService.getCarById(vin));
        //requires cars id: http://localhost:9102/api/ctrl/remove_car?vin=yourvalue.
    }

    @GetMapping("/getCar_id")
    public ResponseEntity<String> getBy_id(@RequestParam(defaultValue = "NoID") String vin) {
        Car foundCar = carService.getCarById(vin);
        if (foundCar==null)        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: No car matches criteria OR repository empty");
        }
        return ResponseEntity.ok(foundCar.toString());
        //requires cars id: http://localhost:9102/api/ctrl/getCar_id?vin=yourvalue.
    }

    @GetMapping("/getAllCars")
    public ResponseEntity<String> getAll_Cars() {
        return carService.getAllCars();
        //requires cars id: http://localhost:9102/api/ctrl/getAllCars
    }

    @GetMapping("/getCar_make")
    public ResponseEntity<String> carBy_Make(@RequestParam(defaultValue = "NoMake") String make) {
        List<Car> ToReturnList=carService.getCarsByMake(make);

        if (ToReturnList==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empty Repository: No cars to return");
        }
        if (ToReturnList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No match using criteria");
        }
        return ResponseEntity.ok(ToReturnList.toString());
        //requires cars id: http://localhost:9102/api/ctrl/getCar_make?make=yourvalue.
    }


    @GetMapping("/getCar_year")
    public ResponseEntity<String> carBy_year(@RequestParam(defaultValue = "NoYear") int year) {
        List<Car> ToReturnList=carService.getCarsByYear(year);

        if (ToReturnList==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empty Repository: No cars to return");
        }
        if (ToReturnList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No match using criteria");
        }
        return ResponseEntity.ok(ToReturnList.toString());
        //requires cars id: http://localhost:9102/api/ctrl/getCar_year?year=yourvalue.
    }

    @GetMapping("/getCar_color")
    public ResponseEntity<String> carBy_color(@RequestParam(defaultValue = "NoYear") String color) {
        List<Car> ToReturnList=carService.getCarsByColor(color);

        if (ToReturnList==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empty Repository: No cars to return");
        }
        if (ToReturnList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No match using criteria");
        }
        return ResponseEntity.ok(ToReturnList.toString());
        //requires cars id: http://localhost:9102/api/ctrl/getCar_year?year=yourvalue.
    }

    @RequestMapping("/update/{vin}/{sWhat}/{sTo}")
    public ResponseEntity<String> updateCar(@PathVariable String vin, @PathVariable String sWhat, @PathVariable String sTo) {
        Car carToUpdate=carService.getCarById(vin);
        if (!(sWhat.length() == 1 && sWhat.charAt(0) >= 'a' && sWhat.charAt(0) <= 'k')) {
            return ResponseEntity.badRequest().body("Error: incorrect option input");
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
    public ResponseEntity<Double> calcAvgMileage() {
        Double avgMileage= carService.calculateAverageMileage();
        if (avgMileage == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(0.00);
        }
        return ResponseEntity.ok(carService.calculateAverageMileage());
        //requires cars id: http://localhost:9102/api/ctrl/avg_mileage
    }

    @GetMapping("/find_cheapest")
    public ResponseEntity<String> car_Cheapest() {
        Car ToReturnCar=carService.findCheapestCar();
        if (ToReturnCar==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empty Repository: No cars to return");
        }
        return ResponseEntity.ok(ToReturnCar.toString());
        //requires cars id: http://localhost:9102/api/ctrl/find_cheapest
    }

    @GetMapping("/find_Expensive")
    public ResponseEntity<String> car_Expensive() {
        Car ToReturnCar=carService.findMostExpensiveCar();
        if (ToReturnCar==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empty Repository: No cars to return");
        }
        return ResponseEntity.ok(ToReturnCar.toString());
        //requires cars id: http://localhost:9102/api/ctrl/find_Expensive
    }

    @GetMapping("/find_Newest")
    public ResponseEntity<String> car_Newest() {
        Car ToReturnCar=carService.findNewestCar();
        if (ToReturnCar==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empty Repository: No cars to return");
        }
        return ResponseEntity.ok(ToReturnCar.toString());
        //requires cars id: http://localhost:9102/api/ctrl/find_Newest
    }

    @GetMapping("/find_Oldest")
    public ResponseEntity<String> car_Oldest() {
        Car ToReturnCar=carService.findOldestCar();
        if (ToReturnCar==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empty Repository: No cars to return");
        }
        return ResponseEntity.ok(ToReturnCar.toString());
        //requires cars id: http://localhost:9102/api/ctrl/find_Oldest
    }

    @GetMapping("/search/{criteria}")
    public ResponseEntity<String> carSearch(@PathVariable String criteria) {
        List<Car> ToReturnList=carService.searchCars(criteria);
        if (ToReturnList==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empty Repository: No cars to return");
        }
        if (ToReturnList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No match using criteria");
        }
        return ResponseEntity.ok(carService.searchCars(criteria).toString());
        //requires cars id: http://localhost:9102/api/ctrl/search/{criteria)
    }

}
