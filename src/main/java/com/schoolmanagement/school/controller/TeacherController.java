package com.schoolmanagement.school.controller;

import com.schoolmanagement.school.entity.Teacher;
import com.schoolmanagement.school.repository.TeacherRepository;
import com.schoolmanagement.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping(value = "/teacher/all")
    public List<Teacher> getAllTeacher() {
        return teacherService.getAllTeacher();
    }

    @PostMapping("/teacher")
    public Teacher addTeacher(@Validated @RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    @DeleteMapping(value = "/teacher/{id}")
    public void deleteTeacher(@PathVariable("id") Long id) {
        teacherService.deleteTeacher(id);
    }

    @PatchMapping(value = "/teacher/all")
    public ResponseEntity<Object> updatePartiallyData(@PathVariable("id") Long id, @Validated @RequestBody Teacher teacher) {
        Optional<Teacher> teacherFromDB = teacherRepository.findById(id);
        if (teacherFromDB.isPresent()) {
            ResponseEntity.notFound().build();
        }
        Teacher existingTeacher = teacherFromDB.get();
        if (existingTeacher.getFirstName() == null) {
            existingTeacher.setFirstName(teacher.getFirstName());
        }

        if (existingTeacher.getLastName() == null) {
            existingTeacher.setLastName(teacher.getLastName());
        }

        Teacher saveTeacher = teacherRepository.save(existingTeacher);
        return ResponseEntity.ok(saveTeacher);
    }

    @GetMapping("/teacher/bysalary")
    public List<Teacher> fundTeacherBySalary(@RequestParam Double salary) {
        return teacherService.getTeachersWithSalaryGreater(salary);
    }

    @GetMapping("/teacher/FirstName")
    public ResponseEntity<List<Teacher>> getTeachersByFirstName(@RequestParam String firstName) {
        List<Teacher> teachers = teacherService.getTeachersByFirstName(firstName);

        if (teachers.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(teachers);
        }
    }
}
