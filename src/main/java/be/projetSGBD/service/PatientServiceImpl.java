package be.projetSGBD.service;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import be.projetSGBD.entity.AssociationEntity;
import be.projetSGBD.entity.CentreVaccinationEntity;
import be.projetSGBD.entity.PatientEntity;
import be.projetSGBD.entity.PatientPlanningEntity;
import be.projetSGBD.entity.PlanningEntity;
import be.projetSGBD.model.Patient;
import be.projetSGBD.model.PatientPlanning;
import be.projetSGBD.model.Planning;
import be.projetSGBD.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	private PatientRepository patientRepo;

	public PatientServiceImpl(PatientRepository patientRepo) {
		super();
		this.patientRepo = patientRepo;
	}

	
	@Override
	public Optional<PatientEntity> patientById(long idPatient) {
		Optional<PatientEntity> pe = patientRepo.findById(idPatient);
		return pe;
	}

	@Override
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
		.idCentreVaccination(pe.getCentreVaccination().getIdCentreVaccination());
		return p;
	}
	
	
	public PatientPlanning toModel(PatientPlanningEntity ppe) {
		PatientPlanning pp = new PatientPlanning();
		pp.idPatientPlanning(ppe.getIdPatientPlanning())
			.idPatient(ppe.getPatient().getIdPatient());
		
		return pp;
	}


	@Override
	public PatientEntity createPatient(String numeroNational, String nomFamille, String prenom, Date dateNaissance,
			String pays, String ville, String adresse, Long idCentre, Long idAssociation) {
		
		PatientEntity pe = new PatientEntity();
		CentreVaccinationEntity cve = new CentreVaccinationEntity();
		AssociationEntity ae = new AssociationEntity();
		
		cve.setIdCentreVaccination(idCentre);
		ae.setIdAssociation(idAssociation);
		
		pe.setNumeroNational(numeroNational);
		pe.setNomFamille(nomFamille);
		pe.setPrenom(prenom);
		pe.setDateNaissance(dateNaissance);
		pe.setPays(pays);
		pe.setVille(ville);
		pe.setAdresse(adresse);
		pe.setCentreVaccination(cve);
		pe.setAssociation(ae);
		
		return patientRepo.save(pe);
	}

	@Override
	public PatientEntity createPatient(PatientEntity pe) {
		// TODO Auto-generated method stub
		return patientRepo.save(pe);
	}

	@Override
	public void deletePatient(long idPatient) {
		this.patientRepo.deleteById(idPatient);
		
	}

	@Override
	public PatientEntity toEntity(Patient model) {
		PatientEntity pe = new PatientEntity();
		pe.setNumeroNational(model.getNumeroNational());
		pe.setNomFamille(model.getNomFamille());
		pe.setPrenom(model.getPrenom());
		pe.setDateNaissance(model.getDateNaissance());
		pe.setPays(model.getPays());
		pe.setVille(model.getVille());
		pe.setAdresse(model.getAdresse());
		return pe;
	}

	@Override
	public List<Patient> toModelListPatient(List<PatientEntity> list) {
		if (Objects.isNull(list)) {
			return Collections.emptyList();
		}
			return list.stream().map(e -> toModel(e)).collect(toList());
	}


	@Override
	public List<PatientPlanningEntity> PatientPlanningByPatientId(long idPatient) {
		PatientEntity pe = this.patientRepo.findById(idPatient).get();
		return pe.getPatientPlanning();
	}


	@Override
	public List<PatientPlanning> toModelListPatientPlanningPatient(List<PatientPlanningEntity> list) {
		if (Objects.isNull(list)) {
			return Collections.emptyList();
		}
		   return list.stream().map(e -> toModel(e)).collect(toList());
	}
}
