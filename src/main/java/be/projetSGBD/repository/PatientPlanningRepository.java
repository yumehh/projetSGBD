package be.projetSGBD.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.projetSGBD.entity.PatientPlanningEntity;

@Repository
public interface PatientPlanningRepository extends CrudRepository<PatientPlanningEntity, Long>{

}
