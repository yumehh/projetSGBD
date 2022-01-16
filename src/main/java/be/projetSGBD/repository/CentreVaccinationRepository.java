package be.projetSGBD.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.projetSGBD.entity.CentreVaccinationEntity;

@Repository
public interface CentreVaccinationRepository extends CrudRepository<CentreVaccinationEntity, Long>{

}
