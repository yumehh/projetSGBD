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
 * a Vaccin class
 */
@ApiModel(description = "a Vaccin class")
@JacksonXmlRootElement(localName = "Vaccin")
@XmlRootElement(name = "Vaccin")
@XmlAccessorType(XmlAccessType.FIELD)
public class Vaccin extends RepresentationModel<Vaccin>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("idVaccin")
  @JacksonXmlProperty(localName = "idVaccin")
  private Long idVaccin;

  @JsonProperty("nomVaccin")
  @JacksonXmlProperty(localName = "nomVaccin")
  private String nomVaccin;

  @JsonProperty("nbsJoursEntreDoses")
  @JacksonXmlProperty(localName = "nbsJoursEntreDoses")
  private Integer nbsJoursEntreDoses;

  @JsonProperty("numeroLot")
  @JacksonXmlProperty(localName = "numeroLot")
  private Integer numeroLot;

  public Vaccin idVaccin(Long idVaccin) {
    this.idVaccin = idVaccin;
    return this;
  }

  /**
   * id
   * @return idVaccin
  */
  @ApiModelProperty(value = "id")


  public Long getIdVaccin() {
    return idVaccin;
  }

  public void setIdVaccin(Long idVaccin) {
    this.idVaccin = idVaccin;
  }

  public Vaccin nomVaccin(String nomVaccin) {
    this.nomVaccin = nomVaccin;
    return this;
  }

  /**
   * nom du vaccin
   * @return nomVaccin
  */
  @ApiModelProperty(value = "nom du vaccin")


  public String getNomVaccin() {
    return nomVaccin;
  }

  public void setNomVaccin(String nomVaccin) {
    this.nomVaccin = nomVaccin;
  }

  public Vaccin nbsJoursEntreDoses(Integer nbsJoursEntreDoses) {
    this.nbsJoursEntreDoses = nbsJoursEntreDoses;
    return this;
  }

  /**
   * la duree entre doses
   * @return nbsJoursEntreDoses
  */
  @ApiModelProperty(value = "la duree entre doses")


  public Integer getNbsJoursEntreDoses() {
    return nbsJoursEntreDoses;
  }

  public void setNbsJoursEntreDoses(Integer nbsJoursEntreDoses) {
    this.nbsJoursEntreDoses = nbsJoursEntreDoses;
  }

  public Vaccin numeroLot(Integer numeroLot) {
    this.numeroLot = numeroLot;
    return this;
  }

  /**
   * le numero de lot
   * @return numeroLot
  */
  @ApiModelProperty(value = "le numero de lot")


  public Integer getNumeroLot() {
    return numeroLot;
  }

  public void setNumeroLot(Integer numeroLot) {
    this.numeroLot = numeroLot;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vaccin vaccin = (Vaccin) o;
    return Objects.equals(this.idVaccin, vaccin.idVaccin) &&
        Objects.equals(this.nomVaccin, vaccin.nomVaccin) &&
        Objects.equals(this.nbsJoursEntreDoses, vaccin.nbsJoursEntreDoses) &&
        Objects.equals(this.numeroLot, vaccin.numeroLot);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idVaccin, nomVaccin, nbsJoursEntreDoses, numeroLot);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Vaccin {\n");
    
    sb.append("    idVaccin: ").append(toIndentedString(idVaccin)).append("\n");
    sb.append("    nomVaccin: ").append(toIndentedString(nomVaccin)).append("\n");
    sb.append("    nbsJoursEntreDoses: ").append(toIndentedString(nbsJoursEntreDoses)).append("\n");
    sb.append("    numeroLot: ").append(toIndentedString(numeroLot)).append("\n");
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

