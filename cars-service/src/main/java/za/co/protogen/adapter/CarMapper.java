package za.co.protogen.adapter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import za.co.protogen.controller.models.openapi.model.CarDTO;
//import za.co.protogen.core.domain.*;
import za.co.protogen.core.domain.car;
import za.co.protogen.core.domain.models.impl.CarServiceImpl;
import za.co.protogen.persistence.models.Car;


import java.util.Arrays;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
    Car dtoToDomain(CarDTO dto);
    CarDTO domainToDto(Car domain);

}