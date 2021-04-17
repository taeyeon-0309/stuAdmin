package com.iu2java.controller;

import com.iu2java.pojo.Student;
import com.iu2java.pojo.User;
import com.iu2java.service.StudentService;
import com.iu2java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    StudentService studentService;

    /**
     * 用户登录
     */
    /**
     * 将提交数据(username,password)写入User对象
     */
    @RequestMapping(value = "/ulogin")
    public String userLogin(String u_username,String u_password, HttpSession session) {
        if(StringUtils.isEmpty(u_username) || StringUtils.isEmpty(u_password)){
            session.setAttribute("umsg","用户名不为空");
            return "login2";
        }
        User user = new User();
        user.setU_username(u_username);
        user.setU_password(u_password);
        User user1 = userService.findUser(user);
        if(user1 != null){
            session.setAttribute("loginUser",user1.getU_username());
            //假如该学生用户存在，则从student表中取出该学生
            Student student = studentService.selectByPrimaryKey(user1.getU_id());
            session.setAttribute("st1",student);
            return "homepage2";
        }
        session.setAttribute("umsg","用户名或密码错误，请重新输入");
        return "login2";
    }

    @GetMapping("user_info.html")
    public String getInfoPage() {
        return "user_info";
    }
}
