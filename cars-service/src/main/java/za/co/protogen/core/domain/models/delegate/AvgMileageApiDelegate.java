package za.co.protogen.core.domain.models.delegate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import za.co.protogen.controller.AvgMileageApiController;
import za.co.protogen.core.domain.api.AvgMileageApi;

import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link AvgMileageApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-07T20:54:30.516515700+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
public interface AvgMileageApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /avg_mileage : Get average mileage
     *
     * @return Successful Responds. Return average mileage (status code 200)
     *         or Empty Repository (status code 404)
     * @see AvgMileageApi#getAvgMileage
     */
    default ResponseEntity<String> getAvgMileage() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
