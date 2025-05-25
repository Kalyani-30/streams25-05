package com.neoteric.student.callablepracties;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmpService service;
    @Autowired
    private EmpRepo empRepo;

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee saved = empRepo.save(employee);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) throws Exception {
        return service.getEmployeeById(id);
    }

    @GetMapping("/range")
    public List<Employee> getEmployeesInRange(@RequestParam int start, @RequestParam int end) throws Exception {
        return service.getAllInRange(start, end);
    }
}
