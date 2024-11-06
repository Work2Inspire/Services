package za.co.protogen.controller.models.openapi.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link UpdateApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-05T20:49:04.739846900+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
public interface UpdateApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * PUT /update/{vin}/{sWhat}/{sTo} : Update car
     *
     * @param vin Car vin (Vehicle Identification Number) used to retrieve car (required)
     * @param sWhat The letter corresponding to the field to Update (required)
     * @param sTo new data to replace the data of a chosen field with (required)
     * @return Successful Responds. Return message and updated car (status code 200)
     *         or Letter that is not an option selected (status code 400)
     * @see UpdateApi#updateCar
     */
    default ResponseEntity<String> updateCar(String vin,
        String sWhat,
        String sTo) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
