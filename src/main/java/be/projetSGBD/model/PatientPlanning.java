package be.projetSGBD.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import javax.xml.bind.annotation.*;
import org.springframework.hateoas.RepresentationModel;

/**
 * PatientPlanning
 */
@ApiModel(description = "PatientPlanning")
@JacksonXmlRootElement(localName = "PatientPlanning")
@XmlRootElement(name = "PatientPlanning")
@XmlAccessorType(XmlAccessType.FIELD)
public class PatientPlanning extends RepresentationModel<PatientPlanning>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("idPatientPlanning")
  @JacksonXmlProperty(localName = "idPatientPlanning")
  private Long idPatientPlanning;

  @JsonProperty("idPatient")
  @JacksonXmlProperty(localName = "idPatient")
  private Long idPatient;

  @JsonProperty("idPlanning")
  @JacksonXmlProperty(localName = "idPlanning")
  private Long idPlanning;

  public PatientPlanning idPatientPlanning(Long idPatientPlanning) {
    this.idPatientPlanning = idPatientPlanning;
    return this;
  }

  /**
   * id
   * @return idPatientPlanning
  */
  @ApiModelProperty(value = "id")


  public Long getIdPatientPlanning() {
    return idPatientPlanning;
  }

  public void setIdPatientPlanning(Long idPatientPlanning) {
    this.idPatientPlanning = idPatientPlanning;
  }

  public PatientPlanning idPatient(Long idPatient) {
    this.idPatient = idPatient;
    return this;
  }

  /**
   * idPatient
   * @return idPatient
  */
  @ApiModelProperty(value = "idPatient")


  public Long getIdPatient() {
    return idPatient;
  }

  public void setIdPatient(Long idPatient) {
    this.idPatient = idPatient;
  }

  public PatientPlanning idPlanning(Long idPlanning) {
    this.idPlanning = idPlanning;
    return this;
  }

  /**
   * idPlanning
   * @return idPlanning
  */
  @ApiModelProperty(value = "idPlanning")


  public Long getIdPlanning() {
    return idPlanning;
  }

  public void setIdPlanning(Long idPlanning) {
    this.idPlanning = idPlanning;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PatientPlanning patientPlanning = (PatientPlanning) o;
    return Objects.equals(this.idPatientPlanning, patientPlanning.idPatientPlanning) &&
        Objects.equals(this.idPatient, patientPlanning.idPatient) &&
        Objects.equals(this.idPlanning, patientPlanning.idPlanning);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPatientPlanning, idPatient, idPlanning);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatientPlanning {\n");
    
    sb.append("    idPatientPlanning: ").append(toIndentedString(idPatientPlanning)).append("\n");
    sb.append("    idPatient: ").append(toIndentedString(idPatient)).append("\n");
    sb.append("    idPlanning: ").append(toIndentedString(idPlanning)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

