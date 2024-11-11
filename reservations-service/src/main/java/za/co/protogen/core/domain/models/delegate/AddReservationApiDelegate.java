package za.co.protogen.core.domain.models.delegate;

import java.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import za.co.protogen.core.domain.api.AddReservationApi;
import za.co.protogen.controller.AddReservationApiController;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link AddReservationApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-09T22:41:04.315909+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
public interface AddReservationApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /addReservation : Create new reservation
     *
     * @param id The unique identifier for the reservation (required)
     * @param userId The unique identifier for the user associated with the reservation (required)
     * @param carId The unique identifier for the car reserved (required)
     * @param fromDate The starting date of the reservation (required)
     * @param toDate The ending date of the reservation (required)
     * @param pLocation The location where the car will be picked up (required)
     * @param dLocation The location where the car will be dropped off. (required)
     * @return Successful. responds with message and all reservations (status code 200)
     * @see AddReservationApi#createRes
     */
    default ResponseEntity<String> createRes(Long id, Long userId, Long carId, LocalDate fromDate, LocalDate toDate, String pLocation, String dLocation) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
