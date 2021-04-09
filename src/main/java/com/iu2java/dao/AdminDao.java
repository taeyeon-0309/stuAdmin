package com.iu2java.dao;

import com.iu2java.pojo.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDao {
    /**
     * 通过账号和密码查询管理员
     */
    Admin adminLogin(String username, String password);

    Admin findAdmin(Admin admin);

    /**
     * 进行分页查询
     */

    //获取总条数
    Integer totalCount(@Param("a_username") String a_username, @Param("a_describe") String a_describe, @Param("a_id") Integer a_id);
    //获取用户列表
    List<Admin> getAdminList(@Param("a_username") String a_username, @Param("a_describe") String a_describe, @Param("a_id") Integer a_id, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    int addAdmin(Admin admin);    //添加管理员信息
    int deleteAdmin(Integer a_id);   //删除管理员信息
    int updateAdmin(Admin admin); //修改管理员信息
    Admin findAdminById(Integer a_id);
    List<Admin> getAll();
}
