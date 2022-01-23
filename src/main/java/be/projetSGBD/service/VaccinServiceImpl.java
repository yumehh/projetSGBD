package be.projetSGBD.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import be.projetSGBD.entity.CentreVaccinationEntity;
import be.projetSGBD.entity.VaccinEntity;
import be.projetSGBD.model.Vaccin;
import be.projetSGBD.repository.VaccinRepository;

@Service
public class VaccinServiceImpl implements VaccinService {
	
	public VaccinRepository vaccinRepo;
	
	private static final Logger log = LoggerFactory.getLogger(VaccinServiceImpl.class);
	
	
	public VaccinServiceImpl(VaccinRepository vaccinRepo) {
		super();
		this.vaccinRepo = vaccinRepo;
	}

	@Override
	public Optional<VaccinEntity> vaccinByIdVaccin(long idVaccin) {
		Optional<VaccinEntity> ve = vaccinRepo.findById(idVaccin);
		return ve;
	}

	@Override
	public Vaccin toModel(VaccinEntity ve) {
		Vaccin v = new Vaccin();
		v.idVaccin(ve.getIdVaccin())
			.nomVaccin(ve.getNomVaccin())
			.nbsJoursEntreDoses(ve.getNbsJoursEntreDoses())
			.numeroLot(ve.getNumeroLot())
			.idCentreVaccination(ve.getCentreVaccination().getIdCentreVaccination());
		return v;
	}

	@Override
	public VaccinEntity createVaccin(String nomVaccin, int dureeEntreDoses, int numeroLot, Long idCentre) {
		VaccinEntity ve = new VaccinEntity();
		CentreVaccinationEntity cve = new CentreVaccinationEntity();
		
		cve.setIdCentreVaccination(idCentre);
		ve.setNomVaccin(nomVaccin);
		ve.setNbsJoursEntreDoses(dureeEntreDoses);
		ve.setNumeroLot(numeroLot);
		ve.setCentreVaccination(cve);
		
		System.out.println(ve);
		System.out.println("idCentreVaccination : " + ve.getCentreVaccination().getIdCentreVaccination());
		
		return vaccinRepo.save(ve);
	}

	
	@Override
	public void deleteVaccin(long idVaccin) {
		this.vaccinRepo.deleteById(idVaccin);
		
	}

	@Override
	public VaccinEntity toEntity(Vaccin model) {
		VaccinEntity ve = new VaccinEntity();
		ve.setNomVaccin(model.getNomVaccin());
		ve.setNbsJoursEntreDoses(model.getNbsJoursEntreDoses());
		ve.setNumeroLot(model.getNumeroLot());
		return ve;
	}

/*
	@Override
	public VaccinEntity createVaccin(VaccinEntity ve, Long idCentre) {
		VaccinEntity entity = new VaccinEntity();
		CentreVaccinationEntity cve = new CentreVaccinationEntity();
		
		cve.setIdCentreVaccination(idCentre);
		ve.setCentreVaccination(cve);
		
		System.out.println(ve);
		System.out.println("idCentreVaccination : " + ve.getCentreVaccination().getIdCentreVaccination());
		
		return vaccinRepo.save(ve);
	}
*/
}
