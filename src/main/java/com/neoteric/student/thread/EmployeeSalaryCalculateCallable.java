package com.neoteric.student.thread;

import java.util.List;
import java.util.concurrent.Callable;

public class EmployeeSalaryCalculateCallable implements Callable<String> {

    List<Employee> employeeList;

    DBService dbService;

    public EmployeeSalaryCalculateCallable(List<Employee> employeeList,
                                           DBService dbService) {

        this.employeeList = employeeList;
        this.dbService = dbService;
    }

    public String call() {
        String status = "Failure";
        try {
            System.out.println("Enter into calculate salary");
            for (int i = 0; i < employeeList.size(); i++) {
                Employee emp = employeeList.get(i);
                Employee dbEmp = dbService.getEmployee(emp.getId());
                double salary = dbEmp.getSal() + 10000;
                System.out.println("Thread name "+Thread.currentThread().getName()+"   "+dbEmp.getId()+"     Employee salary " + salary);
            }
            System.out.println("Exit from Calculate salary");
            status = "Success";
        } catch (Exception e) {
            System.out.println(" Exception occurred while calculating salary");
        }
        return status;
    }
}