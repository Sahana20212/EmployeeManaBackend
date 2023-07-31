package com.ecomm.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomm.employee.entity.EmployeeEntity;
@Repository
public interface EmployeeRepository  extends JpaRepository<EmployeeEntity, Long>{

}
