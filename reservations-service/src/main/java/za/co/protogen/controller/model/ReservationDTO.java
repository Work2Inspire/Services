package za.co.protogen.controller.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import javax.annotation.Generated;

/**
 * Reservation
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-09T22:41:04.315909+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
public class ReservationDTO {

  private Long id;

  private Long userId;

  private Long carId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate fromDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate toDate;

  private String pickUpLocation;

  private String dropOffLocation;

  public ReservationDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ReservationDTO(Long id) {
    this.id = id;
  }

  public ReservationDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @NotNull 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ReservationDTO userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
   */
  
  @Schema(name = "userId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userId")
  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public ReservationDTO carId(Long carId) {
    this.carId = carId;
    return this;
  }

  /**
   * Get carId
   * @return carId
   */
  
  @Schema(name = "carId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("carId")
  public Long getCarId() {
    return carId;
  }

  public void setCarId(Long carId) {
    this.carId = carId;
  }

  public ReservationDTO fromDate(LocalDate fromDate) {
    this.fromDate = fromDate;
    return this;
  }

  /**
   * Get fromDate
   * @return fromDate
   */
  @Valid 
  @Schema(name = "fromDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fromDate")
  public LocalDate getFromDate() {
    return fromDate;
  }

  public void setFromDate(LocalDate fromDate) {
    this.fromDate = fromDate;
  }

  public ReservationDTO toDate(LocalDate toDate) {
    this.toDate = toDate;
    return this;
  }

  /**
   * Get toDate
   * @return toDate
   */
  @Valid 
  @Schema(name = "toDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("toDate")
  public LocalDate getToDate() {
    return toDate;
  }

  public void setToDate(LocalDate toDate) {
    this.toDate = toDate;
  }

  public ReservationDTO pickUpLocation(String pickUpLocation) {
    this.pickUpLocation = pickUpLocation;
    return this;
  }

  /**
   * Get pickUpLocation
   * @return pickUpLocation
   */
  
  @Schema(name = "pickUpLocation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pickUpLocation")
  public String getPickUpLocation() {
    return pickUpLocation;
  }

  public void setPickUpLocation(String pickUpLocation) {
    this.pickUpLocation = pickUpLocation;
  }

  public ReservationDTO dropOffLocation(String dropOffLocation) {
    this.dropOffLocation = dropOffLocation;
    return this;
  }

  /**
   * Get dropOffLocation
   * @return dropOffLocation
   */
  
  @Schema(name = "dropOffLocation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dropOffLocation")
  public String getDropOffLocation() {
    return dropOffLocation;
  }

  public void setDropOffLocation(String dropOffLocation) {
    this.dropOffLocation = dropOffLocation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservationDTO reservation = (ReservationDTO) o;
    return Objects.equals(this.id, reservation.id) &&
        Objects.equals(this.userId, reservation.userId) &&
        Objects.equals(this.carId, reservation.carId) &&
        Objects.equals(this.fromDate, reservation.fromDate) &&
        Objects.equals(this.toDate, reservation.toDate) &&
        Objects.equals(this.pickUpLocation, reservation.pickUpLocation) &&
        Objects.equals(this.dropOffLocation, reservation.dropOffLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, carId, fromDate, toDate, pickUpLocation, dropOffLocation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Reservation {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    carId: ").append(toIndentedString(carId)).append("\n");
    sb.append("    fromDate: ").append(toIndentedString(fromDate)).append("\n");
    sb.append("    toDate: ").append(toIndentedString(toDate)).append("\n");
    sb.append("    pickUpLocation: ").append(toIndentedString(pickUpLocation)).append("\n");
    sb.append("    dropOffLocation: ").append(toIndentedString(dropOffLocation)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

