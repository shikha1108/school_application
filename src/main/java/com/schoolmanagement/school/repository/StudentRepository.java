package com.schoolmanagement.school.repository;

import com.schoolmanagement.school.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByAgeGreaterThan(int age);
}
