package com.neoteric.student.callablepracties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.empId BETWEEN :start AND :end")
    List<Employee> findByIdRange(@Param("start") int start, @Param("end") int end);
}
