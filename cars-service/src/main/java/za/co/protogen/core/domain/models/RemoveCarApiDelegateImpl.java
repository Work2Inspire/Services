package za.co.protogen.core.domain.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.protogen.adapter.aCarMapperImpl;
import za.co.protogen.core.domain.models.delegate.RemoveCarApiDelegate;
import za.co.protogen.persistence.carEntity;
import za.co.protogen.persistence.repository.CarRepository;

@Service
public class RemoveCarApiDelegateImpl implements RemoveCarApiDelegate {

    private final CarRepository carRepository;

    // Spring will automatically inject CarRepository here
    @Autowired
    public RemoveCarApiDelegateImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    aCarMapperImpl carMapper = new aCarMapperImpl();

    @Override
    public ResponseEntity<String> deleteCar(String vin) {
        boolean found;
        //Check if repository is empty
        if (carRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Repository Empty: no cars to return");
        }
        //Return as List, a collection of cars fitting the given criteria
        carEntity foundCar=carRepository.findAll().stream().filter(a->a.getVin().equals(vin)).findFirst().orElse(null);

        if (foundCar != null){ //if not null delete, if null return not found error
            carRepository.delete(foundCar);
            return ResponseEntity.ok("Car removed successfully!<br/>" + carRepository.findAll().size() + " cars found");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Car not found or no carId entered");
        }
    }
}