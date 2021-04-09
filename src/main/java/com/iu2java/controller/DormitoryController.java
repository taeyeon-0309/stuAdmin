package com.iu2java.controller;

import com.iu2java.pojo.Dormitory;
import com.iu2java.pojo.PageInfo;
import com.iu2java.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户控制器类
 */
@Controller
public class DormitoryController {
	// 依赖注入
	@Autowired
	private DormitoryService dormitoryService;

	/**
	 * 分页查询
	 * pageIndex 当前页码
	 * pageSize  显示条数
	 */
	@RequestMapping(value = "/findDormitory")
	public String findDormitory(String a_name,Integer s_dormitoryid,
								Integer pageIndex, Integer pageSize, Model model) {

	  PageInfo<Dormitory> di = dormitoryService.findPageInfo(a_name,s_dormitoryid, pageIndex,pageSize);
	  model.addAttribute("di",di);
		return "dormitory_list";
	}

	/**
	 * 导出Excel
	 */
	@RequestMapping(value = "/exportdormitorylist", method = RequestMethod.POST)
	@ResponseBody
	public List<Dormitory> exportDormitory(){
		List<Dormitory> dormitoryList = dormitoryService.getAll();
		return dormitoryList;
	}

	/**
	 * 添加宿舍信息
	 */
	@RequestMapping(value = "/addDormitory" ,method = RequestMethod.POST)
	@ResponseBody
	public String addDormitory( @RequestBody Dormitory dormitory) {
		int d = dormitoryService.insertSelective(dormitory);
		return "dormitory_list";
	}

	/**
	 * 删除宿舍信息
	 */
	@RequestMapping( "/deleteDormitory")
	@ResponseBody
	public String deleteDormitory(Integer d_id) {
		int d = dormitoryService.deleteByPrimaryKey(d_id);
		return "dormitory_list";
	}

	/**
	 * 修改学生信息
	 */
	@RequestMapping( "/updateDormitory")
	public String updateDormitory( Dormitory dormitory) {
		int d = dormitoryService.updateByPrimaryKey(dormitory);
		return "redirect:/findDormitory";
	}


	@RequestMapping( "/findDormitoryById")
	public String findDormitoryById(Integer d_id, HttpSession session) {

		Dormitory d= dormitoryService.selectByPrimaryKey(d_id);
		session.setAttribute("d",d);
		return "dormitory_edit";
	}

	/**
	 * 宿舍人员信息查询
	 */
//	@GetMapping(value = "/findDormitoryStudent")
//	public String toDormStuPage(){
//		return "dormitory_Studentlist";
//	}

	@RequestMapping(value = "/findDormitoryStudent")
	public String findDormitoryStudent(Integer s_dormitoryid, Model model) {
		System.out.println("此时宿舍id:"+s_dormitoryid);
		Dormitory dormitory = dormitoryService.selectByKey(s_dormitoryid);
		System.out.println("此时宿舍信息:"+dormitory);
		List<Dormitory> d = dormitoryService.findDormitoryStudent(dormitory);
		model.addAttribute("ds",d);
		return "dormitory_Studentlist";
	}

}
