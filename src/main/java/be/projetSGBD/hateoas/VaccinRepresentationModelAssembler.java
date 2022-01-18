package be.projetSGBD.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import be.projetSGBD.controller.PatientController;
import be.projetSGBD.controller.VaccinController;
import be.projetSGBD.entity.VaccinEntity;
import be.projetSGBD.model.Vaccin;
import be.projetSGBD.service.VaccinService;

@Component
public class VaccinRepresentationModelAssembler extends RepresentationModelAssemblerSupport<VaccinEntity, Vaccin> {

	private VaccinService vaccinService;
	
	public VaccinRepresentationModelAssembler(VaccinService vaccinService) {
		super(VaccinController.class, Vaccin.class);
		this.vaccinService = vaccinService;
	}

	@Override
	public Vaccin toModel(VaccinEntity entity) {
		Vaccin resource = createModelWithId(entity.getIdVaccin(), entity);
		BeanUtils.copyProperties(entity, resource);
		
		resource.add(linkTo(methodOn(VaccinController.class).getVaccinByIdVaccin(entity.getIdVaccin())).withSelfRel());

		
		return resource;
	}

}
