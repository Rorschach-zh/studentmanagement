package com.tujiao.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String studyid;
    private String name;
    private int sex;
    private int age;
    private Date birth;
    private String phone;
    private String address;
//    private String major;
}
