package com.bridgelabz.employeepayroll.repository;

import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  IEmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {
    EmployeePayrollData findEmployeesByDepartment();

    Object findEmployeesByDepartment(String department);
}
