/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.8.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package za.co.protogen.core.domain.api;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import za.co.protogen.core.domain.models.delegate.AddUserApiDelegate;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-10T10:21:23.805578500+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
@Validated
@Tag(name = "user", description = "the user API")
public interface AddUserApi {

    default AddUserApiDelegate getDelegate() {
        return new AddUserApiDelegate() {};
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
     */
    @Operation(
        operationId = "createUser",
        summary = "Create new user",
        tags = { "user", "new", "add" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful - responds with message and the list of all users", content = {
                @Content(mediaType = "text/html", schema = @Schema(implementation = String.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/add_user",
        produces = { "text/html" }
    )
    
    default ResponseEntity<String> createUser(
        @NotNull @Parameter(name = "Id", description = "The user identification number", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "Id", required = true) Long id,
        @NotNull @Parameter(name = "fName", description = "The user's first name", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "fName", required = true) String fName,
        @NotNull @Parameter(name = "lName", description = "The user's last name", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "lName", required = true) String lName,
        @NotNull @Parameter(name = "DOB", description = "The user's date of birth", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "DOB", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate DOB,
        @NotNull @Parameter(name = "rsaId", description = "South African Id Number", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "rsaId", required = true) String rsaId
    ) {
        return getDelegate().createUser(id, fName, lName, DOB, rsaId);
    }

}