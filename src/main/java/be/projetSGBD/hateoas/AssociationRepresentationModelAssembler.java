package be.projetSGBD.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import be.projetSGBD.controller.AssociationController;
import be.projetSGBD.entity.AssociationEntity;
import be.projetSGBD.model.Association;
import be.projetSGBD.service.AssociationService;

@Component
public class AssociationRepresentationModelAssembler extends RepresentationModelAssemblerSupport<AssociationEntity, Association>{

	private AssociationService associationService;
	
	public AssociationRepresentationModelAssembler(AssociationService associationService) {
		super(AssociationController.class, Association.class);
		this.associationService = associationService;
	}

	@Override
	public Association toModel(AssociationEntity entity) {
		Association resource = createModelWithId(entity.getIdAssociation(), entity);
		BeanUtils.copyProperties(entity, resource);
		
		resource.idAssociation(entity.getIdAssociation())
		.patient(associationService.toModelListPatient(entity.getPatient()))
		.centreVaccination(associationService.toModelListCentre(entity.getCentreVaccination()));
		
		resource.add(linkTo(methodOn(AssociationController.class).getAssociationByIdAssociation(entity.getIdAssociation())).withSelfRel());

		
		return resource;
	}

}
