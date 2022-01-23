package be.projetSGBD.controller;

import static org.springframework.http.ResponseEntity.notFound;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import be.projetSGBD.api.PatientPlanningApi;
import be.projetSGBD.hateoas.PatientPlanningRepresentationModelAssembler;
import be.projetSGBD.model.PatientPlanning;
import be.projetSGBD.service.PatientPlanningService;

@RestController
public class PatientPlanningController implements PatientPlanningApi {

	private static final Logger log = LoggerFactory.getLogger(PatientPlanningController.class);
	
	private PatientPlanningService ppService;
	private PatientPlanningRepresentationModelAssembler assembler;
	
	
	public PatientPlanningController(PatientPlanningService ppService,
			PatientPlanningRepresentationModelAssembler assembler) {
		super();
		this.ppService = ppService;
		this.assembler = assembler;
	}


	@Override
	public Optional<NativeWebRequest> getRequest() {
		// TODO Auto-generated method stub
		return PatientPlanningApi.super.getRequest();
	}


	@Override
	public ResponseEntity<PatientPlanning> createPatientPlanning(@Valid PatientPlanning patientPlanning) {
		// TODO Auto-generated method stub
		//return PatientPlanningApi.super.createPatientPlanning(patientPlanning);
		return Optional.of(ppService.createPatientPlanning(patientPlanning.getIdPatient(), patientPlanning.getIdPlanning()))
				.map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());
	}


	@Override
	public ResponseEntity<Void> deletePatientPlanning(Long idPatientPlanning) {
		this.ppService.deletePatientPlanning(idPatientPlanning);
		return new ResponseEntity<>(HttpStatus.OK);
	}


	@Override
	public ResponseEntity<PatientPlanning> getPatientPlanningByIdPatientPlanning(Long idPatientPlanning) {
		// TODO Auto-generated method stub
		//return PatientPlanningApi.super.getPatientPlanningByIdPatientPlanning(idPatientPlanning);
		return ppService.patientPlanningById(idPatientPlanning)
				.map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());
	}
	

	
}
