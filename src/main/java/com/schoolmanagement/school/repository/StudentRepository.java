package com.schoolmanagement.school.repository;

import com.schoolmanagement.school.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {
    //create method to get all students whose age is greater than 20.
//    public default List<Student> getAllStudentByAge(List<Student> students) {
//        List<Student> newList = new ArrayList<>();
//        for(Student student : students) {
//            if(student.getAge() > 20) {
//                newList.add(student);
//            }
//        }
//        return newList;
//
//    }
    List<Student> findByAgeGreaterThan(int age);
}
