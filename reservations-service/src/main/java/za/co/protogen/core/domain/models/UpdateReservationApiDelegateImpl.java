package za.co.protogen.core.domain.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.protogen.adapter.aReservationMapperImpl;
import za.co.protogen.core.domain.models.delegate.UpdateReservationApiDelegate;
import za.co.protogen.persistence.Reservation;
import za.co.protogen.persistence.repository.ResRepository;

import java.time.LocalDate;


@Service
public class UpdateReservationApiDelegateImpl implements UpdateReservationApiDelegate {

    private final ResRepository resRepository;
    private static final Logger logger = LoggerFactory.getLogger(UpdateReservationApiDelegateImpl.class);
    // Spring will automatically inject ResRepository here
    @Autowired
    public UpdateReservationApiDelegateImpl(ResRepository resRepository) {
        this.resRepository = resRepository;
    }

    aReservationMapperImpl resMapper = new aReservationMapperImpl();

    @Override
    public ResponseEntity<String> updateReservation(Long reservationId, String sWhat, String sTo) {
        //Check if repository is empty
        if (resRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Repository Empty: no cars to return");
        }
        //Check if sWhat input is correct
        if (!(sWhat.length() == 1 && sWhat.charAt(0) >= 'a' && sWhat.charAt(0) <= 'g')) {
            return ResponseEntity.ok("Error: Option is invalid");
        }
        //"sWhat" Options---------
        // a.ReservationId
        // b.UserId
        // c.CarId
        // d.From Date
        // e.To Date
        // f.DropOffLocation
        // g.PickUpLocation
        
        Reservation foundRes = resRepository.findAll().stream().filter(a->a.getId().equals(reservationId)).findFirst().orElse(null);

        try{
            if (foundRes==null){// if null throw exception to trigger catch
                throw new Exception();
            }
            switch (sWhat) {//One case is selected based on user choice
                case "a" :
                    foundRes.setId(Long.parseLong(sTo));
                    break;
                case "b":
                    foundRes.setUserId(Long.parseLong(sTo));
                    break;
                case "c":
                    foundRes.setCarId(Long.parseLong(sTo));
                    break;
                case "d":
                    foundRes.setFromDate(LocalDate.parse(sTo));
                    break;
                case "e":
                    foundRes.setToDate(LocalDate.parse(sTo));
                    break;
                case "f":
                    foundRes.setPickUpLocation(sTo);
                    break;
                case "g":
                    foundRes.setDropoffLocation(sTo);
                    break;
            }
            resRepository.save(foundRes);
        }
        catch (Exception e){
            logger.error("Failed to Update in {}. is reservation null?", UpdateReservationApiDelegateImpl.class.getSimpleName(),e);
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok("Update successful <br/>"+foundRes);
    }
}