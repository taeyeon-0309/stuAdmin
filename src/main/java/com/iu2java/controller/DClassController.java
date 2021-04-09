package com.iu2java.controller;

import com.iu2java.pojo.DClass;
import com.iu2java.pojo.PageInfo;
import com.iu2java.service.DClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户控制器类
 */
@Slf4j
@Controller
public class DClassController {
	// 依赖注入
	@Autowired
	private DClassService dcService;

	/**
	 * 分页查询
	 * pageIndex 当前页码
	 * pageSize  显示条数
	 */
	@RequestMapping(value = "/findClass")
	public String findClass(Integer c_classid, String c_classname, String c_counsellor,
							Integer pageIndex, Integer pageSize, Model model) {

	  PageInfo<DClass> ci = dcService.findPageInfo(c_classname,c_counsellor,
			  c_classid,pageIndex,pageSize);
	  model.addAttribute("ci",ci);
	  model.addAttribute("c_classid",c_classid);
		return "class_list";
	}

	/**
	 * 导出Excel
	 */
	@RequestMapping(value = "/exportclasslist", method = RequestMethod.POST)
	@ResponseBody
	public List<DClass> exportClass(){
		List<DClass> classList = dcService.getAll();
		return classList;
	}

	/**
	 * 删除学生信息
	 */
	@RequestMapping( "/deleteClass")
	@ResponseBody
	public String deleteClass(Integer c_id) {
		int c = dcService.deleteClass(c_id);
		return "class_list";
	}

	/**
	 * 添加班级信息
	 */
	@RequestMapping(value = "/addClass" ,method = RequestMethod.POST)
	@ResponseBody
	public String addClass( @RequestBody DClass uclass) {
		int c = dcService.addClass(uclass);
//		log.info("c:"+c);
		return "class_list";
	}

	@RequestMapping( "/findClassById")
	public String findClassById(Integer c_id, HttpSession session) {
		DClass c= dcService.findClassById(c_id);
		session.setAttribute("c",c);
		return "class_edit";
	}

	/**
	 * 修改班级信息
	 */
	@RequestMapping(value = "/updateClass" ,method = RequestMethod.POST)

	public String updateClass( DClass uclass) {
		int c = dcService.updateClass(uclass);
		return "redirect:/findClass";
	}

	/**
	 * 班级人员信息查询
	 */
	@GetMapping(value = "/findClassStudent")
	public String toFinfPage(){
		return "class_Studentlist";
	}

	@PostMapping(value = "/findClassStudent")
	public String findClassStudent(@RequestParam(value = "c_classid",required = false) Integer c_classid,@RequestParam(value = "c_classname",required = false) String c_classname, Model model) {
		System.out.printf("name="+c_classname+"id="+c_classid);
		DClass dclass = new DClass();
		dclass.setC_classid(c_classid);
		dclass.setC_classname(c_classname);
		List<DClass> c = dcService.findClassStudent(dclass);
		log.info(c.toString());
		model.addAttribute("cs",c);
		return "class_Studentlist";
	}

}
