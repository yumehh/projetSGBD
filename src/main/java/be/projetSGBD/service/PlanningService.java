package be.projetSGBD.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import be.projetSGBD.entity.PlanningEntity;
import be.projetSGBD.model.Planning;

public interface PlanningService {

	public Optional<PlanningEntity> planningById(long idPlanning);
	
	public Planning toModel(PlanningEntity pe);
	
	public PlanningEntity createPlanning(Date dateRdv, Long idCentre);
	
	public PlanningEntity createPlanning(PlanningEntity pe);
	
	public void deletePlanning(long idPlanning);
	
	public PlanningEntity toEntity(Planning model);
	
	public List<Planning> toModelList(List<PlanningEntity> list);
}
