package be.projetSGBD.model;

import java.util.Objects;
import be.projetSGBD.model.Planning;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * A patient Class
 */
@ApiModel(description = "A patient Class")
@JacksonXmlRootElement(localName = "Patient")
@XmlRootElement(name = "Patient")
@XmlAccessorType(XmlAccessType.FIELD)
public class Patient extends RepresentationModel<Patient>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("idPatient")
  @JacksonXmlProperty(localName = "idPatient")
  private Long idPatient;

  @JsonProperty("numeroNational")
  @JacksonXmlProperty(localName = "numeroNational")
  private String numeroNational;

  @JsonProperty("nomFamille")
  @JacksonXmlProperty(localName = "nomFamille")
  private String nomFamille;

  @JsonProperty("Prenom")
  @JacksonXmlProperty(localName = "Prenom")
  private String prenom;

  @JsonProperty("dateNaissance")
  @JacksonXmlProperty(localName = "dateNaissance")
  private Date dateNaissance;

  @JsonProperty("Pays")
  @JacksonXmlProperty(localName = "Pays")
  private String pays;

  @JsonProperty("Ville")
  @JacksonXmlProperty(localName = "Ville")
  private String ville;

  @JsonProperty("Adresse")
  @JacksonXmlProperty(localName = "Adresse")
  private String adresse;

  @JsonProperty("Planning")
  @JacksonXmlProperty(localName = "Planning")
  @Valid
  private List<Planning> planning = null;

  @JsonProperty("idCentreVaccination")
  @JacksonXmlProperty(localName = "idCentreVaccination")
  private Long idCentreVaccination;

  public Patient idPatient(Long idPatient) {
    this.idPatient = idPatient;
    return this;
  }

  /**
   * id
   * @return idPatient
  */
  @ApiModelProperty(value = "id")


  public Long getIdPatient() {
    return idPatient;
  }

  public void setIdPatient(Long idPatient) {
    this.idPatient = idPatient;
  }

  public Patient numeroNational(String numeroNational) {
    this.numeroNational = numeroNational;
    return this;
  }

  /**
   * numero national.
   * @return numeroNational
  */
  @ApiModelProperty(value = "numero national.")


  public String getNumeroNational() {
    return numeroNational;
  }

  public void setNumeroNational(String numeroNational) {
    this.numeroNational = numeroNational;
  }

  public Patient nomFamille(String nomFamille) {
    this.nomFamille = nomFamille;
    return this;
  }

  /**
   * nom de famille.
   * @return nomFamille
  */
  @ApiModelProperty(value = "nom de famille.")


  public String getNomFamille() {
    return nomFamille;
  }

  public void setNomFamille(String nomFamille) {
    this.nomFamille = nomFamille;
  }

  public Patient prenom(String prenom) {
    this.prenom = prenom;
    return this;
  }

  /**
   * prenom.
   * @return prenom
  */
  @ApiModelProperty(value = "prenom.")


  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public Patient dateNaissance(Date dateNaissance) {
    this.dateNaissance = dateNaissance;
    return this;
  }

  /**
   * date de naissance.
   * @return dateNaissance
  */
  @ApiModelProperty(value = "date de naissance.")


  public Date getDateNaissance() {
    return dateNaissance;
  }

  public void setDateNaissance(Date dateNaissance) {
    this.dateNaissance = dateNaissance;
  }

  public Patient pays(String pays) {
    this.pays = pays;
    return this;
  }

  /**
   * pays
   * @return pays
  */
  @ApiModelProperty(value = "pays")


  public String getPays() {
    return pays;
  }

  public void setPays(String pays) {
    this.pays = pays;
  }

  public Patient ville(String ville) {
    this.ville = ville;
    return this;
  }

  /**
   * ville
   * @return ville
  */
  @ApiModelProperty(value = "ville")


  public String getVille() {
    return ville;
  }

  public void setVille(String ville) {
    this.ville = ville;
  }

  public Patient adresse(String adresse) {
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

  public Patient planning(List<Planning> planning) {
    this.planning = planning;
    return this;
  }

  public Patient addPlanningItem(Planning planningItem) {
    if (this.planning == null) {
      this.planning = new ArrayList<>();
    }
    this.planning.add(planningItem);
    return this;
  }

  /**
   * Collection of planning
   * @return planning
  */
  @ApiModelProperty(value = "Collection of planning")

  @Valid

  public List<Planning> getPlanning() {
    return planning;
  }

  public void setPlanning(List<Planning> planning) {
    this.planning = planning;
  }

  public Patient idCentreVaccination(Long idCentreVaccination) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Patient patient = (Patient) o;
    return Objects.equals(this.idPatient, patient.idPatient) &&
        Objects.equals(this.numeroNational, patient.numeroNational) &&
        Objects.equals(this.nomFamille, patient.nomFamille) &&
        Objects.equals(this.prenom, patient.prenom) &&
        Objects.equals(this.dateNaissance, patient.dateNaissance) &&
        Objects.equals(this.pays, patient.pays) &&
        Objects.equals(this.ville, patient.ville) &&
        Objects.equals(this.adresse, patient.adresse) &&
        Objects.equals(this.planning, patient.planning) &&
        Objects.equals(this.idCentreVaccination, patient.idCentreVaccination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPatient, numeroNational, nomFamille, prenom, dateNaissance, pays, ville, adresse, planning, idCentreVaccination);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Patient {\n");
    
    sb.append("    idPatient: ").append(toIndentedString(idPatient)).append("\n");
    sb.append("    numeroNational: ").append(toIndentedString(numeroNational)).append("\n");
    sb.append("    nomFamille: ").append(toIndentedString(nomFamille)).append("\n");
    sb.append("    prenom: ").append(toIndentedString(prenom)).append("\n");
    sb.append("    dateNaissance: ").append(toIndentedString(dateNaissance)).append("\n");
    sb.append("    pays: ").append(toIndentedString(pays)).append("\n");
    sb.append("    ville: ").append(toIndentedString(ville)).append("\n");
    sb.append("    adresse: ").append(toIndentedString(adresse)).append("\n");
    sb.append("    planning: ").append(toIndentedString(planning)).append("\n");
    sb.append("    idCentreVaccination: ").append(toIndentedString(idCentreVaccination)).append("\n");
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

