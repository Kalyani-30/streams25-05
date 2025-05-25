package com.neoteric.student.service;

import com.neoteric.student.dto.Student;
import com.neoteric.student.entity.StudEntity;
import com.neoteric.student.repo.StudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudService {
  @Autowired
  StudRepo studRepo;

  public  void saveStudent(Student studentDto){
    StudEntity studEntity= new StudEntity();
    studEntity.setName(studentDto.getName());
    studEntity.setAddress(studentDto.getAddress());
    studEntity.setPhoneNo(studentDto.getPhoneNo());
    studEntity.setEmail(studentDto.getEmail());
    studRepo.save(studEntity);
}

  public Student getStudentById(Long id) {
    StudEntity entity = studRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Student not found"));

    Student student = new Student();
    student.setName(entity.getName());
    student.setAddress(entity.getAddress());
    student.setPhoneNo(entity.getPhoneNo());
    student.setEmail(entity.getEmail());

    return student;
  }


  }


