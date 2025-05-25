package com.neoteric.student.thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        DBService dbService = new DBService();
        String name = "Neo";

        Collection<Employee> list = DBService.getEmployeList();

        List<Employee> employeeList = new ArrayList<>(list);

        int empSize = list.size();

        System.out.println("Employee size " + empSize);

        int batchSize = 300;


        int counter = empSize / batchSize;
        ExecutorService service = Executors.newFixedThreadPool(counter);

        List<EmployeeSalaryCalculateCallable> salaryCalculateCallables = new ArrayList<>();
        for (int i = 0; i < counter; i++) {

            List<Employee> subList = employeeList.subList(i * batchSize, (i * batchSize) + batchSize);
            EmployeeSalaryCalculateCallable employeeCallable =
                    new EmployeeSalaryCalculateCallable(subList,
                            dbService);

            salaryCalculateCallables.add(employeeCallable);


        }


        List<Future<String>> listempSalaryFuture = service.invokeAll(salaryCalculateCallables);


        for (int i = 0; i < listempSalaryFuture.size(); i++) {
            Future<String> futureResult = listempSalaryFuture.get(i);

            String callableResult = futureResult.get();

            System.out.println(callableResult);
        }


    }
}