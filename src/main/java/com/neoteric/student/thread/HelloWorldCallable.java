package com.neoteric.student.thread;

import java.util.concurrent.Callable;

public class HelloWorldCallable implements Callable<Employee> {

    private  String name;

    private  DBService dbService;
    public HelloWorldCallable(String name,DBService dbService){
        this.name = name;
        this.dbService = dbService;
    }
    @Override
    public Employee call() throws Exception {
        return dbService.getEmployee(name);
    }
}