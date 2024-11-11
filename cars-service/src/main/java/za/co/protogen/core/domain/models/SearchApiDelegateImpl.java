package za.co.protogen.core.domain.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.protogen.adapter.aCarMapperImpl;
import za.co.protogen.controller.models.CarDTO;
import za.co.protogen.core.domain.models.delegate.SearchApiDelegate;
import za.co.protogen.persistence.carEntity;
import za.co.protogen.persistence.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchApiDelegateImpl implements SearchApiDelegate {

    private final CarRepository carRepository;
    private static final Logger logger = LoggerFactory.getLogger(SearchApiDelegateImpl.class);

    // Spring will automatically inject CarRepository here
    @Autowired
    public SearchApiDelegateImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    aCarMapperImpl carMapper = new aCarMapperImpl();
    List<String> strListOfCars;
    List<String> splitStringCriteria;
    List<carEntity> lstSearchResults;

    @Override
    public ResponseEntity<String> searchCars(String criteria) {
        //check if repository is empty
        if (carRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Repository Empty: no cars to return");
        }

        strListOfCars = new ArrayList<>(); //Holds every car in repo in full detail string
        lstSearchResults = new ArrayList<>();//pre List to return search results
        splitStringCriteria = List.of(criteria.split(" ")); // split criteria into array

        //returns all cars but in their tostring() forms and all placed in a list
        strListOfCars=carRepository.findAll().stream().map(carEntity::toString).toList();
        List<carEntity> repoCarsList=carRepository.findAll();


        for (int i = 0; i < strListOfCars.size(); i++) {
            int iSuccess=0; //Counts number of criteria current row passed

            for (int j = 0; j < splitStringCriteria.size(); j++) {
                if (strListOfCars.get(i).contains(splitStringCriteria.get(j))){
                    iSuccess++;
                }
                if (iSuccess==splitStringCriteria.size()){
                    //Using their index, i, Find its Car object equivalent and Add to lstSearchResults
                    lstSearchResults.add(repoCarsList.get(i));
                }
            }//Cycle through split string
        }//Cycle through string list of Cars

        List<CarDTO> ListToReturn =new ArrayList<>();

        try{
            for (int i = 0; i < lstSearchResults.size(); i++) {
                //itterate and Map to model the user will see and send back
                ListToReturn.add(carMapper.domainToDto(lstSearchResults.get(i)));
            }
        } catch (Exception e) {
            logger.error("Failed to converting List of domain to DTO in {}. Null domain Car?", SearchApiDelegateImpl.class.getSimpleName(),e);
            throw new RuntimeException(e);
        }


        return ResponseEntity.ok("Search results: <br/>"+ListToReturn.toString());
        


    }
}