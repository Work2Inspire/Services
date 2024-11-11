package za.co.protogen.core.domain.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.protogen.adapter.aCarMapperImpl;
import za.co.protogen.controller.models.CarDTO;
import za.co.protogen.core.domain.models.delegate.FindOldestApiDelegate;
import za.co.protogen.persistence.carEntity;
import za.co.protogen.persistence.repository.CarRepository;

import java.util.Comparator;


@Service
public class FindOldestApiDelegateImpl implements FindOldestApiDelegate {

    private static final Logger logger = LoggerFactory.getLogger(FindOldestApiDelegateImpl.class);
    private final CarRepository carRepository;

    // Spring will automatically inject CarRepository here
    @Autowired
    public FindOldestApiDelegateImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    aCarMapperImpl carMapper = new aCarMapperImpl();

    @Override
    public ResponseEntity<String> getOldest() {
        if (carRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Repository Empty: no cars to return");
        }//return error message if repository is empty

        //Retrieve Oldest car
        carEntity RepoCar= carRepository.findAll().stream().min(Comparator.comparingInt(carEntity::getYear)).orElse(null);

        CarDTO dtoToSendBack;
        try{
            if (RepoCar==null){// if null throw exception to trigger catch
                throw new Exception();
            }
             dtoToSendBack = carMapper.domainToDto(RepoCar);
        } catch (Exception e) {
            logger.error("Failed to converting domain to DTO in {}. Null domain Car?", FindOldestApiDelegateImpl.class.getSimpleName(),e);
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("Returned oldest car: <br/>"+dtoToSendBack);
    }
}