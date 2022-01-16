package be.projetSGBD.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import be.projetSGBD.entity.CentreVaccinationEntity;
import be.projetSGBD.entity.PatientEntity;
import be.projetSGBD.entity.VaccinEntity;
import be.projetSGBD.model.CentreVaccination;
import be.projetSGBD.model.Patient;
import be.projetSGBD.model.Vaccin;

public interface CentreVaccinationService {

	public Optional<CentreVaccinationEntity> centreVaccinationById(long idCentreVaccination);
	
	public List<PatientEntity> patientByCentreVaccinationId(long idCentreVaccination);
	
	public List<VaccinEntity> vaccinByCentreVaccinationId(long idCentreVaccination);
	
	public CentreVaccination toModel(CentreVaccinationEntity centreVaccination);
	
	public CentreVaccinationEntity createCentre(String localite, String adresse, String heureOuverture);
	
	public CentreVaccinationEntity createCentre(CentreVaccinationEntity entity);
	
	public void deleteCentre(long idCentreVaccination);
	
	public List<Vaccin> toModelList(List<VaccinEntity> list);
	
	public List<Patient> toModelListPatient(List<PatientEntity> list);
	
	public CentreVaccinationEntity toEntity(CentreVaccination model);
}
