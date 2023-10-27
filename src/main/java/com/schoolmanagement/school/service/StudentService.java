package com.schoolmanagement.school.service;

import com.schoolmanagement.school.entity.Student;
import com.schoolmanagement.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
    public List<Student> getStudentsWithAgeGreaterThan20() {
        return studentRepository.findByAgeGreaterThan(20);
    }
}
