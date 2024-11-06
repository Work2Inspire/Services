package za.co.protogen.controller.models.openapi.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link RemoveCarApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-05T20:49:04.739846900+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
public interface RemoveCarApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /remove_car : Find and Delete car using vin (Vehicle Identification Number)
     *
     * @param vin Vin (Vehicle Identification Number) to find car (required)
     * @return Successful responds with message and repository current size (status code 200)
     *         or Car not found (status code 404)
     * @see RemoveCarApi#deleteCar
     */
    default ResponseEntity<String> deleteCar(String vin) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
