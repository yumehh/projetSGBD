 package be.projetSGBD.service;

import static java.util.stream.Collectors.toSet;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.projetSGBD.entity.PatientEntity;
import be.projetSGBD.entity.PlanningEntity;
import be.projetSGBD.model.Patient;
import be.projetSGBD.model.Planning;
import be.projetSGBD.repository.PatientRepository;

@Service
public class PatientServiceImpl implements  PatientService {

	
	public PatientRepository patientRepo;
	
	private static final Logger log = LoggerFactory.getLogger(PatientServiceImpl.class);

	public PatientServiceImpl(PatientRepository patientRepo) {
		super();
		this.patientRepo = patientRepo;
	}
	

	@Override
	public Optional<PatientEntity> patientByIdPatient(long idPatient) {
		Optional<PatientEntity> pe = patientRepo.findById(idPatient);
		return pe;
	}

	@Override
	public Patient toModel(PatientEntity pe) {
		Patient p = new Patient();
		p.idPatient(pe.getIdPatient()).numeroNational(p.getNumeroNational());
		return p;
	}
	
	private Planning toModel(PlanningEntity pe) {
		Planning p = new Planning();
		p.idPlanning(pe.getIdPlanning());
		return p;
	}
	

	@Override
	public void deletePatient(long idPatient) {
		this.patientRepo.deleteById(idPatient);
		
	}

	@Override
	public PatientEntity toEntity(Patient model) {
		PatientEntity pe = new PatientEntity();
		pe.setNumeroNational(model.getNumeroNational());
		return pe;
	}

	@Override
	public PatientEntity createPatient(PatientEntity entity) {
		
		return patientRepo.save(entity);
	}

	@Override
	public Set<Planning> toModelList(List<PlanningEntity> list) {
		if(Objects.isNull(list)) {
			return Collections.emptySet();
		}
		return list.stream().map(e -> toModel(e)).collect(toSet());
	}

	@Override
	public void dropEmail(String email) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public PatientEntity createPatient(String numeroNational, String nomFamille, String prenom, Date DateNaissance,
			String Pays, String Ville, String Adresse) {
		PatientEntity pe = new PatientEntity();
		pe.setNumeroNational(numeroNational);
		pe.setNomFamille(nomFamille);
		pe.setPrenom(prenom);
		pe.setDateNaissance(DateNaissance);
		pe.setPays(Pays);
		pe.setVille(Ville);
		pe.setAdresse(Adresse);
		return pe;
	}

}
