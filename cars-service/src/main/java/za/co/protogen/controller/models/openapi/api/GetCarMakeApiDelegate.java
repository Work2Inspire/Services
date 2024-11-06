package za.co.protogen.controller.models.openapi.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link GetCarMakeApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-05T20:49:04.739846900+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
public interface GetCarMakeApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /getCar_make : Find and Return car using make
     *
     * @param make Car make used to retrieve car (required)
     * @return Successful Responds. Return List of Cars matching make criteria (status code 200)
     *         or No Car matches make criteria or Empty Repository (status code 404)
     * @see GetCarMakeApi#getByMake
     */
    default ResponseEntity<String> getByMake(String make) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
