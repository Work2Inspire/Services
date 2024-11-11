package za.co.protogen.core.domain.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.protogen.adapter.aCarMapperImpl;
import za.co.protogen.controller.models.CarDTO;
import za.co.protogen.core.domain.models.delegate.GetCarMakeApiDelegate;
import za.co.protogen.persistence.carEntity;
import za.co.protogen.persistence.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetCarMakeApiDelegateImpl implements GetCarMakeApiDelegate {

    private final CarRepository carRepository;
    private static final Logger logger = LoggerFactory.getLogger(GetCarMakeApiDelegateImpl.class);

    // Spring will automatically inject CarRepository here
    @Autowired
    public GetCarMakeApiDelegateImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    aCarMapperImpl carMapper = new aCarMapperImpl();

    @Override
    public ResponseEntity<String> getByMake(String make) {
        //Confirm repository is not empty
        if (carRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Repository Empty: no cars to return");
        }
        //Return as List, a collection of cars fitting the make criteria
        List<carEntity> SelectByMake = carRepository.findAll().stream().filter(a->a.getMake().equals(make)).collect(Collectors.toList());

        List<CarDTO> ListToReturn =new ArrayList<>();

        //If selectbymake is empty return NotFound error
        if (SelectByMake.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No car matches criteia");
        }
        try{
            for (int i = 0; i < SelectByMake.size(); i++) {// convert all carEntity into dto and place into the returning list
                ListToReturn.add(carMapper.domainToDto(SelectByMake.get(i)));
            }
        } catch (Exception e) {
            logger.error("Failed to converting List of domain to DTO in {}. Null domain Car?", GetCarMakeApiDelegateImpl.class.getSimpleName(),e);
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok("Returned list of "+make+" cars: <br/>"+ListToReturn);

    }
}