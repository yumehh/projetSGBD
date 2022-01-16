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

import be.projetSGBD.api.PatientApi;
import be.projetSGBD.hateoas.PatientRepresentationModelAssembler;
import be.projetSGBD.model.Patient;
import be.projetSGBD.service.PatientService;

@RestController
public class PatientController implements PatientApi {
	
	private static final Logger log = LoggerFactory.getLogger(PatientController.class);
	
	private PatientService patientService;
	private PatientRepresentationModelAssembler assembler;
	
	
	public PatientController(PatientService patientService, PatientRepresentationModelAssembler assembler) {
		super();
		this.patientService = patientService;
		this.assembler = assembler;
	}


	@Override
	public Optional<NativeWebRequest> getRequest() {
		// TODO Auto-generated method stub
		return PatientApi.super.getRequest();
	}


	@Override
	public ResponseEntity<Patient> createPatient(@Valid Patient patient) {
		return Optional.of(patientService.createPatient(patientService.toEntity(patient))).map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());
	}


	@Override
	public ResponseEntity<Void> deletePatient(Long idPatient) {
		this.patientService.deletePatient(idPatient);
		return new ResponseEntity<>(HttpStatus.OK);
	}


	@Override
	public ResponseEntity<Patient> getPatientByIdPatient(Integer idPatient) {
		// TODO Auto-generated method stub
		return patientService.patientByIdPatient(idPatient).map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());
	} 
	
	

}
