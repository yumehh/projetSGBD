package be.projetSGBD.service;

import java.util.Optional;

import be.projetSGBD.entity.PatientPlanningEntity;
import be.projetSGBD.model.PatientPlanning;

public interface PatientPlanningService {

	public Optional<PatientPlanningEntity> patientPlanningById(long idPatientPlanning);
	
	PatientPlanning toModel(PatientPlanningEntity entity);
	
	public PatientPlanningEntity createPatientPlanning(Long idPatient, Long idPlanning);
	
	public PatientPlanningEntity createPatientPlanning(PatientPlanningEntity entity);
	
	public void deletePatientPlanning(long idPatientPlanning);
	
	public PatientPlanningEntity toEntity(PatientPlanning model);
}
