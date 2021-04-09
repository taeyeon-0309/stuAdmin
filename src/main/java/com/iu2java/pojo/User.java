package com.iu2java.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * d_user
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private Integer u_id;

    private Integer u_studentid;

    private String u_username;
    
    private String u_password;

    private static final long serialVersionUID = 1L;
}