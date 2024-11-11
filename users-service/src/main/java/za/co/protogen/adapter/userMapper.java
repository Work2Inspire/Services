package za.co.protogen.adapter;

import org.mapstruct.Mapper;
import za.co.protogen.controller.model.controllerModel;
import za.co.protogen.core.domain.domainModel;
import za.co.protogen.persistence.entityModel;

@Mapper(componentModel = "spring")
public interface userMapper {

    domainModel ctrlToDomain(controllerModel dto);
    controllerModel domainToCtrl(domainModel domain);

    domainModel entityToDomain (entityModel dto);
    entityModel domainToEntity(domainModel domain);

}