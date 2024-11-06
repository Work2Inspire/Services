package za.co.protogen.controller.models.openapi.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link FindOldestApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-05T20:49:04.739846900+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
public interface FindOldestApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /find_Oldest : Return oldest car
     *
     * @return Successful Responds. Return car with lowest year (status code 200)
     *         or Empty Repository (status code 404)
     * @see FindOldestApi#getOldest
     */
    default ResponseEntity<String> getOldest() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
