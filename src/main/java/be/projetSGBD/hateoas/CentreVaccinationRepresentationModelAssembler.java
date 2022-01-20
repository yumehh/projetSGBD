package be.projetSGBD.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import be.projetSGBD.controller.CentreVaccinationController;
import be.projetSGBD.entity.CentreVaccinationEntity;
import be.projetSGBD.model.CentreVaccination;
import be.projetSGBD.service.CentreVaccinationService;

@Component
public class CentreVaccinationRepresentationModelAssembler extends RepresentationModelAssemblerSupport<CentreVaccinationEntity, CentreVaccination>{

	private CentreVaccinationService centreService;
	
	public CentreVaccinationRepresentationModelAssembler(CentreVaccinationService centreService) {
		super(CentreVaccinationController.class, CentreVaccination.class);
		this.centreService = centreService;
	}

	@Override
	public CentreVaccination toModel(CentreVaccinationEntity entity) {
		CentreVaccination resource = createModelWithId(entity.getIdCentreVaccination(), entity);
		BeanUtils.copyProperties(entity, resource);
		
		resource.idCentreVaccination(entity.getIdCentreVaccination())
			.patient(centreService.toModelListPatient(entity.getPatient()))
			.vaccin(centreService.toModelList(entity.getVaccin()))
			.planning(centreService.toModelListPlanning(entity.getPlanning()))
			.idAssociation(entity.getAssociation().getIdAssociation());
		
		resource.add(linkTo(methodOn(CentreVaccinationController.class).getCentreVaccinationByIdCentreVaccination(entity.getIdCentreVaccination())).withSelfRel());
		
		return resource;
	}

}
