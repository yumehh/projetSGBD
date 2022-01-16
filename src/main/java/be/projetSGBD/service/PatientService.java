package be.projetSGBD.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import be.projetSGBD.entity.PatientEntity;
import be.projetSGBD.entity.PlanningEntity;
import be.projetSGBD.model.Patient;
import be.projetSGBD.model.Planning;

public interface PatientService {

	public Optional<PatientEntity> patientByIdPatient(long idPatient);
	
	Patient toModel(PatientEntity pe);
	
	public PatientEntity createPatient(String numeroNational, String nomFamille, String prenom, Date DateNaissance, String Pays, String Ville, String Adresse);
	
	public void deletePatient(long idPatient);

	public PatientEntity toEntity(Patient model);
	
	public PatientEntity createPatient(PatientEntity entity);
	
	public Set<Planning> toModelList(List<PlanningEntity> list);
	
	public void dropEmail(String email);
	
	
}
