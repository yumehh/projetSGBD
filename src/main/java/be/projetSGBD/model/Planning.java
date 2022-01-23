package be.projetSGBD.model;

import java.util.Objects;
import be.projetSGBD.model.Patient;
import be.projetSGBD.model.PatientPlanning;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Date;
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
 * a Planning class
 */
@ApiModel(description = "a Planning class")
@JacksonXmlRootElement(localName = "Planning")
@XmlRootElement(name = "Planning")
@XmlAccessorType(XmlAccessType.FIELD)
public class Planning extends RepresentationModel<Planning>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("idPlanning")
  @JacksonXmlProperty(localName = "idPlanning")
  private Long idPlanning;

  @JsonProperty("dateRdv")
  @JacksonXmlProperty(localName = "dateRdv")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private Date dateRdv;

  @JsonProperty("idCentreVaccination")
  @JacksonXmlProperty(localName = "idCentreVaccination")
  private Long idCentreVaccination;

  @JsonProperty("patient")
  @JacksonXmlProperty(localName = "patient")
  @Valid
  private List<Patient> patient = null;

  @JsonProperty("PatientPlanning")
  @JacksonXmlProperty(localName = "PatientPlanning")
  @Valid
  private List<PatientPlanning> patientPlanning = null;

  public Planning idPlanning(Long idPlanning) {
    this.idPlanning = idPlanning;
    return this;
  }

  /**
   * id
   * @return idPlanning
  */
  @ApiModelProperty(value = "id")


  public Long getIdPlanning() {
    return idPlanning;
  }

  public void setIdPlanning(Long idPlanning) {
    this.idPlanning = idPlanning;
  }

  public Planning dateRdv(Date dateRdv) {
    this.dateRdv = dateRdv;
    return this;
  }

  /**
   * date de rdv
   * @return dateRdv
  */
  @ApiModelProperty(value = "date de rdv")


  public Date getDateRdv() {
    return dateRdv;
  }

  public void setDateRdv(Date dateRdv) {
    this.dateRdv = dateRdv;
  }

  public Planning idCentreVaccination(Long idCentreVaccination) {
    this.idCentreVaccination = idCentreVaccination;
    return this;
  }

  /**
   * fk
   * @return idCentreVaccination
  */
  @ApiModelProperty(value = "fk")


  public Long getIdCentreVaccination() {
    return idCentreVaccination;
  }

  public void setIdCentreVaccination(Long idCentreVaccination) {
    this.idCentreVaccination = idCentreVaccination;
  }

  public Planning patient(List<Patient> patient) {
    this.patient = patient;
    return this;
  }

  public Planning addPatientItem(Patient patientItem) {
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

  public Planning patientPlanning(List<PatientPlanning> patientPlanning) {
    this.patientPlanning = patientPlanning;
    return this;
  }

  public Planning addPatientPlanningItem(PatientPlanning patientPlanningItem) {
    if (this.patientPlanning == null) {
      this.patientPlanning = new ArrayList<>();
    }
    this.patientPlanning.add(patientPlanningItem);
    return this;
  }

  /**
   * Collection of PatientPlanning
   * @return patientPlanning
  */
  @ApiModelProperty(value = "Collection of PatientPlanning")

  @Valid

  public List<PatientPlanning> getPatientPlanning() {
    return patientPlanning;
  }

  public void setPatientPlanning(List<PatientPlanning> patientPlanning) {
    this.patientPlanning = patientPlanning;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Planning planning = (Planning) o;
    return Objects.equals(this.idPlanning, planning.idPlanning) &&
        Objects.equals(this.dateRdv, planning.dateRdv) &&
        Objects.equals(this.idCentreVaccination, planning.idCentreVaccination) &&
        Objects.equals(this.patient, planning.patient) &&
        Objects.equals(this.patientPlanning, planning.patientPlanning);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPlanning, dateRdv, idCentreVaccination, patient, patientPlanning);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Planning {\n");
    
    sb.append("    idPlanning: ").append(toIndentedString(idPlanning)).append("\n");
    sb.append("    dateRdv: ").append(toIndentedString(dateRdv)).append("\n");
    sb.append("    idCentreVaccination: ").append(toIndentedString(idCentreVaccination)).append("\n");
    sb.append("    patient: ").append(toIndentedString(patient)).append("\n");
    sb.append("    patientPlanning: ").append(toIndentedString(patientPlanning)).append("\n");
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

