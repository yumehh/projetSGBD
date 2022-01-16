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
  private String Prenom;

  @JsonProperty("dateNaissance")
  @JacksonXmlProperty(localName = "dateNaissance")
  private Date dateNaissance;

  @JsonProperty("Pays")
  @JacksonXmlProperty(localName = "Pays")
  private String Pays;

  @JsonProperty("Ville")
  @JacksonXmlProperty(localName = "Ville")
  private String Ville;

  @JsonProperty("Adresse")
  @JacksonXmlProperty(localName = "Adresse")
  private String Adresse;

  @JsonProperty("planning")
  @JacksonXmlProperty(localName = "planning")
  @Valid
  private List<Planning> planning = null;

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

  public Patient Prenom(String Prenom) {
    this.Prenom = Prenom;
    return this;
  }

  /**
   * Prenom.
   * @return Prenom
  */
  @ApiModelProperty(value = "Prenom.")


  public String getPrenom() {
    return Prenom;
  }

  public void setPrenom(String Prenom) {
    this.Prenom = Prenom;
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

  public Patient Pays(String Pays) {
    this.Pays = Pays;
    return this;
  }

  /**
   * Pays
   * @return Pays
  */
  @ApiModelProperty(value = "Pays")


  public String getPays() {
    return Pays;
  }

  public void setPays(String Pays) {
    this.Pays = Pays;
  }

  public Patient Ville(String Ville) {
    this.Ville = Ville;
    return this;
  }

  /**
   * Ville
   * @return Ville
  */
  @ApiModelProperty(value = "Ville")


  public String getVille() {
    return Ville;
  }

  public void setVille(String Ville) {
    this.Ville = Ville;
  }

  public Patient Adresse(String Adresse) {
    this.Adresse = Adresse;
    return this;
  }

  /**
   * Adresse
   * @return Adresse
  */
  @ApiModelProperty(value = "Adresse")


  public String getAdresse() {
    return Adresse;
  }

  public void setAdresse(String Adresse) {
    this.Adresse = Adresse;
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
        Objects.equals(this.Prenom, patient.Prenom) &&
        Objects.equals(this.dateNaissance, patient.dateNaissance) &&
        Objects.equals(this.Pays, patient.Pays) &&
        Objects.equals(this.Ville, patient.Ville) &&
        Objects.equals(this.Adresse, patient.Adresse) &&
        Objects.equals(this.planning, patient.planning);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPatient, numeroNational, nomFamille, Prenom, dateNaissance, Pays, Ville, Adresse, planning);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Patient {\n");
    
    sb.append("    idPatient: ").append(toIndentedString(idPatient)).append("\n");
    sb.append("    numeroNational: ").append(toIndentedString(numeroNational)).append("\n");
    sb.append("    nomFamille: ").append(toIndentedString(nomFamille)).append("\n");
    sb.append("    Prenom: ").append(toIndentedString(Prenom)).append("\n");
    sb.append("    dateNaissance: ").append(toIndentedString(dateNaissance)).append("\n");
    sb.append("    Pays: ").append(toIndentedString(Pays)).append("\n");
    sb.append("    Ville: ").append(toIndentedString(Ville)).append("\n");
    sb.append("    Adresse: ").append(toIndentedString(Adresse)).append("\n");
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

