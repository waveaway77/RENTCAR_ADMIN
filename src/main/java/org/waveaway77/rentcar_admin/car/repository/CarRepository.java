package org.waveaway77.rentcar_admin.car.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.waveaway77.rentcar_admin.car.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("SELECT p FROM Car p " +
            "WHERE ( p.category = :category )" +
            "AND (:model = '' OR p.model = :model) " +
            "AND (:company = '' OR p.company = :company) " +
            "AND (:prodYear = '' OR p.prodYear = :prodYear)")
    Page<Car> findByDynamicConditions(
            @Param("pageRequest") PageRequest pageRequest,
            @Param("category") String category,
            @Param("model") String model,
            @Param("company") String company,
            @Param("prodYear") String prodYear
            );
}
