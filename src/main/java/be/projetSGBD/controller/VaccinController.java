package be.projetSGBD.controller;

import static org.springframework.http.ResponseEntity.notFound;

import java.math.BigDecimal;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import be.projetSGBD.hateoas.VaccinRepresentationModelAssembler;
import be.projetSGBD.api.VaccinApi;
import be.projetSGBD.model.Vaccin;
import be.projetSGBD.service.VaccinService;

@RestController
public class VaccinController implements VaccinApi {

	private static final Logger log = LoggerFactory.getLogger(VaccinController.class);
	
	private VaccinService vaccinService;
	private VaccinRepresentationModelAssembler assembler;
	
	
	
	public VaccinController(VaccinService vaccinService, VaccinRepresentationModelAssembler assembler) {
		super();
		this.vaccinService = vaccinService;
		this.assembler = assembler;
	}

	@Override
	public Optional<NativeWebRequest> getRequest() {
		// TODO Auto-generated method stub
		return VaccinApi.super.getRequest();
	}

	@Override
	public ResponseEntity<Vaccin> createVaccin(@Valid Vaccin vaccin) {
		// TODO Auto-generated method stub
		//return VaccinApi.super.createVaccin(vaccin);
		//return Optional.of(vaccinService.createVaccin(vaccinService.toEntity(vaccin), vaccin.getIdCentreVaccination()))
			//	.map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());
		
		return Optional.of(vaccinService.createVaccin(vaccin.getNomVaccin(), vaccin.getNbsJoursEntreDoses(), vaccin.getNumeroLot(), vaccin.getIdCentreVaccination()))
				.map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());
	}

	@Override
	public ResponseEntity<Void> deleteVaccin(Long idVaccin) {
		this.vaccinService.deleteVaccin(idVaccin);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Vaccin> getVaccinByIdVaccin(Long idVaccin) {
		// TODO Auto-generated method stub
		//return VaccinApi.super.getVaccinByIdVaccin(idVaccin);
		return vaccinService.vaccinByIdVaccin(idVaccin)
				.map(assembler::toModel)
					.map(ResponseEntity::ok).orElse(notFound().build());
	}
	
	

}
