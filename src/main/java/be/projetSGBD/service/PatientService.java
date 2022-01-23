package be.projetSGBD.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import be.projetSGBD.entity.PatientEntity;
import be.projetSGBD.entity.PatientPlanningEntity;
import be.projetSGBD.model.Patient;
import be.projetSGBD.model.PatientPlanning;

public interface PatientService {

	public Optional<PatientEntity> patientById(long idPatient);
	
	public Patient toModel(PatientEntity patient);
	
	public PatientEntity createPatient(
			String numeroNational,
			String nomFamille,
			String prenom,
			Date dateNaissance,
			String pays,
			String ville,
			String adresse, 
			Long idCentre,
			Long idAssociation
			);
	
	public PatientEntity createPatient(PatientEntity pe);
	
	public void deletePatient(long idPatient);
	
	public PatientEntity toEntity(Patient model);
	
	public List<Patient> toModelListPatient(List<PatientEntity> list);
	
	public List<PatientPlanningEntity> PatientPlanningByPatientId(long idPatient);
	
	public List<PatientPlanning> toModelListPatientPlanningPatient(List<PatientPlanningEntity> list); 
}
