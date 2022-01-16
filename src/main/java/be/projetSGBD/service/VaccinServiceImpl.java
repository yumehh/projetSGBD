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
			.numeroLot(ve.getNumeroLot());
		return v;
	}

	@Override
	public VaccinEntity createVaccin(String nomVaccin, int dureeEntreDoses, int numeroLot) {
		VaccinEntity ve = new VaccinEntity();
		ve.setNomVaccin(nomVaccin);
		ve.setNbsJoursEntreDoses(dureeEntreDoses);
		ve.setNumeroLot(numeroLot);
		return this.vaccinRepo.save(ve);
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

	@Override
	public VaccinEntity createVaccin(VaccinEntity ve) {
		// TODO Auto-generated method stub
		return vaccinRepo.save(ve);
	}

}
