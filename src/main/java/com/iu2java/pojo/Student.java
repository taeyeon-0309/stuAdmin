package com.iu2java.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * d_student
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    private  Integer s_id;
    private  Integer s_studentid;
    private  String  s_name;
    private  String  s_sex;
    private  Integer  s_age;
    private  Integer  s_phone;
    private  Integer  s_classid;
    private  String s_classname;
    private  Integer  s_dormitoryid;

    private static final long serialVersionUID = 1L;
}