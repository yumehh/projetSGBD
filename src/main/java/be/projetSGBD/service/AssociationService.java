package be.projetSGBD.service;

import java.util.List;
import java.util.Optional;

import be.projetSGBD.entity.AssociationEntity;
import be.projetSGBD.entity.CentreVaccinationEntity;
import be.projetSGBD.entity.PatientEntity;
import be.projetSGBD.model.Association;
import be.projetSGBD.model.CentreVaccination;
import be.projetSGBD.model.Patient;

public interface AssociationService {

	public Optional<AssociationEntity> associationById(long idAssociation);
	
	public List<PatientEntity> patientByAssociationId(long idAssociation);
	
	public List<CentreVaccinationEntity> centreByAssociationId(long idAssociation);
	
	public Association toModel(AssociationEntity association);
	
	public AssociationEntity createAssociation(long idAssociation, String zone);
	
	public AssociationEntity createAssociation(AssociationEntity entity);
	
	public void deleteAssociation(long idAssociation);
	
	public List<Patient> toModelListPatient(List<PatientEntity> list);
	
	public List<CentreVaccination> toModelListCentre(List<CentreVaccinationEntity> list);
	
	public AssociationEntity toEntity(Association model);
}
