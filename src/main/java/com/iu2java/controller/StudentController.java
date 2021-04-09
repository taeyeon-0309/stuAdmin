package com.iu2java.controller;

import com.iu2java.pojo.PageInfo;
import com.iu2java.pojo.Student;
import com.iu2java.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户控制器类
 */
@Controller
@Slf4j
public class StudentController {
	// 依赖注入
	@Autowired
	private StudentService studentService;

	/**
	 * 分页查询
	 * pageIndex 当前页码
	 * pageSize  显示条数
	 */
	@RequestMapping(value = "/findStudent")
	public String findStudent(String s_name, Integer s_studentid,Integer s_classid, String s_classname,
							  Integer pageIndex, Integer pageSize, Model model) {

	  PageInfo<Student> pi = studentService.findPageInfo(s_name,s_studentid,s_classid,
			  					s_classname,pageIndex,pageSize);
	  model.addAttribute("pi",pi);
	  model.addAttribute("s_name",s_name);
		return "student_list";
	}

	/**
	 * 导出Excel
	 */
	@RequestMapping(value = "/exportstudentlist", method = RequestMethod.POST)
	@ResponseBody
	public List<Student> exportStudent(){
		List<Student> studentList = studentService.getAll();
		return studentList;
	}

	/**
	 * 删除学生信息
	 */
	@RequestMapping( "/deleteStudent")
	@ResponseBody
	public String deleteStudent(Integer s_id) {
		studentService.deleteByPrimaryKey(s_id);
		return "student_list";
	}

/**
 * 添加学生信息
 */

   @RequestMapping(value = "/addStudent" ,method = RequestMethod.POST)
   @ResponseBody
   public String addStudent(@RequestBody Student student) {
	    studentService.addStudent(student);
	    return "student_list";
    }

	/**
	 * 修改学生信息
	 */
	@RequestMapping(value = "/updateStudent" ,method = RequestMethod.POST )
	public String updateStudent( Student student) {
		studentService.updateByPrimaryKey(student);
		return "redirect:/findStudent";
	}

	@RequestMapping(value = "/changeInfo2", method = RequestMethod.GET)
	public String toChangePage(){
		return "changeInfo";
	}

	@RequestMapping(value = "/changeInfo2", method = RequestMethod.POST)
	public String changeInfo(Student student, HttpSession session) {
		studentService.updateByPrimaryKey(student);
		session.setAttribute("st1",student);
		return "redirect:/changeInfo2";
	}

	/**
	 * 查找学生信息
	 */
    @RequestMapping( "/findStudentById")
    public String findStudent(Integer s_id, HttpSession session) {

        Student s= studentService.selectByPrimaryKey(s_id);
        session.setAttribute("s",s);
        return "student_edit";
    }
}
