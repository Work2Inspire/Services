package za.co.protogen.core.domain.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.protogen.adapter.aCarMapperImpl;
import za.co.protogen.controller.models.CarDTO;
import za.co.protogen.core.domain.models.delegate.GetCarIdApiDelegate;
import za.co.protogen.persistence.carEntity;
import za.co.protogen.persistence.repository.CarRepository;

@Service
public class GetCarIdApiDelegateImpl implements GetCarIdApiDelegate {

    private final CarRepository carRepository;
    private static final Logger logger = LoggerFactory.getLogger(GetCarIdApiDelegateImpl.class);

    // Spring will automatically inject CarRepository here
    @Autowired
    public GetCarIdApiDelegateImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    aCarMapperImpl carMapper = new aCarMapperImpl();

    @Override
    public ResponseEntity<String> getById(String vin) {

        CarDTO dtoToSendBack;
        try{//return a Car using provided vin
            carEntity foundCar=carRepository.findAll().stream().filter(a->a.getVin().equals(vin)).findFirst().orElse(null);
            if (foundCar==null){// if null throw exception to enter catch block
                throw new Exception();
            }
            dtoToSendBack = carMapper.domainToDto(foundCar);//map returned entity to what the user will see
        } catch (Exception e) {
            logger.error("Failed to converting domain to DTO in {}. Null domain? no car matches criteria?", GetCarIdApiDelegateImpl.class.getSimpleName());
            ResponseEntity<String> toReturn;
            return ResponseEntity.ok("Error: No car found");// rest template ignores error coded returns, so I used ok instead
        }

        return ResponseEntity.ok("Returned car by provided vin: <br/>"+dtoToSendBack);
    }
}