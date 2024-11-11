package za.co.protogen.core.domain.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.protogen.adapter.aReservationMapperImpl;
import za.co.protogen.controller.model.ReservationDTO;
import za.co.protogen.core.domain.models.delegate.SearchReservationApiDelegate;
import za.co.protogen.persistence.Reservation;
import za.co.protogen.persistence.repository.ResRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class SearchReservationApiDelegateImpl implements SearchReservationApiDelegate {

    private final ResRepository resRepository;
    private static final Logger logger = LoggerFactory.getLogger(SearchReservationApiDelegateImpl.class);

    // Spring will automatically inject ResRepository here
    @Autowired
    public SearchReservationApiDelegateImpl(ResRepository resRepository) {
        this.resRepository = resRepository;
    }

    aReservationMapperImpl resMapper = new aReservationMapperImpl();

    @Override
    public ResponseEntity<String> searchReservation(String criteria) {
        if (resRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Repository Empty: no cars to return");
        }
        List<String> strListOfRes = new ArrayList<>();
        List<String> splitStringCriteria = new ArrayList<>();//stores the given criteria split using " " as delimeter
        List<Reservation> lstSearchResults = new ArrayList<>();

        splitStringCriteria = List.of(criteria.split(" ")); // split criteria into array

        //find and tolist all Reservations, each one toString
        strListOfRes=resRepository.findAll().stream().map(Reservation::toString).toList();

        if (strListOfRes.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Reservation matched criteria");
        }
        for (int i = 0; i < strListOfRes.size(); i++) {
            int iSuccess=0; //Counts number of criteria current row passed

            for (int j = 0; j < splitStringCriteria.size(); j++) {
                if (strListOfRes.get(i).contains(splitStringCriteria.get(j))){
                    iSuccess++;
                }
                if (iSuccess==splitStringCriteria.size()){
                    //Using their index, i, Find its Reservation object equivalent and Add to lstSearchResults
                    lstSearchResults.add(resRepository.findAll().get(i));
                }
            }//Cycle through split string

        }//Cycle through string list of Reservations

        List<ReservationDTO> ListToReturn =new ArrayList<>();

        try{//convert every Reservation in lstSearchResults into client models else trigger log and error
            for (int i = 0; i < lstSearchResults.size(); i++) {
                ListToReturn.add(resMapper.domainToDto(lstSearchResults.get(i)));
            }
        } catch (Exception e) {
            logger.error("Failed to converting List of domain to DTO in {}. Null domain Reservation?", SearchReservationApiDelegateImpl.class.getSimpleName(),e);
            throw new RuntimeException(e);
        }
        
        
        return ResponseEntity.ok("Results are as follows: <br/>"+ListToReturn);
    }
}