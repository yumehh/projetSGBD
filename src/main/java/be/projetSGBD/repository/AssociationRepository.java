package be.projetSGBD.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.projetSGBD.entity.AssociationEntity;

@Repository
public interface AssociationRepository extends CrudRepository<AssociationEntity, Long>{

}
