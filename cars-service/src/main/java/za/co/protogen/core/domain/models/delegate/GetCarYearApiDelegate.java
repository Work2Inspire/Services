package za.co.protogen.core.domain.models.delegate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import za.co.protogen.controller.GetCarYearApiController;
import za.co.protogen.core.domain.api.GetCarYearApi;

import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link GetCarYearApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-07T20:54:30.516515700+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
public interface GetCarYearApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /getCar_year : Find and Return car using year
     *
     * @param year Car year used to retrieve car (required)
     * @return Successful Responds. Return List of Cars matching year criteria (status code 200)
     *         or No Car matches year criteria or Empty Repository (status code 404)
     * @see GetCarYearApi#getByYear
     */
    default ResponseEntity<String> getByYear(Integer year) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
