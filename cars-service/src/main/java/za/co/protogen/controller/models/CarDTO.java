package za.co.protogen.controller.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Car
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-07T18:42:17.741185300+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
public class CarDTO {

  private String vin;

  private String make;

  private String model;

  private Integer year;

  private String color;

  private String engine;

  /**
   * Gets or Sets transmission
   */
  public enum TransmissionEnum {
    AUTOMATIC("Automatic"),

    MANUAL("Manual"),

    CVT("CVT");

    private String value;

    TransmissionEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TransmissionEnum fromValue(String value) {
      for (TransmissionEnum b : TransmissionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private TransmissionEnum transmission;

  /**
   * Gets or Sets fuelType
   */
  public enum FuelTypeEnum {
    GASOLINE("Gasoline"),

    DIESEL("Diesel"),

    ELECTRIC("Electric");

    private String value;

    FuelTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static FuelTypeEnum fromValue(String value) {
      for (FuelTypeEnum b : FuelTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private FuelTypeEnum fuelType;

  private Integer mileage;

  private Integer price;

  private Integer ownerId;

  @Valid
  private List<String> features = new ArrayList<>();

  public CarDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CarDTO(String vin) {
    this.vin = vin;
  }

  public CarDTO vin(String vin) {
    this.vin = vin;
    return this;
  }

  /**
   * Get vin
   * @return vin
   */
  @NotNull 
  @Schema(name = "vin", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("vin")
  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }

  public CarDTO make(String make) {
    this.make = make;
    return this;
  }

  /**
   * Get make
   * @return make
   */
  
  @Schema(name = "make", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("make")
  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public CarDTO model(String model) {
    this.model = model;
    return this;
  }

  /**
   * Get model
   * @return model
   */
  
  @Schema(name = "model", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("model")
  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public CarDTO year(Integer year) {
    this.year = year;
    return this;
  }

  /**
   * Get year
   * @return year
   */
  
  @Schema(name = "year", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("year")
  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public CarDTO color(String color) {
    this.color = color;
    return this;
  }

  /**
   * Get color
   * @return color
   */
  
  @Schema(name = "color", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("color")
  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public CarDTO engine(String engine) {
    this.engine = engine;
    return this;
  }

  /**
   * Get engine
   * @return engine
   */
  
  @Schema(name = "engine", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("engine")
  public String getEngine() {
    return engine;
  }

  public void setEngine(String engine) {
    this.engine = engine;
  }

  public CarDTO transmission(TransmissionEnum transmission) {
    this.transmission = transmission;
    return this;
  }

  /**
   * Get transmission
   * @return transmission
   */
  
  @Schema(name = "transmission", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("transmission")
  public TransmissionEnum getTransmission() {
    return transmission;
  }

  public void setTransmission(TransmissionEnum transmission) {
    this.transmission = transmission;
  }

  public CarDTO fuelType(FuelTypeEnum fuelType) {
    this.fuelType = fuelType;
    return this;
  }

  /**
   * Get fuelType
   * @return fuelType
   */
  
  @Schema(name = "fuelType", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fuelType")
  public FuelTypeEnum getFuelType() {
    return fuelType;
  }

  public void setFuelType(FuelTypeEnum fuelType) {
    this.fuelType = fuelType;
  }

  public CarDTO mileage(Integer mileage) {
    this.mileage = mileage;
    return this;
  }

  /**
   * Get mileage
   * @return mileage
   */
  
  @Schema(name = "mileage", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("mileage")
  public Integer getMileage() {
    return mileage;
  }

  public void setMileage(Integer mileage) {
    this.mileage = mileage;
  }

  public CarDTO price(Integer price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
   */
  
  @Schema(name = "price", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("price")
  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public CarDTO ownerId(Integer ownerId) {
    this.ownerId = ownerId;
    return this;
  }

  /**
   * Get ownerId
   * @return ownerId
   */
  
  @Schema(name = "ownerId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ownerId")
  public Integer getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(Integer ownerId) {
    this.ownerId = ownerId;
  }

  public CarDTO features(List<String> features) {
    this.features = features;
    return this;
  }

  public CarDTO addFeaturesItem(String featuresItem) {
    if (this.features == null) {
      this.features = new ArrayList<>();
    }
    this.features.add(featuresItem);
    return this;
  }

  /**
   * Get features
   * @return features
   */
  
  @Schema(name = "features", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("features")
  public List<String> getFeatures() {
    return features;
  }

  public void setFeatures(List<String> features) {
    this.features = features;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarDTO car = (CarDTO) o;
    return Objects.equals(this.vin, car.vin) &&
        Objects.equals(this.make, car.make) &&
        Objects.equals(this.model, car.model) &&
        Objects.equals(this.year, car.year) &&
        Objects.equals(this.color, car.color) &&
        Objects.equals(this.engine, car.engine) &&
        Objects.equals(this.transmission, car.transmission) &&
        Objects.equals(this.fuelType, car.fuelType) &&
        Objects.equals(this.mileage, car.mileage) &&
        Objects.equals(this.price, car.price) &&
        Objects.equals(this.ownerId, car.ownerId) &&
        Objects.equals(this.features, car.features);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vin, make, model, year, color, engine, transmission, fuelType, mileage, price, ownerId, features);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Car {\n");
    sb.append("    vin: ").append(toIndentedString(vin)).append("\n");
    sb.append("    make: ").append(toIndentedString(make)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    engine: ").append(toIndentedString(engine)).append("\n");
    sb.append("    transmission: ").append(toIndentedString(transmission)).append("\n");
    sb.append("    fuelType: ").append(toIndentedString(fuelType)).append("\n");
    sb.append("    mileage: ").append(toIndentedString(mileage)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    features: ").append(toIndentedString(features)).append("\n");
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

