package za.co.protogen.core.domain;

import java.util.List;

enum etransmission {Manual,Automatic,CVT}
enum efuelType {Gasoline, Diesel, Electric}


public class car {
    private String vin;
    //A unique identifier assigned to the car (Vehicle Identification Number).
    private String make;
    //The car's manufacturer or brand.
    private String model;
    //The specific model name or number.
    private int year;
    //The year the car was manufactured.
    private String color;
    //The color of the car's exterior.
    private String engine;
    //Details about the car's engine, such as type, displacement, or horsepower.
    private etransmission transmission;
    //The type of transmission the car has (e.g., manual, automatic).
    private efuelType fuelType;
    //The type of fuel the car uses (e.g., gasoline, diesel, electric).
    private int mileage;
    //The number of miles the car has traveled.
    private int price;
    //The price of the car.
    private int ownerId;
    //The owner's unique identifier.
    private List<String> features;
    //A list of additional features or options the car may have, such as a navigation system, sunroof, etc.

    @Override
    public String toString() {
        return "Car{make='"+make+"', model="+model+"', year="+year+"', color="+color+"', engine="+engine+"', transmission="+transmission+"', fuelType="+fuelType+"', mileage="+mileage+"', vin="+vin+"', price="+price+"', ownerId="+ownerId+"', features="+features+" }";
    }//For better retrieval

//    Car(String make,String model,int year,String color,String engine,String transmission,String fuelType,int mileage,String vin,int price,int ownerId,List<String> features){
//        this.make=make;
//        this.model=model;
//        this.year=year;
//        this.color=color;
//        this.engine=engine;
//        setTransmission(transmission);
//        setFuelType(fuelType);
//        this.mileage=mileage;
//        this.vin=vin;
//        this.price=price;
//        this.ownerId=ownerId;
//        this.features=features;
//    }

    //setter methods for every property declared------------------------------------------------
    public void setMake(String make){
        this.make=make;
    }
    public void setModel(String model){
        this.model=model;
    }
    public void setYear(int year){
        this.year=year;
    }
    public void setColor(String color){
        this.color=color;
    }
    public void setEngine(String engine){
        this.engine=engine;
    }
    public void setTransmission(String Transmission){
        try {
            this.transmission=etransmission.valueOf(Transmission);
        }catch (Exception e){
            System.out.println("Error: Defaulting to Null");
            this.transmission=null;
        }
    }//Find and set etransmission enum value using input Transmission string else set null

    public void setFuelType(String FuelType){
        try {
            this.fuelType=efuelType.valueOf(FuelType);
        }catch (Exception e){
            System.out.println("Error: Defaulting to Null");
            this.fuelType=null;
        }

    }//Use incoming string to set Fuel but default to null if string is incorrect

    public void setMileage(int mileage){
        this.mileage=mileage;
    }
    public void setVin(String vin){
        this.vin=vin;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public void setOwnerId(int ownerId){
        this.ownerId=ownerId;
    }
    public void setFeatures(List<String> features){
        this.features=features;
    }

     //getters methods for every property declared-----------------------------------------------
    public String getMake(){
        return this.make;
    }
    public String getModel(){
        return this.model;
    }
    public int getYear(){
        return this.year;
    }
    public String getColor(){
        return this.color;
    }
    public String getEngine(){
        return this.engine;
    }
    public String getTransmission(){
        return this.transmission.name();
    }
    public String getFuelType(){
        return this.fuelType.name();
    }
    public int getMileage(){
        return this.mileage;
    }
    public String getVin(){
        return this.vin;
    }
    public int getPrice(){
        return this.price;
    }
    public int getOwnerId(){
        return this.ownerId;
    }
    public List<String> getFeatures(){
        return this.features;
    }
}

//make: The car's manufacturer or brand.
//model: The specific model name or number.
//year: The year the car was manufactured.
//color: The color of the car's exterior.
//engine: Details about the car's engine, such as type, displacement, or horsepower.
//transmission: The type of transmission the car has (e.g., manual, automatic).
//fuelType: The type of fuel the car uses (e.g., gasoline, diesel, electric).
//mileage: The number of miles the car has traveled.
//vin: A unique identifier assigned to the car (Vehicle Identification Number).
//price: The price of the car.
//ownerId: The owner's unique identifier.
//features: A list of additional features or options the car may have, such as a navigation system,
//sunroof, etc.