/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.8.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package za.co.protogen.core.domain.api;

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
import za.co.protogen.core.domain.models.delegate.UpdateApiDelegate;

import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-10T10:21:23.805578500+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
@Validated
@Tag(name = "user", description = "the user API")
public interface UpdateApi {

    default UpdateApiDelegate getDelegate() {
        return new UpdateApiDelegate() {};
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
     */
    @Operation(
        operationId = "updateUser",
        summary = "Update user",
        tags = { "user", "update" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful Responds. Return message and updated user", content = {
                @Content(mediaType = "text/html", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "404", description = "Repository is empty", content = {
                @Content(mediaType = "text/html", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "400", description = "Letter that is not an option selected", content = {
                @Content(mediaType = "text/html", schema = @Schema(implementation = String.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/update/{userId}/{sWhat}/{sTo}",
        produces = { "text/html" }
    )
    
    default ResponseEntity<String> updateUser(
        @Parameter(name = "userId", description = "Id to identify the User", required = true, in = ParameterIn.PATH) @PathVariable("userId") Long userId,
        @Parameter(name = "sWhat", description = "The letter corresponding to the field to Update", required = true, in = ParameterIn.PATH) @PathVariable("sWhat") String sWhat,
        @Parameter(name = "sTo", description = "new data to replace the data of a chosen field with", required = true, in = ParameterIn.PATH) @PathVariable("sTo") String sTo
    ) {
        return getDelegate().updateUser(userId, sWhat, sTo);
    }

}