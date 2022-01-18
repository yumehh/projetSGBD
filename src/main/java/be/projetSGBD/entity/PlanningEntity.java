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
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Planning")
@Data
public class PlanningEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long idPlanning;
	Date dateRdv;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
			name="PatientPlanning",
			joinColumns= {@JoinColumn(name="idPlanning")},
			inverseJoinColumns = {@JoinColumn(name="patient_id")})
	List<PatientEntity> patient;
	
}
