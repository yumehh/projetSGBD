package be.projetSGBD.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import be.projetSGBD.entity.PatientEntity;
import be.projetSGBD.entity.PatientPlanningEntity;
import be.projetSGBD.entity.PlanningEntity;
import be.projetSGBD.model.PatientPlanning;
import be.projetSGBD.repository.PatientPlanningRepository;

@Service
public class PatientPlanningServiceImpl implements PatientPlanningService {

	public PatientPlanningRepository ppRepo;

	private static final Logger log = LoggerFactory.getLogger(PatientPlanningServiceImpl.class);

	
	public PatientPlanningServiceImpl(PatientPlanningRepository ppRepo) {
		super();
		this.ppRepo = ppRepo;
	}

	@Override
	public Optional<PatientPlanningEntity> patientPlanningById(long idPatientPlanning) {
		Optional<PatientPlanningEntity> ppe = ppRepo.findById(idPatientPlanning);
		return ppe;
	}

	@Override
	public PatientPlanning toModel(PatientPlanningEntity entity) {
		PatientPlanning pp = new PatientPlanning();
		pp.idPatientPlanning(entity.getIdPatientPlanning())
			.idPatient(entity.getPatient().getIdPatient())
			.idPlanning(entity.getPlanning().getIdPlanning());
		return pp;
	}

	@Override
	public PatientPlanningEntity createPatientPlanning(Long idPatient, Long idPlanning) {
		PatientPlanningEntity ppe = new PatientPlanningEntity();
		PatientEntity pe = new PatientEntity();
		PlanningEntity planning = new PlanningEntity();
		
		pe.setIdPatient(idPatient);
		planning.setIdPlanning(idPlanning);
		
		ppe.setPatient(pe);
		ppe.setPlanning(planning);
		
		System.out.println("ppe " + ppe);
		System.out.println("idpatient : " + ppe.getPatient().getIdPatient() + "idplanning : " + ppe.getPlanning().getIdPlanning());
		
		return ppRepo.save(ppe);
	}

	@Override
	public void deletePatientPlanning(long idPatientPlanning) {
		this.ppRepo.deleteById(idPatientPlanning);
		
	}

	@Override
	public PatientPlanningEntity toEntity(PatientPlanning model) {
		PatientPlanningEntity ppe = new PatientPlanningEntity();
		ppe.setIdPatientPlanning(model.getIdPatientPlanning());
		return ppe;
	}

}
