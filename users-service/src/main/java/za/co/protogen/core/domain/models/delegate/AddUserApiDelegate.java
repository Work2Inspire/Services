package za.co.protogen.core.domain.models.delegate;

import java.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import za.co.protogen.controller.AddUserApiController;
import za.co.protogen.core.domain.api.AddUserApi;

import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link AddUserApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-10T10:21:23.805578500+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
public interface AddUserApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /add_user : Create new user
     *
     * @param id The user identification number (required)
     * @param fName The user&#39;s first name (required)
     * @param lName The user&#39;s last name (required)
     * @param DOB The user&#39;s date of birth (required)
     * @param rsaId South African Id Number (required)
     * @return Successful - responds with message and the list of all users (status code 200)
     * @see AddUserApi#createUser
     */
    default ResponseEntity<String> createUser(Long id,
        String fName,
        String lName,
        LocalDate DOB,
        String rsaId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
