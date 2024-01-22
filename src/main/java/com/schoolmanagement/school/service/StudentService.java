package com.schoolmanagement.school.service;

import com.schoolmanagement.school.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudent();

    public Student saveStudent(Student student);

    public void deleteStudentById(Long id);

    public List<Student> getStudentsWithAgeGreater(Integer age);

}
