package be.projetSGBD.entity;

import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Patient")
@Data
public class PatientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPatient;
	String numeroNational;
	String nomFamille;
	String prenom;
	Date dateNaissance;
	String pays;
	String ville;
	String adresse;
	
	@ManyToOne
	@JoinColumn(name="idCentreVaccination")
	private CentreVaccinationEntity centreVaccination;
	
	@ManyToOne
	@JoinColumn(name="idAssociation")
	private AssociationEntity association;
	
	@ManyToMany(mappedBy = "patient")
	List<PlanningEntity> planning;
}




