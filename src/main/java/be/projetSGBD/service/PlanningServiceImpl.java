package be.projetSGBD.service;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import be.projetSGBD.entity.CentreVaccinationEntity;
import be.projetSGBD.entity.PatientEntity;
import be.projetSGBD.entity.PatientPlanningEntity;
import be.projetSGBD.entity.PlanningEntity;
import be.projetSGBD.model.PatientPlanning;
import be.projetSGBD.model.Planning;
import be.projetSGBD.repository.PlanningRepository;

@Service
public class PlanningServiceImpl implements PlanningService {

	private PlanningRepository planningRepo;
	
	private static final Logger log = LoggerFactory.getLogger(PlanningServiceImpl.class);

	public PlanningServiceImpl(PlanningRepository planningRepo) {
		super();
		this.planningRepo = planningRepo;
	}

	@Override
	public Optional<PlanningEntity> planningById(long idPlanning) {
		Optional<PlanningEntity> pe = planningRepo.findById(idPlanning);
		return pe;
	}
	
	@Override
	public List<PatientPlanningEntity> PatientPlanningByPlanningId(long idPlanning) {
		PlanningEntity pe = this.planningRepo.findById(idPlanning).get();
		return pe.getPatientPlanning();
	}

	@Override
	public Planning toModel(PlanningEntity pe) {
		Planning p = new Planning();
		p.idPlanning(pe.getIdPlanning())
			.dateRdv(pe.getDateRdv())
			.idCentreVaccination(pe.getCentreVaccination().getIdCentreVaccination())
			;
		return p;
	}
	
	public PatientPlanning toModel(PatientPlanningEntity ppe) {
		PatientPlanning pp = new PatientPlanning();
		pp.idPatientPlanning(ppe.getIdPatientPlanning())
		.idPlanning(ppe.getPlanning().getIdPlanning());
		return pp;
	}

	@Override
	public PlanningEntity createPlanning(Date dateRdv, Long idCentre) {
		PlanningEntity pe = new PlanningEntity();
		CentreVaccinationEntity cve = new CentreVaccinationEntity();
		PatientPlanningEntity pp = new PatientPlanningEntity();

		cve.setIdCentreVaccination(idCentre);
		pe.setDateRdv(dateRdv);
		pe.setCentreVaccination(cve);
		pe.setPatient(cve.getPatient());
		
		return planningRepo.save(pe);
	}

	@Override
	public PlanningEntity createPlanning(PlanningEntity pe) {
		
		return planningRepo.save(pe);
	}

	@Override
	public void deletePlanning(long idPlanning) {
		this.planningRepo.deleteById(idPlanning);
		
	}

	@Override
	public PlanningEntity toEntity(Planning model) {
		PlanningEntity pe = new PlanningEntity();
		pe.setDateRdv(model.getDateRdv());
		return pe;
	}

	@Override
	public List<Planning> toModelList(List<PlanningEntity> list) {
		if (Objects.isNull(list)) {
			return Collections.emptyList();
		}
		return list.stream().map(e -> toModel(e)).collect(toList());
	}
	
	@Override
	public List<PatientPlanning> toModelListPatientPlanningPlanning(List<PatientPlanningEntity> list) {
		if (Objects.isNull(list)) {
			return Collections.emptyList();
		}
		   return list.stream().map(e -> toModel(e)).collect(toList());
	}

}
