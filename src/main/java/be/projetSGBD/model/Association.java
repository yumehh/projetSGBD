package be.projetSGBD.model;

import java.util.Objects;
import be.projetSGBD.model.CentreVaccination;
import be.projetSGBD.model.Patient;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import javax.xml.bind.annotation.*;
import org.springframework.hateoas.RepresentationModel;

/**
 * a Association class
 */
@ApiModel(description = "a Association class")
@JacksonXmlRootElement(localName = "Association")
@XmlRootElement(name = "Association")
@XmlAccessorType(XmlAccessType.FIELD)
public class Association extends RepresentationModel<Association>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("idAssociation")
  @JacksonXmlProperty(localName = "idAssociation")
  private Long idAssociation;

  @JsonProperty("zone")
  @JacksonXmlProperty(localName = "zone")
  private String zone;

  @JsonProperty("patient")
  @JacksonXmlProperty(localName = "patient")
  @Valid
  private List<Patient> patient = null;

  @JsonProperty("centreVaccination")
  @JacksonXmlProperty(localName = "centreVaccination")
  @Valid
  private List<CentreVaccination> centreVaccination = null;

  public Association idAssociation(Long idAssociation) {
    this.idAssociation = idAssociation;
    return this;
  }

  /**
   * id
   * @return idAssociation
  */
  @ApiModelProperty(value = "id")


  public Long getIdAssociation() {
    return idAssociation;
  }

  public void setIdAssociation(Long idAssociation) {
    this.idAssociation = idAssociation;
  }

  public Association zone(String zone) {
    this.zone = zone;
    return this;
  }

  /**
   * zone de localite
   * @return zone
  */
  @ApiModelProperty(value = "zone de localite")


  public String getZone() {
    return zone;
  }

  public void setZone(String zone) {
    this.zone = zone;
  }

  public Association patient(List<Patient> patient) {
    this.patient = patient;
    return this;
  }

  public Association addPatientItem(Patient patientItem) {
    if (this.patient == null) {
      this.patient = new ArrayList<>();
    }
    this.patient.add(patientItem);
    return this;
  }

  /**
   * a collection of patient
   * @return patient
  */
  @ApiModelProperty(value = "a collection of patient")

  @Valid

  public List<Patient> getPatient() {
    return patient;
  }

  public void setPatient(List<Patient> patient) {
    this.patient = patient;
  }

  public Association centreVaccination(List<CentreVaccination> centreVaccination) {
    this.centreVaccination = centreVaccination;
    return this;
  }

  public Association addCentreVaccinationItem(CentreVaccination centreVaccinationItem) {
    if (this.centreVaccination == null) {
      this.centreVaccination = new ArrayList<>();
    }
    this.centreVaccination.add(centreVaccinationItem);
    return this;
  }

  /**
   * a collection of CentreVaccination
   * @return centreVaccination
  */
  @ApiModelProperty(value = "a collection of CentreVaccination")

  @Valid

  public List<CentreVaccination> getCentreVaccination() {
    return centreVaccination;
  }

  public void setCentreVaccination(List<CentreVaccination> centreVaccination) {
    this.centreVaccination = centreVaccination;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Association association = (Association) o;
    return Objects.equals(this.idAssociation, association.idAssociation) &&
        Objects.equals(this.zone, association.zone) &&
        Objects.equals(this.patient, association.patient) &&
        Objects.equals(this.centreVaccination, association.centreVaccination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idAssociation, zone, patient, centreVaccination);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Association {\n");
    
    sb.append("    idAssociation: ").append(toIndentedString(idAssociation)).append("\n");
    sb.append("    zone: ").append(toIndentedString(zone)).append("\n");
    sb.append("    patient: ").append(toIndentedString(patient)).append("\n");
    sb.append("    centreVaccination: ").append(toIndentedString(centreVaccination)).append("\n");
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

