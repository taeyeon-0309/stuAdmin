package com.iu2java.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DClass {
    private  Integer c_id;
    private  Integer c_classid;
    private  String  c_classname;
    private  String  c_counsellor;

    //班级与学生为一对多关系，使用链表
    private List<Student>  students;

    private static final long serialVersionUID = 1L;
}
