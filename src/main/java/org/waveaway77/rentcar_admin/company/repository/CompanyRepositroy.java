package org.waveaway77.rentcar_admin.company.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.waveaway77.rentcar_admin.company.entity.Company;
import org.waveaway77.rentcar_admin.company.entity.Company;

@Repository
public interface CompanyRepositroy extends CrudRepository<Company, Integer> {
}
