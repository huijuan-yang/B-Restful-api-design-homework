package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.model.StudentRequestInfo;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping
    public List<Student> getStudentsByGender(@RequestParam(value = "gender") Gender gender) {
        return studentService.getStudentsByGender(gender);
    }

    @GetMapping(value = "/{id}")
    public List<Student> getStudentInfoById(@PathVariable Integer id) {
        return studentService.getStudentInfoById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody StudentRequestInfo studentRequestInfo) {
        studentService.addStudent(studentRequestInfo);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }
}
