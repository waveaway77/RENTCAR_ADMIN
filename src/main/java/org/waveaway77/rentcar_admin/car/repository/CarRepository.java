package org.waveaway77.rentcar_admin.car.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.waveaway77.rentcar_admin.car.entity.Car;

import java.time.LocalDateTime;
import java.util.List;

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

    Page<Car> findByCategoryAndStatus(
            String category
            , String status
            , PageRequest pageRequest
    );

    @Transactional
    @Modifying
    @Query("UPDATE Car c SET c.category = :category" +
            ", c.prodYear = :prodYear" +
            ", c.company = :company" +
            ", c.model = :model" +
            ", c.updatedAt = :updatedAt" +
            " WHERE c.carId = :carId")
    void updateCarInfo(
            @Param("carId") int carId
            , @Param("category") String category
            , @Param("prodYear") String prodYear
            , @Param("company") String company
            , @Param("model") String model
            , @Param("updatedAt") LocalDateTime updatedAt
    );

    @Transactional
    @Modifying
    @Query("UPDATE Car c SET c.status = :status" +
            ", c.updatedAt = :updatedAt" +
            " WHERE c.carId = :carId")
    void updateCarStatus(
            @Param("carId") int carId
            , @Param("status") String status
            , @Param("updatedAt") LocalDateTime updatedAt
    );

}
