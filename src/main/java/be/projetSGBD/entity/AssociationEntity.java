package be.projetSGBD.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Association")
@Data
public class AssociationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long idAssociation;
	
	@OneToMany(mappedBy = "association")
	private Set<PatientEntity> patient;
	
	@OneToMany(mappedBy = "association")
	private Set<CentreVaccinationEntity> centreVaccination;
}
