package be.projetSGBD.model;

import java.util.Objects;
import be.projetSGBD.model.Patient;
import be.projetSGBD.model.Planning;
import be.projetSGBD.model.Vaccin;
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
 * a CentreVaccination Class
 */
@ApiModel(description = "a CentreVaccination Class")
@JacksonXmlRootElement(localName = "CentreVaccination")
@XmlRootElement(name = "CentreVaccination")
@XmlAccessorType(XmlAccessType.FIELD)
public class CentreVaccination extends RepresentationModel<CentreVaccination>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("idCentreVaccination")
  @JacksonXmlProperty(localName = "idCentreVaccination")
  private Long idCentreVaccination;

  @JsonProperty("localite")
  @JacksonXmlProperty(localName = "localite")
  private String localite;

  @JsonProperty("adresse")
  @JacksonXmlProperty(localName = "adresse")
  private String adresse;

  @JsonProperty("heureOuverture")
  @JacksonXmlProperty(localName = "heureOuverture")
  private String heureOuverture;

  @JsonProperty("patient")
  @JacksonXmlProperty(localName = "patient")
  @Valid
  private List<Patient> patient = null;

  @JsonProperty("vaccin")
  @JacksonXmlProperty(localName = "vaccin")
  @Valid
  private List<Vaccin> vaccin = null;

  @JsonProperty("planning")
  @JacksonXmlProperty(localName = "planning")
  @Valid
  private List<Planning> planning = null;

  public CentreVaccination idCentreVaccination(Long idCentreVaccination) {
    this.idCentreVaccination = idCentreVaccination;
    return this;
  }

  /**
   * id
   * @return idCentreVaccination
  */
  @ApiModelProperty(value = "id")


  public Long getIdCentreVaccination() {
    return idCentreVaccination;
  }

  public void setIdCentreVaccination(Long idCentreVaccination) {
    this.idCentreVaccination = idCentreVaccination;
  }

  public CentreVaccination localite(String localite) {
    this.localite = localite;
    return this;
  }

  /**
   * localite
   * @return localite
  */
  @ApiModelProperty(value = "localite")


  public String getLocalite() {
    return localite;
  }

  public void setLocalite(String localite) {
    this.localite = localite;
  }

  public CentreVaccination adresse(String adresse) {
    this.adresse = adresse;
    return this;
  }

  /**
   * adresse
   * @return adresse
  */
  @ApiModelProperty(value = "adresse")


  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public CentreVaccination heureOuverture(String heureOuverture) {
    this.heureOuverture = heureOuverture;
    return this;
  }

  /**
   * heure d'ouverture
   * @return heureOuverture
  */
  @ApiModelProperty(value = "heure d'ouverture")


  public String getHeureOuverture() {
    return heureOuverture;
  }

  public void setHeureOuverture(String heureOuverture) {
    this.heureOuverture = heureOuverture;
  }

  public CentreVaccination patient(List<Patient> patient) {
    this.patient = patient;
    return this;
  }

  public CentreVaccination addPatientItem(Patient patientItem) {
    if (this.patient == null) {
      this.patient = new ArrayList<>();
    }
    this.patient.add(patientItem);
    return this;
  }

  /**
   * Collection of patient
   * @return patient
  */
  @ApiModelProperty(value = "Collection of patient")

  @Valid

  public List<Patient> getPatient() {
    return patient;
  }

  public void setPatient(List<Patient> patient) {
    this.patient = patient;
  }

  public CentreVaccination vaccin(List<Vaccin> vaccin) {
    this.vaccin = vaccin;
    return this;
  }

  public CentreVaccination addVaccinItem(Vaccin vaccinItem) {
    if (this.vaccin == null) {
      this.vaccin = new ArrayList<>();
    }
    this.vaccin.add(vaccinItem);
    return this;
  }

  /**
   * Collection of vaccin
   * @return vaccin
  */
  @ApiModelProperty(value = "Collection of vaccin")

  @Valid

  public List<Vaccin> getVaccin() {
    return vaccin;
  }

  public void setVaccin(List<Vaccin> vaccin) {
    this.vaccin = vaccin;
  }

  public CentreVaccination planning(List<Planning> planning) {
    this.planning = planning;
    return this;
  }

  public CentreVaccination addPlanningItem(Planning planningItem) {
    if (this.planning == null) {
      this.planning = new ArrayList<>();
    }
    this.planning.add(planningItem);
    return this;
  }

  /**
   * Collection of vaccin
   * @return planning
  */
  @ApiModelProperty(value = "Collection of vaccin")

  @Valid

  public List<Planning> getPlanning() {
    return planning;
  }

  public void setPlanning(List<Planning> planning) {
    this.planning = planning;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CentreVaccination centreVaccination = (CentreVaccination) o;
    return Objects.equals(this.idCentreVaccination, centreVaccination.idCentreVaccination) &&
        Objects.equals(this.localite, centreVaccination.localite) &&
        Objects.equals(this.adresse, centreVaccination.adresse) &&
        Objects.equals(this.heureOuverture, centreVaccination.heureOuverture) &&
        Objects.equals(this.patient, centreVaccination.patient) &&
        Objects.equals(this.vaccin, centreVaccination.vaccin) &&
        Objects.equals(this.planning, centreVaccination.planning);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idCentreVaccination, localite, adresse, heureOuverture, patient, vaccin, planning);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CentreVaccination {\n");
    
    sb.append("    idCentreVaccination: ").append(toIndentedString(idCentreVaccination)).append("\n");
    sb.append("    localite: ").append(toIndentedString(localite)).append("\n");
    sb.append("    adresse: ").append(toIndentedString(adresse)).append("\n");
    sb.append("    heureOuverture: ").append(toIndentedString(heureOuverture)).append("\n");
    sb.append("    patient: ").append(toIndentedString(patient)).append("\n");
    sb.append("    vaccin: ").append(toIndentedString(vaccin)).append("\n");
    sb.append("    planning: ").append(toIndentedString(planning)).append("\n");
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

