package za.co.protogen.core.domain.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.protogen.adapter.aReservationMapperImpl;
import za.co.protogen.controller.model.ReservationDTO;
import za.co.protogen.core.domain.models.delegate.GetReservationByIdApiDelegate;
import za.co.protogen.persistence.Reservation;
import za.co.protogen.persistence.repository.ResRepository;

@Service
public class GetReservationByIdApiDelegateImpl implements GetReservationByIdApiDelegate {

    private final ResRepository resRepository;
    private static final Logger logger = LoggerFactory.getLogger(GetReservationByIdApiDelegateImpl.class);
    // Spring will automatically inject ResRepository here
    @Autowired
    public GetReservationByIdApiDelegateImpl(ResRepository resRepository) {
        this.resRepository = resRepository;
    }
    aReservationMapperImpl resMapper = new aReservationMapperImpl();

    public ResponseEntity<String> getReservationById(Long id) {
        //check if repository is not empty
        if (resRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Repository Empty: no cars to return");
        }
        Reservation foundRes=resRepository.findAll().stream().filter(a->a.getId().equals(id)).findFirst().orElse(null);
        ReservationDTO dtoToSendBack;
        try{
            if (foundRes==null){// if null throw exception to trigger catch
                throw new RuntimeException();
            }
            dtoToSendBack = resMapper.domainToDto(foundRes);
        } catch (Exception e) {
            logger.error("Failed to converting domain to DTO in {}. Null domain or no reservation matches criteria?", GetReservationByIdApiDelegateImpl.class.getSimpleName(),e);
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("Returned reservation by provided id: <br/>"+dtoToSendBack);
    }
}