package com.iu2java.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 1
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DormRepair implements Serializable {
    private Integer r_id;

    private Integer d_id;

//    private String d_dormbuilding;

    private String r_name;

    private String reason;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date create_time;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date update_time;

    private static final long serialVersionUID = 1L;
}