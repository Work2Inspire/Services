package za.co.protogen.core.impl;

import za.co.protogen.core.CarService;
import za.co.protogen.domain.Car;
import za.co.protogen.utility.Constant;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {

    @Override
    public String addCar(Car car) {
        Constant.cars.add(car);
        return "Car Added Successfully!<br/>" +"There is now " + Constant.cars.size() + " cars";
    }
    @Override
    public String removeCar(Car car) {
        Boolean found;
        found=Constant.cars.removeIf(a->a.equals(car));
        if (found){
            return "Car Added Successfully!<br/>There is now" + Constant.cars.size() + " cars";
        }
        else {
            return "Error: Car not found or no car entered";
        }
    }

    @Override
    public Car getCarById(String vin) {
        Car foundCar = Constant.cars.stream().filter(a->a.getVin().equals(vin)).findFirst().orElse(null);

        return foundCar;
    }//searches for and returns a specific car using its unique vin else return null

    @Override
    public List<Car> getAllCars() {
        return Constant.cars;
    }

    @Override
    public List<Car> getCarsByMake(String make) {
        return Constant.cars.stream().filter(a->a.getMake().equals(make)).collect(Collectors.toList());
    }//searches for and returns a specific car using its make else return null

    @Override
    public List<Car> getCarsByYear(int year) {

        return Constant.cars.stream().filter(a->a.getYear()==year).collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        return Constant.cars.stream().filter(a->a.getColor().equals(color)).collect(Collectors.toList());
    }

    @Override
    public String updateCar(Car car,String ansUpdate,String ansUpdateTo) {

        switch (ansUpdate) {
            case "a" :
                car.setVin(ansUpdateTo);
                return "Update successful <br/>"+car.toString();
            case "b":
                car.setOwnerId(Integer.parseInt(ansUpdateTo));
                return "Update successful <br/>"+car.toString();
            case "c":
                car.setMileage(Integer.parseInt(ansUpdateTo));
                return "Update successful <br/>"+car.toString();
            case "d":
                car.setYear(Integer.parseInt(ansUpdateTo));
                return "Update successful <br/>"+car.toString();
            case "e":
                car.setMake(ansUpdateTo);
                return "Update successful <br/>"+car.toString();
            case "f":
                car.setModel(ansUpdateTo);
                return "Update successful <br/>"+car.toString();
            case "g":
                car.setColor(ansUpdateTo);
                return "Update successful <br/>"+car.toString();
            case "h":
                car.setEngine(ansUpdateTo);
                return "Update successful <br/>"+car.toString();
            case "i":
                car.setFuelType(ansUpdateTo);
                return "Update successful <br/>"+car.toString();
            case "j":
                car.setTransmission(ansUpdateTo);
                return "Update successful <br/>"+car.toString();
            default:
                return "Unable to perform action";

        }


    }

    @Override
    public double calculateAverageMileage() {
        int CarCount = Constant.cars.size();
        int MileageTotal=0;
        double totAvg = 0.00;

        for (int i = 0; i < Constant.cars.size() ; i++) {
            MileageTotal+=Constant.cars.get(i).getMileage();
        }
        totAvg= (double) MileageTotal /CarCount;

        return totAvg;
    }

    @Override
    public Car findCheapestCar() {
        return Constant.cars.stream().min(Comparator.comparingInt(Car::getPrice)).orElse(null);
    }

    @Override
    public Car findMostExpensiveCar() {
        return Constant.cars.stream().max(Comparator.comparingInt(Car::getPrice)).orElse(null);
    }

    @Override
    public Car findNewestCar() {
        return Constant.cars.stream().max(Comparator.comparingInt(Car::getYear)).orElse(null);
    }

    @Override
    public Car findOldestCar() {
        return Constant.cars.stream().min(Comparator.comparingInt(Car::getYear)).orElse(null);
    }

    @Override
    public List<Car> searchCars(String criteria) {
        List<String> strListOfCars = new ArrayList<>();
        List<String> splitStringCriteria = new ArrayList<>();
        //stores the criteria split using " " as delimeter
        List<Car> ListToReturn = new ArrayList<>();

        splitStringCriteria = List.of(criteria.split(" ")); // split criteria into array

        strListOfCars=Constant.cars.stream().map(Car::toString).toList();
            //Transform car objects from Constant.cars list into List of String

        for (int i = 0; i < strListOfCars.size(); i++) {
            int iSuccess=0; //Counts number of criteria current row passed

            for (int j = 0; j < splitStringCriteria.size(); j++) {
                if (strListOfCars.get(i).contains(splitStringCriteria.get(j))){
                    iSuccess++;
                }
                if (iSuccess==splitStringCriteria.size()){
                    //Using their index, i, Find its Car object equivalent and Add to listToReturn
                    ListToReturn.add(Constant.cars.get(i));
                }
            }//Cycle through split string

        }//Cycle through string list of Cars

        return ListToReturn;
    } //if multiple criteria match completely
}

