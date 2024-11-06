package za.co.protogen.core.domain.models.impl;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import za.co.protogen.adapter.CarMapperImpl;
import za.co.protogen.core.CarService;
import za.co.protogen.persistence.models.Car;
import za.co.protogen.persistence.repository.CarRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    // Spring will automatically inject CarRepository here
    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    @Autowired
    CarMapperImpl carMapperImpl;

    @Override
    public ResponseEntity<String> addCar(String vin) {

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

        carRepository.save(newCar);

        return ResponseEntity.ok("Car Added Successfully!<br/>Available cars:" + carRepository.findAll().size());
    }

    @Override
    public ResponseEntity<String> removeCar(Car car) {
        boolean found;
//        found=Constant.cars.removeIf(a->a.equals(car));
        found=carRepository.existsById(car.getVin());
        if (found){
            carRepository.delete(car);
            return ResponseEntity.ok( "Car removed Successfully!<br/>"+ carRepository.findAll().size() + " cars available");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Car not found or no car entered");
        }
    }

    @Override
    public Car getCarById(String vin) {
//        Car foundCar=carRepository.getReferenceById(vin);
        Car foundCar=carRepository.findAll().stream().filter(a->a.getVin().equals(vin)).findFirst().orElse(null);


        return foundCar;
    }//searches for and returns a specific car using its unique vin else return null

    @Override
    public ResponseEntity<String> getAllCars() {
        if (carRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Repository Empty: No cars to return");
        }

        return ResponseEntity.ok(carRepository.findAll().toString());
    }

    @Override
    public List<Car> getCarsByMake(String make) {

        if (carRepository.findAll().isEmpty()){
            return null;
        }
       List<Car> ListToReturn = carRepository.findAll().stream().filter(a->a.getMake().equals(make)).collect(Collectors.toList());
       System.out.println(ListToReturn);

       return ListToReturn;
//        return carRepository.getCarsByMake(make);
    }//searches for and returns a specific car using its make else return null

    @Override
    public List<Car> getCarsByYear(int year) {
        if (carRepository.findAll().isEmpty()){
            return null;
        }
        List<Car> ListToReturn = carRepository.findAll().stream().filter(a->a.getYear()==year).toList();
        return ListToReturn;
//        return carRepository.getCarsByYear(year);
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        if (carRepository.findAll().isEmpty()){
            return null;
        }
        List<Car> ListToReturn = carRepository.findAll().stream().filter(a->a.getColor().equals(color)).collect(Collectors.toList());

        return ListToReturn;
//        return carRepository.getCarsByColor(color);
    }

    @Override
    public ResponseEntity<String> updateCar(Car car, String ansUpdate, String ansUpdateTo) {

        switch (ansUpdate) {
            case "a" :
                car.setVin(ansUpdateTo);
                break;
            case "b":
                car.setOwnerId(Integer.parseInt(ansUpdateTo));
                break;
            case "c":
                car.setMileage(Integer.parseInt(ansUpdateTo));
                break;
            case "d":
                car.setYear(Integer.parseInt(ansUpdateTo));
                break;
            case "e":
                car.setMake(ansUpdateTo);
                break;
            case "f":
                car.setModel(ansUpdateTo);
                break;
            case "g":
                car.setColor(ansUpdateTo);
                break;
            case "h":
                car.setEngine(ansUpdateTo);
                break;
            case "i":
                car.setFuelType(ansUpdateTo);
                break;
            case "j":
                car.setTransmission(ansUpdateTo);
                break;
         }
        carRepository.save(car);
        return ResponseEntity.ok("Update successful <br/>"+car);
    }

    @Override
    public double calculateAverageMileage() {
        if (carRepository.findAll().isEmpty()){
            return 0;
        }// if no cars exist return 0.00 avg

        Long CarCount = carRepository.count();
        int MileageTotal=0;
        double totAvg;

        for (int i = 0; i < carRepository.findAll().size() ; i++) {
            MileageTotal+=carRepository.findAll().get(i).getMileage();
        }
        totAvg= (double) MileageTotal /CarCount;

        return totAvg;
    }

    @Override
    public Car findCheapestCar() {
        Car RepoCar= carRepository.findAll().stream().min(Comparator.comparingInt(Car::getPrice)).orElse(null);
        return RepoCar;

//        return carRepository.findFirstByOrderByPriceAsc();
    }

    @Override
    public Car findMostExpensiveCar() {
        Car RepoCar= carRepository.findAll().stream().max(Comparator.comparingInt(Car::getPrice)).orElse(null);
//        return carRepository.findFirstByOrderByPriceDesc();
        return RepoCar;
    }

    @Override
    public Car findNewestCar() {
        Car RepoCar= carRepository.findAll().stream().max(Comparator.comparingInt(Car::getYear)).orElse(null);
//        return carRepository.findFirstByOrderByYearDesc();
        return RepoCar;
    }

    @Override
    public Car findOldestCar() {
        Car RepoCar= carRepository.findAll().stream().min(Comparator.comparingInt(Car::getYear)).orElse(null);
//        return carRepository.findFirstByOrderByYearAsc();

        return RepoCar;
    }

    @Override
    public List<Car> searchCars(String criteria) {
        if (carRepository.findAll().isEmpty()){
            return null;
        }

        List<String> strListOfCars = new ArrayList<>();
        List<String> splitStringCriteria = new ArrayList<>();
        //stores the criteria split using " " as delimeter
        List<Car> ListToReturn = new ArrayList<>();

        splitStringCriteria = List.of(criteria.split(" ")); // split criteria into array

        List<Car> repoCarsList=carRepository.findAll();

        for (int i = 0; i < strListOfCars.size(); i++) {
            int iSuccess=0; //Counts number of criteria current row passed

            for (int j = 0; j < splitStringCriteria.size(); j++) {
                if (strListOfCars.get(i).contains(splitStringCriteria.get(j))){
                    iSuccess++;
                }
                if (iSuccess==splitStringCriteria.size()){
                    //Using their index, i, Find its Car object equivalent and Add to listToReturn
                    ListToReturn.add(repoCarsList.get(i));
                }
            }//Cycle through split string

        }//Cycle through string list of Cars

        return ListToReturn;
    } //if multiple criteria match completely
}

