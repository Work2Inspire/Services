package za.co.protogen.core.domain.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.protogen.adapter.aCarMapperImpl;
import za.co.protogen.controller.models.CarDTO;
import za.co.protogen.core.domain.models.delegate.AddCarApiDelegate;
import za.co.protogen.persistence.carEntity;
import za.co.protogen.persistence.repository.CarRepository;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class AddCarApiDelegateImpl implements AddCarApiDelegate {

    private final CarRepository carRepository;

    // Spring will automatically inject CarRepository here
    @Autowired
    public AddCarApiDelegateImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    aCarMapperImpl carMapper = new aCarMapperImpl();

    @Override
    public ResponseEntity<String> createCar(String vin, int price, int year) {//3 params chosen for demostration purposes
        // Business logic or task to be performed
        //Create new car
        CarDTO newCarDTO = new CarDTO();
        newCarDTO.setMake("Moro");
        newCarDTO.setModel("BMW");
        newCarDTO.setYear(year);
        newCarDTO.setColor("White");
        newCarDTO.setEngine("1.8L");
        newCarDTO.setTransmission(CarDTO.TransmissionEnum.AUTOMATIC);
        newCarDTO.setFuelType(CarDTO.FuelTypeEnum.ELECTRIC);
        newCarDTO.setMileage(10000);
        newCarDTO.setVin(vin);
        newCarDTO.setPrice(price);
        newCarDTO.setOwnerId(123);
        newCarDTO.setFeatures( new ArrayList<>(Arrays.asList("sun roof", "yearn for the mines")));

        //Map domain to entity model to send to repository
        carEntity newEntityCar = carMapper.dtoToDomain(newCarDTO);
        carRepository.save(newEntityCar);
        CarDTO dtoToSendBack = carMapper.domainToDto(newEntityCar);
        return ResponseEntity.ok(dtoToSendBack.toString());
    }
}