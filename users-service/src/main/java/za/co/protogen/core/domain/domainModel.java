package za.co.protogen.core.domain;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import javax.annotation.Generated;

/**
 * DUser
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-10T11:09:40.117860800+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
public class domainModel {

  private Long userId;

  private String firstName;

  private String lastName;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dateOfBirth;

  private String rsaId;

  public domainModel() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public domainModel(Long userId, String firstName, String lastName, LocalDate dateOfBirth, String rsaId) {
    this.userId = userId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.rsaId = rsaId;
  }

  public domainModel userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
   */
  @NotNull 
  @Schema(name = "userId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("userId")
  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public domainModel firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
   */
  @NotNull 
  @Schema(name = "firstName", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public domainModel lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
   */
  @NotNull 
  @Schema(name = "lastName", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public domainModel dateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * Get dateOfBirth
   * @return dateOfBirth
   */
  @NotNull @Valid 
  @Schema(name = "DateOfBirth", example = "Fri Aug 11 02:00:00 SAST 2023", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("DateOfBirth")
  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public domainModel rsaId(String rsaId) {
    this.rsaId = rsaId;
    return this;
  }

  /**
   * Get rsaId
   * @return rsaId
   */
  @NotNull 
  @Schema(name = "rsaId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("rsaId")
  public String getRsaId() {
    return rsaId;
  }

  public void setRsaId(String rsaId) {
    this.rsaId = rsaId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    domainModel duser = (domainModel) o;
    return Objects.equals(this.userId, duser.userId) &&
        Objects.equals(this.firstName, duser.firstName) &&
        Objects.equals(this.lastName, duser.lastName) &&
        Objects.equals(this.dateOfBirth, duser.dateOfBirth) &&
        Objects.equals(this.rsaId, duser.rsaId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, firstName, lastName, dateOfBirth, rsaId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DUser {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    rsaId: ").append(toIndentedString(rsaId)).append("\n");
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

