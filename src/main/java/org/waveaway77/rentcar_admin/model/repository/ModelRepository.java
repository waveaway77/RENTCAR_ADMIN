package org.waveaway77.rentcar_admin.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.waveaway77.rentcar_admin.model.entity.Model;
import org.waveaway77.rentcar_admin.model.entity.Model;

@Repository
public interface ModelRepository extends CrudRepository<Model, Integer> {
}
