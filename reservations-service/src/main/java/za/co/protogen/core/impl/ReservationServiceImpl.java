package za.co.protogen.core.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import za.co.protogen.core.ReservationService;
import za.co.protogen.persistence.Reservation;
import za.co.protogen.persistence.repository.ResRepository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private RestTemplate restTemplate;// Spring will automatically inject ResRepository here
    private final ResRepository resRepository;

    public ReservationServiceImpl(ResRepository resRepository) {
        this.resRepository = resRepository;
    }

    @Override
    public void addReservation(Reservation reservation) {
        String carResponse;
        String userResponse;
            //Using restTemplate confirm if userId and carId exist in other services
            String getCarURI = "http://localhost:9102/cars/" + reservation.getCarId();
            carResponse = restTemplate.getForObject(getCarURI, String.class);

            String getUserURI = "http://localhost:9101/users/" + reservation.getUserId();
            userResponse = restTemplate.getForObject(getUserURI, String.class);
        resRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return resRepository.findAll().stream().toList();
    }

    @Override
    public void removeReservation(Long id) {
        if (!resRepository.existsById(id)) {
            throw new IllegalStateException("Reservation not found");
        }
        resRepository.deleteById(id);
    }

    @Override
    public Reservation getReservationById(Long id) {
        Optional<Reservation> reservationOptional = resRepository.findById(id);
        return reservationOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Reservation not found"));
    }

    @Override
    public void updateReservation(Long id, Reservation updateReservationInfo) {
        Reservation existingReservation = getReservationById(id);
        if (existingReservation != null) {//Updating only the changes

            if (updateReservationInfo.getId() != null) {
                existingReservation.setId(updateReservationInfo.getId());
            }
            if (updateReservationInfo.getUserId() != null) {
                existingReservation.setUserId(updateReservationInfo.getUserId());
            }
            if (updateReservationInfo.getCarId() != null) {
                existingReservation.setCarId(updateReservationInfo.getCarId());
            }
            if (updateReservationInfo.getFromDate() != null) {
                existingReservation.setFromDate(updateReservationInfo.getFromDate());
            }
            if (updateReservationInfo.getToDate() != null) {
                existingReservation.setToDate(updateReservationInfo.getToDate());
            }
            if (updateReservationInfo.getPickUpLocation() != null) {
                existingReservation.setPickUpLocation(updateReservationInfo.getPickUpLocation());
            }
            if (updateReservationInfo.getDropOffLocation() != null) {
                existingReservation.setDropOffLocation(updateReservationInfo.getDropOffLocation());
            }

            resRepository.save(existingReservation);
        }
    }
    
    @Override
    public List<Reservation> searchReservations( Long id, Long userId, Long carId, LocalDate fromDate, LocalDate toDate, String pickUpLocation, String dropOffLocation) {

        Reservation searchReservation = new Reservation();
        searchReservation.setId(id);
        searchReservation.setUserId(userId);
        searchReservation.setCarId(carId);
        searchReservation.setFromDate(fromDate);
        searchReservation.setToDate(toDate);
        searchReservation.setPickUpLocation(pickUpLocation);
        searchReservation.setDropOffLocation(dropOffLocation);

        // Create an ExampleMatcher
        ExampleMatcher matcher = ExampleMatcher.matchingAny() // Match ANY property
                .withIgnoreNullValues() // Ignore null fields
                .withIgnoreCase(); // Ignore case sensitivity

        // Create Example instance
        Example<Reservation> example = Example.of(searchReservation, matcher);

        // Find all matching reservations
        return resRepository.findAll(example);

    }

}
