package com.iu2java.controller;

import com.iu2java.pojo.Admin;
import com.iu2java.pojo.PageInfo;
import com.iu2java.service.AdminService;
import com.iu2java.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
public class AdminController {
	// 依赖注入
	@Autowired
	private AdminService adminService;
	/**
	 * 用户登录
	 */
	/**
	 * 将提交数据(username,password)写入Admin对象
	 */
	@RequestMapping(value = "/login")
	public String login(String a_username,String a_password,HttpSession session) {
		//判断输入账号密码是否为空
		if(StringUtils.isEmpty(a_username) || StringUtils.isEmpty(a_password)){
			session.setAttribute("amsg","账号密码不为空");
			return "login";
		}
		// 通过账号和密码查询用户
		String lockPassword = MD5Util.MD5EncodeUtf8(a_password);
//		Admin ad = adminService.adminLogin(a_username, lockPassword);
		Admin admin = new Admin();
		admin.setA_username(a_username);
		admin.setA_password(lockPassword);
		Admin ad = adminService.findAdmin(admin);
		if(ad != null){
			session.setAttribute("loginAdmin",ad.getA_username());
			session.setAttribute("ad", ad);
			return "homepage";
		}
		session.setAttribute("amsg", "用户名或密码错误，请重新登录！");
		return "login";
	}


	/**
	 * 退出登录
	 */
	@RequestMapping(value = "/loginOut")
	public String loginOut(HttpSession session) {
		session.invalidate();
		return "login";

	}
	/**
	 * 桌面信息
	 */
	@GetMapping("admin_info.html")
	public String getInfoPage() {
		return "admin_info";
	}

	/**
	 * 选择学生登录
	 */
	@RequestMapping(value = "/login2")
	public String loginUser(){
		return "login2";
	}

	/**
	 * 分页查询
	 */
	@RequestMapping(value = "/findAdmin")
	public String findAdmin(String a_username, String a_describe,Integer pageIndex,
							Integer a_id ,Integer pageSize, Model model) {

		PageInfo<Admin> ai = adminService.findPageInfo(a_username,a_describe,
				a_id,pageIndex,pageSize);
		model.addAttribute("ai",ai);
		return "admin_list";
	}

	/**
	 * 导出Excel
	 */
	@RequestMapping(value = "/exportadminlist" , method = RequestMethod.POST)
	@ResponseBody
	public List<Admin> exportAdmin(){
		List<Admin> admin = adminService.getAll();
		return admin;
	}

	/**
	 * 添加管理员信息
	 */
	@RequestMapping(value = "/addAdmin" ,method = RequestMethod.POST)
	@ResponseBody
	public String addAdmin( @RequestBody Admin admin) {

		admin.setA_password(MD5Util.MD5EncodeUtf8(admin.getA_password()));
		adminService.addAdmin(admin);
		return "admin_list";
	}

	/**
	 * 删除管理员信息；将请求体a_id写入参数a_id
	 */
	@RequestMapping( "/deleteAdmin")
	@ResponseBody
	public String deleteAdmin(Integer a_id) {
		adminService.deleteAdmin(a_id);
		return "admin_list";
	}

	/**
	 * 修改管理员信息
	 */
	/**
	 * 将提交数据(a_id,a_username...)写入Admin对象
	 */
	@RequestMapping( value = "/updateAdmin", method = RequestMethod.POST)
	public String updateAdmin(Admin admin) {
		admin.setA_password(MD5Util.MD5EncodeUtf8(admin.getA_password()));
		adminService.updateAdmin(admin);
		return "redirect:/findAdmin";
	}


	/**
	 * 根据管理员Id搜索;将请求数据a_id写入参数a_id
	 */
	@RequestMapping("/findAdminById")
	public String findAdminById(Integer a_id,HttpSession session) {
		Admin a= adminService.findAdminById(a_id);
		session.setAttribute("a",a);
		return "admin_edit";
	}

	/**
	 * 跳转到更改密码页面
	 */
	@RequestMapping( value = "/changePassword",method = RequestMethod.GET)
	public String toChangePage() {
		return "admin_change";
	}

	/**
	 * 更改本人账户密码
	 */
	@RequestMapping( value = "/changePassword",method = RequestMethod.POST)
	public String updateAdminPassword(Admin admin, String a_password, String newPass_2, HttpSession session) {
		if(a_password.equals("") || newPass_2.equals("")){
			session.setAttribute("emsg","密码不为空");
			return "admin_change";
		}else if (!newPass_2.equals(a_password)) {
			session.setAttribute("emsg","两次密码不同");
			return "admin_change";
        }else {
			session.setAttribute("newPass",a_password);
			log.info(a_password);
			log.info(admin.toString());
			admin.setA_password(MD5Util.MD5EncodeUtf8(admin.getA_password()));
			adminService.updateAdmin(admin);
			session.setAttribute("msg","修改成功,请重新登录");
			return "login";
		}
	}
}