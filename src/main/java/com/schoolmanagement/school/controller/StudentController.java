package com.schoolmanagement.school.controller;

import com.schoolmanagement.school.entity.Student;
import com.schoolmanagement.school.repository.StudentRepository;
import com.schoolmanagement.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(value = "/student/all")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @PostMapping("/student")
    public Student saveStudent(@Validated @RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PatchMapping("/student/{id}")
    public ResponseEntity<Object> updateStudent(@PathVariable(value = "id") Long id, @Validated @RequestBody Student student) {
        Optional<Student> studentFromDB = studentRepository.findById(id);
        if (!studentFromDB.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Student existingStudent = studentFromDB.get();
        if (student.getFirstName() != null) {
            existingStudent.setFirstName(student.getFirstName());
        }
        if (student.getLastName() != null) {
            existingStudent.setLastName(student.getLastName());
        }
        if (student.getAge() != null) {
            existingStudent.setAge(student.getAge());
        }
        Student savedStudent = studentRepository.save(existingStudent);
        return ResponseEntity.ok(savedStudent);
    }

    @DeleteMapping(value = "/student/{id}")
    public void deleteStudent1(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);
    }

    @GetMapping("/student/byage")
    public List<Student> findStudentByAge(@RequestParam Integer age) {
        return studentService.getStudentsWithAgeGreater(age);
    }


}


