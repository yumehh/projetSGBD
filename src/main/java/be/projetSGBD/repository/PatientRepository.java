package be.projetSGBD.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.projetSGBD.entity.PatientEntity;

@Repository
public interface PatientRepository extends CrudRepository<PatientEntity, Long>{

}
