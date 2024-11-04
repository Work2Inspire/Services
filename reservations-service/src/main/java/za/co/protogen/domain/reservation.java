package za.co.protogen.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class reservation {
    private Long id;
    //The unique identifier for the reservation (type: Long).
    private Long userId;
    //The unique identifier for the user associated with the reservation (type: Long).
    private Long carId;
    //The unique identifier for the car reserved (type: Long).
    private LocalDate fromDate;
    //The starting date of the reservation (type: LocalDate).
    private LocalDate toDate;
    //The ending date of the reservation (type: LocalDate).
    private String pickUpLocation;
    //The location where the car will be picked up.
    private String dropoffLocation;
    //The location where the car will be dropped off.

    @Override
    public String toString() {
        return "Reservation {id='"+id+"', userId="+userId+"', carId="+carId+"', fromDate="+fromDate+"', toDate="+toDate+"', pickUpLocation="+pickUpLocation+"', dropoffLocation="+dropoffLocation+" }";
    }//For better retrieval

    //getter
    public Long getId() {
        return id;
    }
    public Long getUserId() {
        return userId;
    }
    public Long getCarId() {
        return carId;
    }
    public LocalDate getFromDate() {
        return fromDate;
    }
    public LocalDate getToDate() {
        return toDate;
    }
    public String getPickUpLocation() {
        return pickUpLocation;
    }
    public String getDropoffLocation() {
        return dropoffLocation;
    }
    //setter

    public void setId(Long id) {
        this.id = id;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setCarId(Long carId) {
        this.carId = carId;
    }
    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }
    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }
    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }
    public void setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }
}




//id: The unique identifier for the reservation (type: Long).
//userId: The unique identifier for the user associated with the reservation (type: Long).
//carId: The unique identifier for the car reserved (type: Long).
//fromDate: The starting date of the reservation (type: LocalDate).
//toDate: The ending date of the reservation (type: LocalDate).
//pickUpLocation: The location where the car will be picked up.
//dropoffLocation: The location where the car will be dropped off.