package be.projetSGBD.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "VACCIN")
@Data
public class VaccinEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idVaccin")
	long idVaccin;
	String nomVaccin;
	int nbsJoursEntreDoses;
	int numeroLot;
	

	@ManyToOne
	@JoinColumn(name = "idCentreVaccination", nullable = false)
	CentreVaccinationEntity centreVaccination;

	
}
