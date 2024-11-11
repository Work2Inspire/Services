package za.co.protogen.core.domain.models.delegate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import za.co.protogen.controller.GetUserIdApiController;
import za.co.protogen.core.domain.api.GetUserIdApi;

import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link GetUserIdApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-10T10:21:23.805578500+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
public interface GetUserIdApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /getUser_id : Find and Return user using userId
     *
     * @param userId userId of the user to return (required)
     * @return Successful. Responds message and with user (status code 200)
     *         or No User matches userId criteria or repository empty (status code 404)
     * @see GetUserIdApi#getById
     */
    default ResponseEntity<String> getById(int userId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
