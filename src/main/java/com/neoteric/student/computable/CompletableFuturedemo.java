package com.neoteric.student.computable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFuturedemo {

    public static void main(String[] args) {

        // Asynchronously fetch employee
        CompletableFuture<Employee> empFuture = CompletableFuture.supplyAsync(() -> {
            simulateDelay("Fetching Employee");
            return new Employee(101, "kallu", "Engineering");
        });

        // Asynchronously fetch salary
        CompletableFuture<Salary> salFuture = CompletableFuture.supplyAsync(() -> {
            simulateDelay("Fetching Salary");
            return new Salary(101, 85000.00);
        });

        // Combine both results
        CompletableFuture<EmployeeProfile> profileFuture = empFuture.thenCombine(salFuture, (employee, salary) -> {
            return new EmployeeProfile(employee, salary);
        });

        // Display result once done
        profileFuture.thenAccept(profile -> profile.display());

        // Keep main thread alive
        sleep(5);
    }

    static void simulateDelay(String taskName) {
        try {
            System.out.println(taskName + "...");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds); // wait for all tasks to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

