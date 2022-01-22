package be.projetSGBD.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import be.projetSGBD.controller.PatientController;
import be.projetSGBD.entity.PatientEntity;
import be.projetSGBD.model.Patient;
import be.projetSGBD.service.PatientService;
import be.projetSGBD.service.PlanningService;

@Component
public class PatientRepresentationModelAssembler extends RepresentationModelAssemblerSupport<PatientEntity, Patient>{

	private PatientService patientService;
	private PlanningService planningService;
	private PlanningRepresentationModelAssembler planningAssembler;
	
	

	public PatientRepresentationModelAssembler(
			PatientService patientService, PlanningService planningService,
			PlanningRepresentationModelAssembler planningAssembler) {
		super(PatientController.class, Patient.class);
		this.patientService = patientService;
		this.planningService = planningService;
		this.planningAssembler = planningAssembler;
	}



	@Override
	public Patient toModel(PatientEntity entity) {
		Patient resource = createModelWithId(entity.getIdPatient(), entity);
		BeanUtils.copyProperties(entity, resource);
		
		resource.idPatient(entity.getIdPatient())
		.numeroNational(entity.getNumeroNational())
		.nomFamille(entity.getNomFamille())
		.prenom(entity.getPrenom())
		.dateNaissance(entity.getDateNaissance())
		.pays(entity.getPays())
		.ville(entity.getVille())
		.adresse(entity.getAdresse())
		.idCentreVaccination(entity.getCentreVaccination().getIdCentreVaccination())
		.idAssociation(entity.getAssociation().getIdAssociation())
		.planning(planningService.toModelList(entity.getPlanning()).stream().collect(Collectors.toList()));
		;
		
		resource.add(linkTo(methodOn(PatientController.class).getPatientByIdPatient(entity.getIdPatient())).withSelfRel());

		return resource;
	}

}
