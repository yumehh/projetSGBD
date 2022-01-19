package be.projetSGBD.service;

import java.util.Optional;

import be.projetSGBD.entity.CentreVaccinationEntity;
import be.projetSGBD.entity.VaccinEntity;
import be.projetSGBD.model.Vaccin;

public interface VaccinService {

	public Optional<VaccinEntity> vaccinByIdVaccin(long idVaccin);
	
	Vaccin toModel(VaccinEntity ve);
	
	public VaccinEntity createVaccin(String nomVaccin, int dureeEntreDoses, int numeroLot, Long idCentre);
	
	public void deleteVaccin(long idVaccin);
	
	public VaccinEntity toEntity(Vaccin model);
	
	//public VaccinEntity createVaccin(VaccinEntity ve);

}
