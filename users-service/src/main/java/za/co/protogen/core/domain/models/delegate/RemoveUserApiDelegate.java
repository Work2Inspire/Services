package za.co.protogen.core.domain.models.delegate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import za.co.protogen.controller.RemoveUserApiController;
import za.co.protogen.core.domain.api.RemoveUserApi;

import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link RemoveUserApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-10T10:21:23.805578500+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
public interface RemoveUserApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /remove_user : Find and Delete user using userId)
     *
     * @param id Id of user to remove (required)
     * @return Successful responds with message and all users in repository (status code 200)
     *         or User not found or No users in repository (status code 404)
     * @see RemoveUserApi#deleteUser
     */
    default ResponseEntity<String> deleteUser(Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
