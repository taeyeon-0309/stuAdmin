package com.iu2java.dao;

import com.iu2java.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    /**
     * 进行分页查询
     */

    //获取总条数
    public Integer totalCount(@Param("s_name") String s_name, @Param("s_studentid")Integer s_studentid,
                              @Param("s_classid")Integer s_classid, @Param("s_classname")String s_classname);
    //获取用户列表
    public List<Student> getStudentList(@Param("s_name") String s_name, @Param("s_studentid")Integer s_studentid, @Param("s_classid")Integer s_classid,
                                        @Param("s_classname")String s_classname, @Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);
    public List<Student> getAll();

    //删除学生信息
    int deleteByPrimaryKey(Integer s_id);

    //添加学生信息
    int addStudent(Student student);

    //添加学生信息且每一列均不为空
    int insertSelective(Student record);

    //查找学生信息
    Student selectByPrimaryKey(Integer s_id);

    //通过student查找
    Student findStudent(Student student);

    //修改学生信息且均不为空
    int updateByPrimaryKeySelective(Student record);

    //修改学生信息
    int updateByPrimaryKey(Student record);
}