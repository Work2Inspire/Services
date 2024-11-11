package za.co.protogen.core.domain.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.protogen.adapter.aCarMapperImpl;
import za.co.protogen.controller.models.CarDTO;
import za.co.protogen.core.domain.models.delegate.FindNewestApiDelegate;
import za.co.protogen.persistence.carEntity;
import za.co.protogen.persistence.repository.CarRepository;

import java.util.Comparator;

@Service
public class FindNewestApiDelegateImpl implements FindNewestApiDelegate {

    private final CarRepository carRepository;
    private static final Logger logger = LoggerFactory.getLogger(FindNewestApiDelegateImpl.class);

    // Spring will automatically inject CarRepository here
    @Autowired
    public FindNewestApiDelegateImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    aCarMapperImpl carMapper = new aCarMapperImpl();

    @Override
    public ResponseEntity<String> getNewest() {
        if (carRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Repository Empty: no cars to return");
        }//return not found error if repository is empty

        //Retrieve newest car
        carEntity RepoCar= carRepository.findAll().stream().max(Comparator.comparingInt(carEntity::getYear)).orElse(null);

        CarDTO dtoToSendBack;
        try{
            if (RepoCar==null){// if null throw exception to trigger catch
                throw new Exception();
            }
            dtoToSendBack = carMapper.domainToDto(RepoCar);
        } catch (Exception e) {
            logger.error("Failed to converting domain to DTO in {}. Null domain Car?", FindNewestApiDelegateImpl.class.getSimpleName(),e);
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("Returned newest car: <br/>"+dtoToSendBack);
    }
}