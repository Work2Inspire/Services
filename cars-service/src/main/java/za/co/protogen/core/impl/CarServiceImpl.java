package za.co.protogen.core.impl;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import za.co.protogen.core.CarService;
import za.co.protogen.persistence.Car;
import za.co.protogen.persistence.repository.CarRepository;
import za.co.protogen.utility.Constant;

import javax.naming.Context;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
public class CarServiceImpl implements CarService {
    // Injecting the JPA repository
//    @Autowired
//    private CarRepository carRepository;

//Alt
    private final CarRepository carRepository;

    // Spring will automatically inject CarRepository here
    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public String addCar(Car car) {
        Car newCar=new Car();
        newCar.setVin(car.getVin());
        newCar.setMake(car.getMake());
        newCar.setModel(car.getModel());
        newCar.setYear(car.getYear());
        newCar.setColor(car.getColor());
        newCar.setEngine(car.getEngine());
        newCar.setTransmission(car.getTransmission());
        newCar.setFuelType(car.getFuelType());
        newCar.setColor(car.getColor());
        newCar.setMileage(car.getMileage());
        newCar.setPrice(car.getPrice());
        newCar.setOwnerId(car.getOwnerId());
        newCar.setFeatures(car.getFeatures());

        carRepository.save(newCar);
//        Constant.cars.add(car);
        return "Car Added Successfully!<br/>" +"There is now " + carRepository.findAll().size() + " cars";
    }

    @Override
    public String removeCar(Car car) {
        boolean found;
//        found=Constant.cars.removeIf(a->a.equals(car));
        found=carRepository.existsById(car.getVin());
        if (found){
            carRepository.delete(car);
            return "Car Added Successfully!<br/>There is now" + carRepository.findAll().size() + " cars";
        }
        else {
            return "Error: Car not found or no car entered";
        }
    }

    @Override
    public Car getCarById(String vin) {
//        car foundCar = Constant.cars.stream().filter(a->a.getVin().equals(vin)).findFirst().orElse(null);
//        Car foundCar=carRepository.getReferenceById(vin);
        Car foundCar=carRepository.findAll().stream().filter(a->a.getVin().equals(vin)).findFirst().orElse(null);
        //orElseThrow(()->new RuntimeException("No car with that ID found"));  Not clean
        return foundCar;
    }//searches for and returns a specific car using its unique vin else return null

    @Override
    public List<Car> getAllCars() {

        return carRepository.findAll();
//        Constant.cars;
    }

    @Override
    public List<Car> getCarsByMake(String make) {
//Also
       List<Car> ListToReturn = carRepository.findAll().stream().filter(a->a.getMake().equals(make)).collect(Collectors.toList());

       return ListToReturn;
//        return carRepository.getCarsByMake(make);
    }//searches for and returns a specific car using its make else return null

    @Override
    public List<Car> getCarsByYear(int year) {
        List<Car> ListToReturn = carRepository.findAll().stream().filter(a->a.getYear()==year).toList();

        return ListToReturn;
//        return carRepository.getCarsByYear(year);
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        List<Car> ListToReturn = carRepository.findAll().stream().filter(a->a.getColor().equals(color)).collect(Collectors.toList());

        return ListToReturn;
//        return carRepository.getCarsByColor(color);
    }

    @Override
    public String updateCar(Car car, String ansUpdate, String ansUpdateTo) {

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
        return "Update successful <br/>"+car.toString();
    }

    @Override
    public double calculateAverageMileage() {
        Long CarCount = carRepository.count();
        int MileageTotal=0;
        double totAvg = 0.00;

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

