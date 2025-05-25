package com.neoteric.student.callablepracties;


import java.util.concurrent.Callable;

public class EmployeeCallable implements Callable<Employee> {

        private final int empId;
        private final EmpRepo repository;

        public EmployeeCallable(int empId, EmpRepo repository) {
            this.empId = empId;
            this.repository = repository;
        }

        @Override
        public Employee call() throws Exception {
            return repository.findById(empId).orElse(null);
        }
    }


