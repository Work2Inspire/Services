package za.co.protogen.adapter;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

import org.springframework.stereotype.Component;
import za.co.protogen.controller.models.openapi.model.CarDTO;
import za.co.protogen.controller.models.openapi.model.CarDTO.FuelTypeEnum;
import za.co.protogen.controller.models.openapi.model.CarDTO.TransmissionEnum;
import za.co.protogen.persistence.models.Car;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-06T19:49:59+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public Car dtoToDomain(CarDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Car car = new Car();

        car.setMake( dto.getMake() );
        car.setModel( dto.getModel() );
        if ( dto.getYear() != null ) {
            car.setYear( dto.getYear() );
        }
        car.setColor( dto.getColor() );
        car.setEngine( dto.getEngine() );
        if ( dto.getTransmission() != null ) {
            car.setTransmission( dto.getTransmission().name() );
        }
        if ( dto.getFuelType() != null ) {
            car.setFuelType( dto.getFuelType().name() );
        }
        if ( dto.getMileage() != null ) {
            car.setMileage( dto.getMileage() );
        }
        car.setVin( dto.getVin() );
        if ( dto.getPrice() != null ) {
            car.setPrice( dto.getPrice() );
        }
        if ( dto.getOwnerId() != null ) {
            car.setOwnerId( dto.getOwnerId() );
        }
        List<String> list = dto.getFeatures();
        if ( list != null ) {
            car.setFeatures( new ArrayList<String>( list ) );
        }

        return car;
    }

    @Override
    public CarDTO domainToDto(Car domain) {
        if ( domain == null ) {
            return null;
        }

        CarDTO carDTO = new CarDTO();

        carDTO.setVin( domain.getVin() );
        carDTO.setMake( domain.getMake() );
        carDTO.setModel( domain.getModel() );
        carDTO.setYear( domain.getYear() );
        carDTO.setColor( domain.getColor() );
        carDTO.setEngine( domain.getEngine() );
        if ( domain.getTransmission() != null ) {
            carDTO.setTransmission( Enum.valueOf( TransmissionEnum.class, domain.getTransmission() ) );
        }
        if ( domain.getFuelType() != null ) {
            carDTO.setFuelType( Enum.valueOf( FuelTypeEnum.class, domain.getFuelType() ) );
        }
        carDTO.setMileage( domain.getMileage() );
        carDTO.setPrice( domain.getPrice() );
        carDTO.setOwnerId( domain.getOwnerId() );
        List<String> list = domain.getFeatures();
        if ( list != null ) {
            carDTO.setFeatures( new ArrayList<String>( list ) );
        }

        return carDTO;
    }

}

