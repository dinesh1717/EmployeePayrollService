package com.bridgelabz.employeepayroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public @ToString class EmployeePayrollDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name is Invalid")
    @NotEmpty(message = "Employee name can't be null")
    public String name;
    @Min(value = 500, message = "Min wage should be more than 500")
    public long salary;
    @JsonFormat(pattern = "dd MM yyyy")
    @NotNull(message = "Startdate should not be empty")
    @PastOrPresent(message = "startDate shuld be past or todays date")
    public LocalDate startDate;

    @Pattern(regexp = "male|female", message = " Gender  needs to be male or female")
    public String gender;

    @NotBlank(message = "Note can not be empty")
    public String note;

    @NotBlank(message = "profilePic can not be empty")
    public String profilePic;

    @NotNull(message = "department should not be empty")
    public List<String> departments;
}


