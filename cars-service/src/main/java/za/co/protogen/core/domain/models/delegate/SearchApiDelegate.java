package za.co.protogen.core.domain.models.delegate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import za.co.protogen.controller.SearchApiController;
import za.co.protogen.core.domain.api.SearchApi;

import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link SearchApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-07T20:54:30.516515700+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
public interface SearchApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /search/{criteria} : Search cars that meet criteria
     *
     * @param criteria search criteria to find car (required)
     * @return Successful Responds. Return List of cars meeting criteria in any field (status code 200)
     *         or Empty Repository (status code 404)
     * @see SearchApi#searchCars
     */
    default ResponseEntity<String> searchCars(String criteria) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}