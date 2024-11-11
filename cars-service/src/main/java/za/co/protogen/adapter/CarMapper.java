package za.co.protogen.adapter;

import org.mapstruct.Mapper;
import za.co.protogen.controller.models.CarDTO;
import za.co.protogen.persistence.carEntity;

@Mapper(componentModel = "spring")
public interface CarMapper {
    //Mapping from one layer to another
    carEntity dtoToDomain(CarDTO dto);
    CarDTO domainToDto(carEntity domain);
}
