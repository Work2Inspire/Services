package za.co.protogen.adapter;

import org.springframework.stereotype.Component;
import za.co.protogen.controller.models.CarDTO;
import za.co.protogen.controller.models.CarDTO.FuelTypeEnum;
import za.co.protogen.controller.models.CarDTO.TransmissionEnum;
import za.co.protogen.persistence.carEntity;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-08T14:05:37+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class aCarMapperImpl implements CarMapper {


    @Override
    public carEntity dtoToDomain(CarDTO dto) {
        if ( dto == null ) {
            return null;
        }

        carEntity car = new carEntity();

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
    public CarDTO domainToDto(carEntity domain) {
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
//            carDTO.setTransmission( Enum.valueOf( TransmissionEnum.class, domain.getTransmission() ) );
            carDTO.setTransmission( Enum.valueOf( TransmissionEnum.class, domain.getTransmission().toUpperCase()));
        }
        if ( domain.getFuelType() != null ) {
            carDTO.setFuelType( Enum.valueOf( FuelTypeEnum.class, domain.getFuelType().toUpperCase()));
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
