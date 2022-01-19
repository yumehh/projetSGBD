package be.projetSGBD.controller;

import static org.springframework.http.ResponseEntity.notFound;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import be.projetSGBD.api.PlanningApi;
import be.projetSGBD.hateoas.PatientRepresentationModelAssembler;
import be.projetSGBD.hateoas.PlanningRepresentationModelAssembler;
import be.projetSGBD.model.Planning;
import be.projetSGBD.service.PatientService;
import be.projetSGBD.service.PlanningService;

@RestController
public class PlanningController implements PlanningApi {

	private PatientService patientService;
	private PatientRepresentationModelAssembler assemblerPatient;
	private PlanningService planningService;
	private PlanningRepresentationModelAssembler assembler;
	
	
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
	
	
}
