package com.iu2java.dao;

import com.iu2java.pojo.DClass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 管理员DAO层接口
 */
public interface DClassDao {
	/**
	 * 进行分页查询
	 */

	//获取总条数
	Integer totalCount(@Param("c_classname") String c_classname, @Param("c_classid") Integer c_classid, @Param("c_counsellor") String c_counsellor);
	//获取用户列表
	List<DClass> getClassList(@Param("c_classname") String c_classname, @Param("c_classid") Integer c_classid, @Param("c_counsellor") String c_counsellor, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

	int deleteClass(Integer c_id);   //删除班级信息
	int addClass(DClass ucalss);    //添加班级信息
	int updateClass(DClass uclass); //修改班级信息
	DClass findClassById(Integer c_id);
	List<DClass> findClassStudent(DClass uclass);//查询班级人员信息,返回类型为class和student的拼接
	List<DClass> getAll();
}
