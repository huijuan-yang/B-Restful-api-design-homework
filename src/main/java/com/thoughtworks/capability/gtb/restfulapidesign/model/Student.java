package com.thoughtworks.capability.gtb.restfulapidesign.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer id;
    private String name;
    private Gender gender;
    private String note;

    public Student (Integer id, StudentRequestInfo studentRequestInfo) {
        this.id = id;
        this.name = studentRequestInfo.getName();
        this.gender = studentRequestInfo.getGender();
        this.note = studentRequestInfo.getNote();
    }

}
