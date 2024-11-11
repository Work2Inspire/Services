package za.co.protogen.adapter;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import za.co.protogen.controller.model.ReservationDTO;
import za.co.protogen.persistence.Reservation;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-10T00:44:46+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class aReservationMapperImpl implements reservationMapper {

    @Override
    public Reservation dtoToDomain(ReservationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Reservation reservation = new Reservation();

        reservation.setId( dto.getId() );
        reservation.setUserId( dto.getUserId() );
        reservation.setCarId( dto.getCarId() );
        reservation.setFromDate( dto.getFromDate() );
        reservation.setToDate( dto.getToDate() );
        reservation.setPickUpLocation( dto.getPickUpLocation() );
        reservation.setDropoffLocation(dto.getDropOffLocation());
        return reservation;
    }

    @Override
    public ReservationDTO domainToDto(Reservation domain) {
        if ( domain == null ) {
            return null;
        }

        ReservationDTO reservationDTO = new ReservationDTO();

        reservationDTO.setId( domain.getId() );
        reservationDTO.setUserId( domain.getUserId() );
        reservationDTO.setCarId( domain.getCarId() );
        reservationDTO.setFromDate( domain.getFromDate() );
        reservationDTO.setToDate( domain.getToDate() );
        reservationDTO.setPickUpLocation( domain.getPickUpLocation() );
        reservationDTO.setDropOffLocation(domain.getDropoffLocation());
        return reservationDTO;
    }
}
