package be.projetSGBD.service;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import be.projetSGBD.entity.AssociationEntity;
import be.projetSGBD.entity.CentreVaccinationEntity;
import be.projetSGBD.entity.PatientEntity;
import be.projetSGBD.model.Association;
import be.projetSGBD.model.CentreVaccination;
import be.projetSGBD.model.Patient;
import be.projetSGBD.repository.AssociationRepository;

@Service
public class AssociationServiceImpl implements AssociationService {

	private AssociationRepository associationRepo;
	
	public AssociationServiceImpl(AssociationRepository associationRepo) {
		super();
		this.associationRepo = associationRepo;
	}
	

	@Override
	public Optional<AssociationEntity> associationById(long idAssociation) {
		Optional<AssociationEntity> ae = associationRepo.findById(idAssociation);
		return ae;
	}

	@Override
	public List<PatientEntity> patientByAssociationId(long idAssociation) {
		AssociationEntity ae = this.associationRepo.findById(idAssociation).get();
		return ae.getPatient();
	}

	@Override
	public List<CentreVaccinationEntity> centreByAssociationId(long idAssociation) {
		AssociationEntity ae = this.associationRepo.findById(idAssociation).get();
		return ae.getCentreVaccination();
	}

	@Override
	public Association toModel(AssociationEntity association) {
		Association a = new Association();
		a.setIdAssociation(association.getIdAssociation());
		a.setZone(association.getZone());
		
		return a;
	}
	
	public Patient toModel(PatientEntity pe) {
		Patient p = new Patient();
		p.idPatient(pe.getIdPatient())
		.numeroNational(pe.getNumeroNational())
		.nomFamille((pe.getNomFamille()))
		.prenom(pe.getPrenom())
		.dateNaissance(pe.getDateNaissance())
		.pays(pe.getPays())
		.ville(pe.getVille())
		.adresse(pe.getAdresse())
		.idCentreVaccination(pe.getCentreVaccination().getIdCentreVaccination())
		.idAssociation(pe.getAssociation().getIdAssociation())
		;
		
		return p;
	} 
	
	public CentreVaccination toModel(CentreVaccinationEntity cve) {
		CentreVaccination cv = new CentreVaccination();
		cv.idCentreVaccination(cve.getIdCentreVaccination())
		.localite(cve.getLocalite())
		.adresse(cve.getAdresse())
		.heureOuverture(cve.getHeureOuverture())
		.idAssociation(cve.getAssociation().getIdAssociation())
		;
		return cv;
	}

	@Override
	public AssociationEntity createAssociation(long idAssociation, String zone) {
		AssociationEntity ae = new AssociationEntity();
		ae.setIdAssociation(idAssociation);
		ae.setZone(zone);
		return ae;
	}

	@Override
	public AssociationEntity createAssociation(AssociationEntity entity) {
		
		return associationRepo.save(entity);
	}

	@Override
	public void deleteAssociation(long idAssociation) {
		this.associationRepo.deleteById(idAssociation);
		
	}

	@Override
	public List<Patient> toModelListPatient(List<PatientEntity> list) {
		if(Objects.isNull(list)) {
			return Collections.emptyList();
		}
		return list.stream().map(e -> toModel(e)).collect(toList());
	}

	@Override
	public List<CentreVaccination> toModelListCentre(List<CentreVaccinationEntity> list) {
		if(Objects.isNull(list)) {
			return Collections.emptyList();
		}
		return list.stream().map(e -> toModel(e)).collect(toList());
	}

	@Override
	public AssociationEntity toEntity(Association model) {
		AssociationEntity ae = new AssociationEntity();
		ae.setIdAssociation(model.getIdAssociation());
		ae.setZone(model.getZone());
		return ae;
	}

}
