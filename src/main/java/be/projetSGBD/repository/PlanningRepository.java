package be.projetSGBD.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.projetSGBD.entity.PlanningEntity;

@Repository
public interface PlanningRepository extends CrudRepository<PlanningEntity, Long>{

}
