package com.neoteric.student.callablepracties;

import jakarta.persistence.*;

@Entity
@Table(name = "emptable") // Maps to the MySQL table `emptable`
public class Employee {

    @Id
    @Column(name = "empId")
    private int empId;

    @Column(name = "empname")
    private String empName;

    @Column(name = "salary")
    private double salary;

    public Employee() {
    }

    public Employee(int empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
