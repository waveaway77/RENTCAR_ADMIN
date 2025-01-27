package org.waveaway77.rentcar_admin.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.waveaway77.rentcar_admin.rent.entity.Rent;
import org.waveaway77.rentcar_admin.rent.entity.Rent;

@Repository
public interface RentRepository extends JpaRepository<Rent, Integer> {
}
