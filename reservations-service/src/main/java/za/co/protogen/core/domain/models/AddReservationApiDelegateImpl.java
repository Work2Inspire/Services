package za.co.protogen.core.domain.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import za.co.protogen.controller.model.ReservationDTO;
import za.co.protogen.core.domain.models.delegate.AddReservationApiDelegate;
import za.co.protogen.persistence.Reservation;
import za.co.protogen.persistence.repository.ResRepository;
import za.co.protogen.adapter.aReservationMapperImpl;

import java.time.LocalDate;

@Service
public class AddReservationApiDelegateImpl implements AddReservationApiDelegate {

    private final ResRepository resRepository;
    @Autowired
    private RestTemplate restTemplate;
    // Spring will automatically inject ResRepository here
    @Autowired
    public AddReservationApiDelegateImpl(ResRepository resRepository) {
        this.resRepository = resRepository;
    }

    aReservationMapperImpl resMapper = new aReservationMapperImpl();

    @Override
    public ResponseEntity<String> createRes(Long id, Long userId, Long carId, LocalDate fromDate, LocalDate toDate, String pLocation, String dLocation) {
        //Using restTemplate confirm if userId and carId dont exist in other services
        String getCarURI = "http://localhost:9102/getCar_id?vin="+carId;
        String carResponse = restTemplate.getForObject(getCarURI, String.class);
        if (!carResponse.equals("Error: No car found")){//if string returned is not "No car found"
            return ResponseEntity.ok("CarId already exists");
        }
        String getUserURI = "http://localhost:9101/getUser_id?userId="+userId;
        String userResponse = restTemplate.getForObject(getUserURI, String.class);
        if (!userResponse.equals("Error: Id not found/Empty Id input")){
            return ResponseEntity.ok("UserId already exists");
        }
        //if the input is valid create reservation
        ReservationDTO newRes = new ReservationDTO();
        newRes.setId(id);
        newRes.setUserId(userId);
        newRes.setCarId(carId);
        newRes.setFromDate(fromDate);
        newRes.setToDate(toDate);
        newRes.setPickUpLocation(pLocation);
        newRes.setDropOffLocation(dLocation);

        //convert reservation from client model to entity model
        Reservation newEntityRes = resMapper.dtoToDomain(newRes);
        resRepository.save(newEntityRes);
        //convert back to client model to send back to the client
        ReservationDTO dtoToSendBack = resMapper.domainToDto(newEntityRes);
        return ResponseEntity.ok(dtoToSendBack.toString());

    }
}