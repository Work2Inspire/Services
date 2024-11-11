package za.co.protogen.core.domain.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.protogen.adapter.aReservationMapperImpl;
import za.co.protogen.controller.model.ReservationDTO;
import za.co.protogen.core.domain.models.delegate.GetAllReservationsApiDelegate;
import za.co.protogen.persistence.Reservation;
import za.co.protogen.persistence.repository.ResRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllReservationsApiDelegateImpl implements GetAllReservationsApiDelegate {

    private final ResRepository resRepository;
    private static final Logger logger = LoggerFactory.getLogger(GetAllReservationsApiDelegateImpl.class);

    @Autowired
    public GetAllReservationsApiDelegateImpl(ResRepository resRepository) {
        this.resRepository = resRepository;
    }
    aReservationMapperImpl resMapper = new aReservationMapperImpl();

    public ResponseEntity<String> getAllRes() {
        //Check if repository is not empty
        if (resRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Repository Empty: no cars to return");
        }
        List<Reservation> AllCars= resRepository.findAll(); //return all cars
        List<ReservationDTO> ListToSend =new ArrayList<>();

        try{ //Convert every car listed into client models and save into listToSend to return
            for (int i = 0; i < AllCars.size(); i++) {
                ListToSend.add(resMapper.domainToDto(AllCars.get(i)));
            }
        } catch (Exception e) {
            logger.error("Failed to converting List of domain to DTO in {}. Null domain reservation?", GetAllReservationsApiDelegateImpl.class.getSimpleName(),e);
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("All reservations: <br/>"+ListToSend);
    }

}

