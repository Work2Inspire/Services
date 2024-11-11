package za.co.protogen.core.domain.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.protogen.adapter.aCarMapperImpl;
import za.co.protogen.controller.models.CarDTO;
import za.co.protogen.core.domain.models.delegate.GetAllCarsApiDelegate;
import za.co.protogen.persistence.carEntity;
import za.co.protogen.persistence.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllCarsApiDelegateImpl implements GetAllCarsApiDelegate {

    private final CarRepository carRepository;
    private static final Logger logger = LoggerFactory.getLogger(GetAllCarsApiDelegateImpl.class);

    // Spring will automatically inject CarRepository here
    @Autowired
    public GetAllCarsApiDelegateImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    aCarMapperImpl carMapper = new aCarMapperImpl();

    @Override
    public ResponseEntity<String> getAll() {
        if (carRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Repository Empty: no cars to return");
        }//Get not found error when repository is empty

        List<carEntity> AllCars= carRepository.findAll();
        List<CarDTO> ListToSend =new ArrayList<>();

        try{
            for (int i = 0; i < AllCars.size(); i++) {
                if (AllCars.get(i)==null){// if null throw exception to trigger catch
                    throw new Exception();
                }
                ListToSend.add(carMapper.domainToDto(AllCars.get(i)));
            }
        } catch (Exception e) {
            logger.error("Failed to converting List of domain to DTO in {}. Null domain Car?", GetAllCarsApiDelegateImpl.class.getSimpleName(),e);
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("All cars: <br/>"+ListToSend);
    }
}