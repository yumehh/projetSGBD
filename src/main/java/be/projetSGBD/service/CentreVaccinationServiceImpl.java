package be.projetSGBD.service;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import be.projetSGBD.entity.CentreVaccinationEntity;
import be.projetSGBD.entity.PatientEntity;
import be.projetSGBD.entity.VaccinEntity;
import be.projetSGBD.model.CentreVaccination;
import be.projetSGBD.model.Patient;
import be.projetSGBD.model.Vaccin;
import be.projetSGBD.repository.CentreVaccinationRepository;

@Service
public class CentreVaccinationServiceImpl implements CentreVaccinationService {


	private CentreVaccinationRepository centreRepo;
	
	public CentreVaccinationServiceImpl(CentreVaccinationRepository centreRepo) {
		super();
		this.centreRepo = centreRepo;
	}

	@Override
	public Optional<CentreVaccinationEntity> centreVaccinationById(long idCentreVaccination) {
		Optional<CentreVaccinationEntity> cve = centreRepo.findById(idCentreVaccination);
		return cve;
	}

	@Override
	public List<PatientEntity> patientByCentreVaccinationId(long idCentreVaccination) {
		CentreVaccinationEntity cve = this.centreRepo.findById(idCentreVaccination).get();
		return cve.getPatient();
	}

	@Override
	public List<VaccinEntity> vaccinByCentreVaccinationId(long idCentreVaccination) {
		CentreVaccinationEntity cve = this.centreRepo.findById(idCentreVaccination).get();
		return cve.getVaccin();
	}

	@Override
	public CentreVaccination toModel(CentreVaccinationEntity centreVaccination) {
		CentreVaccination cv = new CentreVaccination();
		cv.setIdCentreVaccination(centreVaccination.getIdCentreVaccination());
		cv.setAdresse(centreVaccination.getAdresse());
		cv.setHeureOuverture(centreVaccination.getHeureOuverture());
		cv.setLocalite(centreVaccination.getLocalite());
		return cv;
	}
	
	public Vaccin toModel(VaccinEntity ve) {
		Vaccin v = new Vaccin();
		v.idVaccin(ve.getIdVaccin())
		.nbsJoursEntreDoses(ve.getNbsJoursEntreDoses())
		.nomVaccin(ve.getNomVaccin())
		.numeroLot(ve.getNumeroLot());
		return v;
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
		.adresse(pe.getAdresse());
		return p;
	}

	@Override
	public CentreVaccinationEntity createCentre(String localite, String adresse, String heureOuverture) {
		CentreVaccinationEntity cve = new CentreVaccinationEntity();
		cve.setAdresse(adresse);
		cve.setLocalite(localite);
		cve.setHeureOuverture(heureOuverture);
		return cve;
	}

	@Override
	public CentreVaccinationEntity createCentre(CentreVaccinationEntity entity) {
		
		return centreRepo.save(entity);
	}

	@Override
	public void deleteCentre(long idCentreVaccination) {
		this.centreRepo.deleteById(idCentreVaccination);
		
	}

	@Override
	public List<Vaccin> toModelList(List<VaccinEntity> list) {
		if (Objects.isNull(list)) {
			return Collections.emptyList();
		}
		   return list.stream().map(e -> toModel(e)).collect(toList());
	}

	@Override
	public List<Patient> toModelListPatient(List<PatientEntity> list) {
		if (Objects.isNull(list)) {
			return Collections.emptyList();
		}
		   return list.stream().map(e -> toModel(e)).collect(toList());
	}

	@Override
	public CentreVaccinationEntity toEntity(CentreVaccination model) {
		CentreVaccinationEntity cve = new CentreVaccinationEntity();
		cve.setAdresse(model.getAdresse());
		cve.setHeureOuverture(model.getHeureOuverture());
		cve.setLocalite(model.getLocalite());
		cve.setPlanning(model.getPlanning());
		return cve;
	}
}
