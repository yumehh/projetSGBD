package be.projetSGBD;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import be.projetSGBD.repository.CentreVaccinationRepository;
import be.projetSGBD.repository.PatientRepository;
import be.projetSGBD.repository.VaccinRepository;


@SpringBootTest
class ProjetSgbdApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(ProjetSgbdApplicationTests.class);

	@Autowired
	PatientRepository patientRepo;
	
	@Autowired
	VaccinRepository vaccinRepo;
	
	@Autowired
	CentreVaccinationRepository centreRepo;
	
	@Test
	void contextLoads() {
	}
	
	
	@Test
	void testDB(){
		patientRepo.findAll().forEach(s -> {
			log.info("nomFamille : " + s.getNomFamille());

			
		});
	}
	
	@Test
	void testGetVaccin() {
		vaccinRepo.findAll().forEach(s ->{
			log.info("getVaccin : " + s.getNomVaccin());
		});
	}
	
	
	
	@Test
	void testCentre() {
		centreRepo.findAll().forEach(e ->{
			log.info("localité : " + e.getLocalite());
		});
	}
}
