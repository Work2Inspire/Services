package za.co.protogen.core.domain.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.protogen.adapter.aCarMapperImpl;
import za.co.protogen.controller.models.CarDTO;
import za.co.protogen.core.domain.models.delegate.GetCarColorApiDelegate;
import za.co.protogen.persistence.carEntity;
import za.co.protogen.persistence.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetCarColorApiDelegateImpl implements GetCarColorApiDelegate {

    private final CarRepository carRepository;
    private static final Logger logger = LoggerFactory.getLogger(GetCarColorApiDelegateImpl.class);

    // Spring will automatically inject CarRepository here
    @Autowired
    public GetCarColorApiDelegateImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    aCarMapperImpl carMapper = new aCarMapperImpl();

    @Override
    public ResponseEntity<String> getByColor(String color) {
        if (carRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Repository Empty: no cars to return");
        }//Return Not Found if repository is empty

        //List holds all cars with the same color criteria
        List<carEntity> SelectByColor = carRepository.findAll().stream().filter(a->a.getColor().equals(color)).collect(Collectors.toList());

        List<CarDTO> ListToReturn =new ArrayList<>();

        //check if any cars returned
        if (SelectByColor.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No car matches criteria");
        }
        try{
            for (int i = 0; i < SelectByColor.size(); i++) {
                ListToReturn.add(carMapper.domainToDto(SelectByColor.get(i)));
            }
        } catch (Exception e) {
            logger.error("Failed to converting List of domain to DTO in {}. Null domain Car?", GetCarColorApiDelegateImpl.class.getSimpleName(),e);
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok("Returned list of "+color+" cars: <br/>"+ListToReturn);
    }
}



