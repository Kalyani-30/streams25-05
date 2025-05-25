package com.neoteric.student.thread;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBService {

    private static Map<String, Employee> employeeMap = new HashMap<>();


    static {
        addEmployee();

    }


    public static void addEmployee() {
        for (int i = 0; i < 1800; i++) {
            employeeMap.put("Neo " + i, new Employee("Neo " + i, 1000 + i, "Neo " + i));
        }
    }


    public static Collection<Employee> getEmployeList() {

        return employeeMap.values();


    }

    public Employee getEmployee(String id) {


        return employeeMap.get(id);
    }
}