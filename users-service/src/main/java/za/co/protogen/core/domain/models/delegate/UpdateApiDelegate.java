package za.co.protogen.core.domain.models.delegate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import za.co.protogen.controller.UpdateApiController;
import za.co.protogen.core.domain.api.UpdateApi;

import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link UpdateApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-10T10:21:23.805578500+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
public interface UpdateApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * PUT /update/{userId}/{sWhat}/{sTo} : Update user
     *
     * @param userId Id to identify the User (required)
     * @param sWhat The letter corresponding to the field to Update (required)
     * @param sTo new data to replace the data of a chosen field with (required)
     * @return Successful Responds. Return message and updated user (status code 200)
     *         or Repository is empty (status code 404)
     *         or Letter that is not an option selected (status code 400)
     * @see UpdateApi#updateUser
     */
    default ResponseEntity<String> updateUser(Long userId,
        String sWhat,
        String sTo) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
