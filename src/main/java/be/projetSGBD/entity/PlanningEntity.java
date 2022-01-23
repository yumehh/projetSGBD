package be.projetSGBD.entity;

import java.util.Date;
import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name = "Planning")
@Data
public class PlanningEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long idPlanning;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	Date dateRdv;
	
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
			name="PatientPlanning",
			joinColumns= {@JoinColumn(name="idPlanning")},
			inverseJoinColumns = {@JoinColumn(name="idPatient")})
	List<PatientEntity> patient;
	
	
	@ManyToOne
	@JoinColumn(name="idCentreVaccination")
	CentreVaccinationEntity centreVaccination;
	
	@OneToMany(mappedBy = "planning")
	List<PatientPlanningEntity> patientPlanning;
}
