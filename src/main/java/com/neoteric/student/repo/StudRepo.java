package com.neoteric.student.repo;

import com.neoteric.student.dto.Student;
import com.neoteric.student.entity.StudEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudRepo extends JpaRepository<StudEntity,Long> {
}
