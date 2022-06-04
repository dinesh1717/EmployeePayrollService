package com.bridgelabz.employeepayroll.service;


import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    private final List<EmployeePayrollData> empDataList = new ArrayList<>();

    {


    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return empDataList.get(empId - 1);
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(empDataList.size() + 1, employeePayrollDTO);
        empDataList.add(empData);
        

        return empData;
    }


    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.setName(empPayrollDTO.name);
        empData.setSalary(empPayrollDTO.salary);
        empDataList.set(empId - 1, empData);
        return empData;
    }

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {

        return empDataList;
    }
    @Override
    public void deleteEmployeePayrollData(int empId) {
        empDataList.remove(empId - 1);
    }

}






