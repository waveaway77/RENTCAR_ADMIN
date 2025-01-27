package org.waveaway77.rentcar_admin.category.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.waveaway77.rentcar_admin.category.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "select c.value from Category c")
    String[] findCategory();
}