package za.co.protogen.adapter;

import org.mapstruct.Mapper;
import za.co.protogen.controller.model.ReservationDTO;
import za.co.protogen.persistence.Reservation;

@Mapper(componentModel = "spring")
public interface reservationMapper {
    //convert domain to client model
    Reservation dtoToDomain(ReservationDTO dto);
    //convert client model to domain
    ReservationDTO domainToDto(Reservation domain);
}
