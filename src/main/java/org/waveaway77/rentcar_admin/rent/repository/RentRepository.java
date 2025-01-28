package org.waveaway77.rentcar_admin.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.waveaway77.rentcar_admin.rent.entity.Rent;
import org.waveaway77.rentcar_admin.rent.entity.Rent;

@Repository
public interface RentRepository extends JpaRepository<Rent, Integer> {

    @Query("SELECT r.status FROM Rent r WHERE r.carId = :carId")
    String findByCarId(int carId);
}
