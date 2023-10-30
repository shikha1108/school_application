package com.schoolmanagement.school.service;

import com.schoolmanagement.school.entity.Teacher;
import com.schoolmanagement.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    public List<Teacher> getTeachersWithSalaryGreater(Double salary) {
        return teacherRepository.findBySalaryGreaterThan(salary);
    }

    public List<Teacher> getTeachersByFirstName(String firstName) {
        return teacherRepository.findByFirstName(firstName);
    }

}
