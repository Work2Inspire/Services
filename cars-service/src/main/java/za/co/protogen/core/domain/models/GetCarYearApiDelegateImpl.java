package za.co.protogen.core.domain.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.protogen.adapter.aCarMapperImpl;
import za.co.protogen.controller.models.CarDTO;
import za.co.protogen.core.domain.models.delegate.GetCarYearApiDelegate;
import za.co.protogen.persistence.carEntity;
import za.co.protogen.persistence.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetCarYearApiDelegateImpl implements GetCarYearApiDelegate {

    private final CarRepository carRepository;
    private static final Logger logger = LoggerFactory.getLogger(GetCarYearApiDelegateImpl.class);

    // Spring will automatically inject CarRepository here
    @Autowired
    public GetCarYearApiDelegateImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    aCarMapperImpl carMapper = new aCarMapperImpl();

    @Override
    public ResponseEntity<String> getByYear(Integer year) {
        //confirm Repository is not empty
        if (carRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Repository Empty: no cars to return");
        }
        //Return as List, a collection of cars fitting the year criteria
        List<carEntity> SelectByYear = carRepository.findAll().stream().filter(a->a.getYear()==year).toList();

        List<CarDTO> ListToReturn =new ArrayList<>();

        //If selectbyyear is empty return NotFound error
        if (SelectByYear.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No car matches criteia");
        }
        try{
            for (int i = 0; i < SelectByYear.size(); i++) {// convert all carEntities into dto and place into the returning list
                ListToReturn.add(carMapper.domainToDto(SelectByYear.get(i)));
            }
        } catch (Exception e) {
            logger.error("Failed to converting List of domain to DTO in {}. Null domain Car?", GetCarYearApiDelegateImpl.class.getSimpleName(),e);
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok("Returned list of "+year+" cars: <br/>"+ListToReturn);

    }
}

