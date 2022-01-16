package be.projetSGBD.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.projetSGBD.entity.VaccinEntity;

@Repository
public interface VaccinRepository extends CrudRepository<VaccinEntity, Long>{

}
