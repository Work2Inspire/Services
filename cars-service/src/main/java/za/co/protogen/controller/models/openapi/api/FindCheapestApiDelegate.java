package za.co.protogen.controller.models.openapi.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link FindCheapestApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-05T20:49:04.739846900+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
public interface FindCheapestApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /find_cheapest : Return cheapest car
     *
     * @return Successful Responds. Return car with lowest price (status code 200)
     *         or Empty Repository (status code 404)
     * @see FindCheapestApi#getCheapest
     */
    default ResponseEntity<String> getCheapest() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
