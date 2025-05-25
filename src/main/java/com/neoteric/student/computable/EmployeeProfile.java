package com.neoteric.student.computable;

public class EmployeeProfile {
    private Employee employee;
    private  Salary salary;

    public EmployeeProfile(Employee employee, Salary salary) {
        this.employee = employee;
        this.salary = salary;
    }

    public void display() {
        System.out.println("Employee Profile:");
        System.out.println("Name: " + employee.name);
        System.out.println("Department: " + employee.department);
        System.out.println("Salary: $" + salary.amount);
    }
}
