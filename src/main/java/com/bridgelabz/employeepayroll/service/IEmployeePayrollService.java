package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;

import java.time.LocalDate;
import java.util.List;


public interface IEmployeePayrollService {
    List<EmployeePayrollData> getEmployeePayrollData();


    EmployeePayrollData getEmployeePayrollDataById(int empId);

    List<EmployeePayrollData> getEmployeesPayrollDataByDepartment(String department);

    List<EmployeePayrollData> getEmployeePayrollDataBySalary(long salary);

    List<EmployeePayrollData> getEmployeePayrollDataByGender(String gender);

    List<EmployeePayrollData> getEmployeePayrollDataByStartDate(LocalDate startDate);


    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);

    EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO);

    void deleteEmployeePayrollData(int empId);
}



