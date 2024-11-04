package za.co.protogen.core;

import org.jvnet.hk2.annotations.Service;
import za.co.protogen.domain.reservation;
import za.co.protogen.persistence.Reservation;

import java.util.List;

@Service
public interface ReservationService {
    String addReservation(Reservation res);
        //Adds a new reservation to the service.
    String removeReservation(Reservation res);
        //Removes a reservation from the service.
    Reservation getReservationById(Long id);
        //Retrieves a reservation from the service based on its unique identifier.
    List<Reservation> getAllReservations();
        //Retrieves a list of all reservations in the service.
    String updateReservation(Reservation res, String ansUpdate, String ansUpdateTo);
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