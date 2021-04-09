package com.iu2java.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;
    private  Integer a_id;
    private  String  a_username;

    @JsonIgnore
    private  String  a_password;

    private  String  a_name;
    private  Integer a_phone;

    @JsonIgnore
    private  Integer a_power;

    private  String  a_describe;
}
