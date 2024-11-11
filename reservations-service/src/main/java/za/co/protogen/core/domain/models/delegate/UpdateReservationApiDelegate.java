package za.co.protogen.core.domain.models.delegate;

import za.co.protogen.controller.UpdateReservationApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import za.co.protogen.core.domain.api.UpdateReservationApi;

import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link UpdateReservationApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-09T22:41:04.315909+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
public interface UpdateReservationApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * PATCH /updateReservation/{reservationId}/{sWhat}/{sTo} : Update a reservation
     *
     * @param reservationId The unique identifier for the reservation (required)
     * @param sWhat What to change (only the listed letters) (required)
     * @param sTo content to update reservation field with (required)
     * @return Successful. responds with message and corresponding reservation (status code 200)
     *         or Wrong letter option selected (status code 400)
     *         or Reservation Id not found or Repository Empty (status code 404)
     * @see UpdateReservationApi#updateReservation
     */
    default ResponseEntity<String> updateReservation(Long reservationId,
        String sWhat,
        String sTo) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
