package be.projetSGBD.hateoas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import be.projetSGBD.controller.PatientController;
import be.projetSGBD.entity.PatientEntity;
import be.projetSGBD.model.Patient;
import be.projetSGBD.service.PatientService;

@Component
public class PatientRepresentationModelAssembler extends RepresentationModelAssemblerSupport<PatientEntity, Patient>{

	private static final Logger log = LoggerFactory.getLogger(PatientRepresentationModelAssembler.class);

	private PatientService patientService;
	
	
	
	public PatientRepresentationModelAssembler(PatientService patientService) {
		super(PatientController.class, Patient.class);
		this.patientService = patientService;
	}


	@Override
	public Patient toModel(PatientEntity entity) {
		Patient resource = createModelWithId(entity.getIdPatient(), entity);
		BeanUtils.copyProperties(entity, resource);
		
		return resource;
	}

}
