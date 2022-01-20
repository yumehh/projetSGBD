package be.projetSGBD.service;

import java.util.Date;
import java.util.Optional;

import be.projetSGBD.entity.PatientEntity;
import be.projetSGBD.model.Patient;

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
}
