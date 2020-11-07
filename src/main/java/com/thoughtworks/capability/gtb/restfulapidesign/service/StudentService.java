package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.model.StudentRequestInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class StudentService {

    private Map<Integer, Student> studentMap = new HashMap<>();

    public StudentService() {
        studentMap.put(1, new Student(1, "Amy", Gender.FEMALE, ""));
        studentMap.put(2, new Student(2, "Bob", Gender.MALE, ""));
        studentMap.put(3, new Student(3, "Cathy", Gender.FEMALE, ""));
        studentMap.put(4, new Student(4, "Daniel", Gender.MALE, ""));
        studentMap.put(5, new Student(5, "Ella", Gender.FEMALE, ""));
        studentMap.put(6, new Student(6, "Franklin", Gender.MALE, ""));
        studentMap.put(7, new Student(7, "Gary", Gender.MALE, ""));
        studentMap.put(8, new Student(8, "Hannah", Gender.FEMALE, ""));
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(studentMap.values());
    }

    public void addStudent(StudentRequestInfo studentRequestInfo) {
        Integer addId = studentMap.size() + 1;
        studentMap.put(addId, new Student(addId, studentRequestInfo));
    }

    public void deleteStudent(Integer id) {
        studentMap.remove(id);
    }

    public List<Student> getStudentsByGender(Gender gender) {
//        List<Student> studentsListByGender = new ArrayList<>();
//        for (Student student : studentMap.values()) {
//            if (student.getGender() == gender) {
//                studentsListByGender.add(student);
//            }
//        }
//
//        return studentsListByGender;
        return studentMap.values().stream().filter(student ->
                student.getGender() == gender).collect(Collectors.toList());
    }
}
