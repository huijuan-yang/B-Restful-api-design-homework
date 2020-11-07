package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Group;
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

    @PutMapping(value = "/{id}")
    public void updateStudentInfo(@PathVariable Integer id, @RequestBody Student student) {
        studentService.updateStudentInfo(id, student);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }

    @GetMapping(value = "/groups")
    public List<Group> getAllGroupsStudents() {
        return studentService.getAllGroupsStudents();
    }

    @GetMapping(value = "/groups/{groupId}")
    public List<Group> getGroupInfoByGroupId(@PathVariable Integer groupId) {
        return studentService.getGroupInfoByGroupId(groupId);
    }

    @GetMapping(value = "/group-students")
    public List<Group> getGroupStudents() {
        return studentService.shuffleStudents();
    }

    @PutMapping(value = "/groups/{groupId}")
    public void updateGroupName(@PathVariable Integer groupId, @RequestBody String groupName) {
        studentService.updateGroupName(groupId, groupName);
    }
}
