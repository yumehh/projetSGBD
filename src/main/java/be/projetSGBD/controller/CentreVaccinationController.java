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

import be.projetSGBD.api.CentreVaccinationApi;
import be.projetSGBD.hateoas.CentreVaccinationRepresentationModelAssembler;
import be.projetSGBD.hateoas.PatientRepresentationModelAssembler;
import be.projetSGBD.hateoas.VaccinRepresentationModelAssembler;
import be.projetSGBD.model.CentreVaccination;
import be.projetSGBD.model.Patient;
import be.projetSGBD.model.Vaccin;
import be.projetSGBD.service.CentreVaccinationService;
import be.projetSGBD.service.PatientService;
import be.projetSGBD.service.VaccinService;

@RestController
public class CentreVaccinationController implements CentreVaccinationApi {

	private CentreVaccinationService centreService;
	private PatientService patientService;
	private VaccinService vaccinService;
	private CentreVaccinationRepresentationModelAssembler assembler;
	private PatientRepresentationModelAssembler patientAssembler;
	private VaccinRepresentationModelAssembler vaccinAssembler;
	

	public CentreVaccinationController(CentreVaccinationService centreService, PatientService patientService,
			VaccinService vaccinService, CentreVaccinationRepresentationModelAssembler assembler,
			PatientRepresentationModelAssembler patientAssembler, VaccinRepresentationModelAssembler vaccinAssembler) {
		super();
		this.centreService = centreService;
		this.patientService = patientService;
		this.vaccinService = vaccinService;
		this.assembler = assembler;
		this.patientAssembler = patientAssembler;
		this.vaccinAssembler = vaccinAssembler;
	}


	@Override
	public Optional<NativeWebRequest> getRequest() {
		// TODO Auto-generated method stub
		return CentreVaccinationApi.super.getRequest();
	}


	@Override
	public ResponseEntity<CentreVaccination> createCentreVaccination(@Valid CentreVaccination centreVaccination) {
		// TODO Auto-generated method stub
		//return Optional.of(centreService.createCentre(centreService.toEntity(centreVaccination))).map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());
		return Optional.of(centreService.createCentre(centreVaccination.getAdresse(), centreVaccination.getLocalite(), centreVaccination.getHeureOuverture(), centreVaccination.getIdAssociation()))
					.map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());
	}


	@Override
	public ResponseEntity<Void> deleteCentreVaccination(Long idCentreVaccination) {
		this.centreService.deleteCentre(idCentreVaccination);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}


	@Override
	public ResponseEntity<CentreVaccination> getCentreVaccinationByIdCentreVaccination(long idCentreVaccination) {
		// TODO Auto-generated method stub
		return centreService.centreVaccinationById(idCentreVaccination).map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());
	}
	
	
	
	public ResponseEntity<List<Patient>> getPatientByIdCentreVaccination(Long idCentreVaccination){
		
		return ok(Collections.EMPTY_LIST);
		
	}
	
	public ResponseEntity<List<Vaccin>>getVaccinByIdCentreVaccination(Long idCentreVaccination){
		return ok(Collections.EMPTY_LIST);
	}
	
}
