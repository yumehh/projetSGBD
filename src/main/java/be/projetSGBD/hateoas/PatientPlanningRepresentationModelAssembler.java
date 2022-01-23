package be.projetSGBD.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import be.projetSGBD.controller.PatientPlanningController;
import be.projetSGBD.entity.PatientPlanningEntity;
import be.projetSGBD.model.PatientPlanning;
import be.projetSGBD.service.PatientPlanningService;

@Component
public class PatientPlanningRepresentationModelAssembler extends RepresentationModelAssemblerSupport<PatientPlanningEntity, PatientPlanning> {

	private PatientPlanningService ppService;
	
	

	public PatientPlanningRepresentationModelAssembler(PatientPlanningService ppService) {
		super(PatientPlanningController.class, PatientPlanning.class);
		this.ppService = ppService;
	}

	@Override
	public PatientPlanning toModel(PatientPlanningEntity entity) {
		PatientPlanning resource = createModelWithId(entity.getIdPatientPlanning(), entity);
		BeanUtils.copyProperties(entity, resource);
		
		resource.idPatientPlanning(entity.getIdPatientPlanning())
			.idPatient(entity.getPatient().getIdPatient())
			.idPlanning(entity.getPlanning().getIdPlanning());
		
		resource.add(linkTo(methodOn(PatientPlanningController.class).getPatientPlanningByIdPatientPlanning(entity.getIdPatientPlanning())).withSelfRel());

		
		return resource;
	}

}
