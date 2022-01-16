package be.projetSGBD.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
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
	long idPatient;
	String numeroNational;
	String nomFamille;
	String Prenom;
	Date dateNaissance;
	String Pays;
	String Ville;
	String Adresse;
	
	@ManyToOne
	@JoinColumn(name="idCentreVaccination")
	private CentreVaccinationEntity centreVaccination;
	
	@ManyToOne
	@JoinColumn(name="idAssociation")
	private AssociationEntity association;
	
	@ManyToMany(mappedBy = "patient")
	Set<PlanningEntity> planning;
}
