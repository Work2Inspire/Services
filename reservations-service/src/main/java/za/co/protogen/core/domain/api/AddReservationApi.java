/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.8.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package za.co.protogen.core.domain.api;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.co.protogen.core.domain.models.delegate.AddReservationApiDelegate;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-09T22:41:04.315909+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
@Validated
@Tag(name = "Reservation", description = "the Reservation API")
public interface AddReservationApi {

    default AddReservationApiDelegate getDelegate() {
        return new AddReservationApiDelegate() {};
    }

    /**
     * POST /addReservation : Create new reservation
     *
     * @param id The unique identifier for the reservation (required)
     * @param userId The unique identifier for the user associated with the reservation (required)
     * @param carId The unique identifier for the car reserved (required)
     * @param fromDate The starting date of the reservation (required)
     * @param toDate The ending date of the reservation (required)
     * @param pLocation The location where the car will be picked up (required)
     * @param dLocation The location where the car will be dropped off. (required)
     * @return Successful. responds with message and all reservations (status code 200)
     */
    @Operation(
        operationId = "createRes",
        summary = "Create new reservation",
        tags = { "Reservation", "new", "add" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful. responds with message and all reservations", content = {
                @Content(mediaType = "text/html", schema = @Schema(implementation = String.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/addReservation",
        produces = { "text/html" }
    )
    
    default ResponseEntity<String> createRes(
        @NotNull @Parameter(name = "id", description = "The unique identifier for the reservation", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "id", required = true) Long id,
        @NotNull @Parameter(name = "userId", description = "The unique identifier for the user associated with the reservation", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "userId", required = true) Long userId,
        @NotNull @Parameter(name = "carId", description = "The unique identifier for the car reserved", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "carId", required = true) Long carId,
        @NotNull @Parameter(name = "fromDate", description = "The starting date of the reservation", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "fromDate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
        @NotNull @Parameter(name = "toDate", description = "The ending date of the reservation", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "toDate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate,
        @NotNull @Parameter(name = "pLocation", description = "The location where the car will be picked up", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "pLocation", required = true) String pLocation,
        @NotNull @Parameter(name = "dLocation", description = "The location where the car will be dropped off.", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "dLocation", required = true) String dLocation
    ) {
        return getDelegate().createRes(id, userId, carId, fromDate, toDate, pLocation, dLocation);
    }

}