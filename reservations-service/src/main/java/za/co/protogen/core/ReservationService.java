package za.co.protogen.core;

import za.co.protogen.domain.Reservation;

import java.util.List;

public interface ReservationService {
    void addReservation(Reservation res);
        //Adds a new reservation to the service.
    void removeReservation(Reservation res);
        //Removes a reservation from the service.
    Reservation getReservationById(Long id);
        //Retrieves a reservation from the service based on its unique identifier.
    List<Reservation> getAllReservations();
        //Retrieves a list of all reservations in the service.
    void updateReservation(Reservation res,String ansUpdate,String ansUpdateTo);
        //Updates the information or attributes of a reservation.
    List<Reservation> searchReservations(String criteria);
    //Searches for reservations based on various criteria, such as user ID, car ID, dates, etc.
}


//searchReservations(): Searches for reservations based on various criteria, such as user ID, car ID, dates, etc.

//addReservation(): Adds a new reservation to the service.
//removeReservation(): Removes a reservation from the service.
//getReservationById(): Retrieves a reservation from the service based on its unique identifier.
//getAllReservations(): Retrieves a list of all reservations in the service.
//updateReservation(): Updates the information or attributes of a reservation.
//searchReservations(): Searches for reservations based on various criteria, such as user ID, car ID, dates, etc.