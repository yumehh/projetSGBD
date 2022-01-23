package be.projetSGBD.controller;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import be.projetSGBD.api.PlanningApi;
import be.projetSGBD.hateoas.PatientRepresentationModelAssembler;
import be.projetSGBD.hateoas.PlanningRepresentationModelAssembler;
import be.projetSGBD.model.Patient;
import be.projetSGBD.model.PatientPlanning;
import be.projetSGBD.model.Planning;
import be.projetSGBD.service.PatientService;
import be.projetSGBD.service.PlanningService;

@RestController
public class PlanningController implements PlanningApi {

	private PatientService patientService;
	private PatientRepresentationModelAssembler assemblerPatient;
	private PlanningService planningService;
	private PlanningRepresentationModelAssembler assembler;
	
	//@JsonCreator
	public PlanningController(PatientService patientService, PatientRepresentationModelAssembler assemblerPatient,
			 PlanningService planningService, PlanningRepresentationModelAssembler assembler) {
		super();
		this.patientService = patientService;
		this.assemblerPatient = assemblerPatient;
		this.planningService = planningService;
		this.assembler = assembler;
	}


	@Override
	public Optional<NativeWebRequest> getRequest() {
		// TODO Auto-generated method stub
		return PlanningApi.super.getRequest();
	}


	@Override
	public ResponseEntity<Planning> createPlanning(@Valid Planning planning) {
		// TODO Auto-generated method stub
		//return PlanningApi.super.createPlanning(planning);
		//return Optional.of(planningService.createPlanning(planningService.toEntity(planning))).map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());
		return Optional.of(planningService.createPlanning(planning.getDateRdv(), planning.getIdCentreVaccination())).map(assembler::toModel)
				.map(ResponseEntity::ok).orElse(notFound().build());
	}


	@Override
	public ResponseEntity<Void> deletePlanning(long idPlanning) {
		this.planningService.deletePlanning(idPlanning);
		return new ResponseEntity<>(HttpStatus.OK);
	}


	@Override
	public ResponseEntity<Planning> getPlanningByIdPlanning(long idPlanning) {
		// TODO Auto-generated method stub
		//return PlanningApi.super.getPlanningByIdPlanning(idPlanning);
		return planningService.planningById(idPlanning)
				.map(assembler::toModel)
					.map(ResponseEntity::ok).orElse(notFound().build());
	}
	
	public ResponseEntity<List<Patient>> getPatientByPlanningId(Long idPlanning){
		
		return ok(Collections.emptyList());
	}
	
public ResponseEntity<List<PatientPlanning>> getPlanningByIdPatientPlanning(Long idPlanning){
		
		return ok(Collections.emptyList());
	}
	
	
}
