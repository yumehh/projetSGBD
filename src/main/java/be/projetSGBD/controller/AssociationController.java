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

import be.projetSGBD.api.AssociationApi;
import be.projetSGBD.hateoas.AssociationRepresentationModelAssembler;
import be.projetSGBD.hateoas.CentreVaccinationRepresentationModelAssembler;
import be.projetSGBD.hateoas.PatientRepresentationModelAssembler;
import be.projetSGBD.model.Association;
import be.projetSGBD.model.CentreVaccination;
import be.projetSGBD.model.Patient;
import be.projetSGBD.service.AssociationService;
import be.projetSGBD.service.CentreVaccinationService;
import be.projetSGBD.service.PatientService;

@RestController
public class AssociationController implements AssociationApi {

	private AssociationService associationService;
	private PatientService patientService;
	private CentreVaccinationService centreService;
	private AssociationRepresentationModelAssembler assembler;
	private PatientRepresentationModelAssembler patientAssembler;
	private CentreVaccinationRepresentationModelAssembler centreAssembler;
	
	
	public AssociationController(AssociationService associationService, PatientService patientService,
			CentreVaccinationService centreService, AssociationRepresentationModelAssembler assembler,
			PatientRepresentationModelAssembler patientAssembler,
			CentreVaccinationRepresentationModelAssembler centreAssembler) {
		super();
		this.associationService = associationService;
		this.patientService = patientService;
		this.centreService = centreService;
		this.assembler = assembler;
		this.patientAssembler = patientAssembler;
		this.centreAssembler = centreAssembler;
	}
	

	@Override
	public Optional<NativeWebRequest> getRequest() {
		// TODO Auto-generated method stub
		return AssociationApi.super.getRequest();
	}

	@Override
	public ResponseEntity<Association> createAssociation(@Valid Association association) {
		// TODO Auto-generated method stub
		//return Optional.of(associationService.createAssociation(associationService.toEntity(association))).map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());
		return Optional.of(associationService.createAssociation(association.getIdAssociation(), association.getZone()))
				.map(assembler::toModel)
					.map(ResponseEntity::ok).orElse(notFound().build());
	}

	@Override
	public ResponseEntity<Void> deleteAssociation(Long idAssociation) {
		this.associationService.deleteAssociation(idAssociation);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Association> getAssociationByIdAssociation(Long idAssociation) {
		// TODO Auto-generated method stub
		return associationService.associationById(idAssociation).map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());
	}
	
	public ResponseEntity<List<Patient>> getPatientByIdAssociation(String idAssociation){
		
		return ok(Collections.EMPTY_LIST);
	}

	public ResponseEntity<List<CentreVaccination>> getCentreVaccinationByIdAssociation(String idAssociation){
		
		return ok(Collections.EMPTY_LIST);
	}
	
}
