package com.neoteric.student.callablepracties;



import java.util.List;
import java.util.concurrent.Callable;

public class SalaryCreditorRangeTask implements Callable<List<Employee>> {

    private final int startId;
    private final int endId;
    private final EmpRepo repository;

    public SalaryCreditorRangeTask(int startId, int endId, EmpRepo repository) {
        this.startId = startId;
        this.endId = endId;
        this.repository = repository;
    }

    @Override
    public List<Employee> call() throws Exception {
        return repository.findByIdRange(startId, endId);
    }
}
