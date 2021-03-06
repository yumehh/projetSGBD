package be.projetSGBD.entity;

import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	String prenom;
	Date dateNaissance;
	String pays;
	String ville;
	String adresse;
	
	@ManyToOne
	@JoinColumn(name="idCentreVaccination")
	CentreVaccinationEntity centreVaccination;
	
	@ManyToOne
	@JoinColumn(name="idAssociation")
	AssociationEntity association;
	
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
			name="PatientPlanning",
			joinColumns= {@JoinColumn(name="idPlanning")},
			inverseJoinColumns = {@JoinColumn(name="idPatient")})
	List<PlanningEntity> planning;
	
	
	@OneToMany(mappedBy = "patient")
	List<PatientPlanningEntity> patientPlanning;
	
}




