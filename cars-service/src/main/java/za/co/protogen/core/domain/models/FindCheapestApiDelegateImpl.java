package za.co.protogen.core.domain.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.protogen.adapter.aCarMapperImpl;
import za.co.protogen.controller.models.CarDTO;
import za.co.protogen.core.domain.models.delegate.FindCheapestApiDelegate;
import za.co.protogen.persistence.carEntity;
import za.co.protogen.persistence.repository.CarRepository;

import java.util.Comparator;

@Service
public class FindCheapestApiDelegateImpl implements FindCheapestApiDelegate {

    private final CarRepository carRepository;
    private static final Logger logger = LoggerFactory.getLogger(FindCheapestApiDelegateImpl.class);

    // Spring will automatically inject CarRepository here
    @Autowired
    public FindCheapestApiDelegateImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    aCarMapperImpl carMapper = new aCarMapperImpl();

    @Override
    public ResponseEntity<String> getCheapest() {
        if (carRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Repository Empty: no cars to return");
        }//Check if repository is empty

        //Retrieve Cheapest car from repository
        carEntity RepoCar= carRepository.findAll().stream().min(Comparator.comparingInt(carEntity::getPrice)).orElse(null);

        CarDTO dtoToSendBack;
        try{
            if (RepoCar==null){// if null throw exception to trigger catch
                throw new Exception();
            }
            dtoToSendBack = carMapper.domainToDto(RepoCar); //Map to client view model
        } catch (Exception e) {
            logger.error("Failed to converting domain to DTO in {}. Null domain Car?", FindCheapestApiDelegateImpl.class.getSimpleName(),e);
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok("Returned cheapest car: <br/>"+dtoToSendBack.toString());
    }
}