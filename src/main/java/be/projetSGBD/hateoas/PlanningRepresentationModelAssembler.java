package be.projetSGBD.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import be.projetSGBD.controller.PlanningController;
import be.projetSGBD.entity.PlanningEntity;
import be.projetSGBD.model.Planning;
import be.projetSGBD.service.PlanningService;

@Component
public class PlanningRepresentationModelAssembler extends RepresentationModelAssemblerSupport<PlanningEntity, Planning>{

	private PlanningService planningService;
	
	public PlanningRepresentationModelAssembler(PlanningService planningService) {
		super(PlanningController.class, Planning.class);
		this.planningService = planningService;
	}

	@Override
	public Planning toModel(PlanningEntity entity) {
		Planning resource = createModelWithId(entity.getIdPlanning(), entity);
		BeanUtils.copyProperties(entity, resource);
		
		resource.idPlanning(entity.getIdPlanning())
			.dateRdv(entity.getDateRdv())
			.idCentreVaccination(entity.getCentreVaccination().getIdCentreVaccination());
		
		resource.add(linkTo(methodOn(PlanningController.class).getPlanningByIdPlanning(entity.getIdPlanning())).withSelfRel());

		return resource;
	}

}
