package com.iu2java.pojo;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * d_dormitoryinfo
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dormitory implements Serializable {
    private Integer d_id;

    private Integer s_dormitoryid;

//    private String d_dormbuilding;

    private String d_bedtotal;

    private String d_bed;

    private String a_name;

    private List<Student> students;

    private static final long serialVersionUID = 1L;
}