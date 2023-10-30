package com.schoolmanagement.school.repository;

import com.schoolmanagement.school.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findBySalaryGreaterThan(Double salary);

    List<Teacher> findByFirstName(String firstName);

}
