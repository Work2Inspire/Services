/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.8.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package za.co.protogen.controller.models.openapi.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-05T20:49:04.739846900+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
@Validated
@Tag(name = "car", description = "the car API")
public interface FindOldestApi {

    default FindOldestApiDelegate getDelegate() {
        return new FindOldestApiDelegate() {};
    }

    /**
     * GET /find_Oldest : Return oldest car
     *
     * @return Successful Responds. Return car with lowest year (status code 200)
     *         or Empty Repository (status code 404)
     */
    @Operation(
        operationId = "getOldest",
        summary = "Return oldest car",
        tags = { "car", "oldest", "get", "return" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful Responds. Return car with lowest year", content = {
                @Content(mediaType = "text/html", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "404", description = "Empty Repository", content = {
                @Content(mediaType = "text/html", schema = @Schema(implementation = String.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/find_Oldest",
        produces = { "text/html" }
    )
    
    default ResponseEntity<String> getOldest(
        
    ) {
        return getDelegate().getOldest();
    }

}
