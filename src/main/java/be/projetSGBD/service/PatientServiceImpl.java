package be.projetSGBD.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import be.projetSGBD.entity.PatientEntity;
import be.projetSGBD.model.Patient;
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
		.adresse(pe.getAdresse());
		return p;
	}

	@Override
	public PatientEntity createPatient(String numeroNational, String nomFamille, String prenom, Date dateNaissance,
			String pays, String ville, String adresse) {
		PatientEntity pe = new PatientEntity();
		pe.setNumeroNational(numeroNational);
		pe.setNomFamille(nomFamille);
		pe.setPrenom(prenom);
		pe.setDateNaissance(dateNaissance);
		pe.setPays(pays);
		pe.setVille(ville);
		pe.setAdresse(adresse);
		return pe;
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

}
