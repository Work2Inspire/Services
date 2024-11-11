package za.co.protogen.core.domain.models.delegate;

import za.co.protogen.controller.SearchReservationApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import za.co.protogen.core.domain.api.SearchReservationApi;

import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link SearchReservationApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-09T22:41:04.315909+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
public interface SearchReservationApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * PATCH /searchReservation/{criteria} : search for reservations adhering to criteria
     *
     * @param criteria search criteria (required)
     * @return Successful. responds with message and list of reservations (status code 200)
     *         or No reservations match or Repository Empty (status code 404)
     * @see SearchReservationApi#searchReservation
     */
    default ResponseEntity<String> searchReservation(String criteria) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
