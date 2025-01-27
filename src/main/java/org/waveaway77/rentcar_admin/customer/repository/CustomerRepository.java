package org.waveaway77.rentcar_admin.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.waveaway77.rentcar_admin.customer.entity.Customer;
import org.waveaway77.rentcar_admin.customer.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
