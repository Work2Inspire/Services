package za.co.protogen.core.domain.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.protogen.adapter.aReservationMapperImpl;
import za.co.protogen.core.domain.models.delegate.RemoveReservationApiDelegate;
import za.co.protogen.persistence.Reservation;
import za.co.protogen.persistence.repository.ResRepository;

@Service
public class RemoveReservationApiDelegateImpl implements RemoveReservationApiDelegate {

    private final ResRepository resRepository;

    // Spring will automatically inject ResRepository here
    @Autowired
    public RemoveReservationApiDelegateImpl(ResRepository resRepository) {
        this.resRepository = resRepository;
    }

    aReservationMapperImpl resMapper = new aReservationMapperImpl();

    @Override
    public ResponseEntity<String> removeRes(Long id) {
        //Confirm if repository is not empty
        if (resRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Repository Empty: no cars to return");
        }
        //return reservation fitting criteria
        Reservation foundRes =resRepository.findAll().stream().filter(a->a.getId()==id).findFirst().orElse(null);

        if (foundRes != null){//if not null delete and report else report error notfound
            resRepository.delete(foundRes);
            return ResponseEntity.ok("Reservation Removed Successfully <br/>All Reservations:<br/>"+resRepository.findAll());
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: reservation not found or no ReservationId entered");
        }

    }
}