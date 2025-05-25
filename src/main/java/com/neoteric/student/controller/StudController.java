package com.neoteric.student.controller;

import com.neoteric.student.dto.Student;
import com.neoteric.student.service.StudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudController {
@Autowired
    StudService studService;

@PostMapping( "/save-student")
public void postStudent(@RequestBody Student studentdto){
   studService.saveStudent(studentdto);

}
    @PostMapping("/save-teacher")
public void postTeacher(){
        System.out.println("hello from teacher method");
}

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

}
