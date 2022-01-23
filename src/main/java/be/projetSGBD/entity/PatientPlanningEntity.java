package be.projetSGBD.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="PatientPlanning")
@Data
public class PatientPlanningEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idPatientPlanning")
	long idPatientPlanning;
	
	@ManyToOne
	@JoinColumn(name="idPatientPlanning", updatable = false, insertable = false)
	PatientEntity patient;
	
	@ManyToOne
	@JoinColumn(name="idPatientPlanning", updatable = false, insertable = false)
	PlanningEntity planning;
}
