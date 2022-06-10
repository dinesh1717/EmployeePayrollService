package com.bridgelabz.employeepayroll.controllers;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayroll.dto.ResponseDTO;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
import com.bridgelabz.employeepayroll.service.IEmployeePayrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@Slf4j
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;
    /**
     * Method :- Method to Get the Employee Payroll Data.
     *
     * @return :- Returning ResponseDTO Object.
     */
    @RequestMapping(value= {"","/","get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
        List<EmployeePayrollData> empDataList =null;
        empDataList =employeePayrollService.getEmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success",empDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     * Method :- Method to Get the Employee Payroll Data Using Employee ID.
     *
     * @param employeeId :- passing Employee Id As Input
     * @return :- Returning ResponseDTO Object.
     */
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int employeeId){
        EmployeePayrollData payrollData=null;
        payrollData=employeePayrollService.getEmployeePayrollDataById(employeeId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success for id:", payrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     * Method :- Method to Get the Employee Payroll Data Using Department.
     *
     * passing Department As Input
     * @return :- Returning ResponseDTO Object.
     */

    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDTO> getEmployeeByDepartment(@PathVariable("department") String department) {

        List<EmployeePayrollData> employeeList = null;
        employeeList = employeePayrollService.getEmployeesPayrollDataByDepartment(department);
        ResponseDTO response = new ResponseDTO("Get Call for Department Successful", employeeList);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    /**
     * Method :- Method to Create the Employee Payroll Data.
     *
     * @param employeePayrollDTO :- passing employeePayrollDTO As Input.
     * @return :-  Returning ResponseDTO Object.
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData payrollData=null;
        payrollData=employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee payroll data for:", payrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     * Method :- Method to Update the Employee Payroll Data.
     *
     * @param employeePayrollDTO :- passing employeePayrollDTO As Input.
     * @return :-  Returning ResponseDTO Object.
     */
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@Valid @PathVariable("empId") int empId,@RequestBody EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData payrollData=null;
        payrollData=employeePayrollService.updateEmployeePayrollData(empId,employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee payroll Data for: ", payrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     * Method :- Method to Delete the Employee Payroll Data.
     *
     * @param empId :- passing Employee Id As Input.
     * @return Returning ResponseDTO Object.
     */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO responseDTO = new ResponseDTO("Delete Call Success for id: ", "empId "+empId);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}