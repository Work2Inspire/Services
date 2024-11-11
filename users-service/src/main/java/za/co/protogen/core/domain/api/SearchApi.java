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
import za.co.protogen.core.domain.models.delegate.SearchApiDelegate;

import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-10T10:21:23.805578500+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
@Validated
@Tag(name = "user", description = "the user API")
public interface SearchApi {

    default SearchApiDelegate getDelegate() {
        return new SearchApiDelegate() {};
    }

    /**
     * GET /search/{criteria} : Search users that meet criteria
     *
     * @param criteria search criteria to find user (required)
     * @return Successful Responds. Return List of users meeting criteria in any field (status code 200)
     *         or Empty Repository (status code 404)
     */
    @Operation(
        operationId = "searchUser",
        summary = "Search users that meet criteria",
        tags = { "user", "search", "criteria", "get", "return" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful Responds. Return List of users meeting criteria in any field", content = {
                @Content(mediaType = "text/html", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "404", description = "Empty Repository", content = {
                @Content(mediaType = "text/html", schema = @Schema(implementation = String.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/search/{criteria}",
        produces = { "text/html" }
    )
    
    default ResponseEntity<String> searchUser(
        @Parameter(name = "criteria", description = "search criteria to find user", required = true, in = ParameterIn.PATH) @PathVariable("criteria") String criteria
    ) {
        return getDelegate().searchUser(criteria);
    }

}