package com.neoteric.student.callablepracties;


import com.neoteric.student.callablepracties.EmpRepo;
import com.neoteric.student.callablepracties.Employee;
import com.neoteric.student.callablepracties.EmployeeCallable;
import com.neoteric.student.callablepracties.SalaryCreditorRangeTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Service
public class EmpService {

    @Autowired
    private EmpRepo repository;

    private final ExecutorService executor = Executors.newFixedThreadPool(5);

    public Employee getEmployeeById(int empId) throws Exception {
        Future<Employee> future = executor.submit(new EmployeeCallable(empId, repository));
        return future.get();
    }

    public List<Employee> getAllInRange(int start, int end) throws Exception {
        List<Future<List<Employee>>> futures = new ArrayList<>();
        int batchSize = 20;

        for (int i = start; i <= end; i += batchSize) {
            int batchEnd = Math.min(i + batchSize - 1, end);
            SalaryCreditorRangeTask task = new SalaryCreditorRangeTask(i, batchEnd, repository);
            futures.add(executor.submit(task));
        }

        List<Employee> allEmployees = new ArrayList<>();
        for (Future<List<Employee>> f : futures) {
            allEmployees.addAll(f.get());
        }

        return allEmployees;
    }
}
