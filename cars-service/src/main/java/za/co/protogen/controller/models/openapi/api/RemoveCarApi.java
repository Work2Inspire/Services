/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.8.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package za.co.protogen.controller.models.openapi.api;

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

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-05T20:49:04.739846900+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
@Validated
@Tag(name = "cars", description = "the cars API")
public interface RemoveCarApi {

    default RemoveCarApiDelegate getDelegate() {
        return new RemoveCarApiDelegate() {};
    }

    /**
     * DELETE /remove_car : Find and Delete car using vin (Vehicle Identification Number)
     *
     * @param vin Vin (Vehicle Identification Number) to find car (required)
     * @return Successful responds with message and repository current size (status code 200)
     *         or Car not found (status code 404)
     */
    @Operation(
        operationId = "deleteCar",
        summary = "Find and Delete car using vin (Vehicle Identification Number)",
        tags = { "cars", "remove", "delete" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful responds with message and repository current size", content = {
                @Content(mediaType = "text/html", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "404", description = "Car not found", content = {
                @Content(mediaType = "text/html", schema = @Schema(implementation = String.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/remove_car",
        produces = { "text/html" }
    )
    
    default ResponseEntity<String> deleteCar(
        @NotNull @Parameter(name = "vin", description = "Vin (Vehicle Identification Number) to find car", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "vin", required = true) String vin
    ) {
        return getDelegate().deleteCar(vin);
    }

}