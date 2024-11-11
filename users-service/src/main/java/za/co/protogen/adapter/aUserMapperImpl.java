package za.co.protogen.adapter;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import za.co.protogen.controller.model.controllerModel;
import za.co.protogen.core.domain.domainModel;
import za.co.protogen.persistence.entityModel;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-10T11:19:10+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class aUserMapperImpl implements userMapper {

    @Override
    public domainModel ctrlToDomain(controllerModel dto) {
        if ( dto == null ) {
            return null;
        }

        domainModel domainModel = new domainModel();

        domainModel.setUserId( dto.getUserId() );
        domainModel.setFirstName( dto.getFirstName() );
        domainModel.setLastName( dto.getLastName() );
        domainModel.setDateOfBirth( dto.getDateOfBirth() );

        return domainModel;
    }

    @Override
    public controllerModel domainToCtrl(domainModel domain) {
        if ( domain == null ) {
            return null;
        }

        controllerModel controllerModel = new controllerModel();

        controllerModel.setUserId( domain.getUserId() );
        controllerModel.setFirstName( domain.getFirstName() );
        controllerModel.setLastName( domain.getLastName() );
        controllerModel.setDateOfBirth( domain.getDateOfBirth() );

        return controllerModel;
    }

    @Override
    public domainModel entityToDomain(entityModel dto) {
        if ( dto == null ) {
            return null;
        }

        domainModel domainModel = new domainModel();

        domainModel.setUserId(dto.getId());
        domainModel.setFirstName( dto.getFirstName() );
        domainModel.setLastName( dto.getLastName() );
        domainModel.setDateOfBirth( dto.getDateOfBirth() );

        return domainModel;
    }

    @Override
    public entityModel domainToEntity(domainModel domain) {
        if ( domain == null ) {
            return null;
        }

        entityModel entityModel = new entityModel();

        entityModel.setId(domain.getUserId());
        entityModel.setRsaId( domain.getRsaId() );
        entityModel.setDateOfBirth( domain.getDateOfBirth() );
        entityModel.setLastName( domain.getLastName() );
        entityModel.setFirstName( domain.getFirstName() );

        return entityModel;
    }
}
