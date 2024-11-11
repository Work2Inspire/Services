package za.co.protogen.core.domain.models.delegate;

import za.co.protogen.controller.GetAllReservationsApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import za.co.protogen.core.domain.api.GetAllReservationsApi;

import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link GetAllReservationsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-09T22:41:04.315909+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
public interface GetAllReservationsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /getAll_Reservations : Return all reservation
     *
     * @return Successful. responds with message and all reservations in repository (status code 200)
     *         or Reservation Id not found (status code 404)
     * @see GetAllReservationsApi#getAllRes
     */
    default ResponseEntity<String> getAllRes() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
