package za.co.protogen.core;

import za.co.protogen.persistence.Car;

import java.util.List;


public interface CarService {

    String addCar(Car car);
    //adds a car to the List of cars in service
    String removeCar(Car car);
    //removes a car from the List of cars in service

    Car getCarById(String vin);
    //Retrieves a car from the service based on its unique identifier.

    List<Car> getAllCars();
    //Retrieves a list of all cars in the service.

    List<Car> getCarsByMake(String make);
    //Retrieves a list of cars based on the specified make.

    List<Car> getCarsByYear(int year);
    //Retrieves a list of cars manufactured in the specified year.

    List<Car> getCarsByColor(String color);
    //Retrieves a list of cars with the specified color.

    String updateCar(Car car, String ansUpdate, String ansUpdateTo);
    //Updates the information or attributes of a car.

    double calculateAverageMileage();
    //Calculates the average mileage of all cars in the service.

    Car findCheapestCar();
    //Finds the cheapest car in the service.

    Car findMostExpensiveCar();
    //Finds the most expensive car in the service.

    Car findNewestCar();
    //Finds the newest car in the service based on the manufacturing year.

    Car findOldestCar();
    //Finds the oldest car in the service based on the manufacturing year.

    List<Car> searchCars(String criteria);
    //Searches for cars based on various criteria, such as make, model, price range, etc.
}

//removeCar(): Removes a car from the service.
//getCarById(): Retrieves a car from the service based on its unique identifier.
//getAllCars(): Retrieves a list of all cars in the service.
//getCarsByMake(): Retrieves a list of cars based on the specified make.
//getCarsByYear(): Retrieves a list of cars manufactured in the specified year.
//getCarsByColor(): Retrieves a list of cars with the specified color.
//updateCar(): Updates the information or attributes of a car.
//calculateAverageMileage(): Calculates the average mileage of all cars in the service.
//findCheapestCar(): Finds the cheapest car in the service.
//findMostExpensiveCar(): Finds the most expensive car in the service.
//findNewestCar(): Finds the newest car in the service based on the manufacturing year.
//findOldestCar(): Finds the oldest car in the service based on the manufacturing year.
//searchCars(): Searches for cars based on various criteria, such as make, model, price range, etc.