package za.co.protogen.controller.models.openapi.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link GetCarColorApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-05T20:49:04.739846900+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
public interface GetCarColorApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /getCar_color : Find and Return car using color
     *
     * @param color Car color used to retrieve car (required)
     * @return Successful Responds. Return List of Cars matching color criteria (status code 200)
     *         or No Car matches color criteria or Empty Repository (status code 404)
     * @see GetCarColorApi#getByColor
     */
    default ResponseEntity<String> getByColor(String color) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
