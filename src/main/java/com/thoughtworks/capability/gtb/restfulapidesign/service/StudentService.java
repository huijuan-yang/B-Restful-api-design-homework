package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.model.StudentRequestInfo;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class StudentService {

    private Map<Integer, Student> studentMap = new HashMap<>();
    private Map<Integer, Group> groupMap = new HashMap<>();

    public StudentService() {
        studentMap.put(1, new Student(1, "Amy", Gender.FEMALE, ""));
        studentMap.put(2, new Student(2, "Bob", Gender.MALE, ""));
        studentMap.put(3, new Student(3, "Cathy", Gender.FEMALE, ""));
        studentMap.put(4, new Student(4, "Daniel", Gender.MALE, ""));
        studentMap.put(5, new Student(5, "Ella", Gender.FEMALE, ""));
        studentMap.put(6, new Student(6, "Franklin", Gender.MALE, ""));
        studentMap.put(7, new Student(7, "Gary", Gender.MALE, ""));
        studentMap.put(8, new Student(8, "Hannah", Gender.FEMALE, ""));

        groupMap.put(1, new Group(1, "Group 1", "", new ArrayList<Student>()));
        groupMap.put(2, new Group(2, "Group 2", "", new ArrayList<Student>()));
        groupMap.put(3, new Group(3, "Group 3", "", new ArrayList<Student>()));
        groupMap.put(4, new Group(4, "Group 4", "", new ArrayList<Student>()));
        groupMap.put(5, new Group(5, "Group 5", "", new ArrayList<Student>()));
        groupMap.put(6, new Group(6, "Group 6", "", new ArrayList<Student>()));
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
        return studentMap.values().stream().filter(student ->
                student.getGender() == gender).collect(Collectors.toList());
    }

    public List<Student> getStudentInfoById(Integer id) {
        return studentMap.values().stream().filter(student ->
                student.getId() == id).collect(Collectors.toList());
    }

    public void updateStudentInfo(Integer id, Student student) {
        studentMap.put(id, student);
    }

    public List<Group> getAllGroupsStudents() {
        return new ArrayList<>(groupMap.values());
    }

    public List<Group> getGroupInfoByGroupId(Integer groupId) {
        return groupMap.values().stream().filter(group ->
                group.getGroupId() == groupId).collect(Collectors.toList());
    }

    public List<Group> shuffleStudents() {
        List keys = new ArrayList(studentMap.keySet());
        Collections.shuffle(keys);
        int groupNumber = 1;
        for (Object o : keys) {
            if (groupNumber > 6) {
                groupNumber = 1;
            }
            groupMap.get(groupNumber).getGroupStudents().add(studentMap.get(o));
            groupNumber++;

        }
        return getAllGroupsStudents();
    }
}
