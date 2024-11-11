package za.co.protogen.core.domain.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.protogen.adapter.aCarMapperImpl;
import za.co.protogen.controller.models.CarDTO;
import za.co.protogen.core.domain.models.delegate.UpdateApiDelegate;
import za.co.protogen.persistence.carEntity;
import za.co.protogen.persistence.repository.CarRepository;

@Service
public class UpdateApiDelegateImpl implements UpdateApiDelegate {

    private final CarRepository carRepository;
    private static final Logger logger = LoggerFactory.getLogger(UpdateApiDelegateImpl.class);

    // Spring will automatically inject CarRepository here
    @Autowired
    public UpdateApiDelegateImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    aCarMapperImpl carMapper = new aCarMapperImpl();

    @Override
    public ResponseEntity<String> updateCar(String vin, String sWhat, String sTo) {
        //Check Repository is not empty
        if (carRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Repository Empty: no cars to return");
        }
        if (!(sWhat.length() == 1 && sWhat.charAt(0) >= 'a' && sWhat.charAt(0) <= 'k')) {
            return ResponseEntity.ok("Error: incorrect option input");
        }
//    //"sWhat" Options
//    // a.Vin
//    // b.OwnerID
//    // c.Mileage
//    // d.Year
//    // e.Make
//    // f.Model
//    // g.Color
//    // h.Engine
//    // i.Fueltype
//    // j.Transmission
//    // k.Features
        //return car that matches the vin provided
        carEntity foundCar=carRepository.findAll().stream().filter(a->a.getVin().equals(vin)).findFirst().orElse(null);
        if (foundCar==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no car matches criteria");
        }
        //Switch statement to select the users choice and update it
        switch (sWhat) {
            case "a" :
                foundCar.setVin(sTo);
                break;
            case "b":
                foundCar.setOwnerId(Integer.parseInt(sTo));
                break;
            case "c":
                foundCar.setMileage(Integer.parseInt(sTo));
                break;
            case "d":
                foundCar.setYear(Integer.parseInt(sTo));
                break;
            case "e":
                foundCar.setMake(sTo);
                break;
            case "f":
                foundCar.setModel(sTo);
                break;
            case "g":
                foundCar.setColor(sTo);
                break;
            case "h":
                foundCar.setEngine(sTo);
                break;
            case "i":
//                setFuelType(CarDTO.FuelTypeEnum.fromValue(sTo));
                foundCar.setFuelType(sTo);
                break;
            case "j":
//                .setTransmission(CarDTO.TransmissionEnum.fromValue(sTo));
                foundCar.setTransmission(sTo);
                break;
           }
        //Save then send back to client to display the item that was updated
        carRepository.save(foundCar);
        CarDTO dtoToSendBack;
        try{
            dtoToSendBack = carMapper.domainToDto(foundCar);
        } catch (Exception e) {
            logger.error("Failed to converting domain to DTO in {}. Null domain Car?", UpdateApiDelegateImpl.class.getSimpleName(),e);
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("Update successful <br/>"+foundCar.toString());
    }
}
