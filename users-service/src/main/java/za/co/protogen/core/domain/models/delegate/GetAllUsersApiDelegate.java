package za.co.protogen.core.domain.models.delegate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import za.co.protogen.controller.GetAllUsersApiController;
import za.co.protogen.core.domain.api.GetAllUsersApi;

import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link GetAllUsersApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-10T10:21:23.805578500+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
public interface GetAllUsersApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /getAllUsers : Return all users
     *
     * @return Successful. Responds with message and List of users (status code 200)
     *         or Repository empty (status code 404)
     * @see GetAllUsersApi#getAllUsers
     */
    default ResponseEntity<String> getAllUsers() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
