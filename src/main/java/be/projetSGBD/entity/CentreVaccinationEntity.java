package be.projetSGBD.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="CentreVaccination")
@Data
public class CentreVaccinationEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long idCentreVaccination;
	String localite;
	String adresse;
	String heureOuverture;
	

	@OneToMany(mappedBy = "centreVaccination")
	List<PatientEntity> patient;
	
	@OneToMany(mappedBy = "centreVaccination")
	List<VaccinEntity> vaccin;
	
	@OneToMany(mappedBy = "centreVaccination")
	List<PlanningEntity> planning;
	
	@ManyToOne
	@JoinColumn(name="idAssociation", nullable = false) 
	AssociationEntity association;
	
}
