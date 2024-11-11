package za.co.protogen.core.domain.models.delegate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import za.co.protogen.controller.AddCarApiController;
import za.co.protogen.core.domain.api.AddCarApi;

import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link AddCarApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-07T20:54:30.516515700+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
public interface AddCarApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /add_car/{vin}/{price}/{year} : Create new car
     *
     * @param vin The vin(Vehicle Identification Number) of the car to retrieve (required)
     * @param price Price of the car
     * @param year How old the vehicle is
     * @return Successful responds with message and repository current size (status code 200)
     * @see AddCarApi#createCar
     */
    default ResponseEntity<String> createCar(String vin, int price, int year) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
}
