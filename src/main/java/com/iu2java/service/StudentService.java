package com.iu2java.service;


import com.iu2java.pojo.PageInfo;
import com.iu2java.pojo.Student;

import java.util.List;

/**
 * 用户Service层接口
 * @author 1
 */
public interface StudentService {

	//分页查询
	PageInfo<Student> findPageInfo(String s_name, Integer s_studentid, Integer s_classid,
										  String s_classname, Integer pageIndex, Integer pageSize);

	int deleteByPrimaryKey(Integer s_id);   //通过id删除学生信息
	int addStudent(Student student);   //添加学生信息
	int updateByPrimaryKey(Student student); //修改学生信息
	Student selectByPrimaryKey(Integer s_id);
	Student findStudent(Student student);
	List<Student> getAll();

}
