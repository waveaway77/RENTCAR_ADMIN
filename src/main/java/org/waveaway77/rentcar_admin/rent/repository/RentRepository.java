package org.waveaway77.rentcar_admin.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.waveaway77.rentcar_admin.rent.entity.Rent;
import org.waveaway77.rentcar_admin.rent.entity.Rent;

@Repository
public interface RentRepository extends JpaRepository<Rent, Integer> {

    @Query(value = "SELECT r.status " +
            "FROM Rent r " +
            "WHERE r.car_id = :carId " +
            "ORDER BY r.rent_start_dt DESC " +
            "LIMIT 1",
            nativeQuery = true)
    String selectStatusByCarId(int carId);
}
